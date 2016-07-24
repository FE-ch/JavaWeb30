package introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

import beanutils.Person;

public class Demo1 {

	@Test
	public void test1() throws Exception {
		// Object.class是 stop class, 去掉了从Object继承的class属性
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
	}
	
	@Test
	public void test2() throws Exception {
	
		Person person = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		Method method = pd.getWriteMethod();
		method.invoke(person, 23);
		method = pd.getReadMethod();
		System.out.println(method.invoke(person, null));
	}
}
