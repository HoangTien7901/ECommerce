<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
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

<!-- Toastr -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/toastr/toastr.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/fontawesome-free/css/all.min.css">
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

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">

</head>

<body>
	<header>
		<div class="header-top-wrapper-2 border-bottom-2">
			<div class="header-info-wrapper pl-200 pr-200">
				<div class="header-contact-info">
					<ul>
						<li><i class="pe-7s-call"></i> +011 2231 4545</li>
						<li><i class="pe-7s-mail"></i> <a href="#">company@domail.info</a></li>
					</ul>
				</div>
				<div class="electronics-login-register">
					<ul>
						<c:if test="${username == null}" >
							<li><a href="${pageContext.request.contextPath }/user/account/login"><i class="fas fa-sign-in-alt"></i>Login</a></li>
							<li><a href="${pageContext.request.contextPath }/user/account/register"><i class="fas fa-user-plus"></i>Register</a></li>
						</c:if>
						<c:if test="${username != null}" >
							<li><a href="${pageContext.request.contextPath }/user/account/profile"><i class="pe-7s-users"></i>Hello ${username }</a></li>
							<li><a href="${pageContext.request.contextPath }/user/account/logout"><i class="fas fa-sign-out-alt"></i>Logout</a></li>
						</c:if>
						<li><a data-toggle="modal" data-target="#exampleCompare"
							href="#"><i class="pe-7s-repeat"></i>Compare</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="header-bottom pt-40 pb-30 clearfix">
			<div class="header-bottom-wrapper pr-200 pl-200">
				<div class="logo-3">
					<a href="${pageContext.request.contextPath }/user/home/index"> <img
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
					<div class="categories-cart same-style">
						<div class="same-style-icon">
							<a href="#"><i class="pe-7s-cart"></i></a>
						</div>
						<div class="same-style-text">
							<c:if test="${username != null}" >
								<a href="${pageContext.request.contextPath }/user/cart/index">My Cart<br><span id="productInCartAmount">${productInCartAmount }</span> item(s)</a>
							</c:if>
							<c:if test="${username == null}" >
								<a href="${pageContext.request.contextPath }/user/account/login">My Cart</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- header end -->

	<!--  invoke here #######################  -->
	<jsp:invoke fragment="content"></jsp:invoke>
	<!--  invoke here #######################  -->

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
									<li><a href="cart.html">Cart History</a></li>
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
	
	<input type="hidden" id="msg" value="${msg }">
	<input type="hidden" id="msgType" value="${msgType }">

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

	<!-- Toastr -->
	<script
		src="${pageContext.request.contextPath }/resources/manager/plugins/toastr/toastr.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/manager/custom/toastr.js"></script>
	
	<!-- jquery-validation -->
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/jquery-validation/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/jquery-validation/additional-methods.min.js"></script>

	<script>
		$(document).ready(function() {
	    	$.validator.setDefaults({
			    submitHandler: function () {
			    	$('#formLogin')[0].submit();
			    }
			  });
			
	    	$('#formLogin').validate({
			    rules: {
			      username: {
			        required: true,
			      },
			      password: {
			    	 required: true,
			      }
			    },
			    errorElement: 'span',
			    errorPlacement: function (error, element) {
			      error.addClass('invalid-feedback');
			      element.closest('.form-group').append(error);
			    },
			    highlight: function (element, errorClass, validClass) {
			      $(element).addClass('is-invalid');
			    },
			    unhighlight: function (element, errorClass, validClass) {
			      $(element).removeClass('is-invalid');
			    }
			  });
		});
	</script>
	
	 <!-- product modal in home page -->
	<script>
    	$(document).ready(function() {
    		$(".modal-opener").on('click', function(event){
    		    event.stopPropagation();
    		    event.stopImmediatePropagation();
    		    
    		    var id = $(this).data('id');
    		    var target = $(this).data('target');
    		    
    		    $.ajax({
		    		type: 'GET',
					url: '${pageContext.request.contextPath }/user/product/findInfoById/' + id,
					success: function(product) {
						$("#productDetailsImg").attr("src","${pageContext.request.contextPath }/uploads/images/" + product.avatar); 
						$("#productDetailsName").html(product.name);
						$("#productDetailsRatingCount").html(product.ratingCount + " review(s)");
						$("#productDetailsDescription").html(product.description);
						
						var ratingStars = "";
						for (let i = 1; i <= (product.ratingAverage * 10 / 10); i++) {
							ratingStars += '<i class="pe-7s-star"></i>';
						}
						
						$("#productDetailsRatingResult").html(ratingStars);
						$("#productDetailsDescriptionDetails").html(product.descriptionDetail);
					},
					complete: function() {
						$(target).modal('show');
					}
		    	})
    		});
    	})
    </script>
	
    <!-- change product amount in cart page -->
	<script>
    	$(document).ready(function() {
    		$(".product-quantity-input").on('change', function(event){
    		    event.stopPropagation();
    		    event.stopImmediatePropagation();
    		    
    		    var id = $(this).data('id');
    		    var value = $(this).val();

    		    $.ajax({
		    		type: 'GET',
					url: '${pageContext.request.contextPath }/user/cart/updateQuantity/' + id + '/' + value,
					success: function(data, textStatus, jqXHR) {
						var total = 0;
						
						data.forEach(function(product) {
							var id = product.productId;
							var subtotal = $("#price" + id).text() * $("#quantity" + id).val();
							$("#subtotal" + id).html(subtotal);
							total += subtotal;
						})

						$("#cart-total").html(total);
					},
					error: function(jqXHR, textStatus, errorThrown ) {
						toastr.error("An error occurs: " + textStatus);
					}
		    	})
    		});
    	})
    </script>
    
    <!-- add product to cart in home page -->
	<script>
    	$(document).ready(function() {
    		$(".product-to-cart").on('click', function(event){
    		    event.stopPropagation();
    		    event.stopImmediatePropagation();
    		    
    		    var id = $(this).data('id');
    		   
    		    $.ajax({
		    		type: 'GET',
					url: '${pageContext.request.contextPath }/user/home/addProduct/' + id + '/1',
					success: function(data, textStatus, jqXHR) {
						toastr.success("Product has been place in your cart.");
						$("#productInCartAmount").html(data);
					},
					error: function(jqXHR, textStatus, errorThrown ) {
						if (jqXHR.responseText === "NO_USER_EXCEPTION") {
							window.location.replace('${pageContext.request.contextPath }/user/account/login');
						} else {
							toastr.options = {
								"timeOut": 0
							}
							
							toastr.error(textStatus + " - " + jqXHR.responseText);
						}
					}
		    	})
    		});
    	})
    </script>
    
    <!-- delete product in cart in cart page -->
	<script>
    	$(document).ready(function() {
    		$(".remove-product-in-cart").on('click', function(event){
    		    event.stopPropagation();
    		    event.stopImmediatePropagation();
    		    
    		    var id = $(this).data('id');
    		    
    		    $.ajax({
		    		type: 'GET',
					url: '${pageContext.request.contextPath }/user/cart/delete/' + id,
					success: function(data, textStatus, jqXHR) {
						// hide deleted product
						$('#product-in-cart-row-' + id).css('display', 'none');
						
						// change number of product in cart
						$("#productInCartAmount").html(data.length);
						
						// change total
						var total = 0;
						data.forEach(function(product) {
							total += product.price * product.quantity;							
						});
						
						$("#cart-total").html(total);
					},
					error: function(jqXHR, textStatus, errorThrown ) {
						toastr.options = {
							"timeOut": 0
						}
							
						toastr.error(textStatus + " - " + jqXHR.responseText);
					}
		    	})
    		});
    	})
    </script>
	
	<!-- date picker in register page -->
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#birthday").datepicker();
			$("#birthday").datepicker( "option", "dateFormat", "dd/mm/yy");
			$("#birthday").datepicker( "setDate", "01/01/2001" );
		});
	</script>
</body>

</html>


