package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDao;

import entities.Product;


@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	
	
	private ProductDao productDao ;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			productDao = new ProductDao();
		}catch (Exception e) {
			throw new ServletException(e);	
			
		}
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        System.out.println("sgsgdfg");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/shop.jsp";
        List<String>  DistinctColorList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        
        DistinctColorList = productDao.getDistinctColor();
        productList = productDao.getAllProduct();
        
        request.setAttribute("DistinctColorList", DistinctColorList);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher  = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
    }
}
