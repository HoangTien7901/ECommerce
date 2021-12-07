<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:usertemplate title="${title }">
	<jsp:attribute name="content">
		<div class="shop-page-wrapper shop-page-padding ptb-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="shop-sidebar mr-50">
                            <div class="sidebar-widget mb-50">
                                <h3 class="sidebar-title">Search Products</h3>
                                <div class="sidebar-search">
                                    <form id="searchForm">
                                        <input
											placeholder="Search Products..." type="text" id="keyword">
                                        <button class="search" type="button">
											<i class="ti-search"></i>
										</button>
                                    </form>
                                </div>
                            </div>
                            <div class="sidebar-widget mb-40">
                                <h3 class="sidebar-title">Filter by Price</h3>
                                <div class="price_filter">
                                    <div id="slider-range"></div>
                                    <div class="price_slider_amount">
                                        <div class="label-input">
                                            <label>price : </label>
                                            <input type="text"
												id="amount" name="price" placeholder="Add Your Price" />
											<input type="hidden" id="minPrice" value="0">
											<input type="hidden" id="maxPrice" value="100">
                                        </div>
                                        <button type="button" class="search">Filter</button>
                                    </div>
                                </div>
                            </div>
                            <div class="sidebar-widget mb-45">
                                <h3 class="sidebar-title">Categories</h3>
                                <div class="sidebar-categories">
                                    <ul>
                                    	<c:forEach var="item" items="${categories }">
                                        <li><a class="search-with-category" data-id="${item.id }">${item.name }</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="shop-product-wrapper res-xl">
                            <div class="shop-bar-area">
                                <div class="shop-bar pb-60">
                                    <div class="shop-filter-tab">
                                        <div class="shop-tab nav"
											role=tablist>
                                            <a class="active"
												href="#grid-sidebar3" data-toggle="tab" role="tab"
												aria-selected="false">
                                                <i
												class="ti-layout-grid4-alt"></i>
                                            </a>
                                            <a href="#grid-sidebar4"
												data-toggle="tab" role="tab" aria-selected="true">
                                                <i class="ti-menu"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div
									class="shop-product-content tab-content">
                                    <div id="grid-sidebar3"
										class="tab-pane fade active show">
                                        <div class="row" id="productRows1">
                                        <c:forEach var="item" items="${products }">
                                            <div
												class="col-md-6 col-xl-4">
                                                <div
													class="product-wrapper mb-30">
                                                    <div
														class="product-img">
                                                        <a href="#">
                                                            <img
															src="${pageContext.request.contextPath }/uploads/images/${item.avatar }" alt="">
                                                        </a>
                                                        <div
															class="product-action">
                                                            <a
																class="animate-top product-to-cart" title="Add To Cart" data-id="${item.id }">
                                                                <i
																class="pe-7s-cart"></i>
                                                            </a>
                                                            <a
																class="animate-right modal-opener" title="Quick View"
																data-toggle="modal" data-target="#productDetailsModal" data-id="${item.id }">
                                                                <i
																class="pe-7s-look"></i>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <div
														class="product-content">
                                                        <h4>
															<a>${item.name }</a>
														</h4>
                                                        <span>$${item.price }</span>
                                                    </div>
                                                </div>
                                           </div>
                                        </c:forEach>
                                        </div>
                                    </div>
                                    <div id="grid-sidebar4"
										class="tab-pane fade">
                                        <div class="row" id="productRows2">
                                        <c:forEach var="item" items="${products }">
                                            <div
												class="col-lg-12 col-xl-6">
                                                <div
													class="product-wrapper mb-30 single-product-list product-list-right-pr mb-60">
                                                    <div
														class="product-img list-img-width">
                                                        <a href="#">
                                                            <img
															src="${pageContext.request.contextPath }/uploads/images/${item.avatar }" alt="">
                                                        </a>
                                                        <div
															class="product-action-list-style">
                                                            <a
																class="animate-right modal-opener" title="Quick View"
																data-toggle="modal" data-target="#productDetailsModal" data-id="${item.id }">
                                                                <i
																class="pe-7s-look"></i>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <div
														class="product-content-list">
                                                        <div
															class="product-list-info">
                                                            <h4>
																<a>${item.name }</a>
															</h4>
                                                            <span>$${item.price }</span>
                                                            <p>${item.description }</p>
                                                        </div>
                                                        <div
															class="product-list-cart-wishlist">
                                                            <div
																class="product-list-cart">
                                                                <a
																	class="btn-hover list-btn-style product-to-cart" data-id="${item.id }">add to cart</a>
                                                            </div>
                                                        </div>
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
                                <span class="new" id="productDetailsPrice"></span>
                                <span class="old" id="productDetailsOriginalPrice"></span>
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
                                    <input type="text" value="1"
											name="qtybutton" class="cart-plus-minus-box" id="quantityToCart">
                                </div>
                                <div class="quickview-btn-cart">
                                    <a class="btn-hover-black product-to-cart" id="productDetailsId" data-id="productId">add to cart</a>
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