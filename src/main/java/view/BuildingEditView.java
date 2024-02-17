package view;

import controller.BuildingController;
import dto.BuildingDTO;

public class BuildingEditView {
	
	public static void main(String[] args) {
		BuildingController buildingController = new BuildingController();
		BuildingDTO newBuilding = new BuildingDTO();
		buildingController.insert(newBuilding);
	}
}
