package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.dialect.function.VarArgsSQLFunction;

import entities.Product;
import entities.productDetail;


public class ProductDao {
        private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
        private static final String DB_URL = "jdbc:mysql://localhost:3306/shopkeyboard";
        private static final String ID = "root";
        private static final String PASS = "nhat2382002";

        private static final String DELETE = "DELETE FROM user WHERE id=?";
        private static final String FIND_BY_ID = "SELECT * FROM user WHERE id=?";
        private static final String FIND_BY_NAME = "SELECT * FROM user WHERE name=?";
        private static final String INSERT = "INSERT INTO user(name, tel, passwd) VALUES(?, ?, ?)";
        private static final String UPDATE = "UPDATE user SET name=?, tel=?, passwd=? WHERE id=?";
        
        
        public static final String FIND_ALL_RANK = "SELECT DISTINCT productrank FROM product ORDER BY productrank";
        private static final String FIND_BY_PRODUCT_IDCOLOR = "SELECT * FROM product ,image_product where product.idproduct = image_product.idproduct AND image_product.color='?'";
        
        //ShopServlet 
        public static final String FIND_ALL_PRODUCT = "SELECT * FROM product ORDER BY idproduct DESC;";
        public static final String FIND_PRODUCTDETAIL_GROUPBY_COLOR = "SELECT * FROM image_product group by color ORDER BY idimage;";
        public static final String FIND_PRODUCT_GROUPBY_PRICE = "SELECT * FROM product group by price ORDER BY price asc;";
        public static final String FIND_PRODUCT_GROUPBY_CATEGORY = "SELECT * FROM product group by category ORDER BY idproduct asc;";
        
        //ShopServletByCategory
        public static final String FIND_BY_PRODUCT_BY_CATEGORY = "SELECT * FROM product WHERE category IN (SELECT category FROM product  WHERE idproduct = ? );";
        public static final String FIND_BY_PRODUCT_BY_PRICE = "SELECT * FROM product WHERE price IN (SELECT price FROM product  WHERE idproduct = ? );";
        public static final String FIND_BY_PRODUCT_BY_COLOR = "SELECT * FROM product WHERE idproduct IN (SELECT distinct idproduct FROM image_product  WHERE color in (SELECT distinct color FROM image_product  WHERE idimage = ?));";
        
        //ShopServletByOffset
        public static final String FIND_BY_PRODUCT_BY_LIMIT = "SELECT * FROM product ORDER BY idproduct LIMIT ? ";
        
    private Connection getConnection() {
	    try {
	        Class.forName(DRIVER_NAME);
	        return DriverManager.getConnection(DB_URL, ID, PASS);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
    } 
    
    //ShopServlet
    public List<Product> getAllProduct(String query){
          Connection conn = null;
          PreparedStatement stmt = null;
          List<Product> list = new ArrayList<Product>();
          try {
              conn = getConnection();
              System.out.print("Connnect to database successfully");
              stmt = conn.prepareStatement(query);
              ResultSet rs = stmt.executeQuery();

              while (rs.next()) {
            	  Product product= new Product();
	              product.setIdproduct(rs.getInt("idproduct"));
	              product.setNameproduct(rs.getString("nameproduct"));
	              product.setPrice(rs.getLong("price"));
	              product.setCategory(rs.getString("category"));
	              product.setImage(rs.getString("image"));
	              list.add(product);
              }
          } catch (SQLException e) {
              // e.printStackTrace();
              throw new RuntimeException(e);
          } finally {
              close(stmt);
              close(conn);
          }
          list.forEach(a -> { System.out.print(a); });
          return list;
      }
    public List<productDetail> getAllProductDetail(String query){
    	/*String query = FIND_PRODUCTDETAIL_GROUPBY_COLOR;*/
    	 Connection conn = null;
         PreparedStatement stmt = null;
         List<productDetail> list = new ArrayList<productDetail>();

         try {
             conn = getConnection();
             System.out.print("Connnect to database successfully");
             stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery();

             while (rs.next()) {
            	 productDetail productdetail= new productDetail();
            	 productdetail.setIdimage(rs.getInt("idimage"));
	             productdetail.setIdproduct(rs.getInt("idproduct"));
	             productdetail.setColor(rs.getString("color"));
	             productdetail.setSoluong(rs.getInt("soluong"));
	             productdetail.setImage(rs.getString("image"));
	             list.add(productdetail);
             }
         } catch (SQLException e) {
             // e.printStackTrace();
             throw new RuntimeException(e);
         } finally {
             close(stmt);
             close(conn);
         }
         return list;
     
    }
    
    //ShopServletByColor
    public List<Product> getAllProductByID(String query,String id){
        Connection conn = null;
        PreparedStatement stmt = null;
        List<Product> list = new ArrayList<Product>();
        try {
            conn = getConnection();
            System.out.print("Connnect to database successfully");
            stmt = conn.prepareStatement(query);
                       	
            stmt.setString(1, id);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
          	  Product product= new Product();
	              product.setIdproduct(rs.getInt("idproduct"));
	              product.setNameproduct(rs.getString("nameproduct"));
	              product.setPrice(rs.getLong("price"));
	              product.setCategory(rs.getString("category"));
	              product.setImage(rs.getString("image"));
	              list.add(product);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(conn);
        }
        list.forEach(a -> { System.out.print(a); });
        return list;
    }
    
    public List<Product> getAllProductByIDINT(String query,int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        List<Product> list = new ArrayList<Product>();
        try {
            conn = getConnection();
            System.out.print("Connnect to database successfully");
            stmt = conn.prepareStatement(query);
                       	
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
          	  Product product= new Product();
	              product.setIdproduct(rs.getInt("idproduct"));
	              product.setNameproduct(rs.getString("nameproduct"));
	              product.setPrice(rs.getLong("price"));
	              product.setCategory(rs.getString("category"));
	              product.setImage(rs.getString("image"));
	              list.add(product);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(conn);
        }
        list.forEach(a -> { System.out.print(a); });
        return list;
    }
    private static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
    private static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
