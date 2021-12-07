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
										<a href="${pageContext.request.contextPath }/manager/product/add">
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
												<th>Name</th>
												<th title="Branch's name">B. name</th>
												<th title="Category's name">C. name</th>
												<th>Avatar</th>
												<th>Price</th>
												<th>Original price</th>
												<th>Created</th>
												<th>Updated</th>
												<th>Outstanding</th>
												<th>Best selling</th>
												<th>Status</th>
												<th>Action</th>
												<th>Description</th>
												<th title="Description details">D. details</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${items }" varStatus="varStatus">
												<tr>
													<td>${varStatus.getCount() }</td>
													<td>${item.name }</td>
													<td>${item.branchName }</td>
													<td>${item.categoryName }</td>
													<td>
													<a
													href="${pageContext.request.contextPath }/uploads/images/${item.avatar }"
													data-toggle="lightbox" data-title="${item.name }'s avatar">
                        								<img
														src="${pageContext.request.contextPath }/uploads/images/${item.avatar }"
														class="img-fluid mb-2" alt="${item.name }'s avatar" width="150px" />
                      								</a>
													</td>
													<td>${item.price }</td>
													<td>${item.originalPrice }</td>
													<td>
													<fmt:formatDate var="created" value="${item.created }"
														pattern="dd/MM/yyyy" />
													${created }
													</td>
													<td>
													<fmt:formatDate var="updated" value="${item.updated }"
														pattern="dd/MM/yyyy" />
													${updated }
													</td>
													<td>${item.isOutstanding ? "True" : "False" }</td>
													<td>${item.isBestSelling ? "True" : "False" }</td>
													<td>${item.status ? "Enable" : "Disable" }</td>
													<td>
														<a
													href="${pageContext.request.contextPath }/manager/product/edit/${item.id }">
															<button type="button" class="btn btn-primary">
																<i class="far fa-edit"></i>
															</button>
														</a>
														<button type="button" class="btn btn-danger buttonDelete"
														data-toggle="modal" data-target="#modal-danger"
														data-id="${item.id }"> 
															<i class="far fa-trash-alt"></i>
														</button>
														<a
													href="${pageContext.request.contextPath }/manager/product/toggleStatus/${item.id }">
															<button type="button" class="btn btn-${!item.status ? 'primary' : 'danger' }">
																<i class="fas ${!item.status ? 'fa-check' : 'fa-lock' } "></i>
															</button>
														</a>
													</td>
													<td>${item.description }</td>
													<td>${item.descriptionDetail }</td>
													
											</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th title="Branch's name">B. name</th>
												<th title="Category's name">C. name</th>
												<th>Avatar</th>
												<th>Price</th>
												<th>Original price</th>
												<th>Created</th>
												<th>Updated</th>
												<th>Outstanding</th>
												<th>Best selling</th>
												<th>Status</th>
												<th>Action</th>
												<th>Description</th>
												<th title="Description details">D. details</th>
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
			
			<!-- DataTables  & Plugins -->
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
							data-link="${pageContext.request.contextPath }/manager/product/delete/"
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

	<input type="hidden" id="msg" value="${msg }">
	<input type="hidden" id="msgType" value="${msgType }">

	<!--  jQuery -->
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
				"paging" : true,
				"lengthChange" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false,
				"responsive" : true,
				"columnDefs" : [
					{ className: "none", targets: [13, 14] },
					{ className: "all", targets: [12], 'orderable' : false }
				],
			});

			$('a[data-toggle="lightbox"]').on('click', function(event) {
				event.preventDefault();
				$(this).ekkoLightbox({
					alwaysShowClose : true
				});
			});
		});
	</script>
	</jsp:attribute>
</mt:managertemplate>