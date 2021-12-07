package com.demo.controllers.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.CartInfo;
import com.demo.models.CartProductInfo;
import com.demo.models.ProductInfo;
import com.demo.models.TransactionInfo;
import com.demo.services.user.ICartProductService;
import com.demo.services.user.IProductService;
import com.demo.services.user.ISystemService;
import com.demo.services.user.ITransactionService;

@Controller
@RequestMapping(value = { "user/cart" })
public class CartController {

	@Autowired
	private ICartProductService cartProductService;

	@Autowired
	private ITransactionService transactionService;

	@Autowired
	private IProductService productService;

	@Autowired
	private ISystemService systemService;

	@Autowired
	private Environment environment;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request, RedirectAttributes redirectAttr) {
		HttpSession session = request.getSession();

		// ============= getting store and contact info
		modelMap.put("store", session.getAttribute("store"));
		modelMap.put("contact", session.getAttribute("contact"));

		if (session.getAttribute("productInCartAmount") != null) {
			int amount = (int) session.getAttribute("productInCartAmount");
			modelMap.put("productInCartAmount", amount);
			if (amount == 0) {
				modelMap.put("disableCheckout", "disable");
			}
		} else {
			modelMap.put("productInCartAmount", 0);
			modelMap.put("disableCheckout", "disable");
		}

		ResponseEntity<com.demo.models.System> systemResponse = systemService.getSystem();
		if (!(systemResponse == null || systemResponse.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("business", systemResponse.getBody().getPaypalAccount());
		} else {
			redirectAttr.addFlashAttribute("msg", "Server : Get system info result "
					+ (systemResponse == null ? "null" : systemResponse.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}

		String postUrl = environment.getProperty("paypal.posturl");
		modelMap.put("returnUrl", environment.getProperty("paypal.returnurl"));
		modelMap.put("postUrl", postUrl);

		if (session.getAttribute("cartId") != null) {
			int cartId = (int) session.getAttribute("cartId");

			ResponseEntity<Iterable<CartProductInfo>> response = cartProductService.findByCartId(cartId);
			if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
				double total = 0;

				List<ProductInfo> products = new ArrayList<ProductInfo>();
				for (CartProductInfo cartProduct : response.getBody()) {

					ResponseEntity<ProductInfo> response2 = productService.findInfoById(cartProduct.getProductId());
					if (!(response2 == null || response2.getStatusCode() != HttpStatus.OK)) {
						ProductInfo productInfo = response2.getBody();
						productInfo.setQuantity(cartProduct.getQuantity());
						products.add(productInfo);

						total += productInfo.getPrice() * cartProduct.getQuantity();
					} else {
						modelMap.put("msg", "Server : Get product in cart by id result "
								+ (response2 == null ? "null" : response2.getStatusCode()));
						modelMap.put("msgType", "danger");
					}
				}

				modelMap.put("cartTotal", total);
				modelMap.put("products", products);
			} else {
				modelMap.put("msg",
						"Server : Get cart by id result " + (response == null ? "null" : response.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else {
			modelMap.put("products", null);
		}

		return "user/cart/index";
	}

	@RequestMapping(value = "transaction", method = RequestMethod.GET)
	public String transaction(ModelMap modelMap, HttpServletRequest request, RedirectAttributes redirectAttr) {
		HttpSession session = request.getSession();

		// ============= getting store and contact info
		modelMap.put("store", session.getAttribute("store"));
		modelMap.put("contact", session.getAttribute("contact"));

		if (session.getAttribute("productInCartAmount") != null) {
			int amount = (int) session.getAttribute("productInCartAmount");
			modelMap.put("productInCartAmount", amount);
		} else {
			modelMap.put("productInCartAmount", 0);
		}

		if (session.getAttribute("userId") != null) {
			int userId = (int) session.getAttribute("userId");

			// get all transactions
			ResponseEntity<Iterable<TransactionInfo>> responseEntity = transactionService.findAllByUserId(userId);
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				modelMap.put("transactions", responseEntity.getBody());
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Find transaction by user id result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");

				return "redirect:/user/home/index";
			}
		} else {
			redirectAttr.addFlashAttribute("msg", "Session error: can't find user id");
			redirectAttr.addFlashAttribute("msgType", "danger");

			return "redirect:/user/home/index";
		}

		return "user/cart/transaction";
	}

	@RequestMapping(value = { "updateQuantity/{productId}/{quantity}" }, method = RequestMethod.GET)
	public ResponseEntity changeProductQuantity(@PathVariable("productId") int productId,
			@PathVariable(name = "quantity") int quantity, HttpServletRequest request, ModelMap modelMap) {
		try {
			HttpSession session = request.getSession();

			int cartId = (int) session.getAttribute("cartId");

			// update quantity
			ResponseEntity<Void> response = cartProductService.updateQuantity(cartId, productId, quantity);
			if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {

				// update success, proceed to get products and return them to update subtotal
				// and total in index page
				ResponseEntity<Iterable<CartProductInfo>> response2 = cartProductService.findByCartId(cartId);
				if (!(response2 == null || response2.getStatusCode() != HttpStatus.OK)) {

					// return products to ajax page
					return new ResponseEntity<Iterable<CartProductInfo>>(response2.getBody(), HttpStatus.OK);
				} else {
					throw new Exception("Server : Get products in cart by cart id result "
							+ (response == null ? "null" : response.getStatusCode()));
				}
			} else {
				throw new Exception("Server : Update product in cart result "
						+ (response == null ? "null" : response.getStatusCode()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@RequestMapping(value = { "delete/{productId}" }, method = RequestMethod.GET)
	public ResponseEntity<List<ProductInfo>> deleteProductInCart(@PathVariable("productId") int productId,
			HttpServletRequest request, ModelMap modelMap) {
		try {
			HttpSession session = request.getSession();

			int cartId = (int) session.getAttribute("cartId");

			// delete product in cart
			ResponseEntity<Void> response = cartProductService.delete(cartId, productId);
			if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {

				ResponseEntity<Iterable<CartProductInfo>> response2 = cartProductService.findByCartId(cartId);
				if (!(response2 == null || response2.getStatusCode() != HttpStatus.OK)) {

					// get remaining product
					List<ProductInfo> products = new ArrayList<ProductInfo>();
					for (CartProductInfo cartProduct : response2.getBody()) {

						ResponseEntity<ProductInfo> response3 = productService.findInfoById(cartProduct.getProductId());
						if (!(response3 == null || response3.getStatusCode() != HttpStatus.OK)) {
							ProductInfo productInfo = response3.getBody();
							productInfo.setQuantity(cartProduct.getQuantity());
							products.add(productInfo);
						} else {
							throw new Exception("Server : Get product in cart by id result "
									+ (response3 == null ? "null" : response3.getStatusCode()));
						}
					}

					// return remaining product to ajax
					return new ResponseEntity<List<ProductInfo>>(products, HttpStatus.OK);
				} else {
					throw new Exception("Server : Get cart by id result "
							+ (response2 == null ? "null" : response2.getStatusCode()));
				}

			} else {
				throw new Exception("Server : Update product in cart result "
						+ (response == null ? "null" : response.getStatusCode()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
}