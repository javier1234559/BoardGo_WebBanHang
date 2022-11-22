package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import DAO.ProductDao;
import entities.Product;
import entities.Product;
import entities.productDetail;
import entities.Cart;


@WebServlet(urlPatterns = {"/ProductServlet", "/HOME/ProductServlet"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Cart> lsCart = new ArrayList<>();
	public static long cost = 0;
	
	private ProductDao productDao ;
	
	public void init() throws ServletException {
		try {
			productDao = new ProductDao();
		}catch (Exception e) {
			throw new ServletException(e);	
			
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		ProductDao dao = new ProductDao();
		Product pro = null;
		String code = null;
		Cart cart = new Cart();
		
		if(action == null || action.equals("")) {
			request.setAttribute("lsCart", lsCart);
			request.setAttribute("cost", cost);
			request.getRequestDispatcher("/HOME/cart.jsp").forward(request, response);
			//request.getRequestDispatcher("/ShopServlet").forward(request, response);
			return;
		}
		
		switch(action) {
			case "AddCart":
				code = request.getParameter("code");
				int notice = 0;
				pro = dao.findByID(code);
				if(pro != null) {
					if(lsCart.isEmpty()) {
						cost = cost + pro.getPrice();
						cart.setPro(pro);
						cart.setQuantity(1);
						lsCart.add(cart);
					}else {
						for(Cart item : lsCart) {
							if(item.getPro().getIdproduct() == pro.getIdproduct()) {
								cost = cost + pro.getPrice();
								int qnt = item.getQuantity();
								item.setQuantity(qnt + 1);
								notice = 1;
								break;
							}
						}
						if(notice != 1) {
							cost = cost + pro.getPrice();
							cart.setPro(pro);
							cart.setQuantity(1);
							lsCart.add(cart);
						}
					}
//					if(notice != 1) {
//						cart.setPro(pro);
//						cart.setQuantity(1);
//						lsCart.add(cart);
//					}
//					cost = cost + pro.getPrice();
//					cart.setPro(pro);
//					cart.setQuantity(1);
//					lsCart.add(cart);
				}
				System.out.println("\n");
				System.out.println("size:" +lsCart.size());
				System.out.println("size:" +lsCart.toString());
				HttpSession s = request.getSession();
				s.setAttribute("lsCart",lsCart);
				//request.setAttribute("lsCart", lsCart);
				request.setAttribute("cost", cost);
				request.setAttribute("code", code);
				request.getRequestDispatcher("/HOME/cart.jsp").forward(request, response);
				//request.getRequestDispatcher("/ShopServlet").forward(request, response);
				
				break;
				
			case "DelCart":
				int id = Integer.parseInt(request.getParameter("name"));
				for(Cart item : lsCart) {
					int itemId = item.getPro().getIdproduct();
					if(id == itemId) {
						cost = cost - (item.getPro().getPrice() * item.getQuantity());
						int id1 = lsCart.indexOf(item);
						lsCart.remove(id1);
						break;
					}
				}
				request.setAttribute("lsCart", lsCart);
				request.setAttribute("cost", cost);
				request.getRequestDispatcher("/HOME/cart.jsp").forward(request, response);
				break;
			
			
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}