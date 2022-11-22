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


@WebServlet(urlPatterns = {"/ShopServletByCategory", "/HOME/ShopServletByCategory"})
public class ShopServletByCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ProductDao productDao ;
	
	@Override
	public void init() throws ServletException {
		try {
			productDao = new ProductDao();
		}catch (Exception e) {
			throw new ServletException(e);	
			
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/HOME/shop.jsp";
	    
		String categoryid = request.getParameter("cid");
		
		//Handle logic pagination
        int count = productDao.CountProduct();//9
        int endPage = count/9;
        if(count % 9 != 0 ) {endPage++ ;}
        String index = request.getParameter("index");
        if(index == null) {index = "0";}
        int indexPage = Integer.parseInt(index);
        String activePagination = "active";
		
        String queryallproducts = productDao.FIND_BY_PRODUCT_BY_CATEGORY;
        String querycolor = productDao.FIND_PRODUCTDETAIL_GROUPBY_COLOR;
        String queryprice = productDao.FIND_PRODUCT_GROUPBY_PRICE;
        String querycategory = productDao.FIND_PRODUCT_GROUPBY_CATEGORY;
        
        //Get datafrom database
        List<Product> productList = productDao.getAllProductByID(queryallproducts,categoryid);
        List<Product> productListbyprice = productDao.getAllProduct(queryprice);
        List<Product> productListbycategory = productDao.getAllProduct(querycategory);
        List<productDetail> productDetails = productDao.getAllProductDetail(querycolor);
        
        request.setAttribute("index", index);
        request.setAttribute("activePagination", activePagination);
        request.setAttribute("endPage", endPage);
        
        request.setAttribute("productList", productList);
        request.setAttribute("productListbyprice", productListbyprice);
        request.setAttribute("productListbycategory", productListbycategory);
        request.setAttribute("productDetails", productDetails);
        
        request.setAttribute("cid", categoryid);
        request.setAttribute("active","background-color: aliceblue");
        
        RequestDispatcher dispatcher  = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	


}
