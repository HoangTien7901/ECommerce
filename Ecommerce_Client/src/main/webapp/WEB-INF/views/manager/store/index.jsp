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
								<li class="breadcrumb-item active">${parentPageTitle }</li>
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
								action="${pageContext.request.contextPath }/manager/store/save"
								modelAttribute="item" enctype="multipart/form-data">
									<div class="card-body">
										<div class="form-group">
											<s:label path="name">Store's name</s:label>
											<s:input cssClass="form-control" path="name"
											placeholder="Enter store's name" />
											<s:errors path="name" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="phone">Phone</s:label>
											<s:input cssClass="form-control" path="phone"
											placeholder="Enter phone number" />
											<s:errors path="phone" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="email">Email</s:label>
											<s:input cssClass="form-control" path="email"
											placeholder="Enter email" />
											<s:errors path="email" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<label>Current logo</label>
											<p></p>
											<a href="${pageContext.request.contextPath }/uploads/images/${img }" data-toggle="lightbox" data-title="Store's current logo">
                        						<img src="${pageContext.request.contextPath }/uploads/images/${img }" width="250px" alt="Store's current logo"/>
                      						</a>
										</div>
										
										<div class="form-group">
											<label for="newLogo">Choose new logo</label>
											<div class="input-group">
												<div class="custom-file">
													<input type="file" class="custom-file-input" id="newLogo"
													name="newLogo"
													accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*">
													<label class="custom-file-label" for="newLogo">Choose
														file</label>
												</div>
												
											</div>
										</div>
										
										<div class="form-group">
											<a id="linkPreview" data-toggle="lightbox" data-title="Store's new logo">
                        						<img id="preview" alt="Store's new logo" src="${pageContext.request.contextPath }/uploads/images/defaultPreviewImg.png"/>
                      						</a>
                      						<s:hidden path="logo" />
                      						<s:hidden path="id" />
                      						<s:hidden path="userId"/>
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

	<!-- Page specific script -->
	<!-- Ekko Lightbox -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/ekko-lightbox/ekko-lightbox.min.js"></script>
	<!-- bs-custom-file-input -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<script>
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
	
	</script>
			</jsp:attribute>
</mt:managertemplate>