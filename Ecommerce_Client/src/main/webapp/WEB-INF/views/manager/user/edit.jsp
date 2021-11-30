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
								href="${pageContext.request.contextPath }/manager/user/index">${parentPageTitle }</a></li>
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
								action="${pageContext.request.contextPath }/manager/user/save"
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
						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
			
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
	</jsp:attribute>
</mt:managertemplate>