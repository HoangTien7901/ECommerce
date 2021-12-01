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
								href="${pageContext.request.contextPath }/manager/notification/index">${parentPageTitle }</a></li>
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
								action="${pageContext.request.contextPath }/manager/notification/save"
								modelAttribute="item">
									<div class="card-body">
										<div class="form-group">
											<s:label path="content">Content</s:label>
											<s:textarea cssClass="form-control" path="content" rows="5"
											cols="30" placeholder="Enter content" />
											<s:errors path="content" cssStyle="font-size: 80%;color: #dc3545;"></s:errors>
										</div>
										
										<div class="form-group">
											<label>Recipient</label>
										</div>
										
										<div class="form-check">
										<div class="row">
											<div class="col-1">
												<s:checkbox path="allUser" cssClass="form-check-input"/>
											<label class="form-check-label" for="allUser1">All user</label> 
											</div>
											<div class="col-1">
											<s:checkbox path="allStore" cssClass="form-check-input" />  
											<label class="form-check-label" for="allStore1">All store</label> 
											</div>
										</div>
										</div> 
										
										<div class="form-check">
											<s:hidden path="id" />
										</div>
										<input type="hidden" name="editType" value="${editType }">
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
			
	<!--  page specific script -->
	<script>
		$(document).ready(function() {
			$('#allUser1').on('click', function() {
				var $checked = $('#allUser1').is(":checked")
				$('#allStore1').prop('checked', $checked ? false : true);
			});
			
			$('#allStore1').on('click', function() {
				var $checked = $('#allStore1').is(":checked")
				$('#allUser1').prop('checked', $checked ? false : true);
			});
		});
	
	</script>
	</jsp:attribute>
</mt:managertemplate>