<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>${title }</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath }/uploads/images/${store.logo }">

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
	
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">

</head>

<body>
	<header>
		<div class="header-top-wrapper-2 border-bottom-2">
			<div class="header-info-wrapper pl-200 pr-200">
				<div class="header-contact-info">
					<ul>
						<li><i class="pe-7s-call"></i> ${contact.phone }</li>
						<li><i class="pe-7s-mail"></i> <a>${contact.email }</a></li>
					</ul>
				</div>
				<div class="electronics-login-register">
					<ul>
						<c:if test="${username == null}" >
							<li><a href="${pageContext.request.contextPath }/user/account/login"><i class="fas fa-sign-in-alt"></i>Login</a></li>
							<li><a href="${pageContext.request.contextPath }/user/account/register"><i class="fas fa-user-plus"></i>Register</a></li>
						</c:if>
						<c:if test="${username != null}" >
							<c:if test="${roleId != null}">
								<c:if test="${roleId == 1 }">
									<li><a href="${pageContext.request.contextPath }/user/account/profile" title="Profile"><i class="pe-7s-users"></i>Hello ${username }</a></li>
								</c:if>
								<c:if test="${roleId == 2 }">
									<li><a href="${pageContext.request.contextPath }/manager/profile/index" title="Admin"><i class="pe-7s-users"></i>Hello ${username }</a></li>
								</c:if>
							</c:if>
							<li><a href="${pageContext.request.contextPath }/user/cart/transaction"><i class="fas fa-cart-arrow-down"></i>Transactions</a></li>
							<li><a href="${pageContext.request.contextPath }/user/account/logout"><i class="fas fa-sign-out-alt"></i>Logout</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		<div class="header-bottom pt-40 pb-30 clearfix">
			<div class="header-bottom-wrapper pr-200 pl-200">
				<div class="logo-3">
					<a href="${pageContext.request.contextPath }/user/home/index"> <img
						src="${pageContext.request.contextPath }/uploads/images/${store.logo }"
						alt="Store's logo" height="50px" title="Store's logo">
					</a>
				</div>
				<div class="categories-search-wrapper">
					<div class="categories-wrapper">
					<c:if test="${hideTopSearchBar == null}">
						<form method="get" action="${pageContext.request.contextPath }/user/search/index" >
							<input placeholder="Enter Your key word" type="text" name="keyword">
							<button type="submit">Search</button>
						</form>
					</div>
					</c:if>
				</div>
				<div class="trace-cart-wrapper">
					<div class="categories-cart same-style">
						<div class="same-style-icon">
							<c:if test="${username != null}" >
								<a href="${pageContext.request.contextPath }/user/cart/index"><i class="pe-7s-cart"></i></a>
							</c:if>
							<c:if test="${username == null}" >
								<a href="${pageContext.request.contextPath }/user/account/login"><i class="pe-7s-cart"></i></a>
							</c:if>
						</div>
						<div class="same-style-text">
							<c:if test="${username != null}" >
								<a href="${pageContext.request.contextPath }/user/cart/index">My Cart<br><span id="productInCartAmount">${productInCartAmount }</span> item(s)</a>
							</c:if>
							<c:if test="${username == null}" >
								<a href="${pageContext.request.contextPath }/user/account/login">My Cart<br>0 item(s)</a>
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
									<div class="footer-info-content2">
										<p>
											${contact.name }
										</p>
									</div>
								</div>
								<div class="footer-address-electro">
									<div class="footer-info-icon2">
										<span>Address:</span>
									</div>
									<div class="footer-info-content2">
										<p>
											${contact.address }
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-xl-4">
						<div class="footer-widget mb-40">
							<h3 class="footer-widget-title-3">&nbsp;</h3>
							<div class="footer-info-wrapper-2">
								<div class="footer-address-electro">
									<div class="footer-info-icon2">
										<span>Phone:</span>
									</div>
									<div class="footer-info-content2">
										<p>
											${contact.phone }
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-xl-4">
						<div class="footer-widget mb-40">
							<h3 class="footer-widget-title-3">&nbsp;</h3>
							<div class="footer-info-wrapper-2">
								<div class="footer-address-electro">
									<div class="footer-info-icon2">
										<span>Email:</span>
									</div>
									<div class="footer-info-content2">
										<p>
											<a href="#">${contact.email }</a>
										</p>
									</div>
								</div>
							</div>
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

	<!-- password form in user profile -->
	<script>
		$(document).ready(function() {
			$.validator.addMethod(
					  "passwordPattern",
					  function(value, element, regexp) {
					    var re = new RegExp(regexp);
					    return this.optional( element ) || /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$/.test( value );
					  },
					  "Password should be between 8 and 20 characters and have at least one letter, one number and one special character."
					);
			
	    	$.validator.setDefaults({
			    submitHandler: function () {
			    	$('#formPassword')[0].submit();
			    }
			  });
			
	    	$('#formPassword').validate({
			    rules: {
			      newPassword: {
			        required: true,
			        passwordPattern: true,
			      },
			      oldPassword: {
			    	 required: true,
			    	 minlength: 8,
				     maxlength: 20,
			      },
			      confirmPassword: {
				  	required: true,
				    minlength: 8,
					maxlength: 20,
					equalTo : "#newPassword",
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

 	<!-- login form -->
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
						
						if (product.price != product.originalPrice) {
							$("#productDetailsPrice").html("$" + product.price);
							$("#productDetailsOriginalPrice").html("$" + product.originalPrice);
						} else {
							$("#productDetailsPrice").html("$" + product.price);
						}
						
						var ratingStars = "";
						for (let i = 1; i <= (product.ratingAverage * 10 / 10); i++) {
							ratingStars += '<i class="pe-7s-star"></i>';
						}
						$("#productDetailsId").data('id', product.id);
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
						toastr.options = {
							"timeOut": "0"
						} 
						
						toastr.error("An error occurs: " + textStatus);
					}
		    	})
    		});
    	})
    </script>
    
    <!-- add product to cart -->
	<script>
    	$(document).ready(function() {
    		$(".product-to-cart").on('click', function(event){
    		    event.stopPropagation();
    		    event.stopImmediatePropagation();
    		    
    		    var id = $(this).data('id');
    		    var quantity = $("#quantityToCart").val();
    		    if (!quantity) {
    		    	quantity = 1;
    		    } else {
    		    	if (quantity <= 0) {
    		    		return;
    		    	}
    		    }
    		    
    		    console.log('${pageContext.request.contextPath }/user/home/addProduct/' + id + '/' + quantity);
    		   
    		  	$.ajax({
		    		type: 'GET',
					url: '${pageContext.request.contextPath }/user/home/addProduct/' + id + '/' + quantity,
					success: function(data, textStatus, jqXHR) {
						toastr.success("Product has been place in your cart.");
						$("#productInCartAmount").html(data);
					},
					error: function(jqXHR, textStatus, errorThrown ) {
						if (jqXHR.responseText === "NO_USER_EXCEPTION") {
							window.location.replace('${pageContext.request.contextPath }/user/account/login');
						} else {
							toastr.options = {
								"timeOut": "0"
							}
							
							toastr.error(textStatus + " - " + jqXHR.responseText);
						}
					}
		    	});
    		});
    	})
    </script>
    
     <!-- filter products in search page -->
	<script>
    	$(document).ready(function() {
    		function filter(categoryId) {
    			var keyword = $("#keyword").val();
    			
    			if (keyword === "") {
    				keyword = "tmp";
    			}
    		   	var min = $("#minPrice").val();
    		   	var max = $("#maxPrice").val();
    		   
    		   	var url = '${pageContext.request.contextPath }/user/search/search/' + keyword + '/' + min + '/' + max;
    		   	if (categoryId) {
    		   		url += '/' + categoryId;
    		   	}
    		   	
    		   	$.ajax({
		    		type: 'GET',
					url: url,
					success: function(data, textStatus, jqXHR) {
						var result1 = '';
						var result2 = '';
						
						if (data.length == 0) {
							result1 = '<span>0 product found.</span>';
							result2 = '<span>0 product found.</span>';
						} else {
							data.forEach(function(product) {
								result1 += '<div class="col-md-6 col-xl-4"> <div class="product-wrapper mb-30">';
								result1 += '<div class="product-img"><a href="#"><img src="${pageContext.request.contextPath }/uploads/images/' + product.avatar + '" alt="">';
								result1 += '</a><div class="product-action">';
								result1 += '<a class="animate-top product-to-cart" title="Add To Cart" data-id="' + product.id + '">';
								result1 += '<i class="pe-7s-cart"></i></a>';
								result1 += '<a class="animate-right modal-opener" title="Quick View"';
								result1 += 'data-toggle="modal" data-target="#productDetailsModal" data-id="' + product.id +'">';
								result1 += '<i class="pe-7s-look"></i></a></div></div>';
								result1 += '<div class="product-content">';
								result1 += '<h4><a>' + product.name +'</a></h4>';
								result1 += '<span>$'+ product.price +'</span>';
								result1 += '</div></div></div>';
								
								result2 += '<div class="col-lg-12 col-xl-6">';
								result2 += '<div class="product-wrapper mb-30 single-product-list product-list-right-pr mb-60">';
								result2 += '<div class="product-img list-img-width"><a href="#">';
								result2 += '<img src="${pageContext.request.contextPath }/uploads/images/'+ product.avatar +'" alt="">';
								result2 += '</a><div class="product-action-list-style">';
								result2 += '<a class="animate-right modal-opener" title="Quick View"';
								result2 += 'data-toggle="modal" data-target="#productDetailsModal" data-id="' + product.id + '">';
								result2 += '<i class="pe-7s-look"></i></a></div></div>';
								result2 += '<div class="product-content-list">';
								result2 += '<div class="product-list-info"><h4><a>' + product.name + '</a></h4>';
								result2 += '<span>$' + product.price + '</span>';
								result2 += '<p>' + product.description + '</p></div>';
								result2 += '<div class="product-list-cart-wishlist"><div class="product-list-cart">';
								result2 += '<a class="btn-hover list-btn-style product-to-cart" data-id="'+ product.id +'">add to cart</a></div>';
								result2 += '</div></div></div></div>';
							});
						}
						
						$("#productRows1").html(result1);
						$("#productRows2").html(result2);
					},
					error: function(jqXHR, textStatus, errorThrown ) {
						if (jqXHR.responseText === "NO_USER_EXCEPTION") {
							window.location.replace('${pageContext.request.contextPath }/user/account/login');
						} else {
							toastr.options = {
								"timeOut": "0"
							}
							
							toastr.error(textStatus + " - " + jqXHR.responseText);
						}
					}
    		   	})
    		};
    		
    		$(".search").on('click', function(event){
    		    event.stopPropagation();
    		    event.stopImmediatePropagation();
    		    
    		    filter();
		    }) 
		    
		    $(".search-with-category").on('click', function(event){
    		    event.stopPropagation();
    		    event.stopImmediatePropagation();
    		    
    		    var categoryId = $(this).data('id');
    		    filter(categoryId);
		    });
    		
    		 $(".search-with-category-on-home-page").on('click', function(event){
     		    event.stopPropagation();
     		    event.stopImmediatePropagation();
     		    
     		   	var categoryId = $(this).data('id');
     		   	window.location.replace("${pageContext.request.contextPath}/user/search/index/" + categoryId);
 		    })
    		   	
    		$("#searchForm").on('submit', function(event){
				event.preventDefault();
        		    
				filter();
			}) 
    	})
    </script>
    
    <!-- delete product in cart in cart page -->
	<script>
    	$(document).ready(function() {
    		$( "#target" ).submit(function( event ) {
    			  alert( "Handler for .submit() called." );
    			  
    			});
    		$(".remove-product-in-cart").on('click submit', function(event){
    			event.preventDefault();
    		    event.stopPropagation();
    		    event.stopImmediatePropagation();
    		    
    		    var id = $(this).data('id');
    		    
    		    $.ajax({
		    		type: 'GET',
					url: '${pageContext.request.contextPath }/user/cart/delete/' + id,
					success: function(data, textStatus, jqXHR) {
						var result = '';
						
						data.forEach(function(item, i) {
							result += '<tr id="product-in-cart-row-' + item.id + '">';
							result += '<td class="product-remove"><a';
							result += 'class="remove-product-in-cart" data-id="' + item.id + '"><i class="pe-7s-close"></i></a></td>';
							result += '<td class="product-thumbnail">';
							result += '<a><img width="200px"';
							result += 'src="${pageContext.request.contextPath }/uploads/images/' + item.avatar + '" alt=""></a></td>';
							result += '<td class="product-name"><a href="#">' + item.name + '</a></td>';
							result += '<td class="product-price-cart">';
							result += '<span class="amount">$ <span id="price' + item.id + '">' + item.price + '</span></span></td>';
							result += '<td class="product-quantity">';
							result += '<input value="' + item.quantity + '"';
							result += 'type="number" id="quantity' + item.id + '" class="product-quantity-input" data-id="' + item.id + '" min="1">';
							result += '</td><td class="product-subtotal" id="subtotal' + item.id + '">' + (item.price * item.quantity);
							result += '<input type="hidden" name="item_number_' + (i + 1) + '" value="' + item.id + '">';
							result += '<input type="hidden" name="item_name_' + (i + 1) + '" value="' + item.name + '">';
							result += '<input type="hidden" name="amount_' + (i + 1) + '" value="' + item.price + '">';
							result += '<input type="hidden" name="quantity_' + (i + 1) + '" value="' + item.quantity + '"></td></tr>';
						});
						
						$("#products-in-cart").html(result);
						
						// change number of product in cart and disable check out button if needed
						var amount = data.length
						if (amount == 0) {
							$("#checkoutButton").prop('disabled', true);
						} else {
							$("#checkoutButton").prop('disabled', false);
						}
						$("#productInCartAmount").html(data.length);
						
						// change total
						var total = 0;
						data.forEach(function(product) {
							total += product.price * product.quantity;							
						});
						
						$("#cart-total").html(total);
						
						location.reload();
					},
					error: function(jqXHR, textStatus, errorThrown ) {
						toastr.options = {
							"timeOut": "0"
						}
							
						toastr.error(textStatus + " - " + jqXHR.responseText);
					}
		    	})
    		});
    	})
    </script>
    
    <!-- InputMask -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/moment/moment.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/inputmask/jquery.inputmask.min.js"></script>
	<script>
		$(document).ready(function() {
			//Datemask dd/mm/yyyy
	    	$('#birthday').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' });
		});
	</script>
	
	<!-- DataTables  & Plugins -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/jszip/jszip.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/pdfmake/pdfmake.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/pdfmake/vfs_fonts.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/buttons.print.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
	
	<script>
		$(function() {
			$('#dataTable').DataTable({
				"paging" : true,
				"lengthChange" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false,
				"responsive" : true,
			});
		});
	</script>
	
	<!-- date picker in register page -->
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#birthday, #birthdayRegister").datepicker();
			$("#birthday, #birthdayRegister").datepicker( "option", "dateFormat", "dd/mm/yy");
			$("#birthdayRegister").datepicker( "setDate", "01/01/2001" );
			
			$('#btnResetProfileForm').trigger('click');
		});
	</script>
</body>

</html>


