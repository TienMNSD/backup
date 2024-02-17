package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import constant.SystemConstant;
import utils.ConnectionUtils;
import utils.StringUtils;

public class AccountJdbc {
	 
	 public static void main(String[] args) {

/*	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);) {
	         // Extract data from result set
		         while (rs.next()) {
		            // Retrieve by column name
		            System.out.print("Name: " + rs.getString("name"));
		            System.out.print(", Street: " + rs.getString("street"));
		            System.out.print(", District: " + rs.getString("district"));
		            System.out.println(", Ward: " + rs.getString("ward"));
		            System.out.println(", FloorArea: " + rs.getString("floorarea"));
		         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } */
		 
		 /*try {
			 Integer value1 = 0/10;		
			 System.out.println(value1);
			 Class.forName("com.mysql.jdbc.Driver");
			 Integer value2 = 10/0;		
			 System.out.println(value2);
			 System.out.println("I love you");
		} catch (ClassNotFoundException e) {
			System.out.println("Thiếu file JAR");
		} 
		 catch (Exception e) {
			System.out.println("Lỗi ngoại lệ");
		}*/
		 
		 /*String name = null;
		 String street = null;
		 String district = null;
		 String ward = null;
		 Integer floorarea = null;
		 Integer numberOfBasement = null;*/
		 
		 String userName = null;
		 	
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 try {
			StringBuilder query = new StringBuilder("SELECT * FROM account "+SystemConstant.OneEqualOne);
			userName = "quốc pháp t";

			if (!StringUtils.isNullOrEmpty(userName)) {
				query.append(" and username like '%"+ userName + "%'");
			}
			System.out.println(query);
			Class.forName("com.mysql.jdbc.Driver");
			conn = ConnectionUtils.getConection();
			stmt = conn.createStatement();
	        rs = stmt.executeQuery(query.toString());
//	        ResultSetMetaData rsmd = rs.getMetaData();
	        while (rs.next()) {
	        	System.out.println(rs);
	        	/*rsmd.getColumnType(1);
	        	System.out.print("Id: " + rs.getLong("id")+ ", Type: "+rsmd.getColumnType(1));
	            System.out.print(", Name: " + rs.getString("name"));
	            System.out.print(", Street: " + rs.getString("street"));
	            System.out.print(", District: " + rs.getString("district"));
	            System.out.println(", Ward: " + rs.getString("ward"));
	            System.out.println(", FloorArea: " + rs.getInt("floorarea"));*/
	         }
	      
		} catch (ClassNotFoundException	| SQLException e) {
			System.out.println("Error: "+e.getMessage());	
		} finally {
			try {
				if ( conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("Error: "+e.getMessage());
			}
	        
		}
		    
	   }
	 
}	
