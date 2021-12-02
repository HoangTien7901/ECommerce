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
                                    <form id="form" method="post" action="${pageContext.request.contextPath }/user/account/login">
                                        <input type="text"
											name="username" placeholder="Username">
                                        <input type="password"
											name="password" placeholder="Password">
                                        <div class="button-box">
                                            <div
												class="login-toggle-btn">
                                                <a href="#">Forgot Password?</a>
                                            </div>
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
	
	<!-- jquery-validation -->
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/jquery-validation/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/jquery-validation/additional-methods.min.js"></script>
	<script>
		$(document).ready(function() {
			$.validator.methods.passwordPattern = function( value, element ) {
				 return this.optional( element ) || /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$/.test( value );
			}
			
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
			    	$('#form')[0].submit();
			    }
			  });
			
	    	$('#form').validate({
			    rules: {
			      password: {
			        required: true,
			      },
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
	</jsp:attribute>
</mt:usertemplate>

