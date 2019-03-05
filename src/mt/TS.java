package mt;

 class Data{
	static int cnt = 0;
	
	public synchronized static int increment() { // synchronized access modifier. It makes this method accessible by only 1 thread at a time. 
		
//		synchronized (Data.class) { Synchronized blocks are good for only making 1 members not accessible to multiple threads. 
//			int n = cnt++
//		}
		return cnt++;
	}
}

class MyThread1 extends Thread{
	public void run() {
		for (int i = 0; i < 10000; i++) {
			Data.increment();
		}
	}
}
class MyThread2 extends Thread{
	public void run() {
		for (int i = 0; i < 10000; i++) {
			Data.increment();
		}
	}
}

public class TS {
	
	public void fun() {
		MyThread1 myThread1 = new MyThread1();
		MyThread2 myTheead2 = new MyThread2();
		
		myThread1.start();
		myTheead2.start();
		
		try {
			myThread1.join();
			myTheead2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new TS().fun();
		System.out.println("Thank you...." + Data.cnt);
	}
}
