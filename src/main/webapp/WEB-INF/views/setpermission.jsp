<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cs" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            	<div class="section__content section__content--p30">
                    <div class="container-fluid">
           <!-- USER DATA--><div class="row">
  								<div class="col-lg">
                                <div class="top-campaign" >
                                    <h3 class="title-3 m-b-30">
                                        <i class="zmdi zmdi-account-calendar"></i>
                                        
                                        Permission 
                                    </h3>
                                    
                                    
                                    <div class="table-responsive table-data"style="height: auto;">
                                    <form action="${pageContext.request.contextPath}/addpermission" method="post" >
                                    <c:forEach var = "user" items = "${model1.user}">
                                        <c:set var="dateParts" value="${fn:split(user.parent, '/')}" />
                                        <c:set var="chi" value="${fn:split(user.child, '/')}" />
                                    </c:forEach>
                                    <c:forEach var = "role_id" items = "${model1.role_id}">
                                    <input name="roleId" type="hidden" value="${role_id}" ></input>
                                    </c:forEach>
                                        <table class="table">
                                            <thead>
                                                
                                            </thead>
                                            <tbody>
                                            
                                            <c:forEach var = "listElement" items = "${model1.par1}"> 
                                            	<c:if test = "${listElement.parent_class =='0'}">
                                                <tr>
                                                    <td>
                                                        <label class="au-checkbox">
                                                         
                                                        
                                                            <input name="parent" type="checkbox"  <c:forEach items = "${dateParts}" var="check"> <c:if test ="${listElement.id == check}">checked="checked"</c:if></c:forEach> value="${listElement.id}" >
                                                            <span class="au-checkmark"></span>
                                                          
                                                        </label>
                                                    </td>
                                                  
                                                    <td style="padding-left: 10px;">
                                                        <span class="role admin">${listElement.menu_name}</span>
                                                    </td>
                                                  
                                                </tr>
                                                <c:forEach items="${model1.par1}" var="cell">
                                                	<c:if test = "${cell.parent_class ==listElement.menu_name}">
                                                		<tr>
		                                                    <td>
		                                                   
		                                                        <label class="au-checkbox">
		                                                            <input name="child" type="checkbox" <c:forEach items = "${chi}" var="chlid_check"> <c:if test ="${cell.id == chlid_check}">checked="checked"</c:if></c:forEach>  value="${cell.id}">
		                                                            <span class="au-checkmark"></span>
		                                                        </label>
		                                                    </td>
		                                                    <td style="padding-left: 10px;">
		                                                        <span class="role user">${cell.menu_name}</span>
		                                                    </td>
		                                               </tr>
                                                	</c:if>
												</c:forEach>
                                                </c:if>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                        <div class="card-footer">
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Save
                                        </button>
                                       <a href="${pageContext.request.contextPath}/permission"><button type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-arrow-circle-left"></i> Back
                                        </button></a>
                                    </div>
                                      </form>
                                    </div>
                
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>
   </div>
  </div>
</div>
</div>
    <!-- Jquery JS-->
    <%@ include file="/WEB-INF/views/javaScript.jsp"%>

</body>

</html>
<!-- end document-->
