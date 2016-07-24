package generic;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class Demo1 {
	
	@Test
	public void test1() {
		
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		
		
		// ��ͳ������
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Entry<Integer, String>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("Key: " + key + ", Value: " + value);
		}
		
		// ��ǿfor�������ã�
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key + ", Value: " + value);
		}
	}


}
