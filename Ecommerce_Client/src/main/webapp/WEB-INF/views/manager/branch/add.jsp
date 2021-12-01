<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
								href="${pageContext.request.contextPath }/manager/branch/index">${parentPageTitle }</a></li>
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
								<form method="POST" id="form"
								action="${pageContext.request.contextPath }/manager/branch/create" enctype="multipart/form-data">
									<div class="card-body">
										<div class="form-group">
											<label for="name">Name</label>
											<input class="form-control" name="name"
											placeholder="Enter name" />
										</div>
										
										<div class="form-group">
											<label for="logo">Logo</label>
											<div class="input-group">
												<div class="custom-file">
													<input type="file" class="custom-file-input" id="logo"
													name="logo"
													accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*">
													<label class="custom-file-label" for="logo">Choose
														file</label>
												</div>
											</div>
										</div>
										
										<div class="form-group">
											<a id="linkPreview" data-toggle="lightbox" data-title="Branch's new logo">
                        						<img id="preview" alt="Branch's new logo"/>
                      						</a>
										</div>
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
	<input type="hidden" id="msg" value="${msg }">
	<input type="hidden" id="msgType" value="${msgType }">
	
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
	<!-- jquery-validation -->
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/jquery-validation/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/jquery-validation/additional-methods.min.js"></script>
	<!-- bs-custom-file-input -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<!-- Ekko Lightbox -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/ekko-lightbox/ekko-lightbox.min.js"></script>
	
	<script>
		$(document).ready(function() {
			// add new method for jqueyr validation
			$.validator.methods.string = function( value, element ) {
				  return this.optional( element ) || /^(?![\s.]+$)[a-zA-Z\s.]*$/.test( value );
				}
			
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
		
		// form validation
			$.validator.setDefaults({
		    submitHandler: function () {
		    	$('#form')[0].submit();
		    }
		  });
			
		  $('#form').validate({
		    rules: {
		      name: {
		        required: true,
		        minlength: 3,
		        maxlength: 100,
		        string: true,
		      }
		    },
		    messages: {
		      name: {
		        required: "This field is required.",
		        minLength: "Please enter a value between 3 and 100 characters long.",
		        maxLength: "Please enter a value between 3 and 100 characters long.",
		        string: "This field can only contain alphabetic characters."
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