<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <%@ include file="/WEB-INF/views/head.jsp"%>
</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <img src="${pageContext.request.contextPath}/resources/images/icon/logo.png" alt="CoolAdmin" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
<!-- -----------------------------------------------------------------------------------------------------------------------------  -->
<!-- ------------------------------------------Mobile Resposive--------------------------------------------------------------------------------------------  -->
<!-- -----------------------------------------------------------------------------------------------------------------------------  -->
            
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
                        <li class="has-sub">
                            <a class="js-arrow" href="${pageContext.request.contextPath}/dashBoard">
                                <i class="fas fa-tachometer-alt"></i>Dashboard</a>
                                

<!-- -----------------------------------------------------------------------------------------------------------------------------  -->
<!-- ------------------------------------------Different DashBord--------------------------------------------------------------------------------------------  -->
<!-- -----------------------------------------------------------------------------------------------------------------------------  -->

                        </li>
<!-- --------------------------------------------------------------------------------------------------------------------------------- -->
<!-- --------------------------------------------------------------------------------------------------------------------------------- --> 
           <c:forEach var = "listElement" items = "${model1.par}">
           		<c:if test = "${listElement.parent_class =='0'}">            
              		<li class="has-sub">
          				<a class="js-arrow" href="#" >
                  			<i class="fa fa-list"></i>
                  			${listElement.menu_name}
                		</a>
                		
                <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
					<c:forEach items="${model1.par}" var="cell">
				    	<c:if test = "${cell.parent_class ==listElement.menu_name}">
				        	<li >
					        	<a href="${pageContext.request.contextPath}${cell.url}" class="nav-link">
					           		<i class="fa fa-bullseye"></i>
					                ${cell.menu_name}
					            </a>
				           </li>
				    	</c:if>
					</c:forEach>
              	</ul>
             		
             			 
              		</li>
              
           		</c:if>
           </c:forEach> 
                   
                    </ul>
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/images/icon/logo.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li class="active has-sub">
                            <a class="js-arrow" href="${pageContext.request.contextPath}/dashBoard">
                                <i class="fas fa-tachometer-alt"></i>Dashboard</a>
<!-- -----------------------------------------------------------------------------------------------------------------------------  -->
<!-- ------------------------------------------Different DashBord--------------------------------------------------------------------------------------------  -->
<!-- -----------------------------------------------------------------------------------------------------------------------------  -->

                           
<!-- --------------------------------------------------------------------------------------------------------------------------------- -->
<!-- --------------------------------------------------------------------------------------------------------------------------------- -->                             
                            
                       </li>
           <c:forEach var = "listElement" items = "${model1.par}">
           		<c:if test = "${listElement.parent_class =='0'}">            
              		<li class="has-sub">
          				<a class="js-arrow" href="#" >
                  			<i class="fa fa-list"></i>
                  			${listElement.menu_name}
                		</a>
                		
                <ul class="list-unstyled navbar__sub-list js-sub-list">
					<c:forEach items="${model1.par}" var="cell">
				    	<c:if test = "${cell.parent_class ==listElement.menu_name}">
				        	<li class="nav-item">
					        	<a href="${pageContext.request.contextPath}${cell.url}" class="nav-link">
					           		<i class="fa fa-bullseye"></i>
					                ${cell.menu_name}
					            </a>
				           </li>
				    	</c:if>
					</c:forEach>
              	</ul>
             		
             			 
              		</li>
              
           		</c:if>
           </c:forEach> 
           
<!------------------------------------------------------------------------------------------------------------------------------------  -->
<!----------------------------Static Menu Bar--------------------------------------------------------------------------------------------------------  -->
<!------------------------------------------------------------------------------------------------------------------------------------  -->           
          
                    </ul>
