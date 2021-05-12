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
<%--            <section class="statistic statistic2">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-lg-3">
                            <div class="statistic__item statistic__item--green">
                           <%String m=(String)session.getAttribute("countProduct");%>
                                <h2 class="number"><%=m%></h2>
                                <br>
                                <span class="desc">Total Number of Product</span>
                                <div class="icon">
                                    <i class="zmdi zmdi-account-o"></i>
                                </div>
                            </div>
                        </div>

                      <div class="col-md-6 col-lg-3">
                            <div class="statistic__item statistic__item--blue">
                                <%String mm=(String)session.getAttribute("countsubscribe");%>
                                <h2 class="number"><%=mm%></h2>
                                <span class="desc">Total Number of Subscriber</span>
                                <div class="icon">
                                    <i class="zmdi zmdi-account-o"></i>
                                </div>
                            </div>
                        </div>
                      
                    </div>
                </div>
            </section>
 --%>           
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
