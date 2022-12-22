<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script src="./webjars/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="./webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./webjars/bootstrap/5.2.0/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid w-100">
			<a class="navbar-brand"
				href="<%=request.getContextPath()%>/FoodServlet"><img
				src="img/Fresh Foodies-logos_black.png" alt="" width="33"
				height="33"><b>Fresh Foodies</b></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active fs-4 "
						aria-current="page" href="#">View Cart</a></li>
					<li class="nav-item"><a class="nav-link fs-4 active" href="<%=request.getContextPath()%>/signup.jsp">Sign
							up</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row border border-dark rounded m-3">
			<div class="col-md align-self-center">
				<div class="col-md align-self-center ">
					<h2 class="text-center font-weight-bold text-uppercase">
						<img src="img/Fresh Foodies-logos_black.png"
							class="img-fluid w-50" />
					</h2>
					<h2 class="text-center font-weight">Fresh Foodies</h2>
				</div>
			</div>
			<div class="col align-self-center border border-dark rounded m-5">
				<div style="text-align: justify;" class="m-3">
					<h1>Login</h1>
					<label>Please Enter your Email and Password to login</label>
				</div>
				<form action="LoginServlet" method="post">
					<div class="container">
						<div class="row m-3">
							<div class="col-sm col-sm-offset-3">
								<label for="LoginUsername">Username:</label> <input
									class="form-control" name="LoginUsername" id="LoginUsername"
									placeholder="Username">
							</div>
						</div>
						<div class="row m-3">
							<div class="col-sm col-sm-offset-3">
								<label for="LoginPassword">Password:</label> <input
									class="form-control" name="LoginPassword" id="LoginPassword"
									placeholder="**********">
							</div>
						</div>
						<div class="row m-3">
							<div class="col-sm col-sm-offset-3">
								<a href="<%=request.getContextPath()%>/signup.jsp" class="fw-bold">No Account Yet? Sign up here!</a>
							</div>
						</div>
						<div class="row m-3">
							<div class="col-sm col-sm-offset-3">
								<div class="col-sm-6 col-sm-offset-3 m-3">
									<p>
										<button class="btn btn-primary btn-lg" type="submit" name="LoginButton"
											value="Call Servlet">Login</button>
									</p>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>