<!------------------------------------------------------------------------------------------------------------------------------------  -->
<!------------------------------------------------------------------------------------------------------------------------------------  -->                    
                    
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap" style="float: right;">
                       
                            <div class="header-button">
                               
                                 <%				
                                 					int userId=(int)session.getAttribute("userId");
                                                	String userName=(String)session.getAttribute("name");
                                                	String userEmail=(String)session.getAttribute("userEmail");
                                                	
                                                	String userImage=(String)session.getAttribute("ProfilePic");
                                                	String userMobileNo=(String)session.getAttribute("userMobileNo");
                                                	String userRole=(String)session.getAttribute("userRole");
                                                	
                                                	String userPassword=(String)session.getAttribute("userPassword");
                                                	                     
                                                	
                                                %>
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/resources/images/icon/kisspng-computer-.png" alt="<%=userName %>" />
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#"><%=userName %></a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="${pageContext.request.contextPath}/resources/images/icon/kisspng-computer-.png" alt="<%=userName %>" />
                                                    </a>
                                                </div>
                                                
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#"><%=userName %></a>
                                                    </h5>
                                                    <span class="email"><%=userEmail %></span>
                                                </div>
                                            </div>
                                    
                                            <div class="account-dropdown__footer">
                                                <a href="${pageContext.request.contextPath}/logout">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
           <div class="main-content">
            <div class="section__content section__content--p30">
       		<div class="container-fluid">
       				<div class="row" style="padding-bottom: 30px;">
       					<div class="col-lg">
                                <div class="card">
                                    <div class="card-header">
                                        <strong>USER</strong> PROFILE
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="editUserProfile" method="post" enctype="multipart/form-data" class="form-horizontal">
                                            <input id="cc-pament" name="id" type="hidden" class="form-control" aria-required="true" aria-invalid="false" value="<%=userId%>">
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Name</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="text-input" name="name" minlength="4" value="<%=userName %>" class="au-input au-input--full" placeholder="Enter your User Name" required/>
                                                
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input"  class=" form-control-label">Email Address</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="email" pattern="[a-z0-9_%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" id="email-input" name="email" value="<%=userEmail %>"  placeholder="Enter your email" class="au-input au-input--full" required/>
                                                  
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="password-input" class=" form-control-label">Password</label>
                                                    
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="password" id="password-input" minlength="4" maxlength="15" name="password" value="<%=userPassword %>"  placeholder="Enter a complex password" class="au-input au-input--full" required/>
                                              
                                                </div>
                                            </div>
                                           
                                           <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Mobile Number</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" pattern="\d*" minlength="10" maxlength="15"  name="mobile_number" value="<%=userMobileNo %>" placeholder="Enter your Mobile Number" class="au-input au-input--full" required/>
                                                 
                                                </div>
                                            </div>
                                           <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="disabled-input" class=" form-control-label">Role</label>
                                                </div>
                                                <div class="col-12 col-md-9"><c:forEach var = "role" items = "${model1.role}">
                                                    <input type="text" id="disabled-input" name="role" value="${role.roleName }"  disabled="" class="au-input au-input--full">
                                                	</c:forEach>
                                                </div>
                                            </div>
                                            <%-- <%-- <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="file-input" class=" form-control-label">File input</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="file" id="file-input" name="file" accept="image/x-png,image/gif,image/jpeg" class="">
                                                </div>
                                            </div>
                                          <%if(!userImage.equals("#")) {%>
                                             <div class="image"><%System.out.println("@@@@@@@!!!!@@@@@"); %>
                                                    <a href="#">
                                                        <img src="${pageContext.request.contextPath}<%=userImage%>" alt="<%=userName %>" />
                                                    </a>
                                                </div><%} %>   --%>                                            
                                     <div class="card-footer">
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Submit
                                        </button>
                                       
                                    </div>
                                        </form>
                                    </div>
                                   
                                </div>
  					</div></div>         
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>
	
    <!-- Jquery JS-->
    <script type="text/javascript">
    
    </script>
   <!-- Jquery JS-->
    <%@ include file="/WEB-INF/views/javaScript.jsp"%>

</body>

</html>
<!-- end document-->
