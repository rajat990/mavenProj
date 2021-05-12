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
			            <div class="page-wrapper">
					        <div class="page-content--bge5">
					            <div class="container">
					                <div class="login-wrap">
					                    <div class="login-content">
					                        <div class="login-logo">
					                                   <b><label style="font-size:20px;">REST PASSWORD</label></b>
					                        </div>
<!-- ------------------------------------------------------------------------------------------------------------------- -->                        
              <c:set var = "salary"  value = "${model1.message}"/>
               <c:if test="${salary!=' ' }">   
              <c:if test="${salary!='Your Password is Change Successfully.' }">
                 
               <section class="alert-wrap p-t-70 p-b-70" style="padding: 0px; margin-bottom:10px;">
                <div class="container" style="padding: 0px;">
                    <!-- ALERT-->
                    <div class="alert alert-danger"style="width: auto; margin: 0 auto;" role="alert">
                    
                        <span class="content"><c:out value="${salary}"></c:out></span>
                        <button class="close" type="button" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">
                                <i class="zmdi zmdi-close-circle"></i>
                            </span>
                        </button>
                    </div>
                    <!-- END ALERT-->
                </div>
            </section> </c:if>   </c:if>
             <c:if test="${salary=='Your Password is Change Successfully.' }">  
             <section class="alert-wrap p-t-70 p-b-70" style="padding: 0px; margin-bottom:10px;">
                <div class="container" style="padding: 0px;">
                    <!-- ALERT-->
                    <div class="alert au-alert-success alert-dismissible fade show au-alert au-alert--70per"style="width: auto; margin: 0 auto;" role="alert">
                    <i class="zmdi zmdi-check-circle"></i>
                        <span class="content"><c:out value="${salary}"></c:out></span>
                        <button class="close" type="button" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">
                                <i class="zmdi zmdi-close-circle"></i>
                            </span>
                        </button>
                    </div>
                    <!-- END ALERT-->
                </div>
            </section>
             </c:if>
           
<!-- ---------------------------------------------------------------------------------------------------------------------------- -->                        
					                        <div class="login-form">
					                            <form action="${pageContext.request.contextPath}/restPasswordPro" method="post">
					                            <input type="hidden"  name="email" value=<%=userEmail %> class="form-control">
					                            <input type="hidden"  name="id" value=<%=id %> class="form-control">
					                                 <div class="form-group">
		                                                <div class="input-group">
		                                                    <input type="password" minlength="4" maxlength="15"  id="password2" name="oldPassword" placeholder="Old Password" class="form-control">
		                                                </div>
		                                            </div>
					                         <div class="form-group">
                                                <div class="input-group">
                                                    <input type="password" minlength="4" maxlength="15"  id="password" name="newPassword" placeholder="New Password" onkeyup='check();' class="form-control">
                                                </div>
                                            </div>
					                        <div class="form-group">
                                                <div class="input-group">
                                                    <input type="password" minlength="4" maxlength="15"  id="confirm_password" name="confirmPassword" placeholder="Confirm Password" onkeyup='check();' class="form-control">
													                                           
                                                </div><span style="float: right;" id='message'></span>     
                                            </div>
					                                
					                                <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">submit</button>
					                            </form>
					                        </div>
					                    </div>
					                </div>
					            </div>
					        </div>
    					</div>
           
               
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>
     <script type="text/javascript"  >
var check = function() {
	var demoColors = ["#000000", "#FF0000"];
  if (document.getElementById('password').value ==
    document.getElementById('confirm_password').value) {
    document.getElementById('message').style.color = "green";
    document.getElementById('message').innerHTML = 'Matched';
  } else {
    document.getElementById('message').style.color = "red";
    document.getElementById('message').innerHTML = 'Not Matched';
  }
}
</script>
    <!-- Jquery JS-->
    <%@ include file="/WEB-INF/views/javaScript.jsp"%>
</body>

</html>
<!-- end document-->
