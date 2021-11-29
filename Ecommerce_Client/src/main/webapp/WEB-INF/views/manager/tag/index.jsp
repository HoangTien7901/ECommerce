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
										<!-- This will cause the card to collapse when clicked -->
										<a href="${pageContext.request.contextPath }/manager/tag/add">
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
												<th>Status</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${items }" varStatus="varStatus">
												<tr>
													<td>${varStatus.getCount() }</td>
													<td>${item.name }</td>
													<td>${item.status ? "Enable" : "Disable" }</td>
													<td><a
													href="${pageContext.request.contextPath }/manager/tag/edit/${item.id }">
															<button type="button" class="btn btn-primary">
																<i class="far fa-edit"></i>
															</button>
													</a> |
														<button type="button" class="btn btn-danger buttonDelete"
														data-toggle="modal" data-target="#modal-danger"
														data-id="${item.id }">
															<i class="far fa-trash-alt"></i>
														</button>
												
											</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th>Status</th>
												<th>Action</th>
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
							data-link="${pageContext.request.contextPath }/manager/tag/delete/"
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
				"columnDefs" : [ {
					'targets' : [ 3 ], /* column index, count from 0 */
					'orderable' : false, /* true or false */
				} ]
			});
		});
	</script>
			
	</jsp:attribute>
</mt:managertemplate>