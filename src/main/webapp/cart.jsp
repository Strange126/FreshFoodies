<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>Viewing Cart</title>
<script src="./webjars/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="./webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./webjars/bootstrap/5.2.0/css/bootstrap.min.css">
</head>
  <body class="bg-light">
    <div class="container">
  <div class="py-5 text-center">
    <img src="img/Fresh Foodies-logos_black.png" alt="" width="72"height="72">
    <b style="font-size:30px">Fresh Foodies</b>
    <h2>Checkout form</h2>
  </div>

  <div class="row">
    <div class="col-md-4 order-md-2 mb-4">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">Your cart:</span>
        <span class="text-muted">items in cart: <c:out value="${listCarts.size()}"/></span>
      </h4>
      <ul class="list-group mb-3">
      <c:set var="total" value="${0}"/>
      <c:forEach var="cart" items="${listCarts}"> 
        <li class="list-group-item d-flex justify-content-between lh-condensed">
          <div>
            <h6 class="my-0"><c:out value="${cart.name}"/></h6>
            <small class="text-muted"><c:out value="${cart.description}"/></small>
          </div>
          <c:set var="total" value="${total + cart.price}"/>
          <span class="text-muted">$<c:out value="${cart.price}"/> 
          	<form action="CartServlet" method="post">
          		<button class="btn btn-danger ms-1" value="${cart.cart_id}" name="button" type="submit" >Delete</button>
          	</form>
          </span>
        </li>
        </c:forEach>
        <li class="list-group-item d-flex justify-content-between">
          <span>Total Price:</span>
          <strong>$<c:out value="${total}"/></strong>
        </li>
      </ul>
      
    </div>
    <div class="col-md-8 order-md-1">
      <h4 class="mb-3">Billing address</h4>
      <form action="CartServlet" method="post">
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">First name</label>
            <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">Last name</label>
            <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
          </div>
        </div>
        <div class="mb-3">
          <label for="address">Address</label>
          <input type="text" name="address" class="form-control" id="address" placeholder="1234 Main St" required>
        </div>
        <h4 class="mb-3">Payment</h4>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="cc-name">Name on card</label>
            <input type="text" class="form-control" id="cc-name" placeholder="" required>
            <small class="text-muted">Full name as displayed on card</small>

          </div>
          <div class="col-md-6 mb-3">
            <label for="cc-number">Credit card number</label>
            <input type="text" class="form-control" id="cc-number" placeholder="" required>

          </div>
        </div>
        <div class="row">
          <div class="col-md-3 mb-3">
            <label for="cc-expiration">Expiration</label>
            <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
          </div>
          <div class="col-md-3 mb-3">
            <label for="cc-cvv">CVV</label>
            <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
          </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit" name="button" value="Order">Place Order</button>
      </form>
    </div>
  </div>

</div>
</html>