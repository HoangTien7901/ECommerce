
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Electronics - eCommerce HTML5 Template</title>
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
								href="${pageContext.request.contextPath }/login/index">SINGIN</a></b>|
							<b><a href="${pageContext.request.contextPath }/login/index2">SINGUP</a></b></li>
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
					<div class="all-categories">
						<div class="select-wrapper">
							<select class="select">
								<option value="">All Categories</option>
								<option value="">Smartphones</option>
								<option value="">Computers</option>
								<option value="">Laptops</option>
								<option value="">Camerea</option>
								<option value="">Watches</option>
								<option value="">Lights</option>
								<option value="">Air conditioner</option>
							</select>
						</div>
					</div>
					<div class="categories-wrapper">
						<form action="#">
							<input placeholder="Enter Your key word" type="text">
							<button type="button">Search</button>
						</form>
					</div>
				</div>
				<div class="trace-cart-wrapper">
					<div class="trace same-style">
						<div class="same-style-icon">
							<a href="#"><i class="pe-7s-plane"></i></a>
						</div>
						<div class="same-style-text">
							<a href="#">Product <br>trace
							</a>
						</div>
					</div>
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
						All Departments <i class="pe-7s-angle-down"></i>
					</h3>
				</div>
				<div class="category-menu-list">
					<ul>
						<li><a href="#"><img alt=""
								src="${pageContext.request.contextPath }/resources/user/img/icon-img/5.png">Computer
								& Laptops <i class="pe-7s-angle-right"></i></a>
							<div class="category-menu-dropdown">
								<div class="category-dropdown-style category-common4 mb-40">
									<h4 class="categories-subtitle">Desktop</h4>
									<ul>
										<li><a href="#"> Mother Board</a></li>
										<li><a href="#"> Power Supply</a></li>
										<li><a href="#"> RAM</a></li>
										<li><a href="#"> Graphics Card</a></li>
										<li><a href="#"> Hard Disk Drive</a></li>
										<li><a href="#">Cooling Fan</a></li>
										<li><a href="#">HD Cable</a></li>
									</ul>
								</div>
								<div class="category-dropdown-style category-common4 mb-40">
									<h4 class="categories-subtitle">Laptop</h4>
									<ul>
										<li><a href="#">HP</a></li>
										<li><a href="#">lenovo</a></li>
										<li><a href="#"> vivo</a></li>
										<li><a href="#"> Mack Book Air</a></li>
										<li><a href="#"> Mack Book Pro</a></li>
										<li><a href="#"> LG</a></li>
										<li><a href="#"> Others Brand</a></li>
									</ul>
								</div>
								<div class="category-dropdown-style category-common4 mb-40">
									<h4 class="categories-subtitle">Others</h4>
									<ul>
										<li><a href="#">Monitor</a></li>
										<li><a href="#">Mouse</a></li>
										<li><a href="#">Keybord</a></li>
										<li><a href="#">Speaker</a></li>
										<li><a href="#">Joy Stick</a></li>
										<li><a href="#">Wireless Speaker</a></li>
										<li><a href="#">Software</a></li>
									</ul>
								</div>
								<div class="category-dropdown-style category-common4 mb-40">
									<h4 class="categories-subtitle">Accessories</h4>
									<ul class="border-none">
										<li><a href="#">Monitor</a></li>
										<li><a href="#">Mouse</a></li>
										<li><a href="#">Keybord</a></li>
										<li><a href="#">Speaker</a></li>
										<li><a href="#">Joy Stick</a></li>
										<li><a href="#">Wireless Speaker</a></li>
										<li><a href="#">Software</a></li>
									</ul>
								</div>
								<div class="mega-banner-img">
									<a href="single-product.html"> <img
										src="${pageContext.request.contextPath }/resources/user/img/banner/18.jpg"
										alt="">
									</a>
								</div>
							</div></li>
						<li><a href="#"><img alt=""
								src="${pageContext.request.contextPath }/resources/user/img/icon-img/6.png">Phone
								& Tablets <i class="pe-7s-angle-right"></i></a>
							<div class="category-menu-dropdown">
								<div class="category-dropdown-style category-common4">
									<h4 class="categories-subtitle">Desktop</h4>
									<ul>
										<li><a href="#"> Mother Board</a></li>
										<li><a href="#"> Power Supply</a></li>
										<li><a href="#"> RAM</a></li>
										<li><a href="#"> Graphics Card</a></li>
										<li><a href="#"> Hard Disk Drive</a></li>
										<li><a href="#">Cooling Fan</a></li>
										<li><a href="#">HD Cable</a></li>
									</ul>
								</div>
								<div class="category-dropdown-style category-common4">
									<h4 class="categories-subtitle">Laptop</h4>
									<ul>
										<li><a href="#">HP</a></li>
										<li><a href="#">lenovo</a></li>
										<li><a href="#"> vivo</a></li>
										<li><a href="#"> Mack Book Air</a></li>
										<li><a href="#"> Mack Book Pro</a></li>
										<li><a href="#"> LG</a></li>
										<li><a href="#"> Others Brand</a></li>
									</ul>
								</div>
								<div class="category-dropdown-style category-common4">
									<h4 class="categories-subtitle">Others</h4>
									<ul>
										<li><a href="#">Monitor</a></li>
										<li><a href="#">Mouse</a></li>
										<li><a href="#">Keybord</a></li>
										<li><a href="#">Speaker</a></li>
										<li><a href="#">Joy Stick</a></li>
										<li><a href="#">Wireless Speaker</a></li>
										<li><a href="#">Software</a></li>
									</ul>
								</div>
								<div class="category-dropdown-style category-common4">
									<h4 class="categories-subtitle">Accessories</h4>
									<ul class="border-none">
										<li><a href="#">Monitor</a></li>
										<li><a href="#">Mouse</a></li>
										<li><a href="#">Keybord</a></li>
										<li><a href="#">Speaker</a></li>
										<li><a href="#">Joy Stick</a></li>
										<li><a href="#">Wireless Speaker</a></li>
										<li><a href="#">Software</a></li>
									</ul>
								</div>
							</div></li>
						<li><a href="#"><img alt=""
								src="${pageContext.request.contextPath }/resources/user/img/icon-img/7.png">
								Camera & Photos<i class="pe-7s-angle-right"></i></a>
							<div class="category-menu-dropdown">
								<div class="category-dropdown-style category-common3">
									<h4 class="categories-subtitle">Desktop</h4>
									<ul>
										<li><a href="#"> Mother Board</a></li>
										<li><a href="#"> Power Supply</a></li>
										<li><a href="#"> RAM</a></li>
										<li><a href="#"> Graphics Card</a></li>
										<li><a href="#"> Hard Disk Drive</a></li>
										<li><a href="#">Cooling Fan</a></li>
										<li><a href="#">HD Cable</a></li>
									</ul>
								</div>
								<div class="category-dropdown-style category-common3">
									<h4 class="categories-subtitle">Laptop</h4>
									<ul>
										<li><a href="#">HP</a></li>
										<li><a href="#">lenovo</a></li>
										<li><a href="#"> vivo</a></li>
										<li><a href="#"> Mack Book Air</a></li>
										<li><a href="#"> Mack Book Pro</a></li>
										<li><a href="#"> LG</a></li>
										<li><a href="#"> Others Brand</a></li>
									</ul>
								</div>
								<div class="category-dropdown-style category-common3">
									<h4 class="categories-subtitle">Others</h4>
									<ul class="border-none">
										<li><a href="#">Monitor</a></li>
										<li><a href="#">Mouse</a></li>
										<li><a href="#">Keybord</a></li>
										<li><a href="#">Speaker</a></li>
										<li><a href="#">Joy Stick</a></li>
										<li><a href="#">Wireless Speaker</a></li>
										<li><a href="#">Software</a></li>
									</ul>
								</div>
							</div></li>
						<li><a href="#"><img alt=""
								src="${pageContext.request.contextPath }/resources/user/img/icon-img/8.png">TV
								& Audio </a></li>
						<li><a href="#"><img alt=""
								src="${pageContext.request.contextPath }/resources/user/img/icon-img/9.png">
								Game & Play Station</a></li>
						<li><a href="#"><img alt=""
								src="${pageContext.request.contextPath }/resources/user/img/icon-img/10.png">
								Car Electronics </a></li>
						<li><a href="#"><img alt=""
								src="${pageContext.request.contextPath }/resources/user/img/icon-img/11.png">
								Accessories </a></li>
						<li><a href="#"><img alt=""
								src="${pageContext.request.contextPath }/resources/user/img/icon-img/12.png">
								Gadgets</a></li>
						<li><a href="#"><img alt=""
								src="${pageContext.request.contextPath }/resources/user/img/icon-img/13.png">Others
								Equipment</a></li>
					</ul>
				</div>
			</div>
			<div class="menu-slider-wrapper">
				<div class="menu-style-3 menu-hover text-center">
					<nav>
						<ul>
							<li><a href="${pageContext.request.contextPath }/home">home
									<span class="sticker-new">hot</span>
							</a></li>
							<li><a href="#">pages </a>
								<ul class="single-dropdown">

									<li><a
										href="${pageContext.request.contextPath }/login/index">singin</a></li>
									<li><a
										href="${pageContext.request.contextPath }/login/index2">singup</a></li>
									<li><a href="${pageContext.request.contextPath }/cart">cart
											page</a></li>


								</ul></li>
							<li><a href="shop.html">shop <i class="pe-7s-angle-down"></i>
									<span class="sticker-new">hot</span></a>
								<div class="category-menu-dropdown shop-menu">
									<div class="category-dropdown-style category-common2 mb-30">
										<h4 class="categories-subtitle">shop layout</h4>
										<ul>
											<li><a href="${pageContext.request.contextPath }/shop">
													grid 2 column</a></li>

										</ul>
									</div>


								</div></li>
							<li><a href="blog.html">blog <i class="pe-7s-angle-down"></i>
									<span class="sticker-new">hot</span></a>
								<ul class="single-dropdown">
									<li><a href="blog.html">blog 3 colunm</a></li>
									<li><a href="blog-2-col.html">blog 2 colunm</a></li>
									<li><a href="blog-sidebar.html">blog sidebar</a></li>
									<li><a href="blog-details.html">blog details</a></li>
									<li><a href="blog-details-sidebar.html">blog details 2</a></li>
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
	<div class="electronic-banner-area">
		<div class="custom-row-2"></div>
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
												</a> <a class="animate-top" title="Add To Cart" href="${pageContext.request.contextPath }/cart/add/${products.id}/${products.price}/${products.quantity}/${userid.id }"> <i
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
												<a
													href="${pageContext.request.contextPath }/product-details">${products.name }</a>
											</h4>
											<span>${userid.id }</span>
											<h5>${products.price }</h5>
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
										<a href="${pageContext.request.contextPath }/home/product/${products.id}">
											<img
											src="${pageContext.request.contextPath }/resources/user/img/product/electro/${products.avatar }"
											alt="">
										</a>
										<div class="product-action-right">
											<a class="animate-right" href="${pageContext.request.contextPath }/home/product/${products.id}" data-target="#exampleModal"
												data-toggle="modal" title="Quick View"> <i
												class="pe-7s-look"></i>
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
										<h5> $ ${products.price }</h5>
									</div>
								</div>
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
											<a href="${pageContext.request.contextPath }/home/product/${bes.id}"> <img
												src="${pageContext.request.contextPath }/resources/user/img/product/electro/${bes.avatar }"
												alt="">
											</a>
											<div class="product-action-right">
												<a class="animate-top" title="Add To Cart" href="#"> <i
													class="pe-7s-cart"></i>
												</a> <a class="animate-left" title="Wishlist" href="#"> <i
													class="pe-7s-like"></i>
												</a>
											</div>
										</div>
										<div class="product-content-6">
											<div class="product-rating-4"></div>
											<h4>
												<a href="${pageContext.request.contextPath }/home/product/${bes.id}">${bes.name }</a>
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

	<div class="banner-area wrapper-padding pt-30 pb-95">
		<div class="container-fluid">
			<div class="electro-fexible-banner bg-img"
				style="background-image: url(${pageContext.request.contextPath }/resources/user/img/banner/19.jpg)">
				<div class="fexible-content">
					<h3>Play with flexible</h3>
					<p>
						Multicontrol Smooth Controller, Black Color All Buttons <br>are
						somooth, Super Shine.
					</p>
					<a class="btn-hover flexible-btn"
						href="${pageContext.request.contextPath }/product-details">Buy
						Now</a>
				</div>
			</div>
		</div>
	</div>

	<div class="androit-banner-wrapper wrapper-padding pb-175">
		<div class="container-fluid">
			<div class="androit-banner-img bg-img"
				style="background-image: url(${pageContext.request.contextPath }/resources/user/img/banner/36.jpg)">
				<div class="androit-banner-content">
					<h3>
						Xolo Fast T2 Smartphone, Android <br>7.0 Unlocked.
					</h3>
					<a href="${pageContext.request.contextPath }/product-details">Buy
						Now →</a>
				</div>

			</div>
		</div>
	</div>
	<div class="brand-logo-area-2 wrapper-padding ptb-80">
		<div class="container-fluid">
			<div class="brand-logo-active2 owl-carousel">
				<div class="single-brand">
					<img
						src="${pageContext.request.contextPath }/resources/user/img/brand-logo/7.png"
						alt="">
				</div>
				<div class="single-brand">
					<img
						src="${pageContext.request.contextPath }/resources/user/img/brand-logo/8.png"
						alt="">
				</div>
				<div class="single-brand">
					<img
						src="${pageContext.request.contextPath }/resources/user/img/brand-logo/9.png"
						alt="">
				</div>
				<div class="single-brand">
					<img
						src="${pageContext.request.contextPath }/resources/user/img/brand-logo/10.png"
						alt="">
				</div>
				<div class="single-brand">
					<img
						src="${pageContext.request.contextPath }/resources/user/img/brand-logo/11.png"
						alt="">
				</div>
				<div class="single-brand">
					<img
						src="${pageContext.request.contextPath }/resources/user/img/brand-logo/12.png"
						alt="">
				</div>
				<div class="single-brand">
					<img
						src="${pageContext.request.contextPath }/resources/user/img/brand-logo/13.png"
						alt="">
				</div>
				<div class="single-brand">
					<img
						src="${pageContext.request.contextPath }/resources/user/img/brand-logo/7.png"
						alt="">
				</div>
				<div class="single-brand">
					<img
						src="${pageContext.request.contextPath }/resources/user/img/brand-logo/8.png"
						alt="">
				</div>
			</div>
		</div>
	</div>
	<div class="newsletter-area ptb-60">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-6">
					<div class="section-title-5">
						<h2>Newsletter</h2>
						<p>
							Sign Up for get all update news & Get <span>15% off</span>
						</p>
					</div>
				</div>
				<div class="col-md-12 col-lg-6">
					<div class="newsletter-style-3">
						<div id="mc_embed_signup" class="subscribe-form-3 pr-50">
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
									<li><a href="login.html">Login Hare</a></li>
									<li><a href="${pageContext.request.contextPath }/cart">Cart
											History</a></li>
									<li><a href="checkout.html"> Payment History</a></li>
									<li><a href="shop.html">Product Tracking</a></li>
									<li><a href="register.html">Register</a></li>
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
		<div class="footer-middle black-bg-2 pt-35 pb-40">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-4">
						<div class="footer-services-wrapper mb-30">
							<div class="footer-services-icon">
								<i class="pe-7s-car"></i>
							</div>
							<div class="footer-services-content">
								<h3>Free Shipping</h3>
								<p>Free Shipping on Bangladesh</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-4">
						<div class="footer-services-wrapper mb-30">
							<div class="footer-services-icon">
								<i class="pe-7s-shield"></i>
							</div>
							<div class="footer-services-content">
								<h3>Money Guarentee</h3>
								<p>Free Shipping on Bangladesh</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-4">
						<div class="footer-services-wrapper mb-30">
							<div class="footer-services-icon">
								<i class="pe-7s-headphones"></i>
							</div>
							<div class="footer-services-content">
								<h3>Online Support</h3>
								<p>Free Shipping on Bangladesh</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom  black-bg pt-25 pb-30">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-5">
						<div class="footer-menu">
							<nav>
								<ul>
									<li><a href="#">Privacy Policy </a></li>
									<li><a href="blog.html"> Blog</a></li>
									<li><a href="#">Help Center</a></li>
								</ul>
							</nav>
						</div>
					</div>
					<div class="col-lg-6 col-md-7">
						<div class="copyright f-right mrg-5">
							<p>
								Copyright © <a href="https://hastech.company/">HasTech</a> 2018
								. All Right Reserved.
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- modal -->
	<div class="modal fade" id="exampleCompare" tabindex="-1" role="dialog"
		aria-hidden="true">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span class="pe-7s-close" aria-hidden="true"></span>
		</button>
		<div class="modal-dialog modal-compare-width" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<form action="#">
						<div class="table-content compare-style table-responsive">
							<table>
								<thead>
									<tr>
										<th></th>
										<th><a href="#">Remove <span>x</span></a> <img
											src="${pageContext.request.contextPath }/resources/user/img/cart/4.jpg"
											alt="">
											<p>Blush Sequin Top</p> <span>$75.99</span> <a
											class="compare-btn" href="#">Add to cart</a></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="compare-title">
											<h4>Description</h4>
										</td>
										<td class="compare-dec compare-common">
											<p>Lorem Ipsum is simply dummy text of the printing and
												typesetting industry. Lorem Ipsum has beenin the stand ard
												dummy text ever since the 1500s, when an unknown printer
												took a galley</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title">
											<h4>Sku</h4>
										</td>
										<td class="product-none compare-common">
											<p>-</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title">
											<h4>Availability</h4>
										</td>
										<td class="compare-stock compare-common">
											<p>In stock</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title">
											<h4>Weight</h4>
										</td>
										<td class="compare-none compare-common">
											<p>-</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title">
											<h4>Dimensions</h4>
										</td>
										<td class="compare-stock compare-common">
											<p>N/A</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title">
											<h4>brand</h4>
										</td>
										<td class="compare-brand compare-common">
											<p>HasTech</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title">
											<h4>color</h4>
										</td>
										<td class="compare-color compare-common">
											<p>Grey, Light Yellow, Green, Blue, Purple, Black</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title">
											<h4>size</h4>
										</td>
										<td class="compare-size compare-common">
											<p>XS, S, M, L, XL, XXL</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title"></td>
										<td class="compare-price compare-common">
											<p>$75.99</p>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span class="pe-7s-close" aria-hidden="true"></span>
		</button>
		<div class="modal-dialog modal-quickview-width" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div class="qwick-view-left">
						<div class="quick-view-learg-img">
							<div class="quick-view-tab-content tab-content">
								<div class="tab-pane active show fade" id="modal1"
									role="tabpanel">
									<img
										src="${pageContext.request.contextPath }/resources/user/img/quick-view/l1.jpg"
										alt="">
								</div>
								<div class="tab-pane fade" id="modal2" role="tabpanel">
									<img
										src="${pageContext.request.contextPath }/resources/user/img/quick-view/l2.jpg"
										alt="">
								</div>
								<div class="tab-pane fade" id="modal3" role="tabpanel">
									<img
										src="${pageContext.request.contextPath }/resources/user/img/quick-view/l3.jpg"
										alt="">
								</div>
							</div>
						</div>
						<div class="quick-view-list nav" role="tablist">
							<a class="active" href="#modal1" data-toggle="tab" role="tab">
								<img
								src="${pageContext.request.contextPath }/resources/user/img/quick-view/s1.jpg"
								alt="">
							</a> <a href="#modal2" data-toggle="tab" role="tab"> <img
								src="${pageContext.request.contextPath }/resources/user/img/quick-view/s2.jpg"
								alt="">
							</a> <a href="#modal3" data-toggle="tab" role="tab"> <img
								src="${pageContext.request.contextPath }/resources/user/img/quick-view/s3.jpg"
								alt="">
							</a>
						</div>
					</div>
					<div class="qwick-view-right">
						<div class="qwick-view-content">
							<h3>Handcrafted Supper Mug</h3>
							<div class="price">
								<span class="new">$90.00</span> <span class="old">$120.00
								</span>
							</div>
							<div class="rating-number">
								<div class="quick-view-rating">
									<i class="pe-7s-star"></i> <i class="pe-7s-star"></i> <i
										class="pe-7s-star"></i> <i class="pe-7s-star"></i> <i
										class="pe-7s-star"></i>
								</div>
								<div class="quick-view-number">
									<span>2 Ratting (S)</span>
								</div>
							</div>
							<p>Lorem ipsum dolor sit amet, consectetur adip elit, sed do
								tempor incididun ut labore et dolore magna aliqua. Ut enim ad mi
								, quis nostrud veniam exercitation .</p>
							<div class="quick-view-select">
								<div class="select-option-part">
									<label>Size*</label> <select class="select">
										<option value="">- Please Select -</option>
										<option value="">900</option>
										<option value="">700</option>
									</select>
								</div>
								<div class="select-option-part">
									<label>Color*</label> <select class="select">
										<option value="">- Please Select -</option>
										<option value="">orange</option>
										<option value="">pink</option>
										<option value="">yellow</option>
									</select>
								</div>
							</div>
							<div class="quickview-plus-minus">
								<div class="cart-plus-minus">
									<input type="text" value="02" name="qtybutton"
										class="cart-plus-minus-box">
								</div>
								<div class="quickview-btn-cart">
									<a class="btn-hover-black" href="#">add to cart</a>
								</div>
								<div class="quickview-btn-wishlist">
									<a class="btn-hover" href="#"><i class="pe-7s-like"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>





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