package javaWeb30Days;

public class ThreadDemo {

	public static void main(String[] args) {
		TicketImpl ti = new TicketImpl(); 
		
		Thread t1 = new Thread(ti);
		Thread t2 = new Thread(ti);
		Thread t3 = new Thread(ti);
		Thread t4 = new Thread(ti);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}

class TicketImpl implements Runnable {
	
	private int num = 100;
	Object object = new Object();	//对象锁，供同步代码使用
	
	public TicketImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		
		synchronized (object) {		//同步代码块
			try {
				Thread.sleep(10);
				sale();	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			
		}
		
	}
	
	public void sale() {
		
		while (true) {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + "...sale..." + num--);
			}
		}
	}
}

/*
 * 继承Tread类的方法不适用于当num为非静态字段时候的情况，故使用更为常见的Runable接口
 * 
class Ticket extends Thread{
	
	private static int num = 100; //静态字段才能保证卖票总数是一定的
//	private int count; 	
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		super.run();
		sale();
	}
	
	public void sale() {
		
		while (true) {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + "...sale..." + num--);
			}
		}
	}
}
*/