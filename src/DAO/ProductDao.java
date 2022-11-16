package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entities.Product;

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
        
        private static final String FIND_ALL = "SELECT * FROM product ORDER BY id";
        private static final String FIND_ALL_COLOR = "SELECT DISTINCT color FROM product2 ORDER BY id";
        private static final String FIND_ALL_RANK = "SELECT DISTINCT productrank FROM product2 ORDER BY productrank";
        private static final String FIND_ALL_PRICE = "SELECT DISTINCT price FROM product2 ORDER BY price;";
        
        
    private Connection getConnection() {
	    try {
	        Class.forName(DRIVER_NAME);
	        return DriverManager.getConnection(DB_URL, ID, PASS);
	    } catch (Exception e) {
	        // e.printStackTrace();
	        throw new RuntimeException(e);
	    }
    }
    
    public List<Product> getAllProduct(){

          Connection conn = null;
          PreparedStatement stmt = null;
          List<Product> list = new ArrayList<Product>();

          try {
              conn = getConnection();
              System.out.print("Connnect to database successfully");
              stmt = conn.prepareStatement(FIND_ALL);
              ResultSet rs = stmt.executeQuery();

              while (rs.next()) {
                  Product user= new Product();
                  user.setId(rs.getInt("id"));
                  user.setTitle(rs.getString("title"));
                  user.setPrice(rs.getInt("price"));
                  user.setColor(rs.getString("color"));
                  user.setCategory(rs.getString("category"));
                  user.setProductrank(rs.getInt("productrank"));
                  user.setFavorite(rs.getInt("favorite"));
                  user.setDescription(rs.getString("productdesciption"));
                  user.setImage(rs.getString("image"));
                  System.out.print(user.getId());
                  list.add(user);
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
    public List<String> getDistinctColor(){
        Connection conn = null;
        PreparedStatement stmt = null;
        List<String> list = new ArrayList<>();
        try {
            conn = getConnection();
            System.out.print("Connnect to database successfully");
            stmt = conn.prepareStatement(FIND_ALL_COLOR);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	String color = rs.getString("color");
                System.out.print(color);
                list.add(color);
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
