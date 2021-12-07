<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
                            <span style="font-size: 120%"><b>Change profile</b></span>
                                	<p>&nbsp;</p>
                                <div class="login-form">
                                	<s:form method="post" id="formProfile"
										action="${pageContext.request.contextPath }/user/account/save"
										modelAttribute="item">
										<s:label path="username">Username</s:label>
                                		<s:input
											path="username" placeholder="Enter username" />
										<s:errors path="username"
											cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										<p></p>
										
										<s:label path="fullname">Full name</s:label>
										<s:input
											path="fullname" placeholder="Enter full name" />
										<s:errors path="fullname"
											cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										<p></p>
										
										<label for="birthday">Birthday</label>
											<fmt:formatDate var="birthday"
														value="${item.birthday }" pattern="dd/MM/yyyy" timeZone="Asia/Ho_Chi_Minh" />
											<input id="birthday" name="birthday" type="text" class="form-control" value="${birthday }" data-inputmask-alias="datetime" data-inputmask-inputformat="dd/mm/yyyy" data-mask>
										<s:label path="email">Email</s:label>
										<s:input
											path="email" placeholder="Enter email" />
										<s:errors path="email"
											cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										<p></p>
										
										<s:label path="phone">Phone number</s:label>
										<s:input
											path="phone" placeholder="Enter phone" />
										<s:errors path="phone"
											cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										<p></p>
										
										<s:label path="address">Address <span style="color:red;font-style:italic">(make sure to use this address when you checkout)</span></s:label>
										<s:input
											path="address" placeholder="Enter address" />
										<s:errors path="address"
											cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										<p></p>
										
										<s:hidden path="password"/>	
										<s:hidden path="id"/>
											
										<div class="button-box">
                                            <button type="submit"
												class="default-btn floatright">Save</button>
											<button type="reset" class="default-btn floatright" id="btnResetProfileForm">Reset</button>
                                        </div>
                                	</s:form>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div
						class="col-md-12 col-12 col-lg-6 col-xl-6 ml-auto mr-auto">
                        <div class="login">
                            <div class="login-form-container">
                            <span style="font-size: 120%"><b>Change password</b></span>
                                	<p>&nbsp;</p>
                                <div class="login-form">
                                	<form method="POST" id="formPassword"
								action="${pageContext.request.contextPath }/user/account/changePassword">
										<div class="form-group">
											<label for="oldPassword">Old password</label>
											<input type="password" class="form-control"
											name="oldPassword"></input>
										</div>
									
										<div class="form-group">
											<label for="newPassword">New password</label>
											<input type="password" class="form-control"
											name="newPassword" id="newPassword"></input>
										</div>
										
										<div class="form-group">
											<label for="confirmPassword">Confirm password</label>
											<input type="password" class="form-control"
											name="confirmPassword"></input>
										</div>

										<div class="button-box">
                                            <button type="submit" class="default-btn floatright">Submit</button>
											<button type="reset" class="default-btn floatright">Reset</button>
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

