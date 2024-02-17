package utils;

import java.util.List;
import java.util.Map;

public class ListTypeBuildingUtils {
	public static boolean isTypeOfBuilding(List<String> value, String type) {
		if (value.contains(type)) {
			return true;
		}
		return false;
	}
	
	public static Map<String, String> typeDefaultMap(Map<String, String> typeDefaultMap) {
		typeDefaultMap.put("tang_tret", "tầng trệt");
		typeDefaultMap.put("noi_that", "nội thất");
		typeDefaultMap.put("nguyen_can", "nguyên căn");
		return typeDefaultMap;
	}
}
