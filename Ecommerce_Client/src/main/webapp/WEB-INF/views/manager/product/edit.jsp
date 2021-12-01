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
								href="${pageContext.request.contextPath }/manager/category/index">${parentPageTitle }</a></li>
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
								action="${pageContext.request.contextPath }/manager/product/save"
								modelAttribute="item" enctype="multipart/form-data">
									<div class="card-body">
										<div class="form-group">
											<s:label path="name">Name</s:label>
											<s:input cssClass="form-control" path="name"
											placeholder="Enter name" />
											<s:errors path="name" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="branchId">Branch</s:label>
											<s:select path="branchId" cssClass="form-control">
												<s:options items="${branches}" itemLabel="name"
												itemValue="id"></s:options>
											</s:select>
										</div>
										
										<div class="form-group">
											<s:label path="categoryId">Category</s:label>
											<s:select path="categoryId" cssClass="form-control">
												<s:options items="${categories}" itemLabel="name"
												itemValue="id"></s:options>
											</s:select>
										</div>
										
										<div class="form-group">
											<s:label path="storeId">Store</s:label>
											<s:select path="storeId" cssClass="form-control">
												<s:options items="${stores}" itemLabel="name" itemValue="id"></s:options>
											</s:select>
										</div>
										
										<div class="form-group">
											<label>Current avatar</label>
											<p></p>
											<a href="${pageContext.request.contextPath }/uploads/images/${img }" data-toggle="lightbox" data-title="Product's current avatar">
                        						<img src="${pageContext.request.contextPath }/uploads/images/${img }" width="250px" alt="Product's current avatar"/>
                      						</a>
										</div>
										
										<div class="form-group">
											<label for="newAvatar">Choose new avatar</label>
											<div class="input-group">
												<div class="custom-file">
													<input type="file" class="custom-file-input" id="newAvatar"
													name="newAvatar"
													accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*">
													<label class="custom-file-label" for="newAvatar">Choose
														file</label>
												</div>
												
											</div>
										</div>
										
										<div class="form-group">
											<a id="linkPreview" data-toggle="lightbox" data-title="Product's current avatar">
                        						<img id="preview" alt="Product's new avatar"/>
                      						</a>
										</div>
										
										<div class="form-group">
											<s:label path="description">Description</s:label>
											<s:textarea cssClass="form-control" path="description"
											rows="5" cols="30" placeholder="Enter reason" />
											<s:errors path="description" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<s:label path="descriptionDetail">Description details</s:label>
											<s:textarea cssClass="form-control" path="descriptionDetail"
											rows="10" cols="30" placeholder="Enter description details" />
											<s:errors path="descriptionDetail" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-check">
											<s:checkbox path="isOutstanding" cssClass="form-check-input" />
											<label for="isOutstanding1">Is outstanding</label>
										</div>

										<div class="form-check">
											<s:checkbox path="isBestSelling" cssClass="form-check-input" />
											<label for="isBestSelling1">Is best selling</label>
										</div>
										
										<div class="form-check">
											<s:checkbox path="isNewProduct" cssClass="form-check-input" />
											<label for="isNewProduct1">Is new product</label>
											<s:hidden path="id" />
											<s:hidden path="status" />
											<s:hidden path="avatar" />
											<s:hidden path="banReason" />
											<s:hidden path="saleOffPercent" />
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
	
	<!-- jQuery -->
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