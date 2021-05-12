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
            
             <!-- END USER DATA-->
          				 <div class="col-lg-6" style="max-width: none;">    
                                <div class="card">
                                    <div class="card-header">
                                        <strong>SELECT ROLE</strong> 
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="${pageContext.request.contextPath}/setpermission" method="post" class="form-inline">
                                            <div class="row form-group" >
                                               
                                                <div class="col-12 col-md-9">
                                                <select name="select" id="select" class="form-control" style="cursor: pointer;"required>
                                                    <option value="">---Select Role---</option>
									                     <c:forEach var="role" items="${model1.roles}">
									                     <c:if test="${role.status =='active'}">
									                       <option value="${role.id}" >${role.roleName}</option></c:if>
									                       </c:forEach>
									             </select>
                                                </div>
                                            </div>
                                        
                                    </div>
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Submit
                                        </button>
                                        
                                    </div>
                                   </form>
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
