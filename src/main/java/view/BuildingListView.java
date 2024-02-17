package view;

import java.util.List;

import controller.BuildingController;
import input.BuildingSearchInput;
import output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		String name = null;
		String street = null;
		String district = null;
		String ward = null;
		Integer floorarea = null;
		BuildingSearchInput buildingSearch = new BuildingSearchInput();
		buildingSearch.setFloorArea(floorarea);
		buildingSearch.setName(name);
		buildingSearch.setStreet(street);
		buildingSearch.setDistrict(district);
		buildingSearch.setWard(ward);
		
		BuildingController buildingController = new BuildingController();
		List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearch);
		int i = 1;
		System.out.println("Danh sách các tòa nhà bao gồm: ");
		for (BuildingOutput item: buildings) {
			System.out.println(i+": Tên tòa nhà: "+item.getName()+", địa chỉ: "+item.getAddress()+", loại tòa nhà: "+item.getTypeOutput());
			i++;
		}
//		for (BuildingModel item: buildings) {
//			
//		}
	}
	
}
