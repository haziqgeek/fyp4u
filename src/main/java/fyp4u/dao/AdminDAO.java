package fyp4u.dao;

import java.io.IOException;
import javax.servlet.*;
import java.sql.*;
import java.util.*;
import fyp4u.connection.ConnectionManager;
import fyp4u.model.Admin;
import fyp4u.model.Student;

public class AdminDAO {

	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	int adminid, userid;
	String adminusername,adminpassword,adminphonenumber,adminemail;

	//add admin
		public void add(Admin bean){		
			adminusername = bean.getAdminUsername();
			adminphonenumber = bean.getAdminPhonenumber();

			try {
				//call getConnection() method //3. create statement //4. execute query
				con = ConnectionManager.getConnection();
				
				//3. create statement
				ps=con.prepareStatement("insert into admin(adminusername,adminphonenumber,adminemail)values(?,?,?,?)");
				ps.setString(1,adminusername);
				ps.setString(2,adminpassword);
				ps.setString(3,adminphonenumber);
				ps.setString(4,adminemail);
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		//get all admins
		public static List<Admin> getAllAdmin() { 
			
			List<Admin> admins = new ArrayList<Admin>(); 
			try { 
				//call getConnection() method
				con = ConnectionManager.getConnection();
				//3. create statement
				stmt = con.createStatement(); 
				//4. execute query
				rs = stmt.executeQuery("select * from admin");

				while (rs.next()) { 
					Admin admin = new Admin();
					admin.setAdminID(rs.getInt("adminid"));
					admin.setAdminUsername(rs.getString("adminusername"));	  
					admin.setAdminPhonenumber(rs.getString("adminphonenumber"));
					admins.add(admin);

				} 
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return admins; 
		}


		//get admin by Id
		public static Admin getAdminById(int adminid) {
			Admin admin = new Admin();
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				//3. create statement
				ps=con.prepareStatement("select * from admin where adminid=?");
				ps.setInt(1, adminid);
				//4. execute query
				rs = ps.executeQuery();

				if (rs.next()) {	            
					admin.setAdminID(rs.getInt("adminid"));
					admin.setAdminUsername(rs.getString("adminusername"));	  
					admin.setAdminPhonenumber(rs.getString("adminphonenumber"));
				}
				//5. close connection
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return admin;
		}

		//delete admin
		public void deleteAdmin(int adminid) {
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement 
				ps=con.prepareStatement("delete from admin where adminid=?");
				ps.setInt(1, adminid);
				//4. execute query
				ps.executeUpdate();
				//5. close connection
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		//update admin
		public void updateAdmin(Admin bean) {

			adminid = bean.getAdminID();
			adminusername = bean.getAdminUsername();
			adminphonenumber = bean.getAdminPhonenumber();
					
			String searchQuery = "UPDATE admin SET adminusername= '" + adminusername + "', adminpassword ='" + adminpassword + "', adminphonenumber='" + adminphonenumber + "', adminemail='" + adminemail + "' WHERE adminid= '" + adminid + "'";
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement 
				stmt = con.createStatement();
				//4. execute query
				stmt.executeUpdate(searchQuery);
				//5. close connection
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// get admin by userid
					public static Admin getAdminByUserId(int userid) {
						Admin admin = new Admin();

						try {
							// call getConnection() method from ConnectionManager class
							con = ConnectionManager.getConnection();

							// 3. create statement
							String sql = "SELECT * FROM admin WHERE userid=?";
							ps = con.prepareStatement(sql);
							ps.setInt(1, userid);

							// 4. execute query
							rs = ps.executeQuery();
							if (rs.next()) {
								admin.setAdminID(rs.getInt("adminid"));
								admin.setAdminUsername(rs.getString("adminusername"));
								admin.setAdminPhonenumber(rs.getString("adminphonenumber"));
								admin.setUserID(rs.getInt("userid"));
							}

							// 5. close connection
							con.close();

						} catch (Exception e) {
							e.printStackTrace();

						}

						return admin;
					}

		//get student and supervisor
		/*public static List<Product> getSupplierProducts() { 
			List<Product> prods = new ArrayList<Product>(); 
			try { 
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement 
				stmt = con.createStatement(); 
				//4. execute query
				rs = stmt.executeQuery("SELECT * FROM product p INNER JOIN supplier s ON p.sid = s.sid");

				while (rs.next()) { 
					Product prod = new Product();
					prod.setPid(rs.getInt("pid"));	  
					prod.setProductname(rs.getString("productname"));
					prod.setPrice(rs.getDouble("price"));
					prod.setQuantity(rs.getInt("quantity"));
					prod.setSid(rs.getInt("sid"));
					prod.setSupplier(SupplierDAO.getSupplierById(rs.getInt("sid")));
					prods.add(prod);

				} 
				//5. close connection
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			
			}

			return prods; 
		}*/
}
