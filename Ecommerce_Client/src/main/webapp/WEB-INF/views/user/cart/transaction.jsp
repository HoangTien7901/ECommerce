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
                        <h1 class="cart-heading">Transaction list</h1>
                            <div class="table-content table-responsive">
                                <table id="dataTable">
                                    <thead>
                                        <tr>
                                        	<th>Id</th>
                                            <th>Product name</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                            <th>Created</th>
                                            <th>Status</th>
                                            <th>Cancel reason</th>
                                        </tr>
                                    </thead>
                                    <tbody id="products-in-cart">
                                    	<c:forEach var="item"
										items="${transactions }" varStatus="i">
                                        <tr>
                                            <td>${i.count }</td>
											<td class="product-name"><a href="#">${item.productName } </a></td>
											<td class="product-price-cart">
												<span class="amount">$${item.price }</span>
											</td>
											<td>${item.quantity }</td>
											<td class="product-subtotal">${item.quantity * item.price }</td>
											<td>
												<fmt:formatDate var="created" value="${item.created }" pattern="dd/MM/yyyy" />
													${created }
											</td>
											<td>${item.status }</td>
											<td>${item.cancelReason != null ? item.cancelReason : "Empty"}</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- shopping-cart-area end -->
    
	</jsp:attribute>
</mt:usertemplate>