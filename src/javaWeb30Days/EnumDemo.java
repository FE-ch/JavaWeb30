package javaWeb30Days;

import org.junit.Test;

/**
 * @author ����
 * ö�ٻ����������ԣ�
 * 1.ö���������java�࣬��������ÿһ��ö��ֵ������һ��ʵ������
 * 2.ö���໹����ʵ�ֽӿڣ���̳г�����
 * 3.switch�����Խ���ö��ֵ
 * 4.��ö����ֻ��һ��ö��ֵ������Ե�����̬���ģʽ
 * 
 * ��̬���ģʽ--����
��ͼ��		��֤һ�������һ��ʵ�������ṩһ����������ȫ�ַ��ʵ㡣
��Ҫ�����	һ��ȫ��ʹ�õ���Ƶ���ش��������١�
��ʱʹ�ã�	���������ʵ����Ŀ����ʡϵͳ��Դ��ʱ��
��ν����	�ж�ϵͳ�Ƿ��Ѿ������������������򷵻أ����û���򴴽���
�ؼ����룺	���캯����˽�еġ�
Ӧ��ʵ���� 	1��һ����ֻ����һ����ϯ�� 
			2��Windows �Ƕ���̶��̵߳ģ��ڲ���һ���ļ���ʱ�򣬾Ͳ��ɱ���س��ֶ�����̻��߳�ͬʱ����һ���ļ����������������ļ��Ĵ������ͨ��Ψһ��ʵ�������С� 
			3��һЩ�豸�������������Ϊ����ģʽ������һ����������̨��ӡ�����������ʱ���Ҫ��������̨��ӡ����ӡͬһ���ļ���
�ŵ㣺 		1�����ڴ���ֻ��һ��ʵ�����������ڴ�Ŀ�����������Ƶ���Ĵ���������ʵ�����������ѧԺ��ҳҳ�滺�棩�� 
			2���������Դ�Ķ���ռ�ã�����д�ļ���������
ȱ�㣺		û�нӿڣ����ܼ̳У��뵥һְ��ԭ���ͻ��һ����Ӧ��ֻ�����ڲ��߼�����������������ô����ʵ������
ʹ�ó����� 	1��Ҫ������Ψһ���кš� 
			2��WEB �еļ�����������ÿ��ˢ�¶������ݿ����һ�Σ��õ����Ȼ��������� 
			3��������һ��������Ҫ���ĵ���Դ���࣬���� I/O �����ݿ�����ӵȡ�
ע�����	getInstance() ��������Ҫʹ��ͬ���� synchronized (Singleton.class) ��ֹ���߳�ͬʱ������� instance �����ʵ������
 */



/**
 * Q: ʲôʱ����Ҫ��Stringת��ö��
 * A���û��ύ��ʱ���������ö�����У��Ͳ��Ϸ������Կ���ת����ö��ֵ������Ƿ񱨴���
 *
 */
public class EnumDemo {
	@Test
	public void test() {
		print(Grade.B);
	}

	public void print(Grade g) {
		String value = g.getGrade();
		System.out.println("Get grade between: " + value);
		String localValue = g.localGrade();
		System.out.println("Chinese class: " + localValue);
	}
}

enum Grade {
	A("100-90") {
		public String localGrade() {
			return "����";
		}
	}, 
	B("89-80") {
		public String localGrade() {
			return "����";
		}
	},
	C("79-70") {
		public String localGrade() {
			return "һ��";
		}
	}, 
	D("69-60") {
		public String localGrade() {
			return "��";
		}
	}, 
	E("59-0") {
		public String localGrade() {
			return "������";
		}
	};
	
	private String value;
	/*ö�ٵĹ��캯��������˽�е�*/
	private Grade(String value) {
		this.value = value;
	}
	
	public String getGrade() {
		return this.value;
	}
	
	public abstract String localGrade();
}

enum WeekDay {
	MON, TUE, WED, THU, FRI, SAT, SUN;
	
	private WeekDay() {
		
	}
}