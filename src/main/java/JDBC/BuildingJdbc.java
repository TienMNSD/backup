package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import constant.SystemConstant;
import utils.ConnectionUtils;

public class BuildingJdbc {
	 
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
		 
		 String name = null;
		 String street = null;
		 String district = null;
		 String ward = null;
		 Integer floorarea = null;
//		 Integer numberOfBasement = null;
		 	
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
/*		 Scanner input = new Scanner(System.in);

		    System.out.print("Nhập tên tòa nhà cần tìm kiếm: ");
		    name = input.nextLine();
		    System.out.print("Nhập diện tích tòa nhà cần tìm kiếm: ");
		    floorarea = input.nextInt();*/
		    
		 try {
			StringBuilder query = new StringBuilder("SELECT * FROM building "+SystemConstant.OneEqualOne);
			
			if (!StringUtils.isNullOrEmpty(name)) {
				query.append(" and name like '%"+ name + "%'");
			} if (!StringUtils.isNullOrEmpty(street)) {
				query.append(" and street like '%"+ street + "%'");
			} if (!StringUtils.isNullOrEmpty(district)) {
				query.append(" and district like '%"+ district + "%'");
			} if (!StringUtils.isNullOrEmpty(ward)) {
				query.append(" and ward like '%"+ ward + "%'");
			} if (floorarea != null) {
				query.append(" and floorarea = "+ floorarea);
			} 
			/*if (numberOfBasement != null) {
				query.append(" and numberofbasement = "+ numberOfBasement);
			}*/
			System.out.println(query);
			Class.forName("com.mysql.jdbc.Driver");
			conn = ConnectionUtils.getConection();
			stmt = conn.createStatement();
	        rs = stmt.executeQuery(query.toString());
	        ResultSetMetaData rsmd = rs.getMetaData();
	        while (rs.next()) {
	        	rsmd.getColumnType(1);
	        	System.out.print("Id: " + rs.getLong("id")+ ", Type: "+rsmd.getColumnType(1));
	            System.out.print(", Name: " + rs.getString("name"));
	            System.out.print(", Street: " + rs.getString("street"));
	            System.out.print(", District: " + rs.getString("district"));
	            System.out.println(", Ward: " + rs.getString("ward"));
	            System.out.println(", FloorArea: " + rs.getInt("floorarea"));
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
