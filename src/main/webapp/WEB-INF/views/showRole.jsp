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
            	<div class="section__content section__content--p30">
                    <div class="container-fluid">
            			<button style="float:right; margin-right:10px; clear:both;" data-toggle="modal" data-target="#smallModal"  class="au-btn au-btn-icon au-btn--green au-btn--small">
                           <i class="zmdi zmdi-plus"></i>add item</button><br>
            <div style="margin-top:20px;" class="row m-t-30">
                            <div class="col-md-12">
                                <!-- DATA TABLE-->
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                            
                                                <th>Role</th>
                                                <th>Status</th>
                                                <th colspan="2">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach var="emp" items="${model1.roles}">
									                <tr class="table1">
									                 
									                  
									                  <td>${emp.roleName}</td>
									                  <td style="color: #00ad5f;">${emp.status} </td>
									                  <td><a href="${pageContext.request.contextPath}/editRole/${emp.id}"><button class="btn btn-outline-primary" >Edit</button></a>
									                  <td>
														<button class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#staticModal" value="${emp.id}" onclick="show(this.value)">Delete</button>
													  </td>
									                </tr>
									             
									        </c:forEach> 
                
                </tbody>
                                    </table>
                                    
                                    
                                </div>
                                <!-- END DATA TABLE-->
                                
                                
                            </div>
                        </div>
                        
            </div>
          </div>
        
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>
        <!-- modal small -->
			<div class="modal fade" id="smallModal" tabindex="-1" role="dialog" aria-labelledby="smallmodalLabel" aria-hidden="true">
				<div class="modal-dialog modal-sm" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="smallmodalLabel">Enter New Role</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form action="${pageContext.request.contextPath}/addRole" method="post" novalidate="novalidate" style="margin:10px;">
                                            <!-- <div class="form-group">
                                                <label for="cc-payment" class="control-label mb-1">Name</label>
                                                <input id="cc-pament" name="cc-payment" type="text" class="form-control" aria-required="true" aria-invalid="false" >
                                            </div> -->
                                            <div class="form-group has-success">
                                                <label for="cc-name" class="control-label mb-1">Role</label>
                                                <input id="cc-name" name="roleName" type="text" class="form-control cc-name valid" data-val="true" data-val-required="Please enter the name on card"
                                                    autocomplete="cc-name" aria-required="true" aria-invalid="false" aria-describedby="cc-name-error">
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
													<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
													<button type="Submit" class="btn btn-primary">Confirm</button>
												</div>
                                            </div>
                                        </form>
						
					</div>
				</div>
			</div>
			<!-- end modal small -->
			
			<!-- modal static -->
			<div class="modal fade" id="staticModal" tabindex="-1" role="dialog" aria-labelledby="staticModalLabel" aria-hidden="true"
			 data-backdrop="static">
				<div class="modal-dialog modal-sm" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="staticModalLabel">Static Modal</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p>
							Please click confirm button to Delete Role.
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

    <!-- Jquery JS-->
    <script type="text/javascript"  >
    function show(val){
    	
    	 value="${pageContext.request.contextPath}/deleteRole/"+val;
    	 $("#display").attr("href", value);
    }
</script>
    <%@ include file="/WEB-INF/views/javaScript.jsp"%>

</body>

</html>
<!-- end document-->
