<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html class="no-js" lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Ezone - eCommerce HTML5 Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath }/resources/user/img/favicon.png">

<!-- all css here -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/pe-icon-7-stroke.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/icofont.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/meanmenu.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/bundle.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/user/css/responsive.css">
<script
	src="${pageContext.request.contextPath }/resources/user/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
	<!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<!-- header start -->
	<header>
		<div class="header-top-furniture wrapper-padding-2 res-header-sm">
			<div class="container-fluid">
				<div class="header-bottom-wrapper">
					<div class="logo-2 furniture-logo ptb-30">
						<a href="index.html"> <img
							src="${pageContext.request.contextPath }/resources/user/img/logo/2.png"
							alt="">
						</a>
					</div>
					<div class="menu-style-2 furniture-menu menu-hover">
						<nav>
							<ul>
								<li><a href="${pageContext.request.contextPath }/home">home</a>
									
								<li><a href="#">pages</a>
									
								<li><a href="#">blog</a>
									
								<li><a href="${pageContext.request.contextPath }/contact">contact</a></li>
							</ul>
						</nav>
					</div>
					<div class="header-cart">
						<a class="icon-cart-furniture"
							href="${pageContext.request.contextPath }/cart"> <i
							class="ti-shopping-cart"></i> <span
							class="shop-count-furniture green">02</span>
						</a>

					</div>
				</div>
				<div class="row">
					<div
						class="mobile-menu-area d-md-block col-md-12 col-lg-12 col-12 d-lg-none d-xl-none">
						<div class="mobile-menu">
							<nav id="mobile-menu-active">
								<ul class="menu-overflow">
									<li><a href="${pageContext.request.contextPath }/home">HOME</a>
										
									<li><a href="#">pages</a>
										
									<li><a href="#">BLOG</a>
										
									<li><a href="${pageContext.request.contextPath }/contact"> Contact </a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="header-bottom-furniture wrapper-padding-2 border-top-3">
			<div class="container-fluid">
				<div class="furniture-bottom-wrapper">
					<div class="furniture-login">
						<ul>
							<li>Get Access: <a
								href="${pageContext.request.contextPath }/login/index">Login</a></li>
							<li><a
								href="${pageContext.request.contextPath }/login/index2">Register</a></li>
						</ul>
					</div>
					<!-- <div class="furniture-search">
                            <form action="#">
                                <input placeholder="I am Searching for . . ." type="text">
                                <button>
                                    <i class="ti-search"></i>
                                </button>
                            </form>
                        </div>
                        <div class="furniture-wishlist">
                            <ul>
                                <li><a data-toggle="modal" data-target="#exampleCompare" href="#"><i class="ti-reload"></i> Compare</a></li>
                                <li><a href="wishlist.html"><i class="ti-heart"></i> Wishlist</a></li>
                            </ul>
                        </div> -->
				</div>
			</div>
		</div>
	</header>
	<!-- header end -->
	<%-- <div class="breadcrumb-area pt-205 pb-210" style="background-image: url(${pageContext.request.contextPath }/resources/user/img/bg/breadcrumb.jpg)">
            <div class="container">
                <div class="breadcrumb-content text-center">
                    <h2>cart page</h2>
                    <ul>
                        <li><a href="#">home</a></li>
                        <li> cart page</li>
                    </ul>
                </div>
            </div>
        </div> --%>
	<!-- shopping-cart-area start -->
	<div class="cart-main-area pt-95 pb-100">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<h1 class="cart-heading">Cart ${msg }</h1>
					<form action="#">
						<div class="table-content table-responsive">
							<table>
								<thead>
									<tr>
										<th>remove</th>
										<th>images</th>
										<th>Product</th>
										<th>Price</th>
										<th>Quantity</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>
									
										<tr th:each="item : ${session.cart }">
											<td class="product-remove"><a href="#"><i
													class="pe-7s-close"></i></a></td>
											<td class="product-thumbnail"><a href="#"><img
													src="${pageContext.request.contextPath }/resources/user/img/cart/${item.products.avatar}"
													alt=""></a></td>
											<td class="product-name"><a href="${pageContext.request.contextPath }/product-details">${item.name } </a></td>
											<td class="product-price-cart"><span class="amount">${item.product.price }</span></td>
											<td class="product-quantity"><input value="1"
												type="number"></td>
											<td class="product-subtotal">SUm 22</td>
										</tr>

									
								</tbody>
							</table>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="coupon-all">
									<div class="coupon">
										<input id="coupon_code" class="input-text" name="coupon_code"
											value="" placeholder="Coupon code" type="text"> <input
											class="button" name="apply_coupon" value="Apply coupon"
											type="submit">
									</div>
									<div class="coupon2">
										<input class="button" name="update_cart" value="Update cart"
											type="submit">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-5 ml-auto">
								<div class="cart-page-total">
									<h2>Cart totals</h2>
									<ul>
										<li>Subtotal<span>100.00</span></li>
										<li>Total<span>100.00</span></li>
									</ul>
									<a href="#">Proceed to checkout</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- shopping-cart-area end -->
	<footer class="footer-area">
		<div class="footer-top-area bg-img pt-105 pb-65"
			style="background-image: url(${pageContext.request.contextPath }/resources/user/img/bg/1.jpg)"
			data-overlay="9">
			<div class="container">
				<div class="row">
					<div class="col-xl-4 col-md-3">
						<div class="footer-widget mb-40">
							<h3 class="footer-widget-title">Custom Service</h3>
							<div class="footer-widget-content">
								<ul>
									<li><a href="cart.html">Cart</a></li>
									<li><a href="register.html">My Account</a></li>
									<li><a href="login.html">Login</a></li>
									<li><a href="register.html">Register</a></li>
									<li><a href="#">Support</a></li>
									<li><a href="#">Track</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-xl-4 col-md-3">
						<div class="footer-widget mb-40">
							<h3 class="footer-widget-title">Categories</h3>
							<div class="footer-widget-content">
								<ul>
									<li><a href="shop.html">Dress</a></li>
									<li><a href="shop.html">Shoes</a></li>
									<li><a href="shop.html">Shirt</a></li>
									<li><a href="shop.html">Baby Product</a></li>
									<li><a href="shop.html">Mans Product</a></li>
									<li><a href="shop.html">Leather</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-xl-4 col-md-6">
						<div class="footer-widget mb-40">
							<h3 class="footer-widget-title">Contact</h3>
							<div class="footer-newsletter">
								<p>Lorem Ipsum is simply dummy text of the printing and
									typesetting industry. Lorem Ipsum is dummy.</p>
								<div id="mc_embed_signup" class="subscribe-form pr-40">
									<form
										action="http://devitems.us11.list-manage.com/subscribe/post?u=6bbb9b6f5827bd842d9640c82&amp;id=05d85f18ef"
										method="post" id="mc-embedded-subscribe-form"
										name="mc-embedded-subscribe-form" class="validate"
										target="_blank" novalidate>
										<div id="mc_embed_signup_scroll" class="mc-form">
											<input type="email" value="" name="EMAIL" class="email"
												placeholder="Enter Your E-mail" required>
											<!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups-->
											<div class="mc-news" aria-hidden="true">
												<input type="text"
													name="b_6bbb9b6f5827bd842d9640c82_05d85f18ef" tabindex="-1"
													value="">
											</div>
											<div class="clear">
												<input type="submit" value="Subscribe" name="subscribe"
													id="mc-embedded-subscribe" class="button">
											</div>
										</div>
									</form>
								</div>
								<div class="footer-contact">
									<p>
										<span><i class="ti-location-pin"></i></span> 77 Seventh avenue
										USA 12555.
									</p>
									<p>
										<span><i class=" ti-headphone-alt "></i></span> +88 (015)
										609735 or +88 (012) 112266
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		
	</footer>
	





	<!-- all js here -->
	<script
		src="${pageContext.request.contextPath }/resources/user/js/vendor/jquery-1.12.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/popper.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/jquery.magnific-popup.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/isotope.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/imagesloaded.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/jquery.counterup.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/ajax-mail.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/plugins.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/user/js/main.js"></script>
</body>
</html>

