package mt;

//Thread life cycle
//new
//runnable
//running
//blocked

class Check {
	//Runable way
	class MyFirstThread implements Runnable{
		public MyFirstThread() {
			Thread t = new Thread(this);
			t.start();
		}
		public void run() { //every thread responsibility should be called run
			for (int i = 0; i < 100; i++) {
				
				System.out.println("value of i: " + i);
			}
	}
	}
	//1 tread 1 responsibility
//	class MyFirstThread extends Thread{
//		public void run() { //every thread responsibility should be called run
//			for (int i = 0; i < 100; i++) {
//				
//				System.out.println("value of i: " + i);
//			}
//	}
//	}
class MySecondThread extends Thread{
	public void run() {
		for (int j = 0;j < 100; j++) {
			
			System.out.println("value of j: " + j);
		}
	}
	}

public void mango() {
//	MyFirstThread fThread = new MyFirstThread();
	MySecondThread sThread = new MySecondThread();
	
//	fThread.start();
	sThread.start();

		try {
//			fThread.join();
			sThread.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
}
	
	
}

public class Test {
	public void fun() {
		Check objCheck = new Check();
//		objCheck.mango();
//		objCheck.mango();
	}
	
	public static void main(String[] s) {
		new Test().fun();
		System.out.println("------------------------------thank you");
	}
}