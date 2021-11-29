<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<style>

</style>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-left">
              <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i></a></li>
              <li class="breadcrumb-item active">Add new product</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">        
        <!-- SELECT2 EXAMPLE -->
        <div class="card card-default">
          <div class="card-header">
            <h3 class="card-title">Product Infomation</h3>

            <div class="card-tools">
              <button type="button" class="btn btn-tool" data-card-widget="collapse">
                <i class="fas fa-minus"></i>
              </button>
              <button type="button" class="btn btn-tool" data-card-widget="remove">
                <i class="fas fa-times"></i>
              </button>
            </div>
          </div>
          <!-- /.card-header -->
          <div class="card-body">
           <s:form id="frm" method="post" enctype="multipart/form-data" modelAttribute="product"
			action="${pageContext.request.contextPath}/home/product/create">
           	<div class="row">
           	  <div class="col-md-6">
     			<div class="form-group">
                  <label for="name">Name</label>
                  <s:input class="form-control" path="name" placeholder="Enter product name"/>
                  <s:errors path="name"></s:errors>
                </div>
           	  </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="categoryId">Category</label>
                  <s:select path="categoryId" class="form-control select2bs4" style="width: 100%;" data-placeholder="Please select category">
                    <c:forEach var="category" items="${categories }">
                    	<s:option value="${category.id }">${category.name }</s:option>
                    </c:forEach>
                  </s:select>
                  <s:errors path="categoryId"></s:errors>
                </div>
               </div>
               <div class="col-md-3">
                <div class="form-group">
                  <label for="branchId">Branch</label>
                  <s:select path="branchId" class="form-control select2bs4" style="width: 100%;" data-placeholder="Please select branch">
                    <c:forEach var="branch" items="${branchs }">
                    	<s:option value="${branch.id }">${branch.name }</s:option>
                    </c:forEach>
                  </s:select>
                  <s:errors path="branchId"></s:errors>
                </div>
               </div>
             </div>
             <div class="row">
             	<div class="col-md-3">
	     			<div class="form-group">
	                  <label for="originalPrice">Original Price</label>
	                  <s:input class="form-control" path="originalPrice" placeholder="Enter product price"/>
	                  <s:errors path="originalPrice"></s:errors>
	                </div>
	             </div>
	             <div class="col-md-3">
	                <div class="form-group">
	                  <label for="saleOffPercent">Sale off percent</label>
	                  <s:input type="text" class="form-control" path="saleOffPercent" placeholder="Enter sale off percent"/>
	                </div>
	           	 </div>
           	  	<div class="col-md-3">
	     			<div class="form-group">
	                  <label for="price">Price</label>
	                  <s:input class="form-control" path="price" placeholder="Enter product price"/>
	                  <s:errors path="price"></s:errors>
                	</div>
           	  	</div>
           	  	<div class="col-md-3">
	     			<div class="form-group">
	                  <label for="quantity">Quantity</label>
	                  <s:input class="form-control" path="quantity" placeholder="Enter product quantity"/>
	                  <s:errors path="quantity"></s:errors>
                	</div>
           	  	</div>
             </div>
             <div class="row">
             	<div class="col-md-6">
	     			<div class="form-group">
	                  <label for="description">Description</label>
	                  <s:textarea rows="5" cols="10" class="form-control" path="description" placeholder="Enter description"></s:textarea>
	                  <s:errors path="description"></s:errors>
	                 </div>
           	  	</div>
           	  	<div class="col-md-6">
	     			<div class="form-group">
	                  <label for="descriptionDetail">Description detail</label>
	                  <s:textarea rows="5" cols="10" class="form-control" path="descriptionDetail" placeholder="Enter description detail"></s:textarea>
	                  <s:errors path="descriptionDetail"></s:errors>
	                 </div>
           	  	</div>
             </div> 
             <div class="row">
             	<div class="col-md-6">
	     			<div class="custom-control custom-switch">
					   <s:checkbox id="status" path="status" class="custom-control-input" checked="checked"/>
					   <label class="custom-control-label" for="status">Status</label>
					 </div> 
           	  	</div>
             </div>  
             <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/store/product/uploadImages.jsp"></jsp:include>           
           	 <input type="submit" class="btn btn-success float-sm-right ml-2" value="Save">
           	 <input type="button" class="btn btn-secondary float-sm-right" value="Cancel">
           </s:form>
          </div>
         </div>
        <!-- /.card -->
        </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>