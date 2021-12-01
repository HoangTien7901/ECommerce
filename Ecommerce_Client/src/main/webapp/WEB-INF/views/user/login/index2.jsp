<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Ezone</title>
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
                                    <li><a href="#">PAGES</a>
                                        <ul class="single-dropdown">
                                            <li><a href="${pageContext.request.contextPath }/login/index">Login</a></li>
                                            <li><a href="${pageContext.request.contextPath }/login/index2">Register</a></li>
                                            <li><a href="${pageContext.request.contextPath }/cart">My Cart</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#">SHOP</a></li>
                                   
                                    <li><a href="${pageContext.request.contextPath }/contact">CONTACT</a></li>
                                </ul>
                            </nav>
                        </div>
                        <div class="header-cart">
                            <a class="icon-cart-furniture" href="${pageContext.request.contextPath }/cart">
                                <i class="ti-shopping-cart"></i>
                              
                            </a>
                           
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="header-bottom-furniture wrapper-padding-2 border-top-3">
                <div class="container-fluid">
                    <div class="furniture-bottom-wrapper">
                        <div class="furniture-login">
                             <ul>
                                <li>Get Access: <a href="${pageContext.request.contextPath }/login/index">Login</a></li>
                                <li><a href="${pageContext.request.contextPath }/login/index2">Register</a></li>
                            </ul>
                        </div>
                        
                    </div>
                </div>
            </div>
        </header>
       
        <div class="register-area ptb-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12 col-12 col-lg-12 col-xl-6 ml-auto mr-auto">
                        <div class="login">
                            <div class="login-form-container">
                                <div class="login-form">
                                    <form action="#" method="post">
                                        <input type="text" name="user-name" placeholder="Username">
                                        <input type="password" name="user-password" placeholder="Password">
                                        <input name="user-email" placeholder="Email" type="email">
                                        <div class="button-box">
                                            <button type="submit" class="default-btn floatright">Register</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- register-area end -->
		<%-- <footer class="footer-area">
            <div class="footer-top-area bg-img pt-105 pb-65" style="background-image: url(${pageContext.request.contextPath }/resources/user/img/bg/1.jpg)" data-overlay="9">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-4 col-md-3">
                            <div class="footer-widget mb-40">
                                <h3 class="footer-widget-title">Custom Service</h3>
                                <div class="footer-widget-content">
                                    <ul>
                                        <li><a href="${pageContext.request.contextPath }/cart">Cart</a></li>
                                      
                                        <li><a href="${pageContext.request.contextPath }/login/index">Login</a></li>
                                        <li><a href="${pageContext.request.contextPath }/login/index">Register</a></li>
                                       
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
            
        </footer>
		<!-- modal -->
         --%>
		
		
		
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
