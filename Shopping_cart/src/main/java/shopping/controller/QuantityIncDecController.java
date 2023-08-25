package shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dto.Cart;
@WebServlet("/quantity-inc-dec")
public class QuantityIncDecController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String action=req.getParameter("action");
		int id=   Integer.parseInt(req.getParameter("id"));
		
		ArrayList<Cart> cart_list=(ArrayList<Cart>) req.getSession().getAttribute("cart-list");
		
		if (action!=null) {
			if (action.equals("inc")) {
				for (Cart cart : cart_list) {
					if (cart.getId()==id) {
						int quantity=cart.getQuntity();
						quantity++;
						cart.setQuntity(quantity);
						resp.sendRedirect("Cart.jsp");
					}
				}
			}
			 if (action.equals("dec")) {
				for (Cart cart : cart_list) {
					if (cart.getId()==id && cart.getQuntity()>1) {
						int quantity=cart.getQuntity();
						quantity--;
						cart.setQuntity(quantity);
						break;
					}
				}
				resp.sendRedirect("Cart.jsp");
			}
		}else {
			resp.sendRedirect("Cart.jsp");
		}
	}
	
}
