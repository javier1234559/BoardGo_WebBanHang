package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Product;



public  class Generic<T> {
	
    
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/shopkeyboard";
    private static final String ID = "root";
    private static final String PASS = "nhat2382002";

    private static final String DELETE = "DELETE FROM user WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM user WHERE name=?";
    private static final String INSERT = "INSERT INTO user(name, tel, passwd) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE user SET name=?, tel=?, passwd=? WHERE id=?";
    
    public static final String FIND_ALL = "SELECT * FROM product ORDER BY idproduct";
    public static final String FIND_ALL_COLOR = "SELECT DISTINCT color FROM image_poduct ORDER BY idimage";
    public static final String FIND_ALL_RANK = "SELECT DISTINCT productrank FROM product ORDER BY productrank";
    public static final String FIND_ALL_PRICE = "SELECT DISTINCT price FROM product ORDER BY price;";
    public static final String FIND_ALL_CATEGORY = "SELECT DISTINCT category FROM product";
    private static final String FIND_BY_PRODUCT_ID = "SELECT * FROM product WHERE id=?";
    private static final String FIND_BY_PRODUCT_IDCOLOR = "SELECT * FROM product ,image_poduct where product.idproduct = image_poduct.idproduct AND image_poduct.color='?'";
    
    
    public List<T> list ; // dung de chua du lieu
    
    public Generic() {
    }
    
	private Connection getConnection() {
	    try {
	        Class.forName(DRIVER_NAME);
	        return DriverManager.getConnection(DB_URL, ID, PASS);
	    } catch (Exception e) {
	        // e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}
	
    public  List<T> addList(T item){
        list.add(item);
        
        return list ;
    }
    
    public void loopfixbug(){
    	for(T item : list) {
        	System.out.println(item);
        }
    }
    
    public List<T> getAllProduct(){
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      List<Product> list = new ArrayList<Product>();
		
	      try {
	          conn = getConnection();
	          System.out.print("Connnect to database successfully");
	          stmt = conn.prepareStatement(FIND_ALL);
	          ResultSet rs = stmt.executeQuery();
	
	          while (rs.next()) {
	              Product product= new Product();
	              product.setIdproduct(rs.getInt("idproduct"));
	              product.setNameproduct(rs.getString("idproduct"));
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
	      
	      return (List<T>) list;
	  }
	public List<T> getAllProductByID(String id){
		  Connection conn = null;
	      PreparedStatement stmt = null;
	      List<Product> list = new ArrayList<Product>();
		
	      try {
	    	  conn = getConnection();
	          System.out.print("Connnect to database successfully");
	          stmt = conn.prepareStatement(FIND_BY_PRODUCT_IDCOLOR);
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
	      
	      return (List<T>) list;
	  }
	public List<T> getDistinctString(String query , String column){
		
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    List<String> list = new ArrayList<String>();
	    try {
	        conn = getConnection();
	        System.out.print("Connnect to database successfully");
	        stmt = conn.prepareStatement(query);
	        ResultSet rs = stmt.executeQuery();
	
	        while (rs.next()) {
	        	String name = rs.getString(column);
	            System.out.print(name);
	            list.add(name);
	        }
	        
	    } catch (SQLException e) {
	
	        throw new RuntimeException(e);
	    } finally {
	        close(stmt);
	        close(conn);
	    }
	    
	    return (List<T>) list;
	   
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
