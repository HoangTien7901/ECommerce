package com.demo.controllers.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.CartInfo;
import com.demo.models.CartProductInfo;
import com.demo.models.ProductInfo;
import com.demo.services.user.ICartProductService;
import com.demo.services.user.ICartService;
import com.demo.services.user.IProductService;

@Controller
@RequestMapping(value = {"", "user/home"})
public class HomeController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICartProductService cartProductService;
	
	@Autowired
	private ICartService cartService;
	
	@RequestMapping(value = {"", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("username") != null) {
			modelMap.put("username", session.getAttribute("username"));
		}
		
		ResponseEntity<Iterable<ProductInfo>> responseEntity = productService.findAllInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			Iterable<ProductInfo> items = responseEntity.getBody();
			modelMap.put("items", items);
		} else {
			modelMap.put("msg", "Server - Get all product result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		
		responseEntity = productService.findBestSelling();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			Iterable<ProductInfo> bestSells = responseEntity.getBody();
			modelMap.put("bestSells", bestSells);
		} else {
			modelMap.put("msg", "Server - Get best selling products result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		
		responseEntity = productService.findOutStanding();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			Iterable<ProductInfo> outstandings = responseEntity.getBody();
			modelMap.put("outstandings", outstandings);
		} else {
			modelMap.put("msg", "Server - Get out standing products result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		
		if (session.getAttribute("cartId") != null) {
			
			int cartId = (int) session.getAttribute("cartId");
			ResponseEntity<Iterable<CartProductInfo>> response = cartProductService.findByCartId(cartId);
			if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
				List<CartProductInfo> result = (List<CartProductInfo>) response.getBody();
				session.setAttribute("productInCartAmount", result.size());
				modelMap.put("productInCartAmount", result.size());
			} else {
				modelMap.put("msg", "Server : Get cart by id result " + (response == null ? "null" : response.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else {
			session.setAttribute("productInCartAmount", 0);
			modelMap.put("productInCartAmount", 0);
		}
		
		return "user/home/index";
	}
	
	@RequestMapping(value = { "addProduct/{productId}/{quantity}" }, method = RequestMethod.GET)
	public ResponseEntity addProduct(@PathVariable("productId") int productId, 
			@PathVariable(name = "quantity", required = false) int quantity
			,HttpServletRequest request, ModelMap modelMap) {
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
					modelMap.put("msg", "Server : Get cart by id result " + (response == null ? "null" : response.getStatusCode()));
					modelMap.put("msgType", "danger");
				}
			}
			
			return new ResponseEntity<Integer>((int) session.getAttribute("productInCartAmount"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//			return new ResponseEntity<Integer>();
		}
	}
}
