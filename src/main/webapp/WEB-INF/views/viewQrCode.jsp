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
                                        <strong>Edit</strong> QR-Code
                                    </div>
                                    <c:forEach var="emp" items="${model1.QrCode}">
                                    <div class="card-body card-block">
                                        <form action="${pageContext.request.contextPath}/updateQrcode" method="post" >
                                           <input type="hidden" name="id" value="${emp.id}"  class="form-control" />
                                            <div class="form-group">
                                                <label for="nf-email" class=" form-control-label">Club Name</label>
                                                <input type="text" minlength="4" id="nf-email" name="club_name" value="${emp.club_name}"  class="form-control" required/>
                                            </div>
                                            <!-- 
                                            <div id="map-canvas" style="height:300px; width:500px"></div> -->
                                            <div class="form-group">
                                                <label for="nf-password" class=" form-control-label">Longitude</label>
                                                <input type="text" id="nf-password" minlength="4" name="longitude" value="${emp.longitude}"  class="form-control" required/>
                                               
                                            </div>
                                            <div class="form-group">
                                                <label for="nf-password" class=" form-control-label">Latitude</label>
                                                <input type="text" id="nf-password" minlength="4" name="latitude" value="${emp.latitude}"  class="form-control" required/>
                                               
                                            </div>
                                            <div class="form-group">
                                                <label for="nf-password" class=" form-control-label">Club Address</label>
                                                <input type="text" id="nf-password" minlength="4" name="club_address" value="${emp.club_address}"  class="form-control" required/>
                                               
                                            </div>
                                           <div class="form-group">
                                                <label for="nf-password" class=" form-control-label">Club Tag</label>
                                                <input type="text" id="nf-password" minlength="4" name="club_tag" value="${emp.club_tag}"  class="form-control" required/>
                                               
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
                                        <a href="${pageContext.request.contextPath}/showQrcode"><button type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Back
                                        </button></a>
                                    </div>
                                            
                                        </form>
                                    </div></c:forEach>
                                    
                                </div>
            
          
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

   

    <!-- Jquery JS-->
 <%@ include file="/WEB-INF/views/javaScript.jsp"%>

</body>

</html>
<!-- end document-->
