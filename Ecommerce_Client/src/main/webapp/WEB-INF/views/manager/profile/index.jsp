<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:managertemplate title="${title }">
	<jsp:attribute name="content">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>${parentPageTitle }</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item"><a
								href="${pageContext.request.contextPath }/manager/profile/index">${parentPageTitle }</a></li>
								<li class="breadcrumb-item active">${pageTitle }</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<!-- general form elements -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">${pageTitle }</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<s:form method="POST"
								action="${pageContext.request.contextPath }/manager/profile/save"
								modelAttribute="item">
									<div class="card-body">
										<div class="form-group">
											<s:label path="username">Username</s:label>
											<s:input cssClass="form-control" path="username"
											placeholder="Enter username" />
											<s:errors path="username" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="fullname">Full name</s:label>
											<s:input cssClass="form-control" path="fullname"
											placeholder="Enter full name" />
											<s:errors path="fullname" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="phone">Phone</s:label>
											<s:input cssClass="form-control" path="phone"
											placeholder="Enter phone number" />
											<s:hidden path="id" />
											<s:errors path="phone" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="email">Email</s:label>
											<s:input cssClass="form-control" path="email"
											placeholder="Enter email" />
											<s:errors path="email" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<label for="birthday">Birthday</label>
											<fmt:formatDate var="birthday"
														value="${item.birthday }" pattern="dd/MM/yyyy" timeZone="Asia/Ho_Chi_Minh" />
											<input id="birthday" name="birthday" type="text" class="form-control" value="${birthday }" data-inputmask-alias="datetime" data-inputmask-inputformat="dd/mm/yyyy" data-mask>
										</div>
									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<button type="submit" class="btn btn-primary">Submit</button>
										<button type="reset" class="btn btn-danger float-right">Reset</button>
									</div>
								</s:form>
							</div>
							<!-- /.card -->
							
							<div class="card card-danger">
								<div class="card-header">
									<h3 class="card-title">Change password</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form method="POST" id="form"
								action="${pageContext.request.contextPath }/manager/profile/changePassword">
									<div class="card-body">
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
									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<button type="submit" class="btn btn-primary">Submit</button>
										<button type="reset" class="btn btn-danger float-right">Reset</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
	
	<input type="hidden" id="msg" value="${msg }">
	<input type="hidden" id="msgType" value="${msgType }">

	<!-- jQuery  -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/dist/js/demo.js"></script>
	
	<!-- page specific script  -->
	<!-- jquery-validation -->
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/jquery-validation/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/jquery-validation/additional-methods.min.js"></script>
	
	<!-- InputMask -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/moment/moment.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/inputmask/jquery.inputmask.min.js"></script>
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
			
			//Datemask dd/mm/yyyy
	    	$('#birthday').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' });
			
	    	$.validator.setDefaults({
			    submitHandler: function () {
			    	$('#form')[0].submit();
			    }
			  });
			
	    	$('#form').validate({
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
	</jsp:attribute>
</mt:managertemplate>