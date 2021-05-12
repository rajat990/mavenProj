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
 <!-- Header -->
            <!-- MAIN CONTENT-->
            <div class="main-content">
            
            					<div class="card">
                                    <div class="card-header">
                                        <strong>Edit</strong> MENU
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="updateMenu" method="post" class="">
                                        <c:forEach var="menu" items="${model1.menu}">
                                        
                                        <input name="id" type="hidden" class="form-control" value="${menu.id}"  >
                                            <div class="form-group">
                                                <label for="nf-email" class=" form-control-label">Menu Name</label>
                                                <input type="text" id="nf-email" name="menu_name" value="${menu.menu_name}" class="form-control" required/>
                                                
                                            </div>
                                            <div class="form-group">
                                                <label for="nf-password" class=" form-control-label">Action</label>
                                                <input type="text" id="nf-password" name="url" value="${menu.url}" class="form-control" />
                                               
                                            </div>
                                            
                                            <div class="form-group">
                                                <label for="nf-email" class=" form-control-label">Parent Class</label>
                                                <select name="parent_class" class="form-control" required>
								                     <option value="0" ${menu.parent_class =='0'? 'selected="true"' : '' }>---Select parent menu---</option>
								                     <c:forEach var="par" items="${model1.par}">
								                     <c:if test="${par.parent_class =='0'}">
								                       <option value="${par.menu_name}"<c:if test = "${menu.parent_class == par.menu_name}"> selected </c:if> >${par.menu_name}</option></c:if>
								                      </c:forEach>
								                 </select>
                                                
                                            </div>
                                            <div class="form-group">
                                                <label for="nf-email" class=" form-control-label">Status</label>
                                                <select name="status" class="form-control">
								                     <option value="active">Active</option>
								                      <option value="inactive">Inactive</option>     
								                </select>
                                            </div>
                                            <div class="card-footer">
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Submit
                                        </button>
                                        <a href="../showMenu"><button type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Back
                                        </button></a>
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

    <!-- Jquery JS-->
    <%@ include file="/WEB-INF/views/javaScript.jsp"%>

</body>

</html>
<!-- end document-->
