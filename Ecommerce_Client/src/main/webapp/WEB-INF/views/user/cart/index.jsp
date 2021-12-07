<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:usertemplate title="${title }">
	<jsp:attribute name="content">
        <!-- shopping-cart-area start -->
        <div class="cart-main-area pt-95 pb-100">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h1 class="cart-heading">Cart</h1>
                        <form method="post" action="${postUrl }">
                        <input type="hidden" name="upload" value="1" /> 
						<input type="hidden" name="return" value="${returnUrl }" /> 
						<input type="hidden" name="cmd" value="_cart" /> 
						<input type="hidden" name="business" value="${business }" />
                            <div class="table-content table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Remove</th>
                                            <th>Images</th>
                                            <th>Product</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody id="products-in-cart">
                                    	<c:forEach var="item" items="${products }" varStatus="i">
                                        <tr id="product-in-cart-row-${item.id }">
                                            <td class="product-remove"><a
												class="remove-product-in-cart" data-id="${item.id }"><i class="pe-7s-close"></i></a></td>
                                            <td
												class="product-thumbnail">
                                                <a><img width="200px"
													src="${pageContext.request.contextPath }/uploads/images/${item.avatar }" alt=""></a>
                                            </td>
                                            <td class="product-name"><a
												href="#">${item.name } </a></td>
                                            <td
												class="product-price-cart">
												<span class="amount">$ 
													<span id="price${item.id }">${item.price }</span>
												</span>
											</td>
                                            <td class="product-quantity">
                                                <input value="${item.quantity }"
												type="number" id="quantity${item.id }" class="product-quantity-input" data-id="${item.id }" min="1">
                                            </td>
                                            <td class="product-subtotal" id="subtotal${item.id }">${item.quantity * item.price }
                                        	<input type="hidden" name="item_number_${i.index + 1 }" value="${item.id }">
											<input type="hidden" name="item_name_${i.index + 1 }" value="${item.name }">
											<input type="hidden" name="amount_${i.index + 1 }" value="${item.price }">
											<input type="hidden" name="quantity_${i.index + 1 }" value="${item.quantity}">
											</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-5 ml-auto">
                                    <div class="cart-page-total">
                                        <h2>Cart totals</h2>
                                        <ul>
                                            <li>Total<span id="cart-total">${cartTotal }</span></li>
                                        </ul>
                                        <input type="submit" value="Proceed to checkout" id="checkoutButton" disabled="${disableCheckout }" >
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- shopping-cart-area end -->
    
	</jsp:attribute>
</mt:usertemplate>