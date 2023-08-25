package shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dto.Cart;
@WebServlet("/remove-from-cart")
public class RemoveFromCartControoler extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String id=req.getParameter("id");
		if (id!=null) {
			ArrayList<Cart> cart_list=(ArrayList<Cart>) req.getSession().getAttribute("cart-list");
			if (cart_list!=null) {
				for (Cart cart : cart_list) {
					if (cart.getId()==Integer.parseInt(id)) {
						cart_list.remove(cart_list.indexOf(cart));
						break;
					}
				}
				resp.sendRedirect("Cart.jsp");
			}
		} else {
			resp.sendRedirect("Cart.jsp");
		}
		
		
	}
	
	
}
