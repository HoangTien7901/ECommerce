<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:usertemplate title="${title }">
	<jsp:attribute name="content">
	<div class="pl-200 pr-200 overflow clearfix">
        <div class="categori-menu-slider-wrapper clearfix">
            <div class="categories-menu">
                <div class="category-heading">
                    <h3> All Departments <i
								class="pe-7s-angle-down"></i>
						</h3>
                </div>
                <div class="category-menu-list">
                    <ul>
                        <li>
                            <a href="#"><img alt=""
									src="${pageContext.request.contextPath }/resources/user/img/icon-img/5.png">Computer & Laptops <i
									class="pe-7s-angle-right"></i></a>
                            <div class="category-menu-dropdown">
                                <div
										class="category-dropdown-style category-common4 mb-40">
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
                                <div
										class="category-dropdown-style category-common4 mb-40">
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
                                    <a href="single-product.html">
                                        <img
											src="${pageContext.request.contextPath }/resources/user/img/banner/18.jpg"
											alt="">
                                    </a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="menu-slider-wrapper">
                <div class="menu-style-3 menu-hover text-center">
                    <nav>
                        <ul>
                            <li><a href="index.html">home</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="slider-area">
                    <div class="slider-active owl-carousel">
                        <div
								class="single-slider single-slider-hm3 bg-img pt-170 pb-173"
								style="background-image: url(${pageContext.request.contextPath }/resources/user/img/slider/5.jpg)">
                            <div
									class="slider-animation slider-content-style-3 fadeinup-animated">
                                <h2 class="animated">Invention of <br>design platform 1</h2>
                                <h4 class="animated">Best Product With warranty 1</h4>
                                <a class="electro-slider-btn btn-hover"
										href="product-details.html">buy now</a>
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
                <h2>Top Products</h2>
            </div>
            <div class="top-product-style">
                <div class="tab-content">
                    <div class="tab-pane active show fade" id="electro1"
							role="tabpanel">
                        <div class="custom-row-2">
                        	<c:forEach var="item" items="${outstandings }">
                        	<div class="custom-col-style-2 custom-col-4">
                                <div
											class="product-wrapper product-border mb-24">
                                    <div class="product-img-3">
                                        <a
													href="${pageContext.request.contextPath }/user/product/details/${item.id }">
                                            <img
													src="${pageContext.request.contextPath }/uploads/images/${item.avatar }"
													alt="Product's avatar">
                                        </a>
                                        <div
													class="product-action-right">
                                            <a class="animate-right modal-opener"
														data-target="#productDetailsModal"
														title="Quick View" data-id="${item.id }">
                                                <i class="pe-7s-look"></i>
                                            </a>
                                            <a class="animate-top product-to-cart"
														title="Add To Cart" data-id="${item.id }">
                                                <i class="pe-7s-cart"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div
												class="product-content-4 text-center">
                                        <div class="product-rating-4">
                                        	<c:forEach begin="1"
														end="${item.ratingAverage * 10 / 10}">
                                        		<i
															class="icofont icofont-star yellow"></i>
                                        	</c:forEach>
                                        	<c:forEach begin="1"
														end="${5 - (item.ratingAverage * 10 / 10)}">
                                        		<i
															class="icofont icofont-star"></i>
                                        	</c:forEach>
                                        </div>
                                        <h4>
												<a
														href="${pageContext.request.contextPath }/user/product/details/${item.id }">${item.name }</a>
											</h4>
                                        <span>${item.categoryName }</span>
                                        <h5>${item.price }</h5>
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
    <div class="best-selling-area pb-95">
        <div class="section-title-4 text-center mb-60">
            <h2>Best Selling</h2>
        </div>
        <div class="best-selling-product">
            <div class="row no-gutters">
                <div class="col-lg-12">
                    <div class="best-selling-right">
                        <div class="custom-container">
                            <div class="coustom-row-3">
                            	<c:forEach var="item" items="${bestSells }">
                                <div
											class="custom-col-style-3 custom-col-3">
                                    <div class="product-wrapper mb-6">
                                        <div class="product-img-4">
                                            <a href="#">
                                                <img
														src="${pageContext.request.contextPath }/uploads/images/${item.avatar }"
														alt="">
                                            </a>
                                            <div
														class="product-action-right">
													 <a class="animate-right modal-opener"
															data-target="#productDetailsModal" data-toggle="modal"
															data-id="${item.id }" title="Quick View">
                                                <i class="pe-7s-look"></i>
                                            </a>
                                                <a class="animate-top product-to-cart"
															title="Add To Cart" data-id="${item.id }">
                                                    <i
															class="pe-7s-cart"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="product-content-6">
                                            <div
														class="product-rating-4">
												<c:forEach begin="1" end="${item.ratingAverage * 10 / 10}">
                                        		<i
																class="icofont icofont-star yellow"></i>
                                        	</c:forEach>
                                        	<c:forEach begin="1"
															end="${5 - (item.ratingAverage * 10 / 10)}">
                                        		<i
																class="icofont icofont-star"></i>
                                        	</c:forEach>
                                            </div>
                                            <h4>
													<a href="product-details.html">${item.name }</a>
												</h4>
                                            <h5>${item.price }</h5>
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
    <div class="product-area-2 wrapper-padding pb-70">
        <div class="container-fluid">
            <div class="row">
            	<c:forEach var="item" items="${items }">
                <div class="col-lg-6 col-xl-4">
                    <div
								class="product-wrapper product-wrapper-border mb-30">
                        <div class="product-img-5">
                             <a
										href="${pageContext.request.contextPath }/user/product/details/${item.id }">
                                            <img
										src="${pageContext.request.contextPath }/uploads/images/${item.avatar }"
										alt="Product's avatar">
                                        </a>
                        </div>
                        <div class="product-content-7">
                            <h4>
									<a href="${pageContext.request.contextPath }/user/product/details/${item.id }">
									${item.name }</a>
								</h4>
                            <div class="product-rating-4">
                                <c:forEach begin="1"
														end="${item.ratingAverage * 10 / 10}">
                                        		<i
															class="icofont icofont-star yellow"></i>
                                        	</c:forEach>
                                        	<c:forEach begin="1"
														end="${5 - (item.ratingAverage * 10 / 10)}">
                                        		<i
															class="icofont icofont-star"></i>
                                        	</c:forEach>
                            </div>
                            <h5>$${item.price }</h5>
                            <div class="product-action-electro">
                               	<a class="animate-top .product-to-cart"
									title="Add To Cart" data-id="${item.id }">
                                    <i class="pe-7s-cart"></i>
								</a>
                                <a class="animate-right" title="Compare"
											data-toggle="modal" data-target="#exampleCompare" href="#">
                                    <i class="pe-7s-repeat"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            	</c:forEach>
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
            </div>
        </div>
    </div>
    
     <!-- modal -->
    <div class="modal fade" id="exampleCompare" tabindex="-1"
			role="dialog" aria-hidden="true">
        <button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
            <span class="pe-7s-close" aria-hidden="true"></span>
        </button>
        <div class="modal-dialog modal-compare-width" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <form action="#">
                        <div
								class="table-content compare-style table-responsive">
                            <table>
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>
                                            <a href="#">Remove <span>x</span></a>
                                            <img
												src="${pageContext.request.contextPath }/resources/user/img/cart/4.jpg"
												alt="">
                                            <p>Blush Sequin Top </p>
                                            <span>$75.99</span>
                                            <a class="compare-btn"
												href="#">Add to cart</a>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="compare-title">
                                            <h4>Description </h4>
											</td>
                                        <td
												class="compare-dec compare-common">
                                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has beenin the stand ard dummy text ever since the 1500s, when an unknown printer took a galley</p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="compare-title">
                                            <h4>Availability  </h4>
											</td>
                                        <td
												class="compare-stock compare-common">
                                            <p>In stock</p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="compare-title">
                                            <h4>brand   </h4>
											</td>
                                    </tr>
                                    <tr>
                                        <td class="compare-title"></td>
                                        <td
												class="compare-price compare-common">
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
    <div class="modal fade" id="productDetailsModal" tabindex="-1"
			role="dialog" aria-hidden="true">
        <button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
            <span class="pe-7s-close" aria-hidden="true"></span>
        </button>
        <div class="modal-dialog modal-quickview-width" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="qwick-view-left">
                        <div class="quick-view-learg-img">
                            <div
									class="quick-view-tab-content tab-content">
                                <div class="tab-pane active show fade"
										id="modal1" role="tabpanel">
                                    <img id="productDetailsImg"
											src="#"
											alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="qwick-view-right">
                        <div class="qwick-view-content">
                            <h3 id="productDetailsName"></h3>
                            <div class="price">
                                <span class="new" id="productDetailsOriginalPrice"></span>
                                <span class="old" id="productDetailsPrice"></span>
                            </div>
                            <div class="rating-number">
                                <div class="quick-view-rating">
                                	<span id="productDetailsRatingResult"></span>
                                </div>
                                <div class="quick-view-number">
                                    <span id="productDetailsRatingCount"></span>
                                </div>
                            </div>
                            <p id="productDetailsDescription"></p>
                            <p id="productDetailsDescriptionDetails"></p>
                            <div class="quickview-plus-minus">
                                <div class="cart-plus-minus">
                                    <input type="text" value="02"
											name="qtybutton" class="cart-plus-minus-box">
                                </div>
                                <div class="quickview-btn-cart">
                                    <a class="btn-hover-black" href="#">add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    
	</jsp:attribute>
</mt:usertemplate>