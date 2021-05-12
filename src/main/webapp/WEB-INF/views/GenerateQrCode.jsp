<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<strong>Generate</strong> QR-Code
				</div>
				<div class="card-body card-block">
					<form action="${pageContext.request.contextPath}/addQrcode"
						method="post">
						<div class="form-group">
							<label for="nf-email" class=" form-control-label">Club
								Name</label> <input type="text" id="nf-email" name="clubName"
								placeholder="Enter Club Name...." class="form-control" required />
						</div>
						<div class="form-group">
							<label for="nf-email" class=" form-control-label">Location
								Identifier</label> <input type="text" id="nf-email"
								name="locationIdentifier"
								placeholder="Enter Location Identifier...." class="form-control"
								required />
						</div>
						<div class="form-group">
							<label for="nf-password" class=" form-control-label">Longitude</label>
							<input type="text" id="nf-password" name="longitude"
								placeholder="Enter Longitude" class="form-control" required />
						</div>
						<div class="form-group">
							<label for="nf-password" class=" form-control-label">Latitude</label>
							<input type="text" id="nf-password" name="latitude"
								placeholder="Enter Latitude" class="form-control" required />
						</div>
						<div class="form-group">
							<label for="nf-password" class=" form-control-label">Distance</label>
							<input type="text" id="nf-password" name="distance"
								placeholder="Enter Distance" class="form-control" required />
						</div>
						<div class="form-group">
							<label for="nf-password" class=" form-control-label">Type</label>
							<input type="text" id="nf-password" name="type"
								placeholder="Enter Type" class="form-control" required />
						</div>
						<div class="form-group">
							<label for="nf-password" class=" form-control-label">Phone
								Number</label> <input type="text" id="nf-password"
								name="locationPhoneNumber" placeholder="Enter Phone Number"
								class="form-control" required />
						</div>
						<div class="form-group">
							<label for="nf-password" class=" form-control-label">Email</label>
							<input type="text" id="nf-password" name="locationEmail"
								placeholder="Enter Email" class="form-control" required />
						</div>
						<div class="form-group">
							<label for="nf-password" class=" form-control-label">Club
								Address</label> <input type="text" id="nf-password" name="clubAddress"
								placeholder="Enter Club Address" class="form-control" required />
						</div>
						<div class="form-group">
							<label for="nf-email" class=" form-control-label">Status</label>
							<select name="status" class="form-control">
								<option value="active">Active</option>
								<option value="inactive">Inactive</option>
							</select>
						</div>
						<div class="form-group">
							<div class="card-footer">
								<button type="submit" class="btn btn-primary btn-sm">
									<i class="fa fa-dot-circle-o"></i> Submit
								</button>
								<a href="${pageContext.request.contextPath}/showMenu"><button
										type="reset" class="btn btn-danger btn-sm">
										<i class="fa fa-ban"></i> Back
									</button></a>
							</div>
					</form>
				</div>
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
