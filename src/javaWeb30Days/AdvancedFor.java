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

//	1、操作数组
	@Test
	public void test1() {
		int[] arr = {1, 2, 3};
		for (int num : arr) {
			System.out.println(num);
		}
		
	}
	
//	2、操作集合
	@Test
	public void test2() {
		List list = new ArrayList();
		/*装箱*/
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
		// 此处用的HashMap是无序的，如果要使用有序的，换成LinkedHashMap
		// 例子：购物车
		Map map = new HashMap();
		map.put("1", "abc");
		map.put("2", "bbc");
		map.put("3", "acc");
		
		
		System.out.println("-------------map.keySet------------");
		/*传统方式1*/
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String value = (String) map.get(key);
			
			System.out.println("key = " + key + ", value = " + value);
		}
		
		System.out.println("-------------map.entrySet------------");
		
		/*传统方式2*/
		Set set3 = map.entrySet();
		
		Iterator it2 = set3.iterator();
		while(it2.hasNext()) {
			Map.Entry entry = (Entry) it2.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println("key = " + key + ", value = " + value);
		}
		
		System.out.println("-------------Advanced For------------");
		
		/*增强for循环*/
		for (Object k : map.keySet()) {
			String key = (String) k;
			String value = (String) map.get(k);
			System.out.println("key = " + key + ", value = " + value);
		}
	}

}
