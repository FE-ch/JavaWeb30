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
	Object object = new Object();	//����������ͬ������ʹ��
	
	public TicketImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		
		synchronized (object) {		//ͬ�������
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
 * �̳�Tread��ķ����������ڵ�numΪ�Ǿ�̬�ֶ�ʱ����������ʹ�ø�Ϊ������Runable�ӿ�
 * 
class Ticket extends Thread{
	
	private static int num = 100; //��̬�ֶβ��ܱ�֤��Ʊ������һ����
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