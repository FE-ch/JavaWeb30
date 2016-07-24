package javaWeb30Days;

import org.junit.Test;

/**
 * @author 先生
 * 枚举还有以下特性：
 * 1.枚举是特殊的java类，他申明的每一个枚举值代表了一个实例对象
 * 2.枚举类还可以实现接口，或继承抽象类
 * 3.switch语句可以接收枚举值
 * 4.若枚举类只有一个枚举值，则可以当做单态设计模式
 * 
 * 单态设计模式--介绍
意图：		保证一个类仅有一个实例，并提供一个访问它的全局访问点。
主要解决：	一个全局使用的类频繁地创建与销毁。
何时使用：	当您想控制实例数目，节省系统资源的时候。
如何解决：	判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
关键代码：	构造函数是私有的。
应用实例： 	1、一个党只能有一个主席。 
			2、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。 
			3、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印机打印同一个文件。
优点： 		1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。 
			2、避免对资源的多重占用（比如写文件操作）。
缺点：		没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
使用场景： 	1、要求生产唯一序列号。 
			2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。 
			3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
注意事项：	getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。
 */



/**
 * Q: 什么时候需要将String转成枚举
 * A：用户提交表单时，如果不在枚举类中，就不合法。所以可以转换成枚举值，检测是否报错即可
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
			return "优秀";
		}
	}, 
	B("89-80") {
		public String localGrade() {
			return "良好";
		}
	},
	C("79-70") {
		public String localGrade() {
			return "一般";
		}
	}, 
	D("69-60") {
		public String localGrade() {
			return "差";
		}
	}, 
	E("59-0") {
		public String localGrade() {
			return "不及格";
		}
	};
	
	private String value;
	/*枚举的构造函数必须是私有的*/
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