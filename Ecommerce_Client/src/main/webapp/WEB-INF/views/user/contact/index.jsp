<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!doctype html>
<html class="no-js" lang="en">
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
		<div class="header-top-wrapper-2 border-bottom-2">
			<div class="header-info-wrapper pl-200 pr-200">
				<div class="header-contact-info"></div>
				<div class="electronics-login-register">
					<ul>
						<li><b><a
								href="${pageContext.request.contextPath }/login/index">Login</a></b>|
							<b><a href="${pageContext.request.contextPath }/login/index2">Register</a></b></li>
					</ul>
				</div>
			</div>
		</div>
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
								<li><a>pages</a></li>

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
		<div class="header-bottom-furniture wrapper-padding-2 border-top-3">
			<div class="container-fluid">
				<div class="furniture-bottom-wrapper">
					<div class="furniture-login"></div>


				</div>
			</div>
		</div>
	</header>
	<!-- header end -->

	<!-- shopping-cart-area start -->
	<div class="contact-area ptb-100">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="contact-map-wrapper">
						<div class="contact-message">
							<div class="contact-title">
								<h4>Contact Information</h4>
							</div>
							<form id="contact-form" class="contact-form"
								action="${pageContext.request.contextPath }/contact/save"
								method="POST">
								<div class="row">
									<div class="col-md-6">
										<div class="contact-input-style mb-30">
											<label>Name</label> <input name="name" required=""
												type="text">
										</div>
									</div>
									<div class="col-md-6">
										<div class="contact-input-style mb-30">
											<label>Email</label> <input name="email" required=""
												type="email">
										</div>
									</div>
									<div class="col-md-6">
										<div class="contact-input-style mb-30">
											<label>Phone</label> <input name="phone" required=""
												type="text">
										</div>
									</div>
									<div class="col-md-6">
										<div class="contact-input-style mb-30">
											<label>Address</label> <input name="address" required=""
												type="text">
										</div>
									</div>
									<div class="col-md-12">
										<!-- <div class="contact-textarea-style mb-30">
                                                <label>Comment*</label>
                                                <textarea class="form-control2" name="message" required=""></textarea>
                                            </div> -->
										<button class="submit contact-btn btn-hover" type="submit">
											Send Message</button>
									</div>
								</div>
							</form>
							<!-- <p class="form-messege"></p> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- shopping-cart-area end -->
	<footer>
		<div class="footer-bottom black-bg ptb-20">
			<div class="container">
				<div class="row">
					<div class="col-12 text-center">
						<div class="copyright">
							<p>
								Copyright © <a href="https://hastech.company/">Do An</a> 2021
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
										<td class="compare-title"><h4>Description</h4></td>
										<td class="compare-dec compare-common">
											<p>Lorem Ipsum is simply dummy text of the printing and
												typesetting industry. Lorem Ipsum has beenin the stand ard
												dummy text ever since the 1500s, when an unknown printer
												took a galley</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title"><h4>Sku</h4></td>
										<td class="product-none compare-common">
											<p>-</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title"><h4>Availability</h4></td>
										<td class="compare-stock compare-common">
											<p>In stock</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title"><h4>Weight</h4></td>
										<td class="compare-none compare-common">
											<p>-</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title"><h4>Dimensions</h4></td>
										<td class="compare-stock compare-common">
											<p>N/A</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title"><h4>brand</h4></td>
										<td class="compare-brand compare-common">
											<p>HasTech</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title"><h4>color</h4></td>
										<td class="compare-color compare-common">
											<p>Grey, Light Yellow, Green, Blue, Purple, Black</p>
										</td>
									</tr>
									<tr>
										<td class="compare-title"><h4>size</h4></td>
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
