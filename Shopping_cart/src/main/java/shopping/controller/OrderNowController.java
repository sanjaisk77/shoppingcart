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
@WebServlet("/order-now")
public class OrderNowController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		
		User auth=(User) req.getSession().getAttribute("auth");
		
		if (auth!=null) {
			String productId=req.getParameter("id");
			int productQuantity=Integer.parseInt(req.getParameter("quantity"));
			if (productQuantity<=0) {
				productQuantity=1;
			}
			Orders order=new Orders();
			order.setProductId(Integer.parseInt(productId));
			order.setuId(auth.getId());
			order.setQuanity(productQuantity);
			order.setDate(formatter.format(date));
			
			OrderDao dao=new OrderDao();
			boolean res=dao.saveOrder(order);
			if (res) {
				ArrayList<Cart> cart_list=(ArrayList<Cart>) req.getSession().getAttribute("cart-list");
				if (cart_list!=null) {
					for (Cart cart : cart_list) {
						if (cart.getId()==Integer.parseInt(productId)) {
							cart_list.remove(cart_list.indexOf(cart));
							break;
						}
					}
				}
				resp.sendRedirect("Orders.jsp");
			} else {
				resp.getWriter().println("Failed");
			}
		} else {
			resp.sendRedirect("Login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
