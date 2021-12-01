<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="zxx">
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
	href="${pageContext.request.contextPath }/resources/user/css/jquery-ui.css">
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

								</li>
								<li><a href="#">pages</a>
									<ul class="single-dropdown">

										<li><a
											href="${pageContext.request.contextPath }/login/index">Singin</a></li>
										<li><a
											href="${pageContext.request.contextPath }/login/index2">Singup</a></li>
										<li><a href="${pageContext.request.contextPath }/cart">cart
												page</a></li>

									</ul></li>
								
				
								<li><a href="#">blog</a>
									</li>
								<li><a href="${pageContext.request.contextPath }/contact">contact</a></li>
							</ul>
						</nav>
					</div>
					<div class="header-cart">
						<a class="icon-cart-furniture"
							href="${pageContext.request.contextPath }/cart"> <i
							class="ti-shopping-cart"></i> 
						</a>

					</div>
				</div>

			</div>
		</div>

	</header>
	<!-- header end -->
	<%-- <div class="breadcrumb-area pt-205 breadcrumb-padding pb-210"
		style="background-image: url(${pageContext.request.contextPath }/resources/user/img/bg/breadcrumb.jpg)">
		<div class="container-fluid">
			<div class="breadcrumb-content text-center">
				<h2>shop grid</h2>
				<ul>
					<li><a href="#">home</a></li>
					<li>shop grid</li>
				</ul>
			</div>
		</div>
	</div> --%>
	<div class="shop-page-wrapper shop-page-padding ptb-100">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3">
					<div class="shop-sidebar mr-50">
						<div class="sidebar-widget mb-50">
							<h3 class="sidebar-title">Search Products</h3>
							<div class="sidebar-search">
								<form
									action="${pageContext.request.contextPath }/search/searchkeyword"
									method="get">
									<input placeholder="Search Products..." type="text"
										name="keyword">
									<button type="submit">
										<i class="ti-search"></i>
									</button>
								</form>
							</div>
						</div>
						<div class="sidebar-widget mb-40">
							<h3 class="sidebar-title">Filter by Price</h3>
							<div class="price_filter">
								<!-- <div id="slider-range"></div> -->
								<div class="price_slider_amount">
									<form
										action="${pageContext.request.contextPath }/search/searchbyminmax">
										<input type="text" placeholder="Min" value="0" name="min">
										<input type="text" placeholder="Max" value="0" name="max">
										<input type="submit" value="Search">

									</form>
									<!--
									<div class="label-input">
										<label>price : </label> <input type="text" id="amount"
											name="price" placeholder="Add Your Price" />
									</div>
									<button type="button">Filter</button>
									
									 <div class="label-input">
										<label>price : </label> <input type="text" id="amount"
											name="price" placeholder="Add Your Price" />
									</div>
									<button type="button">Filter</button> -->
								</div>
							</div>
						</div>
						
						<div class="sidebar-widget mb-50">
							<h3 class="sidebar-title"></h3>
							<div class="sidebar-top-rated-all">
								<div class="sidebar-top-rated mb-30">
									
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="shop-product-wrapper res-xl res-xl-btn">
						<div class="shop-bar-area">
							<div class="shop-bar pb-60">
								<div class="shop-found-selector">
									<div class="shop-found">
										<p>
											<span>Total ${quantity } Product </span>


										</p>
									</div>
								</div>
								
							</div>
							<div class="shop-product-content tab-content">
								<div id="grid-sidebar1" class="tab-pane fade active show">
									<div class="row">
										<span>${msg }</span>

										<c:forEach var="products" items="${produ }">

											<div class="col-lg-6 col-md-6 col-xl-3">
												<div class="product-wrapper mb-30">
													<div class="product-img">
														<a
															href="${pageContext.request.contextPath }/product/${products.id}">
															<img
															src="${pageContext.request.contextPath }/resources/user/img/product/electro/${products.avatar }"
															alt="">
														</a>
														<div class="product-action">
															<a class="animate-left" title="Wishlist" href="${pageContext.request.contextPath }/product/${products.id}"> <i
																class="pe-7s-like"></i>
															</a> <a class="animate-top" title="Add To Cart" href="${pageContext.request.contextPath }/cart/buy/${products.id}">
																<i class="pe-7s-cart"></i>
															</a> <a class="animate-right" title="Quick View"
																 data-target="#exampleModal"
																href="${pageContext.request.contextPath }/home/product/${products.id}">
																<i class="pe-7s-look"></i>
															</a>
														</div>
													</div>
													<div class="product-content">
														<h4>
															<a
																href="${pageContext.request.contextPath }/product/${products.id}">${products.name }
															</a>
														</h4>
														<span>$ ${products.price }</span>
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
			</div>
		</div>
	</div>
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
									<li><a href="${pageContext.request.contextPath }/cart">Cart</a></li>
									<li><a href="${pageContext.request.contextPath }/login/index">Login</a></li>
									
									<li><a href="${pageContext.request.contextPath }/login/index2">Register</a></li>
									
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
