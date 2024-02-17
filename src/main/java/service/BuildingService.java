package service;

import java.util.List;

import input.BuildingSearchInput;
import output.BuildingOutput;

public interface BuildingService {
	List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel);
}
