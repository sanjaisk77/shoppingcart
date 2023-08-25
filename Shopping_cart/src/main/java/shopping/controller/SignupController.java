package shopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dao.Shoppingdao;
import shopping.dto.User;


@WebServlet("/signup")
public class SignupController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("signup-name");
		String email=req.getParameter("signup-email");
		String password=req.getParameter("signup-password");
		
		User user=new User();
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		new Shoppingdao().saveUser(user);;
		
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}

}
