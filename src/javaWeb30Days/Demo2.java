package javaWeb30Days;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) {
		Integer integer = 1;	//装箱
		int j = integer;		//拆箱
		
		/*应用*/
		List list = new ArrayList();
		/*装箱*/
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(new Integer(4));	//原始方法
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			int k = (Integer) iterator.next();
			/*拆箱*/
			System.out.println(k);
		}
	}
}
