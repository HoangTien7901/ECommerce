<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:usertemplate title="${title }">
	<jsp:attribute name="content">
			<!-- login-area start -->
        <div class="register-area ptb-100">
            <div class="container-fluid">
                <div class="row">
                    <div
						class="col-md-12 col-12 col-lg-6 col-xl-6 ml-auto mr-auto">
                        <div class="login">
                            <div class="login-form-container">
                            <span style="font-size: 120%"><b>Login</b></span>
                                	<p>&nbsp;</p>
                                <div class="login-form">
                                    <form id="formLogin" method="post"
										action="${pageContext.request.contextPath }/user/account/process-login">
                                    	<div class="form-group"> 
                                        <input type="text"
												name="username" placeholder="Username">
										</div>
										<div class="form-group"> 
                                        <input type="password"
												name="password" placeholder="Password">
										</div>
                                        <div class="button-box">
                                            <button type="submit"
												class="default-btn floatright">Login</button>
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
	</jsp:attribute>
</mt:usertemplate>

