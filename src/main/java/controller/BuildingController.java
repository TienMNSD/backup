package controller;

import java.util.List;

import dto.BuildingDTO;
import input.BuildingSearchInput;
import output.BuildingOutput;
import service.BuildingService;
import service.impl.BuildingServiceImpl;

public class BuildingController {
	
	private BuildingService buildingService = new BuildingServiceImpl();
	
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearch) {
		List<BuildingOutput> results = buildingService.findBuilding(buildingSearch);
		return results;
	}
	
	public BuildingDTO insert(BuildingDTO newBuilding) {
		return null;
	}
}
