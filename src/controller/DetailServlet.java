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


@WebServlet(urlPatterns = {"/DetailServlet", "/HOME/DetailServlet"})
public class DetailServlet extends HttpServlet {
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

        String url = "/HOME/detail.jsp";
        
        String id = request.getParameter("cid");
		
		//query
        String queryproductbyID = productDao.FIND_PRODUCT_BY_ID;
        String queryproductdetailbyID = productDao.FIND_PRODUCT_DETAIL_BY_IDPRODUCT;
        String queryallproductsByCategory = productDao.FIND_BY_PRODUCT_BY_CATEGORY;
        //Get datafrom database
   
        Product DetailProduct = productDao.getProductByID(queryproductbyID, id);
        List<productDetail> productDetails = productDao.ProductDetailByProductID(queryproductdetailbyID,id);
        List<Product> productListByCategory = productDao.getAllProductByID(queryallproductsByCategory,id);
        
        
        request.setAttribute("DetailProduct", DetailProduct);
        request.setAttribute("productDetails", productDetails);
        request.setAttribute("productListByCategory", productListByCategory);
        
        RequestDispatcher dispatcher  = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
    }

}
