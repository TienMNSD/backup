package service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BuildingDao;
import dao.anhyeuem.BuildingAnhYeuEm;
import dao.impl.BuildingDaoImpl;
import input.BuildingSearchInput;
import output.BuildingOutput;
import service.BuildingService;
import utils.ListTypeBuildingUtils;

public class BuildingServiceImpl implements BuildingService {
	
	private BuildingDao buildingDao = new BuildingDaoImpl();

	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel) {
		List<BuildingOutput> buildingOutputs = new ArrayList<>();
		List<BuildingAnhYeuEm> anhyeuems = buildingDao.findBuilding(buildingModel.getFloorArea(), buildingModel.getName(), buildingModel.getStreet(), 
									buildingModel.getWard(), buildingModel.getDistrict(), buildingModel.getType());
//		int i = 0;
		
		for (BuildingAnhYeuEm item: anhyeuems) {
			BuildingOutput buildingOutput = new BuildingOutput();
			buildingOutput.setName(item.getName());
			buildingOutput.setAddress(item.getStreet()+ " "+ item.getWard()+" "+ item.getDistrict());
			buildingOutput.setTypeOutput(item.getType());
			
			StringBuilder typeOutputString = new StringBuilder("");
			List<String> typeList = new ArrayList<String>(Arrays.asList(item.getType().split(",")));
			Map<String, String> typeDefaultMap = new HashMap<>();
			ListTypeBuildingUtils.typeDefaultMap(typeDefaultMap);
			for (Map.Entry<String, String> entry : typeDefaultMap.entrySet()) {
				if(ListTypeBuildingUtils.isTypeOfBuilding(typeList, entry.getKey())) {
					if (typeOutputString.toString().equals("")) {
						typeOutputString.append(entry.getValue());
					} else{
						typeOutputString.append(", "+entry.getValue());
					}
				}
			}
			
/*			if(ListTypeBuildingUtils.isTypeOfBuilding(typeList, "tang_tret")) {
				if (typeString.toString().equals("")) {
					typeString.append("Tầng trệt");
				} else{
					typeString.append(", tầng trệt");
				}
			}
			
			if(ListTypeBuildingUtils.isTypeOfBuilding(typeList, "nguyen_can")) {
				if (typeString.toString().equals("")) {
					typeString.append("Nguyên căn");
				} else{
					typeString.append(", nguyên căn");
				}
			}
			
			if(ListTypeBuildingUtils.isTypeOfBuilding(typeList, "noi_that")) {
				if (typeString.toString().equals("")) {
					typeString.append("Nội thất");
				} else{
					typeString.append(", nội thất");
				}
			}
*/
			buildingOutput.setTypeOutput(typeOutputString.toString());
//			buildingEmyeuanhs[i] = buildingEmyeuanh;
//			i++;
			buildingOutputs.add(buildingOutput);
		}
		
		return buildingOutputs;
	}

}
