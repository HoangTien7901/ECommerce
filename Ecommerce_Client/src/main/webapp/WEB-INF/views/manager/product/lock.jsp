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
								<li class="breadcrumb-item"><a
								href="${pageContext.request.contextPath }/manager/product/index">${parentPageTitle }</a></li>
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
								<form method="POST"
								action="${pageContext.request.contextPath }/manager/product/lock">
									<div class="card-body">
										<div class="form-group">
											<label>Product's name: ${productName }</label>
										</div>
									
										<div class="form-group">
											<label for="banReason">Ban reason</label>
											<textarea class="form-control" rows="5" cols="30" name="banReason" placeholder="Enter ban reason"></textarea>
										</div>
										<input type="hidden" name="id" value="${id }">
									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<button type="submit" class="btn btn-primary">Submit</button>
										<button type="reset" class="btn btn-danger float-right">Reset</button>
									</div>
								</form>
							</div>
							<!-- /.card -->
						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
			
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

	<!-- Ekko Lightbox -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/ekko-lightbox/ekko-lightbox.min.js"></script>
	
	<!-- Page specific script -->
	<!-- bs-custom-file-input -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<script>
		$(document).ready(function() {
			var $checked = $('#status1').is(":checked")
			if (!$checked) {
				$("#banReason").removeAttr("disabled");
			} else {
				$("#banReason").attr("disabled", true);
			}

			$('#status1').on('change', function() {
				var $checked = $('#status1').is(":checked")
				if (!$checked) {
					$("#banReason").removeAttr("disabled");
				} else {
					$("#banReason").attr("disabled", true);
					$("#banReason").val("");
				}
			});
			
			$(document).on('click', '[data-toggle="lightbox"]',
					function(event) {
						event.preventDefault();
						$(this).ekkoLightbox({
							alwaysShowClose : true
						});
					});
			
			bsCustomFileInput.init();
			
			// preview upload image
			$('input[type="file"]').change(function(e) {
				var reader = new FileReader();
				reader.onload = function(e) {
				    // get loaded data and render thumbnail.
				    document.getElementById("preview").src = e.target.result;
				    
				    document.getElementById("linkPreview").href = e.target.result;
				    
				    $("#preview").attr('width','250px');
				  };
				  // read the image file as a data URL.
				  reader.readAsDataURL(this.files[0]);
				});
		});
	</script>			

	</jsp:attribute>
</mt:managertemplate>