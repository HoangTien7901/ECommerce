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
								href="${pageContext.request.contextPath }/manager/banner/index">${parentPageTitle }</a></li>
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
                                <div class="card-body">
                                Current photos of banner <label>${caption }</label>
                                <div class="row">
									<table id="dataTable" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Id</th>
												<th>Photos</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="bannerImg" items="${currentPhotos }" varStatus="varStatus">
												<tr>
													<td>${varStatus.getCount() }</td>
													<td>
														<div class="col-sm-2">
                    						<a
												href="${pageContext.request.contextPath }/uploads/images/${bannerImg.name }"
												data-toggle="lightbox"
												data-title="Banner ${varStatus.getCount() }'s image ${i.getCount() }">
                      							<img
												src="${pageContext.request.contextPath }/uploads/images/${bannerImg.name }"
												class="img-fluid mb-2"
												alt="Banner ${varStatus.getCount() }'s image ${i.getCount() }" />
                    						</a>
                  						</div>		
													
													</td>
													<td>
														<button type="button" class="btn btn-danger buttonDelete"
														data-toggle="modal" data-target="#modal-danger"
														data-id="${bannerImg.id }">
															<i class="far fa-trash-alt"></i>
														</button>
													</td>
											</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th>Id</th>
												<th>Photos</th>
												<th>Action</th>
											</tr>
										</tfoot>
									</table>
								</div>
									<input type="hidden" name="id" id="id" value="${id }">
                					<label>Add new photos</label>
                					<div id="actions" class="row">
                 						<div class="col-lg-6">
                    						<div class="btn-group w-100">
                      						<span
												class="btn btn-success col fileinput-button">
                        						<i class="fas fa-plus"></i>
                        						<span>Add files</span>
                      						</span>
                      						<button type="submit"
												class="btn btn-primary col start">
                        						<i class="fas fa-upload"></i>
                        						<span>Start upload</span>
                      						</button>
                      						<button type="reset"
												class="btn btn-warning col cancel">
                        						<i class="fas fa-times-circle"></i>
                        						<span>Cancel upload</span>
                      						</button>
                    						</div>
                  						</div>
                  						<div class="col-lg-6 d-flex align-items-center">
                    						<div class="fileupload-process w-100">
                      							<div id="total-progress"
												class="progress progress-striped active" role="progressbar"
												aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
                        							<div
													class="progress-bar progress-bar-success"
													style="width: 0%;" data-dz-uploadprogress></div>
                      							</div>
                    						</div>
                  						</div>
                					</div>
                					<div class="table table-striped files"
									id="previews">
                  						<div id="template" class="row mt-2">
                    						<div class="col-auto">
                        						<span class="preview"><img
												src="data:," alt="" data-dz-thumbnail /></span>
                    						</div>
                    					<div class="col d-flex align-items-center">
                        					<p class="mb-0">
                          						<span class="lead" data-dz-name></span>
                          						(<span data-dz-size></span>)
                        					</p>
                        					<strong class="error text-danger"
												data-dz-errormessage></strong>
                    					</div>
                    					<div class="col-4 d-flex align-items-center">
                        					<div
												class="progress progress-striped active w-100"
												role="progressbar" aria-valuemin="0" aria-valuemax="100"
												aria-valuenow="0">
                          					<div
													class="progress-bar progress-bar-success"
													style="width: 0%;" data-dz-uploadprogress></div>
                        					</div>
                    					</div>
                    					<div class="col-auto d-flex align-items-center">
                      					<div class="btn-group">
                        					<button class="btn btn-primary start">
                          					<i class="fas fa-upload"></i>
                          					<span>Start</span>
                        					</button>
                        					<button data-dz-remove
													class="btn btn-warning cancel">
                          					<i class="fas fa-times-circle"></i>
                          					<span>Cancel</span>
                        					</button>
                        					<button data-dz-remove
													class="btn btn-danger delete">
                          					<i class="fas fa-trash"></i>
                          					<span>Delete</span>
                        					</button>
                      					</div>
                    					</div>
                  					</div>
                					</div>
              					</div>
							</div>
							<!-- /.card -->

						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
	<input type="hidden" id="maxFile" value="${maxFile }">
	<input type="hidden" id="maxFileSize" value="${maxFileSize }">
	<input type="hidden" id="msg" value="${msg }">
	<input type="hidden" id="msgType" value="${msgType }">
	
	<div class="modal fade" id="modal-danger">
		<div class="modal-dialog">
			<div class="modal-content bg-danger">
				<div class="modal-header">
					<h4 class="modal-title">Confirm delete</h4>
					<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Are you sure?</p>
				</div>
				<div class="modal-footer justify-content-between">
					<button type="button" class="btn btn-outline-light"
							data-dismiss="modal">Cancel</button>
					<a id="deleteLink"
							data-link="${pageContext.request.contextPath }/manager/banner/deleteImage/${id}/"
							href="#">
						<button type="button" class="btn btn-outline-light">Confirm</button>
					</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>	
			
			
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/dist/js/adminlte.min.js"></script>
	<!-- DataTables  & Plugins -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/jszip/jszip.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/pdfmake/pdfmake.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/pdfmake/vfs_fonts.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/buttons.print.min.js"></script>
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/dist/js/demo.js"></script>
			
	<!-- Page specific script -->
	<!-- dropzonejs -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/dropzone/min/dropzone.min.js"></script>
	<!-- Ekko Lightbox -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/ekko-lightbox/ekko-lightbox.min.js"></script>
	
	<script>
		$(function() {
			$(".buttonDelete").click(function() {
				var id = $(this).data('id');
				console.log("id: " + id);
				var _href = $("#deleteLink").data("link");
				$("#deleteLink").attr("href", _href + id);
			});
			
			$('#dataTable').DataTable({
				"searching" : false,
				"paging" : false,
				"lengthChange" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false,
				"responsive" : true,
				"columnDefs" : [ 
				{
					'targets' : [ 1, 2 ], /* column index, count from 0 */
					'orderable' : false, /* true or false */
				}]
			});
			
			$(document).on('click', '[data-toggle="lightbox"]',
					function(event) {
						event.preventDefault();
						$(this).ekkoLightbox({
							alwaysShowClose : true
						});
					});

			// DropzoneJS Demo Code Start
			Dropzone.autoDiscover = false;

			// Get the template HTML and remove it from the doumenthe template HTML and remove it from the doument
			var previewNode = document.querySelector("#template");
			previewNode.id = "";
			var previewTemplate = previewNode.parentNode.innerHTML;
			previewNode.parentNode.removeChild(previewNode);

			var myDropzone = new Dropzone(document.body, { // Make the whole body a dropzone
				url : "/manager/banner/changePhotos", // Set the url
				thumbnailWidth : 80,
				thumbnailHeight : 80,
				parallelUploads : 20,
				previewTemplate : previewTemplate,
				maxFiles : $("#maxFile").val(),
				acceptedFiles: ".png,.jpg,.gif",
                maxFilesize: $("#maxFileSize").val(),//max file size in MB,
                init: function ()  {
                    this.on("error", function (file, message) {
                        alert(message);
                        this.removeFile(file);
                    }); 
                },
				autoQueue : false, // Make sure the files aren't queued until manually added
				previewsContainer : "#previews", // Define the container to display the previews
				clickable : ".fileinput-button" // Define the element that should be used as click trigger to select files.
			});
			
			myDropzone
					.on(
							"addedfile",
							function(file) {
								// Hookup the start button
								file.previewElement.querySelector(".start").onclick = function() {
									myDropzone.enqueueFile(file);
								};
							});

			// Update the total progress bar
			myDropzone
					.on(
							"totaluploadprogress",
							function(progress) {
								document
										.querySelector("#total-progress .progress-bar").style.width = progress
										+ "%";
							});

			myDropzone.on("sending", function(file, xhr, formData) {
				// Show the total progress bar when upload starts
				document.querySelector("#total-progress").style.opacity = "1";
				// And disable the start button
				file.previewElement.querySelector(".start").setAttribute(
						"disabled", "disabled");
				
				formData.append('id', $("#id").val());
			});

			// Hide the total progress bar when nothing's uploading anymore
			myDropzone.on("queuecomplete", function(progress) {
				document.querySelector("#total-progress").style.opacity = "0";
			});

			// Setup the buttons for all transfers
			// The "add files" button doesn't need to be setup because the config
			// `clickable` has already been specified.
			document.querySelector("#actions .start").onclick = function() {
				myDropzone.enqueueFiles(myDropzone
						.getFilesWithStatus(Dropzone.ADDED));
			};
			document.querySelector("#actions .cancel").onclick = function() {
				myDropzone.removeAllFiles(true);
			};
			// DropzoneJS Demo Code End
		});
	</script>
	</jsp:attribute>
</mt:managertemplate>