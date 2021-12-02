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
                                <div class="login-form">
                                	<s:form method="post"
										action="${pageContext.request.contextPath }/user/account/register"
										modelAttribute="item">
                                		<s:input
											path="username" placeholder="Enter username" />
										<s:errors path="username"
											cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										<p></p>
										
										<s:input
											path="fullname" placeholder="Enter full name" />
										<s:errors path="fullname"
											cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										<p></p>
										
										<input type="text" id="birthday" name="birthday" placeholder="dd/mm/yyyy"/>
										<p></p>
										
										<s:input
											path="email" placeholder="Enter email" />
										<s:errors path="email"
											cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										<p></p>
										<s:input
											path="phone" placeholder="Enter phone" />
										<s:errors path="phone"
											cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										<p></p>
										
										<s:hidden path="password"/>	
										
										<div class="button-box">
                                            <button type="submit"
												class="default-btn floatright">Register</button>
                                        </div>
                                	</s:form>
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

