<%@page import="shopping.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%User auth=(User)request.getSession().getAttribute("auth");
    if(auth !=null){
    	request.setAttribute("auth", auth);
    }    
    %><!DOCTYPE html>
<html>
<head>
<title>Signup Page</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="includes/navBar.jsp" %>
	<div class="cotainer">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="signup" method="post">
				<div class="form-group">
						<label>Name</label> <input type="text"
							class="form-control" name="signup-name"
							placeholder="Enter your Name" required="required">
					</div>
					<div class="form-group">
						<label>Email Address</label> <input type="email"
							class="form-control" name="signup-email"
							placeholder="Enter your Email" required="required">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="signup-password" placeholder="********"
							required="required">
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>

				</form>


			</div>
		</div>
	</div>



	<%@include file="includes/footer.jsp"%>
</body>
</html>