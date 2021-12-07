package com.demo.controllers.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.constant.CartStatus;
import com.demo.entities.Contacts;
import com.demo.models.BannerInfo;
import com.demo.models.CartInfo;
import com.demo.models.CartProductInfo;
import com.demo.models.CategoryInfo;
import com.demo.models.ProductInfo;
import com.demo.models.StoreInfo;
import com.demo.models.TransactionDetailsInfo;
import com.demo.models.TransactionInfo;
import com.demo.models.UserInfo;
import com.demo.paypal.PayPalConfig;
import com.demo.paypal.PayPalResult;
import com.demo.paypal.PayPalSucess;
import com.demo.services.manager.IBannerService;
import com.demo.services.manager.IContactService;
import com.demo.services.manager.IStoreService;
import com.demo.services.user.ICartProductService;
import com.demo.services.user.ICartService;
import com.demo.services.user.ICategoryService;
import com.demo.services.user.IProductService;
import com.demo.services.user.ISystemService;
import com.demo.services.user.ITransactionDetailsService;
import com.demo.services.user.ITransactionService;
import com.demo.services.user.IUserService;

import ch.qos.logback.core.util.SystemInfo;

@Controller
@RequestMapping(value = { "", "user/home" })
public class HomeController {

	@Autowired
	private IProductService productService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICartProductService cartProductService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private ITransactionService transactionService;

	@Autowired
	private ITransactionDetailsService transDetailService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IContactService contactService;

	@Autowired
	private ISystemService systemService;

	@Autowired
	private IBannerService bannerService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private Environment environment;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(Authentication authentication, @RequestParam(name = "logout", required = false) String logout,
			ModelMap modelMap, HttpServletRequest request, RedirectAttributes redirectAttr) {
		String message = "";

		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null) {
			modelMap.put("username", session.getAttribute("username"));

			if (session.getAttribute("roleId") != null) {
				modelMap.put("roleId", (int) session.getAttribute("roleId"));
			}
		}

		// ============= getting store info
		ResponseEntity<StoreInfo> storeResponse = storeService.findInfoById(1);
		if (!(storeResponse == null || storeResponse.getStatusCode() != HttpStatus.OK)) {
			session.setAttribute("store", storeResponse.getBody());
			modelMap.put("store", storeResponse.getBody());
		} else {
			message += "Server - Get store info result "
					+ (storeResponse == null ? "null" : storeResponse.getStatusCode()) + "\n";
		}

		// ============= getting contact info
		ResponseEntity<Contacts> contactResponse = contactService.getContact();
		if (!(contactResponse == null || contactResponse.getStatusCode() != HttpStatus.OK)) {
			Contacts contact = contactResponse.getBody();
			session.setAttribute("contact", contact);
			modelMap.put("contact", contact);
		} else {
			message += "Server - Get contact info result "
					+ (contactResponse == null ? "null" : contactResponse.getStatusCode()) + "\n";
		}

		// ============= getting banners
		ResponseEntity<BannerInfo> bannerResponse = bannerService.findInfoActive();
		if (!(bannerResponse == null || bannerResponse.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("banner", bannerResponse.getBody());
		} else {
			message += "Server - Get banner info result "
					+ (bannerResponse == null ? "null" : bannerResponse.getStatusCode()) + "\n";
		}

		// ============= getting system info
		ResponseEntity<com.demo.models.System> systemResponse = systemService.getSystem();
		if (!(systemResponse == null || systemResponse.getStatusCode() != HttpStatus.OK)) {
			session.setAttribute("title", systemResponse.getBody().getTitle());
			modelMap.put("title", (String) session.getAttribute("title"));
		} else {
			redirectAttr.addFlashAttribute("msg", "Server : Get system info result "
					+ (systemResponse == null ? "null" : systemResponse.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}

		// ============= getting products
		ResponseEntity<Iterable<ProductInfo>> responseEntity = productService.findAllInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			Iterable<ProductInfo> items = responseEntity.getBody();
			modelMap.put("items", items);
		} else {
			message += "Server - Get all product result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()) + "\n";
		}

		responseEntity = productService.findBestSelling();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			Iterable<ProductInfo> bestSells = responseEntity.getBody();
			modelMap.put("bestSells", bestSells);
		} else {
			message += "Server - Get best selling products result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()) + "\n";
		}

		responseEntity = productService.findOutStanding();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			Iterable<ProductInfo> outstandings = responseEntity.getBody();
			modelMap.put("outstandings", outstandings);
		} else {
			message += "Server - Get out standing products result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()) + "\n";
		}
		// ================ finish getting products

		// ================ getting categories
		ResponseEntity<Iterable<CategoryInfo>> categoryReponse = categoryService.findAll();
		if (!(categoryReponse == null || categoryReponse.getStatusCode() != HttpStatus.OK)) {
			List<CategoryInfo> result = (List<CategoryInfo>) categoryReponse.getBody();
			modelMap.put("categories", result);
		} else {
			message += "Server : Get cart by id result "
					+ (categoryReponse == null ? "null" : categoryReponse.getStatusCode()) + "\n";
		}

