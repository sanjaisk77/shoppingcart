<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">E-Commerce Shopping cart</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="Cart.jsp">Cart <span class="badge badge-danger px-1">${cart_list.size()}</span></a>
				</li>
				<%
				if (auth != null) {
				%>
				<li class="nav-item"><a class="nav-link" href="Orders.jsp">Orders</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
				</li>
				<%
				} else {
				%>

				<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a>
				</li>
				<%
				}
				%>
				<li class="nav-item"><a class="nav-link" href="Signup.jsp">Signup</a>
				</li>
			</ul>

		</div>
	</div>
</nav>