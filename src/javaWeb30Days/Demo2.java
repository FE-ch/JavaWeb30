package javaWeb30Days;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) {
		Integer integer = 1;	//װ��
		int j = integer;		//����
		
		/*Ӧ��*/
		List list = new ArrayList();
		/*װ��*/
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(new Integer(4));	//ԭʼ����
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			int k = (Integer) iterator.next();
			/*����*/
			System.out.println(k);
		}
	}
}
