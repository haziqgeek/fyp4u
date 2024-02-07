package fyp4u.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fyp4u.connection.ConnectionManager;
import fyp4u.model.User;

public class UserDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static int userid;
	static String email, password, role;
	
	static StringBuffer sb;
    static String query;
    
  //method for login
    public static User login(User bean) throws NoSuchAlgorithmException {
    	
    	//get email and password
        email = bean.getEmail();
        password = bean.getPassword();
        
        //convert the password to MD5 (encryption)
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        
        byte[] byteData = md.digest();
        
        //convert the byte to hex format
        sb = new StringBuffer();
        for(int i = 0; i < byteData.length; ++i) {
            sb.append(Integer.toString((byteData[i] & 255) + 256, 16).substring(1));
        }


        try {
        	//call getConnection() method
            con = ConnectionManager.getConnection();
            
            //3. create statement
            query = "select * from user where email='" + email + "'AND password='" + sb.toString() + "'";             
            stmt = con.createStatement();
            
            //4.execute query
            rs = stmt.executeQuery(query);
            boolean more = rs.next();
            
            //if user exists set the isValid variable to true  
            if (more) {
                bean.setUserid(rs.getInt("userid"));
                bean.setEmail(rs.getString("email"));
                bean.setRole(rs.getString("role"));
                
                System.out.println(role);
                bean.setValid(true);
            }
            // if user does not exist set the isValid variable to false
            else if (!more) {
                bean.setValid(false);
            }

            con.close();
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return bean;
    }
    

    public void add(User bean) throws NoSuchAlgorithmException {
        email = bean.getEmail();
        password = bean.getPassword();
        role = bean.getRole();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] byteData = md.digest();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < byteData.length; ++i) {
            sb.append(Integer.toString((byteData[i] & 255) + 256, 16).substring(1));
        }

        String pass = sb.toString();

        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("insert into user(email,password,role)values(?,?,?)");
            ps.setString(1, email);
            ps.setString(2, pass);
            ps.setString(3, role);
            ps.executeUpdate();
            con.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

  //method to get user
    public static User getUser(User bean) {
    	//get email
        UserDAO.email = bean.getEmail();
        String searchQuery = "select * from user where email='" + UserDAO.email + "'";

        try {
        	//call getConnection method
            con = ConnectionManager.getConnection();
            //3.Create Statement
            stmt = con.createStatement();
            //4. Execute Statement
            rs = stmt.executeQuery(searchQuery);
            
            boolean more = rs.next();
            
            //if user exist set invalid to true
            if (more) {
                String email = rs.getString("email");
                bean.setEmail(email);
                bean.setValid(true);
            } 
            //if user does not exist set the invalid variable to false
            else if (!more) {
                bean.setValid(false);
            }

            //5. close connection
            con.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return bean;
    }

    //get user by email
    public static User getUserByEmail(String email) {
        User us = new User();

        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("select * from user where email=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setUserid(rs.getInt("userid"));
                us.setEmail(rs.getString("email"));
                us.setPassword(rs.getString("password"));
                us.setRole(rs.getString("role"));
            }

            con.close();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return us;
    }

  //method to get user by id
    public static User getUserById(int userid) {
        User us = new User();

        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("select email, password, role from user where userid=?");
            ps.setInt(1, userid);
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setEmail(rs.getString("email"));
                us.setPassword(rs.getString("password"));
                us.setRole(rs.getString("role"));
            }

            con.close();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return us;
    }

  //method to get user id
    public static List<User> getUserId() {
        ArrayList users = new ArrayList();

        try {
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id, email from user");

            while(rs.next()) {
                User us = new User();
                us.setUserid(rs.getInt("id"));
                us.setEmail(rs.getString("email"));
                users.add(us);
            }

            con.close();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return users;
    }
    /*
  //method to get user supplier
    public static List<User> getUserSupplier() {
        ArrayList users = new ArrayList();

        try {
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user u INNER JOIN supplier s ON u.id = s.id");

            while(rs.next()) {
                User us = new User();
                us.setUserid(rs.getInt("id"));
                us.setEmail(rs.getString("email"));
                us.setSupplier(SupplierDAO.getSupplierId(rs.getInt("id")));
                users.add(us);
            }

            con.close();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return users;
    }*/
    
    //method to delete user
    public void deleteUser(int userid) {
        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("delete from user where userid=?");
            ps.setInt(1, userid);
            ps.executeUpdate();
            con.close();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}
