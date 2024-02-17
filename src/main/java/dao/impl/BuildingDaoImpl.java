package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.util.StringUtils;

import constant.SystemConstant;
import dao.BuildingDao;
import dao.anhyeuem.BuildingAnhYeuEm;
import utils.ConnectionUtils;

public class BuildingDaoImpl implements BuildingDao{
	@Override
	public List<BuildingAnhYeuEm> findBuilding(Integer floorarea, String name, String ward, String street, String district, String type) {
//		BuildingAnhYeuEm[] results = new BuildingAnhYeuEm[3];
		List<BuildingAnhYeuEm> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
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
			System.out.println(query);
			Class.forName("com.mysql.jdbc.Driver");
			conn = ConnectionUtils.getConection();
			stmt = conn.createStatement();
	        rs = stmt.executeQuery(query.toString());
//	        int i = 0;
	        while (rs.next()) {
	        	BuildingAnhYeuEm buildingAnhYeuEm = new BuildingAnhYeuEm();
	        	buildingAnhYeuEm.setName(rs.getString("name"));
	        	buildingAnhYeuEm.setStreet(rs.getString("street"));
	        	buildingAnhYeuEm.setWard(rs.getString("ward"));
	        	buildingAnhYeuEm.setDistrict(rs.getString("district"));
	        	buildingAnhYeuEm.setFloorarea(rs.getInt("floorarea"));
	        	buildingAnhYeuEm.setType(rs.getString("type"));
//	        	results[i] = buildingAnhYeuEm;
//	        	i++;
	        	results.add(buildingAnhYeuEm);
	        }
	        return results;
	      
		} catch (ClassNotFoundException	| SQLException e) {
			System.out.println("Error: "+e.getMessage());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
		return new ArrayList<>();
	}
}
