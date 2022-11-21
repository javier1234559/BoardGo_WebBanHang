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
       
        String queryallproducts = productDao.FIND_ALL_PRODUCT;
        String querycolor = productDao.FIND_PRODUCTDETAIL_GROUPBY_COLOR;
        String queryprice = productDao.FIND_PRODUCT_GROUPBY_PRICE;
        String querycategory = productDao.FIND_PRODUCT_GROUPBY_CATEGORY;
        
        //Get datafrom database
   
        List<Product> productList = productDao.getAllProduct(queryallproducts);
        List<Product> productListbyprice = productDao.getAllProduct(queryprice);
        List<Product> productListbycategory = productDao.getAllProduct(querycategory);
        List<productDetail> productDetails = productDao.getAllProductDetail(querycolor);
        
        request.setAttribute("productList", productList);
        request.setAttribute("productListbyprice", productListbyprice);
        request.setAttribute("productListbycategory", productListbycategory);
        request.setAttribute("productDetails", productDetails);
        RequestDispatcher dispatcher  = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
    }
}