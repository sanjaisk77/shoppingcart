package shopping.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dao.OrderDao;
import shopping.dto.Cart;
import shopping.dto.Orders;
import shopping.dto.User;

@WebServlet("/cart-check-out")
public class CheckOutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		
		ArrayList<Cart> cart_list=(ArrayList<Cart>) req.getSession().getAttribute("cart-list");

		User auth=(User) req.getSession().getAttribute("auth");
		
		if (cart_list!=null&& auth!=null) {
			for (Cart cart : cart_list) {
				Orders orders=new Orders();
				orders.setProductId(cart.getId());
				orders.setuId(auth.getId());
				orders.setQuanity(cart.getQuntity());
				orders.setDate(formatter.format(date));
				
				
				OrderDao dao=new OrderDao();
				boolean res=dao.saveOrder(orders);
				if (!res) break;
			}
			cart_list.clear();
			resp.sendRedirect("Cart.jsp");
			
		} else {
			if (auth==null) {
				resp.sendRedirect("Login.jsp");
			}
			resp.sendRedirect("Cart.jsp");

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
