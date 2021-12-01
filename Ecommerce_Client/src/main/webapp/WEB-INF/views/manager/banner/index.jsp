<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
								<li class="breadcrumb-item active">Banner</li>
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
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">${pageTitle }</h3>
									<div class="card-tools">
										<!-- This will cause the card to maximize when clicked -->
										<button type="button" class="btn btn-tool"
										data-card-widget="maximize">
											<i class="fas fa-expand"></i>
										</button>
										<!-- This will cause the card to collapse when clicked -->
										<a
										href="${pageContext.request.contextPath }/manager/banner/add">
											<button type="button" class="btn btn-primary">Add</button>
										</a>
									</div>
								</div>

								<!-- /.card-header -->
								<div class="card-body">
									<table id="dataTable" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Id</th>
												<th>Caption</th>
												<th>Description</th>
												<th>Link</th>
												<th>Created date</th>
												<th>Updated date</th>
												<th>Status</th>
												<th>Action</th>
												<th>Photos</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="banner" items="${banners }" varStatus="varStatus">
												<tr>
													<td>${varStatus.getCount() }</td>
													<td>${banner.caption }</td>
													<td>${banner.description }</td>
													<td>${banner.link }</td>
													<td><fmt:formatDate var="created"
														value="${banner.created }" pattern="dd/MM/yyyy" />
														${created }</td>
													<td><fmt:formatDate var="updated"
														value="${banner.updated }" pattern="dd/MM/yyyy" />
														${updated }</td>
													<td>${banner.status ? "Active" : "Deactive"}</td>
													<td><a
													href="${pageContext.request.contextPath }/manager/banner/edit/${banner.id }">
															<button type="button" class="btn btn-primary">
																<i class="far fa-edit"></i>
															</button>
													</a>
														<button type="button" class="btn btn-danger buttonDelete"
														data-toggle="modal" data-target="#modal-danger"
														data-id="${banner.id }">
															<i class="far fa-trash-alt"></i>
														</button>
													<a
													href="${pageContext.request.contextPath }/manager/banner/changePhotos/${banner.id }">
															<button type="button" class="btn btn-primary">
																<i class="far fa-images"></i>
															</button>
													</a>
													</td>
													<td>
														<br>
														<div class="row">
														<c:forEach var="bannerImg" items="${banner.imgs }" varStatus="i">
															 <div class="col-sm-2">
                    											<a href="${pageContext.request.contextPath }/uploads/images/${bannerImg.name }" data-toggle="lightbox" data-title="Banner ${varStatus.getCount() }'s image ${i.getCount() }" data-gallery="gallery${banner.id }">
                      												<img src="${pageContext.request.contextPath }/uploads/images/${bannerImg.name }" class="img-fluid mb-2" alt="Banner ${varStatus.getCount() }'s image ${i.getCount() }"/>
                    											</a>
                  											</div>														
														</c:forEach>
														</div>
													</td>
												
											</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th>Id</th>
												<th>Caption</th>
												<th>Description</th>
												<th>Link</th>
												<th>Created date</th>
												<th>Updated date</th>
												<th>Status</th>
												<th>Action</th>
												<th>Photos</th>
											</tr>
										</tfoot>
									</table>
								</div>
								<!-- /.card-body -->

							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->


			</section>
			<!-- /.content -->
		
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
							data-link="${pageContext.request.contextPath }/manager/banner/delete/"
							href="#">
						<button type="button" class="btn btn-outline-light">Confirm</button>
					</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
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
	<!-- AdminLTE App -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script
			src="${pageContext.request.contextPath }/resources/manager/dist/js/demo.js"></script>
	<!-- Page specific script -->
	
	<!-- Ekko Lightbox -->
	<script src="${pageContext.request.contextPath }/resources/manager/plugins/ekko-lightbox/ekko-lightbox.min.js"></script>
	<script>
		$(function() {
			$(".buttonDelete").click(function() {
				var id = $(this).data('id');
				console.log("id: " + id);
				var _href = $("#deleteLink").data("link");
				$("#deleteLink").attr("href", _href + id);
			});

			$('#dataTable').DataTable({
				"paging" : true,
				"lengthChange" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false,
				"responsive" : true,
				"columnDefs" : [ 
				{
					'targets' : [ 7 ], /* column index, count from 0 */
					'orderable' : false, /* true or false */
					'className' : 'all',
				}, 
				{
					'targets' : [8],
					'className' : 'none',
				}]
			});
			
			$(document).on('click', '[data-toggle="lightbox"]', function(event) {
			      event.preventDefault();
			      $(this).ekkoLightbox({
			        alwaysShowClose: true
			      });
			    });
		});
	</script>
			
	</jsp:attribute>
</mt:managertemplate>