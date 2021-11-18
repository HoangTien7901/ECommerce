<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${title }</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/fontawesome-free/css/all.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/dist/css/adminlte.min.css">

</head>

<body class="hold-transition sidebar-mini layout-fixed sidebar-collapse">

	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="../../index3.html" class="nav-link">Home</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
					class="nav-link">Contact</a></li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="../../index3.html" class="brand-link"> <img
				src="${pageContext.request.contextPath }/resources/manager/dist/img/AdminLTELogo.png"
				alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
				style="opacity: .8"> <span
				class="brand-text font-weight-light">AdminLTE 3</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img
							src="${pageContext.request.contextPath }/resources/manager/dist/img/user2-160x160.jpg"
							class="img-circle elevation-2" alt="User Image">
					</div>
					<div class="info">
						<a href="#" class="d-block">Alexander Pierce</a>
					</div>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<li class="nav-item menu-open"><a
							href="${pageContext.request.contextPath }/manager/banner/index"
							class="nav-link"><i class="far fa-circle nav-icon"></i>
								<p>Banner</p> </a></li>
						<li class="nav-item menu-open"><a
							href="${pageContext.request.contextPath }/manager/feedback/index"
							class="nav-link"><i class="far fa-circle nav-icon"></i>
								<p>Feedback</p> </a></li>
						<li class="nav-item menu-open"><a
							href="${pageContext.request.contextPath }/manager/category/index"
							class="nav-link active"><i class="far fa-circle nav-icon"></i>
								<p>Category</p> </a></li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
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
									</div>
								</div>

								<!-- /.card-header -->
								<div class="card-body">
									<table id="dataTable" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th>Parent category</th>
												<th>Status</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${items }">
												<tr>
													<td>${item.id }</td>
													<td>${item.name }</td>
													<td>${item.parentName }</td>
													<td>${item.status ? "Enable" : "Disable" }</td>
													<td><a
														href="${pageContext.request.contextPath }/manager/category/edit/${item.id }">
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
												<th>Parent category</th>
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
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 3.1.0-rc
			</div>
			<strong>Copyright &copy; 2014-2020 <a
				href="https://adminlte.io">AdminLTE.io</a>.
			</strong> All rights reserved.
		</footer>

	</div>

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
						data-link="${pageContext.request.contextPath }/manager/category/delete/"
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
					'targets' : [ 4 ], /* column index, count from 0 */
					'orderable' : false, /* true or false */
				} ]
			});
		});
	</script>
</body>
</html>

