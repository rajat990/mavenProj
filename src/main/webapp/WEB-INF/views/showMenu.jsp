<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html lang="en">
<style>
.table1:hover{

 box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 
 			0 6px 20px 0 rgba(0,0,0,0.19);
        -webkit-transform: translateX(-3px);
        transform: translateX(-3px);
}

</style>
<head>
    <%@ include file="/WEB-INF/views/head.jsp"%>
</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER -->
                
 <%@ include file="/WEB-INF/views/header.jsp"%>
            <!-- HEADER -->

            <!-- MAIN CONTENT-->
            <div class="main-content" style="padding-bottom: 50px;">
            <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                        <div class="col-lg">
            <a style="float:right;" href="${pageContext.request.contextPath}/addMenu">
            	<button style="float:right; margin-right:10px; clear:both;" class="au-btn au-btn-icon au-btn--green au-btn--small">
                   <i class="zmdi zmdi-plus"></i>add item
                </button>
            </a> 
             <br>
           
                                <div class="table-responsive table--no-card m-b-30" style="margin-top:20px;">
                                    <table class="table table-borderless table-striped table-earning">
                                        <thead>
                                            <tr>
                                                
                                                <th>Menu Name</th>
                                                <th>Parent</th>
                                                <th>Status</th>
                                                <th colspan="2">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach var="emp" items="${model1.users}">
									                <tr class="table1">
									                  
									                  <td>${emp.menu_name}</td>
									                  <c:choose><c:when test="${emp.parent_class !='0'}"><td>${emp.parent_class}</td> </c:when><c:otherwise><td></td></c:otherwise></c:choose>
									                  <td style="color: #00ad5f;">${emp.status} </td>
									                  <td><a href="${pageContext.request.contextPath}/editMenu/${emp.id}"><button class="btn btn-outline-primary" >Edit</button></a>
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
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>
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
							Please click confirm button to Delete Menu.
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
    	
    	 value="${pageContext.request.contextPath}/deleteMenu/"+val;
    	 $("#display").attr("href", value);
    }
</script>

    <!-- Jquery JS-->
    <%@ include file="/WEB-INF/views/javaScript.jsp"%>

</body>

</html>
<!-- end document-->
