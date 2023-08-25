package shopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dto.Cart;

@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		
		ArrayList<Cart> cartList=new ArrayList<Cart>();
		
		int id=Integer.parseInt(req.getParameter("id"));
		Cart cm=new Cart();
		cm.setId(id);
		cm.setQuntity(1);
		
		
		HttpSession session=req.getSession();
		ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
		if (cart_list==null) {
			cartList.add(cm);
			session.setAttribute("cart-list", cartList);
			resp.sendRedirect("index.jsp");
		} else {
			cartList=cart_list;
			boolean exist=false;
			for (Cart cart : cart_list) {
				if (cart.getId()==id) {
					exist=true;
					resp.getWriter().println("<h3 style='color :crimson; text-align:center'>Item aleredy Exist in cart.<a href='Cart.jsp'>Go to Cart</a>");
				}
			}
			if (!exist) {
				cartList.add(cm);
				resp.sendRedirect("index.jsp");
			}

		}
		
		
	}

}
