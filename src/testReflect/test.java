package testReflect;

import java.awt.List;
import java.io.File;

//import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.logging.LoggingMXBean;

import org.junit.Test;

/**
 * @author ����
 * @category ���䣺�����࣬�������ֽ���
 * ���ַ�ʽ��
 * 1��
 * Class clazz = Class.forName("full/path/of/Person");
 * 2��
 * Class clazz = new Person().getClass();
 * 3��
 * Class clazz = Person.class;
 */

public class test {

	//���乹�캯����public Person(String name, long user_ID, int age)
	@Test
	public void test() throws Exception {
//		Class clazz = Class.forName("/JavaWeb30_FangLixun/src/testReflect/Person");
		
		Class clazz = new Person().getClass();
		Constructor constructor = clazz.getConstructor(String.class, long.class, int.class);
		Person person = (Person) constructor.newInstance("Shawn", 213123131, 24);
		System.out.println(person.name);
//		fail("Not yet implemented");
	}
	
	@Test
	//���乹�캯����private Person(List list)
	public void test_privatePerson() throws Exception {
		Class clazz = Class.forName("testReflect.Person");
		Constructor constructor = clazz.getDeclaredConstructor(List.class);
		constructor.setAccessible(true);
		Person person = (Person) constructor.newInstance(new List());
		
//		System.out.println(person.name);
	}
	
	
	//����main������ public static void main(String[] args)
	@Test
	public void test1() throws Exception {
		Class clazz = Person.class;
		Method method = clazz.getMethod("main", String[].class);
//		method.invoke(null, new Object[]{new String[]{"aaa", "bbb"}});
		method.invoke(null, (Object) new String[]{"aaa", "bbb"});
		
		for (Parameter i : method.getParameters()) {
			System.out.println(i);
		}
	}
	
//	���䣺public void register()
	@Test
	public void testMethodRegister() throws Exception {
		Person person = new Person();
//		Class clazz = Person.class;
		Class clazz = Class.forName("testReflect.Person");
		Method method = clazz.getMethod("register", null);
		method.invoke(person, null);
		
	}
	
	// ���䣺 public Person[] community(Person[] community)
	@Test
	public void testMethodCommunity() throws Exception {
		Person person = new Person();
		Person p1 = new Person();
		Person p2 = new Person();
		Class clazz = Class.forName("testReflect.Person");
		Method method = clazz.getMethod("community", Person[].class);
		method.invoke(person, (Object) new Person[]{p1, p2});
	}
	
	//�����ֶΣ�
	@Test
	public void test2() throws Exception {
		Class clazz = Class.forName("testReflect.Person");
		Person person = new Person();
		
		// getField �õ�����public�����ֶ�
		Field field = clazz.getField("name");
		// getDeclaredField ���Ի��private�����ֶ�
		Field field2 = clazz.getDeclaredField("user_ID");

		Object name = field.get(person);
		Class type = field.getType();
		
		if (type.equals(String.class)) {
			String sname = (String) name;
			System.out.println(name);
			System.out.println("Name type = " + type);
		}
		
		//set
		field.set(person, "DICK");
		System.out.println(person.name);
		
		field2.setAccessible(true);
		System.out.println(field2.get(person));
	}

}
