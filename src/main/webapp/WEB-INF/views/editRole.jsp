<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="/WEB-INF/views/head.jsp"%>
</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER -->
                   
 <%@ include file="/WEB-INF/views/header.jsp"%>
            <!-- HEADER -->

            <!-- MAIN CONTENT-->
            <div class="main-content">
            
            					<div class="card">
                                    <div class="card-header">
                                        <strong>EDIT</strong> ROLE
                                    </div>
                                    <div class="card-body card-block">
                                       <form action="${pageContext.request.contextPath}/updateRole" method="post" novalidate="novalidate">
                                       <c:forEach var="role" items="${model1.role}">
                   
                                                
                                                <input id="cc-pament" name="id" type="hidden" class="form-control" aria-required="true" aria-invalid="false" value="${role.id}">
                                             
                                            <div class="form-group has-success">
                                                <label for="cc-name" class="control-label mb-1">Role</label>
                                                <input id="cc-name" name="roleName"minlength="4" type="text" class="form-control cc-name valid" data-val="true" data-val-required="Please enter the name on card"
                                                    autocomplete="cc-name" aria-required="true" aria-invalid="false" aria-describedby="cc-name-error" value="${role.roleName}">
                                                <span class="help-block field-validation-valid" data-valmsg-for="cc-name" data-valmsg-replace="true"></span>
                                            </div>
                                            <div class="form-group">
                                                <label for="nf-email" class=" form-control-label">Status</label>
                                                <select name="status" class="form-control">
								                     <option value="active">Active</option>
								                      <option value="inactive">Inactive</option>     
								                </select>
                                            </div>
                                            <div>
                                                <div class="modal-footer">
													<button type="button" class="btn btn-secondary" data-dismiss="modal"><a id="display" style="color:white;"href="${pageContext.request.contextPath}/showRole">Back</a></button>
													<button type="Submit" class="btn btn-primary">Confirm</button>
												</div>
                                            </div>
                                             </c:forEach>
                                        </form>
                                    </div>
                                    
                                </div>
            
                
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>

     <%@ include file="/WEB-INF/views/javaScript.jsp"%>

</body>

</html>
<!-- end document-->
