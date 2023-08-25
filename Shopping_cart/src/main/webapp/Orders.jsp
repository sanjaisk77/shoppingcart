<%@page import="shopping.dto.Product"%>
<%@page import="shopping.dao.ProductDao"%>
<%@page import="shopping.dto.Orders"%>
<%@page import="java.util.List"%>
<%@page import="shopping.dao.OrderDao"%>
<%@page import="shopping.dto.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shopping.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
List<Orders> orders=null;
if (auth != null) {
	request.setAttribute("auth", auth);
	orders=new OrderDao().userOrder(auth.getId());
} else {
		response.sendRedirect("Login.jsp");
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Order Page</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
	<%@include file="includes/navBar.jsp"%>


	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>

			</thead>
			<tbody>
			<%if(orders!=null) {
				for(Orders order:orders){
				ProductDao pDao= new ProductDao();
				Product product=pDao.getProduct(order.getProductId());
				%>
				<tr>
				<td><%=order.getDate() %></td>
				<td><%= product.getName()%></td>
				<td><%= product.getCategory()%></td>
				<td><%=order.getQuanity() %></td>
				<td><%=product.getPrice() %></td>
				<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=order.getOrderId()%>">Cancel</a></td>
				
				</tr>
					
				<%}
			}%>
			
			</tbody>

		</table>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>