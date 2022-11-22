package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDao;
import entities.Product;
import entities.productDetail;

@WebServlet(urlPatterns = {"/HomeServlet", "/HOME/HomeServlet"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
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
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String url = "/HOME/index.jsp";
        
    	String querytop3products = productDao.TOP_3_PRODUCT;
        String querytop12products = productDao.TOP_12_PRODUCT;
        String querycategory = productDao.FIND_PRODUCT_GROUPBY_CATEGORY;
       
       
        //Get data from database
        
        List<Product> top3product = productDao.getAllProduct(querytop3products);
        List<Product> top12product = productDao.getAllProduct(querytop12products);
        List<Product> productListbycategory = productDao.getAllProduct(querycategory);
        
        request.setAttribute("top3product", top3product);
        request.setAttribute("top12product", top12product);
        request.setAttribute("productListbycategory", productListbycategory);
        RequestDispatcher dispatcher  = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
