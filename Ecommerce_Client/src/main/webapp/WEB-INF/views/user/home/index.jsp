
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Ezone</title>
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
	<!--Notification Section-->

	<header>
		<div class="header-top-wrapper-2 border-bottom-2">
			<div class="header-info-wrapper pl-200 pr-200">
				<div class="header-contact-info"></div>
				<div class="electronics-login-register">
					<ul>

						<li><b><a
								href="${pageContext.request.contextPath }/login/index">login</a></b>
							| <b><a
								href="${pageContext.request.contextPath }/login/index2">Register</a></b></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="header-bottom pt-40 pb-30 clearfix">
			<div class="header-bottom-wrapper pr-200 pl-200">
				<div class="logo-3">
					<a href="index.html"> <img
						src="${pageContext.request.contextPath }/resources/user/img/logo/logo-3.png"
						alt="">
					</a>
				</div>


				<div class="categories-search-wrapper">

					<div class="categories-wrapper">
						<form
							action="${pageContext.request.contextPath }/search/searchkeyword"
							method="get">
							<input placeholder="Enter Your key word" type="text"
								name="keyword">
							<button type="submit">Search</button>
						</form>
					</div>
				</div>
				<div class="trace-cart-wrapper">

					<div class="categories-cart same-style">
						<div class="same-style-icon">
							<a href="#"><i class="pe-7s-cart"></i></a>
						</div>
						<div class="same-style-text">
							<a href="${pageContext.request.contextPath }/cart">My Cart <br>02
								Item
							</a>
						</div>

					</div>
				</div>

			</div>
		</div>
	</header>
	<!-- header end -->
	<div class="pl-200 pr-200 overflow clearfix">
		<div class="categori-menu-slider-wrapper clearfix">
			<div class="categories-menu">
				<div class="category-heading">
					<h3>
						Categories <i class="pe-7s-angle-down"></i>
					</h3>
				</div>
				<div class="category-menu-list">

					<ul>
						<c:forEach var="parent" items="${parent1 }">
							<li><a
								href="${pageContext.request.contextPath }/search/category/${parent.id }"><img
									alt=""
									src="${pageContext.request.contextPath }/resources/user/img/icon-img/8.png">${parent.name }
							</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="menu-slider-wrapper">
				<div class="menu-style-3 menu-hover text-center">
					<nav>
						<ul>
							<li><a href="${pageContext.request.contextPath }/home">home</a></li>


							<li><a href="#">pages </a>
							<ul class="single-dropdown">

								<li><a
									href="${pageContext.request.contextPath }/login/index">singin</a></li>
								<li><a
									href="${pageContext.request.contextPath }/login/index2">singup</a></li>
								<li><a href="${pageContext.request.contextPath }/cart">cart page</a></li>


							</ul></li>
							<li><a href="${pageContext.request.contextPath }/contact">contact</a></li>
						</ul>
					</nav>
				</div>
				<div class="slider-area">
					<div class="slider-active owl-carousel">
						<div class="single-slider single-slider-hm3 bg-img pt-170 pb-173"
							style="background-image: url(${pageContext.request.contextPath }/resources/user/img/slider/5.jpg)">
							<div
								class="slider-animation slider-content-style-3 fadeinup-animated">
								<h2 class="animated">
									Invention of <br>design platform
								</h2>
								<h4 class="animated">Best Product With warranty</h4>
								<a class="electro-slider-btn btn-hover"
									href="${pageContext.request.contextPath }/product-details">buy
									now</a>
							</div>
						</div>
						<div class="single-slider single-slider-hm3 bg-img pt-170 pb-173"
							style="background-image: url(${pageContext.request.contextPath }/resources/user/img/slider/20.jpg)">
							<div
								class="slider-animation slider-content-style-3 fadeinup-animated">
								<h2 class="animated">
									Invention of <br>design platform
								</h2>
								<h4 class="animated">Best Product With warranty</h4>
								<a class="electro-slider-btn btn-hover"
									href="${pageContext.request.contextPath }/product-details">buy
									now</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="electro-product-wrapper wrapper-padding pt-95 pb-45">
		<div class="container-fluid">
			<div class="section-title-4 text-center mb-40">
				<h2>Best Selling</h2>
			</div>
			<div class="top-product-style">

				<div class="tab-content">
					<div class="tab-pane active show fade" id="electro1"
						role="tabpanel">
						<div class="custom-row-2">

							<c:forEach var="bes" items="${bestsell}">

								<div class="custom-col-style-3 custom-col-3">
									<div class="product-wrapper mb-6">
										<div class="product-img-4">
											<a
												href="${pageContext.request.contextPath }/home/product/${bes.id}">
												<img
												src="${pageContext.request.contextPath }/resources/user/img/product/electro/${bes.avatar }"
												alt="">
											</a>
											<div class="product-action-right">
												<a class="animate-right"
													href="${pageContext.request.contextPath }/home/product/${products.id}"
													data-target="#exampleModal" title="Quick View"> <i
													class="pe-7s-look"></i>
												</a> <a class="animate-top" title="Add To Cart" href="#"> <i
													class="pe-7s-cart"></i>
											</div>
										</div>
										<div class="product-content-6">
											<div class="product-rating-4"></div>
											<h4>
												<a
													href="${pageContext.request.contextPath }/home/product/${bes.id}">${bes.name }</a>
											</h4>
											<h5>$ ${bes.price }</h5>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div class="electro-product-wrapper wrapper-padding pt-95 pb-45">
		<div class="container-fluid">
			<div class="section-title-4 text-center mb-40">
				<h2>Products</h2>
			</div>
			<div class="top-product-style">
				<!-- <div
					class="product-tab-list3 text-center mb-80 nav product-menu-mrg"
					role="tablist">
					<a class="active" href="#electro1" data-toggle="tab" role="tab">
						<h4>Fiction</h4>
					</a> <a href="#electro2" data-toggle="tab" role="tab">
						<h4>Satire</h4>
					</a> <a href="#electro3" data-toggle="tab" role="tab">
						<h4>Anthologies</h4>
					</a>
				</div> -->
				<div class="tab-content">
					<div class="tab-pane active show fade" id="electro1"
						role="tabpanel">
						<div class="custom-row-2">

							<c:forEach var="products" items="${findall }">
								<div class="custom-col-style-2 custom-col-4">
									<div class="product-wrapper product-border mb-24">
										<div class="product-img-3">
											<a
												href="${pageContext.request.contextPath }/product/${products.id}">
												<img
												src="${pageContext.request.contextPath }/resources/user/img/product/electro/${products.avatar }"
												alt="">
											</a>
											<div class="product-action-right">
												<a class="animate-right"
													href="${pageContext.request.contextPath }/home/product/${products.id}"
													data-target="#exampleModal" title="Quick View"> <i
													class="pe-7s-look"></i>
												</a> <a class="animate-top" title="Add To Cart" href="#"> </a> <i
													class="pe-7s-cart"></i>

											</div>
										</div>
										<div class="product-content-4 text-center">
											<div class="product-rating-4">
												<i class="icofont icofont-star yellow"></i> <i
													class="icofont icofont-star yellow"></i> <i
													class="icofont icofont-star yellow"></i> <i
													class="icofont icofont-star yellow"></i> <i
													class="icofont icofont-star"></i>
											</div>
											<h4>
												<a
													href="${pageContext.request.contextPath }/home/product/${products.id}">${products.name }</a>
											</h4>
											<span> ID: ${userid.id }</span>
											<h5>$ ${products.price }</h5>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="tab-pane fade" id="electro2" role="tabpanel">
						<div class="custom-row-2">

							<div class="custom-col-style-2 custom-col-4">
								<div class="product-wrapper product-border mb-24">
									<div class="product-img-3">
										<a
											href="${pageContext.request.contextPath }/home/product/${products.id}">
											<img
											src="${pageContext.request.contextPath }/resources/user/img/product/electro/${products.avatar }"
											alt="">
										</a>
										<div class="product-action-right">
											<a class="animate-right"
												href="${pageContext.request.contextPath }/home/product/${products.id}"
												data-target="#exampleModal" data-toggle="modal"
												title="Quick View"> <i class="pe-7s-look"></i>
											</a> <a class="animate-top" title="Add To Cart" href="#"> <i
												class="pe-7s-cart"></i>
											</a> <a class="animate-left" title="Wishlist" href="#"> <i
												class="pe-7s-like"></i>
											</a>
										</div>
									</div>
									<div class="product-content-4 text-center">
										<div class="product-rating-4">
											<i class="icofont icofont-star yellow"></i> <i
												class="icofont icofont-star yellow"></i> <i
												class="icofont icofont-star yellow"></i> <i
												class="icofont icofont-star yellow"></i> <i
												class="icofont icofont-star"></i>
										</div>
										<h4>
											<a href="${pageContext.request.contextPath }/product-details">${products.name }</a>
										</h4>
										<span>HHH</span>
										<h5>$ ${products.price }</h5>
									</div>
								</div>
							</div>



						</div>
					</div>

				</div>
			</div>
		</div>
	</div>


	<footer class="footer-area">
		<div class="footer-top-3 black-bg pt-75 pb-25">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-6 col-xl-4">
						<div class="footer-widget mb-40">
							<h3 class="footer-widget-title-3">Contact Us</h3>
							<div class="footer-info-wrapper-2">
								<div class="footer-address-electro">
									<div class="footer-info-icon2">
										<span>Address:</span>
									</div>
									<div class="footer-info-content2">
										<p>
											77 Seventh Streeth Banasree <br>Road Rampura -2100 Dhaka
										</p>
									</div>
								</div>
								<div class="footer-address-electro">
									<div class="footer-info-icon2">
										<span>Phone:</span>
									</div>
									<div class="footer-info-content2">
										<p>
											+11 (019) 2518 4203 <br>+11 (251) 2223 3353
										</p>
									</div>
								</div>
								<div class="footer-address-electro">
									<div class="footer-info-icon2">
										<span>Email:</span>
									</div>
									<div class="footer-info-content2">
										<p>
											<a href="#">domain@mail.com</a> <br> <a href="#">company@domain.info</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-xl-3">
						<div class="footer-widget mb-40">
							<h3 class="footer-widget-title-3">My Account</h3>
							<div class="footer-widget-content-3">
								<ul>
									<li><a href="${pageContext.request.contextPath }/cart">Cart</a></li>
									<li><a
										href="${pageContext.request.contextPath }/login/index">Login</a></li>
									<li><a
										href="${pageContext.request.contextPath }/login/index2">Register</a></li>

								</ul>
							</div>
						</div>
					</div>
					<div class="col-lg-2 col-md-6 col-xl-2">
						<div class="footer-widget mb-40">
							<h3 class="footer-widget-title-3">Information</h3>
							<div class="footer-widget-content-3">
								<ul>
									<li><a href="about-us.html">About Us</a></li>
									<li><a href="#">Our Service</a></li>
									<li><a href="#">Pricing Plan</a></li>
									<li><a href="#"> Vendor Detail</a></li>
									<li><a href="#">Affiliate</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-xl-3">
						<div class="footer-widget widget-right mb-40">
							<h3 class="footer-widget-title-3">Service</h3>
							<div class="footer-widget-content-3">
								<ul>
									<li><a href="#">Product Service</a></li>
									<li><a href="#">Payment Service</a></li>
									<li><a href="#"> Discount Service</a></li>
									<li><a href="#">Shopping Service</a></li>
									<li><a href="#">Promotional Add</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</footer>
	<!-- modal -->






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