<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Ezone - eCommerce HTML5 Template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/resources/user/img/favicon.png">
		
		<!-- all css here -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/magnific-popup.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/animate.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/themify-icons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/pe-icon-7-stroke.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/icofont.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/meanmenu.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/bundle.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/responsive.css">
        <script src="${pageContext.request.contextPath }/resources/user/js/vendor/modernizr-2.8.3.min.js"></script>
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
                            <a href="index.html">
                                <img src="${pageContext.request.contextPath }/resources/user/img/logo/2.png" alt="">
                            </a>
                        </div>
                        <div class="menu-style-2 furniture-menu menu-hover">
                            <nav>
                                <ul>
							<li><a href="${pageContext.request.contextPath }/home">HOME</a>
								</li>
							<li><a href="#">PAGES </a>
								<ul class="single-dropdown">
									
									<li><a href="${pageContext.request.contextPath }/login/index">singin</a></li>
									<li><a href="${pageContext.request.contextPath }/login/index2">singup</a></li>
									<li><a href="${pageContext.request.contextPath }/cart">cart page</a></li>
									
									
								</ul></li>
							<li><a href="#">SHOP <i class="pe-7s-angle-down"></i>
									</a>
								<div class="category-menu-dropdown shop-menu">
									<div class="category-dropdown-style category-common2 mb-30">
										<h4 class="categories-subtitle">shop layout</h4>
										<ul>
											<li><a href="${pageContext.request.contextPath }/shop"> grid 2 column</a></li>
											
										</ul>
									</div>
									
									
								</div></li>
							<li><a href="blog.html">BLOG <i class="pe-7s-angle-down"></i>
									</a>
								<ul class="single-dropdown">
									<li><a href="blog.html">blog 3 colunm</a></li>
									<li><a href="blog-2-col.html">blog 2 colunm</a></li>
									<li><a href="blog-sidebar.html">blog sidebar</a></li>
									<li><a href="blog-details.html">blog details</a></li>
									<li><a href="blog-details-sidebar.html">blog details 2</a></li>
								</ul></li>
							<li><a href="${pageContext.request.contextPath }/contact">CONTACT</a></li>
						</ul>
                            </nav>
                        </div>
       <!-- giỏ hàng -->                 
                        <div class="header-cart">
                            <a class="icon-cart-furniture" href="${pageContext.request.contextPath }/cart">
                                 <i class="ti-shopping-cart"></i>
                                <span class="shop-count-furniture green">02</span> 
                            </a>
                            <%-- <ul class="cart-dropdown">
                         
                                <li class="single-product-cart">
                                    <div class="cart-img">
                                        <a href="#"><img src="${pageContext.request.contextPath }/resources/user/img/cart/2.jpg" alt=""></a>
                                    </div>
                                    <div class="cart-title">
                                        <h5><a href="#"> Bits Headphone</a></h5>
                                        <h6><a href="#">Black</a></h6>
                                        <span>$80.00 x 1</span>
                                    </div>
                                    <div class="cart-delete">
                                        <a href="#"><i class="ti-trash"></i></a>
                                    </div>
                                </li>
                            
                                <li class="cart-space">
                                    <div class="cart-sub">
                                        <h4>Subtotal</h4>
                                    </div>
                                    <div class="cart-price">
                                        <h4>$240.00</h4>
                                    </div>
                                </li>
                                <li class="cart-btn-wrapper">
                                    <a class="cart-btn btn-hover" href="${pageContext.request.contextPath }/cart">view cart</a>
                                    <a class="cart-btn btn-hover" href="#">checkout</a>
                                </li>
                            </ul>
                        </div>
                    </div> --%>
                    <div class="row">
                        <div class="mobile-menu-area d-md-block col-md-12 col-lg-12 col-12 d-lg-none d-xl-none">
                            <div class="mobile-menu">
                                <nav id="mobile-menu-active">
                                    <ul class="menu-overflow">
                                        <li><a href="${pageContext.request.contextPath }/home">HOME</a>
                                            <!-- <ul>
                                                <li><a href="index.html">Fashion</a></li>
                                                <li><a href="index-fashion-2.html">Fashion style 2</a></li>
                                                <li><a href="index-fruits.html">Fruits</a></li>
                                                <li><a href="index-book.html">book</a></li>
                                                <li><a href="index-electronics.html">electronics</a></li>
                                                <li><a href="index-electronics-2.html">electronics style 2</a></li>
                                                <li><a href="index-food.html">food & drink</a></li>
                                                <li><a href="index-furniture.html">furniture</a></li>
                                                <li><a href="index-handicraft.html">handicraft</a></li>
                                                <li><a href="index-smart-watch.html">smart watch</a></li>
                                                <li><a href="index-sports.html">sports</a></li>
                                            </ul> -->
                                        </li>
                                        <li><a href="#">pages</a>
                                            <ul>
                                                <li><a href="about-us.html">about us</a></li>
                                                <li><a href="menu-list.html">menu list</a></li>
                                                <li><a href="login.html">login</a></li>
                                                <li><a href="register.html">register</a></li>
                                                <li><a href="cart.html">cart page</a></li>
                                                <li><a href="checkout.html">checkout</a></li>
                                                <li><a href="wishlist.html">wishlist</a></li>
                                                <li><a href="contact.html">contact</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">shop</a>
                                            <ul>
                                                <li><a href="shop-grid-2-col.html"> grid 2 column</a></li>
                                                <li><a href="shop-grid-3-col.html"> grid 3 column</a></li>
                                                <li><a href="shop.html">grid 4 column</a></li>
                                                <li><a href="shop-grid-box.html">grid box style</a></li>
                                                <li><a href="shop-list-1-col.html"> list 1 column</a></li>
                                                <li><a href="shop-list-2-col.html">list 2 column</a></li>
                                                <li><a href="shop-list-box.html">list box style</a></li>
                                                <li><a href="product-details.html">tab style 1</a></li>
                                                <li><a href="product-details-2.html">tab style 2</a></li>
                                                <li><a href="product-details-3.html"> tab style 3</a></li>
                                                <li><a href="product-details-4.html">sticky style</a></li>
                                                <li><a href="product-details-5.html">sticky style 2</a></li>
                                                <li><a href="product-details-6.html">gallery style</a></li>
                                                <li><a href="product-details-7.html">gallery style 2</a></li>
                                                <li><a href="product-details-8.html">fixed image style</a></li>
                                                <li><a href="product-details-9.html">fixed image style 2</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">BLOG</a>
                                            <ul>
                                                <li><a href="blog.html">blog 3 colunm</a></li>
                                                <li><a href="blog-2-col.html">blog 2 colunm</a></li>
                                                <li><a href="blog-sidebar.html">blog sidebar</a></li>
                                                <li><a href="blog-details.html">blog details</a></li>
                                                <li><a href="blog-details-sidebar.html">blog details 2</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="contact.html"> Contact  </a></li>
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
                                <li>Get Access: <a href="${pageContext.request.contextPath }/login/index">SINGIN</a></li>
                                <li><a href="${pageContext.request.contextPath }/login/index2">SINGUP</a></li>
                            </ul>
                        </div>
                      
                    </div>
                </div>
            </div>
        </header>
        <!-- header end anh lon -->
		<%-- <div class="breadcrumb-area pt-205 pb-210" style="background-image: url(${pageContext.request.contextPath }/resources/user/img/bg/breadcrumb.jpg)">
            <div class="container">
                <div class="breadcrumb-content text-center">
                    <h2>login</h2>
                    <ul>
                        <li><a href="#">home</a></li>
                        <li> login </li>
                    </ul>
                </div>
            </div>
        </div> --%>
        <!-- login-area start -->
        <div class="register-area ptb-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12 col-12 col-lg-6 col-xl-6 ml-auto mr-auto">
                        <div class="login">
                            <div class="login-form-container">
                                <div class="login-form">
                                    <form action="#" method="post">
                                        <input type="text" name="user-name" placeholder="Username">
                                        <input type="password" name="user-password" placeholder="Password">
                                        <div class="button-box">
                                            <div class="login-toggle-btn">
                                                <input type="checkbox">
                                                <label>Remember me</label>
                                                <a href="#">Forgot Password?</a>
                                            </div>
                                            <button type="submit" class="default-btn floatright">Login</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- login-area end -->
	<%-- 	<footer class="footer-area">
            <div class="footer-top-area bg-img pt-105 pb-65" style="background-image: url(${pageContext.request.contextPath }/resources/user/img/bg/1.jpg)" data-overlay="9">
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
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is dummy.</p>
                                    <div id="mc_embed_signup" class="subscribe-form pr-40">
                                        <form action="http://devitems.us11.list-manage.com/subscribe/post?u=6bbb9b6f5827bd842d9640c82&amp;id=05d85f18ef" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" novalidate>
                                            <div id="mc_embed_signup_scroll" class="mc-form">
                                                <input type="email" value="" name="EMAIL" class="email" placeholder="Enter Your E-mail" required>
                                                <!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups-->
                                                <div class="mc-news" aria-hidden="true">
                                                    <input type="text" name="b_6bbb9b6f5827bd842d9640c82_05d85f18ef" tabindex="-1" value="">
                                                </div>
                                                <div class="clear">
                                                    <input type="submit" value="Subscribe" name="subscribe" id="mc-embedded-subscribe" class="button">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="footer-contact">
                                        <p><span><i class="ti-location-pin"></i></span> 77 Seventh avenue USA 12555. </p>
                                        <p><span><i class=" ti-headphone-alt "></i></span> +88 (015) 609735 or +88 (012) 112266</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer-bottom black-bg ptb-20">
                <div class="container">
                    <div class="row">
                        <div class="col-12 text-center">
                            <div class="copyright">
                                <p>
                                    Copyright ©
                                    <a href="https://hastech.company/">HasTech</a> 2018 . All Right Reserved.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer> --%>
		<!-- modal -->
        <div class="modal fade" id="exampleCompare" tabindex="-1" role="dialog" aria-hidden="true">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
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
                                            <th>
                                                <a href="#">Remove <span>x</span></a>
                                                <img src="${pageContext.request.contextPath }/resources/user/img/cart/4.jpg" alt="">
                                                <p>Blush Sequin Top </p>
                                                <span>$75.99</span>
                                                <a class="compare-btn" href="#">Add to cart</a>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="compare-title"><h4>Description </h4></td>
                                            <td class="compare-dec compare-common">
                                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has beenin the stand ard dummy text ever since the 1500s, when an unknown printer took a galley</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="compare-title"><h4>Sku </h4></td>
                                            <td class="product-none compare-common">
                                                <p>-</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="compare-title"><h4>Availability  </h4></td>
                                            <td class="compare-stock compare-common">
                                                <p>In stock</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="compare-title"><h4>Weight   </h4></td>
                                            <td class="compare-none compare-common">
                                                <p>-</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="compare-title"><h4>Dimensions   </h4></td>
                                            <td class="compare-stock compare-common">
                                                <p>N/A</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="compare-title"><h4>brand   </h4></td>
                                            <td class="compare-brand compare-common">
                                                <p>HasTech</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="compare-title"><h4>color   </h4></td>
                                            <td class="compare-color compare-common">
                                                <p>Grey, Light Yellow, Green, Blue, Purple, Black </p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="compare-title"><h4>size    </h4></td>
                                            <td class="compare-size compare-common">
                                                <p>XS, S, M, L, XL, XXL </p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="compare-title"></td>
                                            <td class="compare-price compare-common">
                                                <p>$75.99 </p>
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
        <script src="${pageContext.request.contextPath }/resources/user/js/vendor/jquery-1.12.0.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/popper.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/jquery.magnific-popup.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/isotope.pkgd.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/imagesloaded.pkgd.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/jquery.counterup.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/ajax-mail.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/plugins.js"></script>
        <script src="${pageContext.request.contextPath }/resources/user/js/main.js"></script>
    </body>
</html>
