<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				<c:choose>
					<c:when test="${loggedin}">
						<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link active fs-4 "
								aria-current="page" href="<%=request.getContextPath()%>/CartServlet">View Cart</a></li>
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle fs-4 active" role="button" data-bs-toggle="dropdown" aria-expanded="false">
									<c:out value="${username}" />
								</a>
								 <ul class="dropdown-menu dropdown-menu">
								 	<li>
								 		<form action="FoodServlet" method="post">
								 			<button type="submit" class="btn btn-link text-dark" value="logout" name="button">Log Out</button>
								 		</form>
								 	</li>
								 </ul>
							</li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link fs-4 active"
								href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<div class="row">
			<div id="carouselExampleControls"
				class="carousel carousel-dark slide p-0" data-bs-ride="carousel">
				<div class="carousel-inner border border-3 border-dark rounded">
					<div class="carousel-item active">
						<img src="img/img1.jpg" class="d-block w-100"
							style="width: 100%; height: 700px;" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/img2.jpg" class="d-block w-100"
							style="width: 100%; height: 700px;" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
	</div>
	<div class="container mt-3">
		<div class="row border border-2 border-dark rounded">
			<c:forEach var="food" items="${listFoods}">

				<div class="card m-3" style="width: 18rem;">
					<img src=<c:out value="${food.img}"/> class="card-img-top"
						style="height: 14rem;" alt="...">
					<div class="card-body ">
						<h5 class="card-title">
							<c:out value="${food.name}" />
						</h5>
						<h6 class="card-subtitle mb-2 text-muted">
							$
							<c:out value="${food.price}" />
						</h6>
						<p class="card-text">
							<c:out value="${food.description}" />
						</p>
						<form action="FoodServlet" method="post">
							<button type="submit" class="btn btn-primary" value="${food.food_id}" name="button">Add to Cart</button>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>