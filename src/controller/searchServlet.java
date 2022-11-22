package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDao;
import entities.Product;
import entities.productDetail;


@WebServlet(urlPatterns = {"/searchServlet", "/HOME/searchServlet"})
public class searchServlet extends HttpServlet {
	
     
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtSearch = request.getParameter("txt"); 
		ProductDao dao = new ProductDao();
		
		
		//Handle logic pagination
        int count = dao.CountProduct();
        int endPage = count/9;
        if(count % 9 != 0 ) {endPage++ ;}
        String index = request.getParameter("index");
        if(index == null) {index = "0";}
        int indexPage = Integer.parseInt(index);
        String activePagination = "active";
		
		
		String queryallproducts = ProductDao.FIND_ALL_PRODUCT;
	    String querycolor = ProductDao.FIND_PRODUCTDETAIL_GROUPBY_COLOR;
	    String queryprice = ProductDao.FIND_PRODUCT_GROUPBY_PRICE;
	    String querycategory = ProductDao.FIND_PRODUCT_GROUPBY_CATEGORY;
		
		
		List<Product> list = dao.getProductBySearch(txtSearch);
		
		List<Product> productList = dao.getAllProduct(queryallproducts);
        List<Product> productListbyprice = dao.getAllProduct(queryprice);
        List<Product> productListbycategory = dao.getAllProduct(querycategory);
        List<productDetail> productDetails = dao.getAllProductDetail(querycolor);
        
        
        request.setAttribute("index", index);
        request.setAttribute("activePagination", activePagination);
        request.setAttribute("endPage", endPage);
        
        request.setAttribute("productList", productList);
        request.setAttribute("productListbyprice", productListbyprice);
        request.setAttribute("productListbycategory", productListbycategory);
        request.setAttribute("productDetails", productDetails);
		
		request.setAttribute("productList", list);
		
		request.getRequestDispatcher("/HOME/shop.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
