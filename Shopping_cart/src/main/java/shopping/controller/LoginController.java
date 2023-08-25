package shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.Shoppingdao;
import shopping.dto.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("login-email");
		String password = req.getParameter("login-password");

		User user = new Shoppingdao().getByEmail(email);

		if (user != null) {
			if (user.getPassword().equals(password)) {
			     req.getSession().setAttribute("auth", user);
				resp.sendRedirect("index.jsp");
				

			} else {
				PrintWriter out = resp.getWriter();
				out.print("User Login failed");
			}

		}
	}

}
