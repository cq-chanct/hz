package Thread;

public class waitNotify {
	final static Object obj = new Object();
	static int i;
	private static boolean b =false;
	
	public static class t1 extends Thread{
		public void run(){
			synchronized (obj) {
				System.out.println("t1 start");
				try {
					System.out.println("t1 wait");
					obj.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("t1 end");
			}
		}
	}
	public static class t2 extends Thread{
		public void run(){
			synchronized (obj) {
				System.out.println("t2 start");
				obj.notify();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t2 end");
			}
		}
		
	}
	public static class t3 implements Runnable {

		@Override
		public void run() {
			for(i=0;i<100000;i++);
			
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
//		t1 t1 = new t1();
//		t2 t2 = new t2();
//		t1.start();
//		t2.start();
//		Thread t3 =  new Thread(new t3());
//		t3.start();
		//加入join后main线程会等t3执行完毕后再输出i的值
//		t3.join();
//		System.out.println(i);
		new readerThread().start();
		Thread.sleep(1000);
		b=true;
		Thread.sleep(1000);
		
	}
	
	public static class readerThread  extends Thread{
		public void run(){
			while(b){
				System.out.println("终于 readerThread:"+i);
			}
			
		}
	}
	

}
