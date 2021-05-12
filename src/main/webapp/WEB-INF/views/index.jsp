<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

     
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="/WEB-INF/views/head.jsp"%>
</head>
<body class="animsition">
    <div class="page-wrapper">
        <div class="page-content--bge5">
            <div class="container">
                <div class="login-wrap">
                    <div class="login-content">
                        <div class="login-logo">
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/resources/images/icon/logo.png" alt="AdminPanel">
                            </a>
                        </div>
<!-- ------------------------------------------------------------------------------------------------------------------- -->                        
         
         <c:choose>
        <c:when test="${model1.msg =='0'}">              
               <section class="alert-wrap p-t-70 p-b-70" style="padding: 0px;">
                <div class="container" style="padding: 0px;">
                    <!-- ALERT-->
                    <div class="alert alert-danger"style="width: auto; margin: 0 auto;" role="alert">
                        
                        <span class="content">Login Credentials are Wrong</span>
                        <button class="close" type="button" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">
                                <i class="zmdi zmdi-close-circle"></i>
                            </span>
                        </button>
                    </div>
                    <!-- END ALERT-->
                </div>
            </section>
          </c:when>
          
          </c:choose>
         
                        
<!-- ---------------------------------------------------------------------------------------------------------------------------- -->                        
          
                        <div class="login-form">
                            <form action="${pageContext.request.contextPath}/signIn" method="post">
                                <div class="form-group">
                                    <label>Email Address</label>
                                    <input class="au-input au-input--full" type="email" pattern="[a-z0-9_%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="email" placeholder="userName">
                                </div>
                                
                                <div class="form-group">
                                    <label>Password</label>
                                    <input class="au-input au-input--full" type="password" name="password" minlength="4" maxlength="15" placeholder="Password">
                                </div>
                                <div class="login-checkbox">
                                    <label>
                                        <input type="checkbox" name="remember">Remember Me
                                    </label>
                                    <label>
                                        <a href="${pageContext.request.contextPath}/">Forgotten Password?</a>
                                    </label>
                                </div>
                                <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">sign in</button>
                                
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Jquery JS-->
     <%@ include file="/WEB-INF/views/javaScript.jsp"%>
    <script>
    setTimeout(function() {
        $('#mydiv').fadeOut('fast');
    }, 1500); 
    </script>

</body>

</html>
<!-- end document-->