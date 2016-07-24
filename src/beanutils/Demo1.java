package beanutils;

import org.junit.Test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Demo1 {

	@Test
	public void test1() throws Exception {
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "Shawn");
		
		System.out.println(p.getName());
	}
	
	@Test
	public void test2() throws Exception {
		
		// �û�������ֵ
		String name = "Tom";
		String password = "12345";
		String age = "23";	// ע��˴�beanutils�Զ�ת����age����
		String birthday = "1991-22-11";	// �����Ѿ������Զ�ת����������[yyyy-MM-dd]�����������ڲ��ܼ������ַ�������дʧ�ܣ�
	
		// ע��ʱ��ת����
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) {
				// TODO Auto-generated method stub
				if (value == null) {
					return null;
				}
				if (!(value instanceof String)) {
					throw new ConversionException("Only type String can be converted.");
				}
				
				String str = (String) value;
				if (str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return dateFormat.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
				
			}
			
		}, Date.class);
		
		// ��װ���ݵ�javabean
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println("Name: " + p.getName());
		System.out.println("Password: " + p.getPassword());
		System.out.println("Age: " + p.getAge());
		System.out.println("Birthday: " + p.getBirthday());
	}
	
	
}
 