		// ================ check cart
		if (session.getAttribute("cartId") != null) {

			int cartId = (int) session.getAttribute("cartId");
			ResponseEntity<Iterable<CartProductInfo>> response = cartProductService.findByCartId(cartId);
			if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
				List<CartProductInfo> result = (List<CartProductInfo>) response.getBody();
				session.setAttribute("productInCartAmount", result.size());
				modelMap.put("productInCartAmount", result.size());
			} else {
				message += "Server : Get cart by id result " + (response == null ? "null" : response.getStatusCode())
						+ "\n";
			}
		} else {
			// create new cart if user has login
			CartInfo cartInfo = new CartInfo();

			if (authentication != null) {
				String username = authentication.getName();

				ResponseEntity<UserInfo> userResponse = userService.findInfoByUsername(username);
				if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {

					UserInfo user = userResponse.getBody();
					session.setAttribute("id", user.getId());
					session.setAttribute("userId", user.getId());
					session.setAttribute("username", user.getUsername());
					session.setAttribute("roleId", user.getRoleId());
				} else {
					if (userResponse == null) {
						message += "Can't find any user with username " + username;
					} else {
						message += "Find user by username result " + userResponse.getStatusCode();
					}
				}

				cartInfo.setUserId((int) session.getAttribute("userId"));

				ResponseEntity<CartInfo> cartResponse = cartService.create(cartInfo);
				if (!(cartResponse == null || cartResponse.getStatusCode() != HttpStatus.OK)) {
					// create cart success
					CartInfo result = cartResponse.getBody();

					session.setAttribute("cartId", result.getId());
				} else {
					message += "Server - Create new cart result "
							+ (cartResponse == null ? "null" : cartResponse.getStatusCode());
				}
			}

			session.setAttribute("productInCartAmount", 0);
			modelMap.put("productInCartAmount", 0);
		}

		if (!message.isEmpty()) {
			modelMap.put("msg", message);
			modelMap.put("msgType", "danger");
		}

		return "user/home/index";
	}

	@RequestMapping(value = { "addProduct/{productId}/{quantity}" }, method = RequestMethod.GET)
	public ResponseEntity addProduct(@PathVariable("productId") int productId,
			@PathVariable(name = "quantity", required = false) int quantity, HttpServletRequest request,
			ModelMap modelMap) {
		try {
			int cartId = 0;

			HttpSession session = request.getSession();

			if (session.getAttribute("userId") == null) {
				throw new Exception("NO_USER_EXCEPTION");
			} else {
				// create an emtpy cart
				CartInfo cartInfo = new CartInfo();

				// with first purchase (no cart)
				if (session.getAttribute("cartId") == null) {

					// create new cart
					cartInfo.setUserId((int) session.getAttribute("userId"));

					List<Integer> productIds = new ArrayList<Integer>();
					productIds.add(productId);
					cartInfo.setProductIds(productIds);

					ResponseEntity<CartInfo> responseEntity = cartService.create(cartInfo);
					if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
						// create cart success
						CartInfo result = responseEntity.getBody();

						session.setAttribute("cartId", result.getId());

						modelMap.put("cart", result);
					} else {
						throw new Exception("Server - Create new cart result "
								+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
					}
				} else {
					// with latter purchase
					cartId = (int) session.getAttribute("cartId");

					ResponseEntity<CartInfo> responseEntity = cartService.findInfoById(cartId);
					if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
						cartInfo = responseEntity.getBody();
					} else {
						throw new Exception("Server - Get cart by id result "
								+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
					}
				}

				// create cart_product (add product to cart)
				CartProductInfo cartProduct = new CartProductInfo();
				cartProduct.setCartId(cartId);
				cartProduct.setProductId(productId);
				cartProduct.setQuantity(quantity);

				ResponseEntity<CartProductInfo> responseEntity2 = cartProductService.create(cartProduct);
				if (!(responseEntity2 == null || responseEntity2.getStatusCode() != HttpStatus.OK)) {
					List<Integer> productIds = (List<Integer>) cartInfo.getProductIds();
					productIds.add(responseEntity2.getBody().getId());
					cartInfo.setProductIds(productIds);
				} else {
					throw new Exception("Server - Add product to cart result "
							+ (responseEntity2 == null ? "null" : responseEntity2.getStatusCode()));
				}

				// get product in cart amount
				ResponseEntity<Iterable<CartProductInfo>> response = cartProductService.findByCartId(cartId);
				if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
					List<CartProductInfo> result = (List<CartProductInfo>) response.getBody();
					session.setAttribute("productInCartAmount", result.size());
					modelMap.put("productInCartAmount", result.size());
				} else {
					modelMap.put("msg",
							"Server : Get cart by id result " + (response == null ? "null" : response.getStatusCode()));
					modelMap.put("msgType", "danger");
				}
			}

			return new ResponseEntity<Integer>((int) session.getAttribute("productInCartAmount"), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	// for success purchase request
	@RequestMapping(value = { "success" }, method = RequestMethod.GET)
	public String success(ModelMap modelMap, HttpServletRequest request, RedirectAttributes redirectAttr) {
		String message = "";
		HttpSession session = request.getSession();

		modelMap.put("title", (String) session.getAttribute("title"));

		int cartId = 0;
		if (session.getAttribute("cartId") != null) {
			cartId = (int) session.getAttribute("cartId");

			String business = "";
			ResponseEntity<com.demo.models.System> systemResponse = systemService.getSystem();
			if (!(systemResponse == null || systemResponse.getStatusCode() != HttpStatus.OK)) {
				business = systemResponse.getBody().getPaypalAccount();
			} else {
				redirectAttr.addFlashAttribute("msg", "Server : Get system info result "
						+ (systemResponse == null ? "null" : systemResponse.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}

			PayPalConfig config = new PayPalConfig();
			config.setAuthToken(environment.getProperty("paypal.authtoken"));
			config.setBusiness(environment.getProperty(business));
			config.setPosturl(environment.getProperty("paypal.posturl"));
			config.setReturnurl(environment.getProperty("paypal.returnurl"));

			// ##### result is always null for some reasons #####
//				PayPalResult result = PayPalSucess.getPayPal(request, config);
//				if (result == null) {
//					System.out.println("Paypal result null");
//				}

			ResponseEntity<Void> cartResponse = cartService.updateStatus(cartId, CartStatus.done);
			if (!(cartResponse == null || cartResponse.getStatusCode() != HttpStatus.OK)) {

				// create transaction and transaction details here (first get all cart_product)
				ResponseEntity<Iterable<CartProductInfo>> cartProductResponse = cartProductService.findByCartId(cartId);
				if (!(cartProductResponse == null || cartProductResponse.getStatusCode() != HttpStatus.OK)) {
					// create transaction details
					TransactionDetailsInfo transDetailInfo = new TransactionDetailsInfo();
					transDetailInfo.setName("Transaction details " + (new Date()).toString());
					int userId = (int) session.getAttribute("userId");
					transDetailInfo.setUserId(userId);
					transDetailInfo.setQuantity(((List<CartProductInfo>) cartProductResponse.getBody()).size());

					// create transaction details to connect all transaction
					ResponseEntity<TransactionDetailsInfo> transDetailResponse = transDetailService
							.create(transDetailInfo);
					if (!(transDetailResponse == null || transDetailResponse.getStatusCode() != HttpStatus.OK)) {

						// create transactions
						for (CartProductInfo item : cartProductResponse.getBody()) {

							// get product for transaction info
							ResponseEntity<ProductInfo> productResponse = productService
									.findInfoById(item.getProductId());
							if (!(productResponse == null || productResponse.getStatusCode() != HttpStatus.OK)) {

								ProductInfo product = productResponse.getBody();

								TransactionInfo transactionInfo = new TransactionInfo();
								transactionInfo.setPrice(product.getPrice());
								transactionInfo.setQuantity(item.getQuantity());
								transactionInfo.setProductId(product.getId());
								transactionInfo.setProductName(product.getName());
								transactionInfo.setTransactionDetailsId(transDetailResponse.getBody().getId());

								// create transaction with product info
								ResponseEntity<TransactionInfo> transactionResponse = transactionService
										.create(transactionInfo);
								if (!(transactionResponse == null
										|| transactionResponse.getStatusCode() != HttpStatus.OK)) {
								} else {
									message += "Server - Create transaction result "
											+ (transactionResponse == null ? "null"
													: transactionResponse.getStatusCode());
								}
							} else {
								message += "Server - Get product by id result "
										+ (productResponse == null ? "null" : productResponse.getStatusCode());
							}
						}
					} else {
						message += "Server - Create transaction details result "
								+ (transDetailResponse == null ? "null" : cartResponse.getStatusCode());
					}

				} else {
					message += "Server : Get product in cart by id result "
							+ (cartProductResponse == null ? "null" : cartProductResponse.getStatusCode());
				}

				session.removeAttribute("productInCartAmount");
				session.removeAttribute("cartId");

			} else {
				message += "Server : Get cart by id result "
						+ (cartResponse == null ? "null" : cartResponse.getStatusCode()) + "\n";
			}
		} else {
			message += "Session error - Can find your cart.\n";
		}

		if (!message.isEmpty()) {
			redirectAttr.addFlashAttribute("msg", message);
			redirectAttr.addFlashAttribute("msgType", "danger");
		} else {
			redirectAttr.addFlashAttribute("msg", "Purchase success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		}

		return "redirect:/user/home/index";
	}
}
