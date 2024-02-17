package JavaCoreMain;

import java.util.HashMap;
import java.util.Map;

public class JavaCoreMain {
	public static void main(String[] args) {
/*		List<Integer> list = new ArrayList();
//		list.add("anh yêu em");
		list.add(1235);
		list.add(1235);
//		list.add(true);

		Integer abc = list.get(0);*/
		Map <String, String> map = new HashMap<>();
		map.put("123456789", "nguyễn văn a");
		map.put("123456781", "nguyễn văn a");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key "+ entry.getKey()+ " Value: "+ entry.getValue());
		}
	}

}
