<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>

<html lang="en">
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
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/dist/css/adminlte.min.css">

<!-- Toastr -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/toastr/toastr.min.css">

<!-- codemirror -->
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/codemirror.min.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/theme/blackboard.min.css">
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/theme/monokai.min.css">
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/codemirror.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/mode/xml/xml.min.js"></script>

<!-- Ekko Lightbox -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/ekko-lightbox/ekko-lightbox.css">

<!-- add summernote -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/lang/summernote-ko-KR.min.js"></script>

<!-- dropzonejs -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/dropzone/min/dropzone.min.css">

<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/manager/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
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
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="${pageContext.request.contextPath }/manager/profile/index" class="brand-link"> <img
				src="${pageContext.request.contextPath }/resources/manager/dist/img/AdminLTELogo.png"
				alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
				style="opacity: .8"> <span
				class="brand-text font-weight-light">Manager</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/profile/index"
							class="nav-link ${profileActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Profile</p> </a></li>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/store/index"
							class="nav-link ${storeActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Store</p> </a></li>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/banner/index"
							class="nav-link ${bannerActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Banner</p> </a></li>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/feedback/index"
							class="nav-link ${feedbackActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Feedback</p> </a></li>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/category/index"
							class="nav-link ${categoryActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Category</p> </a></li>
		<%-- 				<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/tag/index"
							class="nav-link ${tagActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Tag</p> </a></li> --%>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/branch/index"
							class="nav-link ${branchActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Branch</p> </a></li>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/notification/index"
							class="nav-link ${notificationActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Notification</p> </a></li>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/product/index"
							class="nav-link ${productActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Product</p> </a></li>
				<%-- 		<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/store/index"
							class="nav-link ${storeActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Store</p> </a></li> --%>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/user/index"
							class="nav-link ${userActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>User</p> </a></li>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/transaction/index"
							class="nav-link ${transactionActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Transaction</p> </a></li>
				<%-- 		<li class="nav-item"><a
							href="${pageContext.request.contextPath }/manager/service/index"
							class="nav-link ${serviceActive }"><i
								class="far fa-circle nav-icon"></i>
								<p>Service</p> </a></li> --%>

						<li class="nav-item ${adminOpen ? 'menu-open' : '' }"><a
							href="#" class="nav-link"> <i class="nav-icon fas fa-table"></i>
								<p>
									Report and others <i class="fas fa-angle-left right"></i>
								</p></a>
							<ul class="nav nav-treeview">
								<li class="nav-item menu-open"><a
									href="${pageContext.request.contextPath }/manager/sales/index"
									class="nav-link ${salesActive }"><i
										class="far fa-circle nav-icon"></i>
										<p>Sales</p> </a></li>
							</ul>
							<ul class="nav nav-treeview">
								<li class="nav-item menu-open"><a
									href="${pageContext.request.contextPath }/manager/system/index"
									class="nav-link ${systemActive }"><i
										class="far fa-circle nav-icon"></i>
										<p>System</p> </a></li>
							</ul>
							<ul class="nav nav-treeview">
								<li class="nav-item menu-open"><a
									href="${pageContext.request.contextPath }/manager/contact/index"
									class="nav-link ${contactActive }"><i
										class="far fa-circle nav-icon"></i>
										<p>Contact</p> </a></li>
							</ul></li>


					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<jsp:invoke fragment="content"></jsp:invoke>

		</div>
		<!-- /.content-wrapper -->
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
	<!-- Toastr -->
	<script
		src="${pageContext.request.contextPath }/resources/manager/plugins/toastr/toastr.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/manager/custom/toastr.js"></script>
</body>
</html>


