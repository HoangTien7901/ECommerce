<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

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
								action="${pageContext.request.contextPath }/manager/system/save"
								modelAttribute="item">
									<div class="card-body">
										<div class="form-group">
											<s:label path="title">Title</s:label>
											<s:input cssClass="form-control" path="title"
											placeholder="Enter web title" />
											<s:errors path="title" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
											
										</div>
										
										<div class="form-group">
											<s:label path="bannerImgAmount">Amount of photo for each banner</s:label>
											<s:input cssClass="form-control" path="bannerImgAmount"/>
											<s:errors path="bannerImgAmount" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
											
										</div>
										
										<div class="form-group">
											<s:label path="maxBannerPhotoSize">Max photo size (Megabytes)</s:label>
											<s:input cssClass="form-control" path="maxBannerPhotoSize"/>
											<s:errors path="maxBannerPhotoSize" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>

										<div class="form-group">
											<s:label path="defaultBanEmailSubject">Default ban email subject</s:label>
											<s:input cssClass="form-control" path="defaultBanEmailSubject"/>
											<s:errors path="defaultBanEmailSubject" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="defaultPasswordEmailContent">Default password email content</s:label>
											<s:textarea path="defaultPasswordEmailContent"/>
											<s:errors path="defaultPasswordEmailContent" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="defaultPasswordEmailSubject">Default password email subject</s:label>
											<s:input cssClass="form-control" path="defaultPasswordEmailSubject"/>
											<s:errors path="defaultPasswordEmailSubject" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="defaultBanEmailContent">Default ban email content</s:label>
											<s:textarea path="defaultBanEmailContent"/>
											<s:errors path="defaultBanEmailContent" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="paypalAccount">Paypal email account</s:label>
											<s:input cssClass="form-control" path="paypalAccount"/>
											<s:errors path="paypalAccount" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="email">Email</s:label>
											<s:input cssClass="form-control" path="email"/>
											<s:errors path="email" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="emailPassword">Email password</s:label>
											<s:password cssClass="form-control" path="emailPassword"/>
										</div>

									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<button type="submit" class="btn btn-primary">Submit</button>
										<a href="${pageContext.request.contextPath }/manager/system/index"><button type="button" class="btn btn-danger float-right">Reset</button></a>
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
			
	<input type="hidden" id="msg" value="${msg }">
	<input type="hidden" id="msgType" value="${msgType }">

	<!--  jQuery -->
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
	<!-- Page specific script -->
	<!-- Summernote -->
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/summernote/summernote-bs4.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#defaultBanEmailContent, #defaultPasswordEmailContent').summernote();
		});
	</script>	
			</jsp:attribute>
</mt:managertemplate>