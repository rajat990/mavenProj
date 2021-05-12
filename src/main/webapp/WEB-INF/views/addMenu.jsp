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
        <!-- HEADER MOBILE-->
                    <!-- HEADER DESKTOP-->
 <%@ include file="/WEB-INF/views/header.jsp"%>
            <!-- MAIN CONTENT-->
            <div class="main-content">
            
            					<div class="card">
                                    <div class="card-header">
                                        <strong>ADD</strong> MENU
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="${pageContext.request.contextPath}/addMenuPro" method="post" >
                                            <div class="form-group">
                                                <label for="nf-email" class=" form-control-label">Menu Name</label>
                                                <input type="text" minlength="4" id="nf-email" name="menu_name" placeholder="Enter Menu Name...." class="form-control" required/>
                                                
                                            </div>
                                            <div class="form-group">
                                                <label for="nf-password" class=" form-control-label">Action</label>
                                                <input type="text"  name="url" placeholder="Enter Url..." class="form-control" />
                                               
                                            </div>
                                           
                                            <div class="form-group">
                                                <label for="nf-email" class=" form-control-label">Parent Class</label>
                                                <select name="parent_class" class="form-control">
								                     <option value="0">---Select parent menu---</option>
								                     <c:forEach var="par" items="${model1.par1}">
								                     <c:if test="${par.parent_class =='0'}">
								                       <option value="${par.menu_name}">${par.parent_class =='0'? par.menu_name :''}</option></c:if>
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
                                        <a href="${pageContext.request.contextPath}/showMenu"><button type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Back
                                        </button></a>
                                    </div>
                                            
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
