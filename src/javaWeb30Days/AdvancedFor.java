package javaWeb30Days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class AdvancedFor {

//	1����������
	@Test
	public void test1() {
		int[] arr = {1, 2, 3};
		for (int num : arr) {
			System.out.println(num);
		}
		
	}
	
//	2����������
	@Test
	public void test2() {
		List list = new ArrayList();
		/*װ��*/
		list.add(1);
		list.add(2);
		list.add(3);
		
		for (Object obj : list) {
			int i = (Integer) obj;
			System.out.println(i);
		}
	}
	
	@Test
	public void test3() {
		// �˴��õ�HashMap������ģ����Ҫʹ������ģ�����LinkedHashMap
		// ���ӣ����ﳵ
		Map map = new HashMap();
		map.put("1", "abc");
		map.put("2", "bbc");
		map.put("3", "acc");
		
		
		System.out.println("-------------map.keySet------------");
		/*��ͳ��ʽ1*/
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String value = (String) map.get(key);
			
			System.out.println("key = " + key + ", value = " + value);
		}
		
		System.out.println("-------------map.entrySet------------");
		
		/*��ͳ��ʽ2*/
		Set set3 = map.entrySet();
		
		Iterator it2 = set3.iterator();
		while(it2.hasNext()) {
			Map.Entry entry = (Entry) it2.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println("key = " + key + ", value = " + value);
		}
		
		System.out.println("-------------Advanced For------------");
		
		/*��ǿforѭ��*/
		for (Object k : map.keySet()) {
			String key = (String) k;
			String value = (String) map.get(k);
			System.out.println("key = " + key + ", value = " + value);
		}
	}

}
