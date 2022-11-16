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

import DAO.Generic;
import DAO.ProductDao;

import entities.Product;



@WebServlet(urlPatterns = {"/ShopServlet", "/HOME/ShopServlet"})
public class ShopServlet extends HttpServlet {
	
	
	/*private ProductDao productDao ;*/
	private Generic<Product> productDao;
	private Generic<String> colorDao;
	private Generic<String> priceDao;
	private Generic<String> categoryDao;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
		/*	productDao = new ProductDao();*/
			productDao = new Generic<Product>();
			colorDao = new Generic<String>();
			priceDao = new Generic<String>();
			categoryDao = new Generic<String>();
			
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

        String url = "/HOME/shop.jsp";
       
        
        String querycolor = colorDao.FIND_ALL_COLOR;
        String queryprice = priceDao.FIND_ALL_PRICE;
        String querycategory = categoryDao.FIND_ALL_CATEGORY;
        
        //Get datafrom database
        List<String>  DistinctColorList = colorDao.getDistinctString(querycolor, "color");
        List<String>  DistinctPriceList = priceDao.getDistinctString(queryprice, "price");
        List<String>  DistinctCategoryList = categoryDao.getDistinctString(querycategory, "category");
        List<Product> productList = productDao.getAllProduct();
        
        request.setAttribute("DistinctColorList", DistinctColorList);
        request.setAttribute("DistinctPriceList", DistinctPriceList);
        request.setAttribute("DistinctCategoryList", DistinctCategoryList);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher  = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
    }
}
