<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="./webjars/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="./webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./webjars/bootstrap/5.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="./webjars/bootstrap-icons/1.10.2/font.bootstrap-icons.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid w-100">
			<a class="navbar-brand" href="#"><img
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
					<li class="nav-item"><a class="nav-link fs-4 active" href="#">Sign In</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<div class="row">
			<div id="carouselExampleControls" class="carousel carousel-dark slide p-0"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/img1.jpg" class="d-block w-100" style="width:100%; height: 700px;" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/img2.jpg" class="d-block w-100" style="width:100%; height: 700px;" alt="...">
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
			Tester
		</div>
	</div>
</body>
</html>