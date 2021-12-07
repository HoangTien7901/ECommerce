<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:usertemplate title="${title }">
	<jsp:attribute name="content">
		 <div class="blog-details pt-95 pb-100">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="blog-details-info">
                            <h3>Oops.... Looks like you don't have permission to access this page.</h3>
                            <p><a href="${pageContext.request.contextPath }/user/home/index">Return to home page</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</jsp:attribute>
</mt:usertemplate>

