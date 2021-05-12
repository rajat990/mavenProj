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
            
           <div class="row" style="margin: 5px;">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35" style="margin-bottom: 0px;">USER TABLE</h3>
                                <a style="float:right;" href="${pageContext.request.contextPath}/GenerateQrCode">
                                		<button style="float:right; margin-right:10px; clear:both;" type="button" class="au-btn au-btn-icon au-btn--green au-btn--small" data-toggle="modal" data-target="#largeModal">
						                   <i class="zmdi zmdi-plus"></i>Add QRCode
						                </button>
						         </a>
                                <div class="table-responsive table-responsive-data2">
                                    <table class="table table-data2" >
                                        <thead>
                                            <tr>
                                                <th>Club Name</th>
                                                <th>Club Address</th>
                                                <th>status</th>
                                                <th></th>
                                                <th ><center>Action</center></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach var="emp" items="${model1.users}">
                                            <tr class="tr-shadow">
                                                
                                                <td>${emp.locationName}</td>
                                                <td>${emp.locationAddress}</td>
                                                <td>
                                                    <span class="status--process">${emp.status}</span>
                                                </td>
                                                <td style="color: #00ad5f;"><a href="${pageContext.request.contextPath}/downloadQRCode/${emp.id}" target="_blank"> <button class="btn btn-danger btn-sm">Download</button> </a></td>	
                                                <td>
                                                    <div class="table-data-feature">
                                                        
                                                       <a href="${pageContext.request.contextPath}/editQRCode/${emp.id}"> <button class="item" style="margin-right:5px;"  title="Edit">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button></a>
                                                        <button class="item"  data-toggle="modal" data-target="#staticModal" value="${emp.id}" onclick="show(this.value)" title="Delete">
                                                            <i class="zmdi zmdi-delete"></i>
                                                        </button>
                                                        
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr class="spacer"></tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE -->
                            </div>
                        </div>
                
                <!-- modal static -->
			<div class="modal fade" id="staticModal" tabindex="-1" role="dialog" aria-labelledby="staticModalLabel" aria-hidden="true"
			 data-backdrop="static">
				<div class="modal-dialog modal-sm" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="staticModalLabel">Confirm Delete</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p>
							Please click confirm button to Delete User.
							</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary"><a id="display" style="color:white;"href="">Confirm</a></button>
						</div>
					</div>
				</div>
			</div>
			<!-- end modal static -->
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>
 <script type="text/javascript"  >
    function show(val){
    	
    	 value="${pageContext.request.contextPath}/deleteQRCode/"+val;
    	 $("#display").attr("href", value);
    }
</script>
    <!-- Jquery JS-->
    <%@ include file="/WEB-INF/views/javaScript.jsp"%>

</body>

</html>
<!-- end document-->
