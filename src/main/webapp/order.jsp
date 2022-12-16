<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>Fresh Foodie Orders</title>
<script src="./webjars/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="./webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./webjars/bootstrap/5.2.0/css/bootstrap.min.css">
</head>
<body>
  <div class="py-5 text-center">
    <img src="img/Fresh Foodies-logos_black.png" alt="" width="72"height="72">
    <b style="font-size:30px">Fresh Foodies</b>
    <h2>Orders</h2>
  </div>
  
   <div class="py-3 text-center">
  <table class="table">
  <thead class="thead">
    <tr>
      <th scope="col">Order Id</th>
      <th scope="col">User Id</th>
      <th scope="col">Food Id</th>
      <th scope="col">Address</th>
      <th scope="col">Timestamp</th>
      <th scope="col">Status</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="order" items="${listOrders}">
  	<!-- for each order, display their items accordingly -->
  	<tr>
  		<td>
  			<c:out value="${order.order_id}">
  			</c:out>
  		</td>
  		<td>
  			<c:out value="${order.order_user_id}">
  			</c:out>
  		</td>
  		<td>
  			<c:out value="${order.order_food_id}"></c:out>
  		</td>
  		<td>
  			<c:out value="${order.address}"></c:out>
  		</td>
  		<td>
  			<c:out value="${order.timestamp}"></c:out>
  		</td>
  		<td>
  			<c:out value="${order.status}"></c:out>
  		</td>
  		<td>
  		  <!-- for each order in database edit/delete buttons which invoke the edit/delet funcs -->
  		  <form action="OrderServlet" method="post">
  		  	 	<button class="btn btn-link text-dark" value='${order.order_id}' name="EditButton">Complete</button> &nbsp;&nbsp;&nbsp;&nbsp; 
          	</form>
          <form action="OrderServlet" method="post">
			<button class="btn btn-link text-dark" value='${order.order_id}' name="DeleteButton">Delete</button>
			</form>
  		</td>
  	</c:forEach>
  </tbody>
</table>
</div>
  
</body>
</html>