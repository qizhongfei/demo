package maps;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public  class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
		lhm.put("1", "1");
		lhm.put("2", "2");
		
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("1", "1");
		treeMap.put("2", "2");
		
	}

}
