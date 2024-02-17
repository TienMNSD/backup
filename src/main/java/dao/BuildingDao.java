package dao;

import java.util.List;

import dao.anhyeuem.BuildingAnhYeuEm;

public interface BuildingDao {
	List<BuildingAnhYeuEm> findBuilding(Integer floorarea, String name, String street, String ward, String district, String type);
}
