package Thread;
/**
 * 线程的创建
 * @author Administrator
 *
 */
public class demoOne {

	public static void main(String[] args) {
		// 匿名内部类创建线程
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("创建匿名内部类");
			}
		};
		// t1.start();
		t1.run();
	}
}

// 继承runnable接口创建线程
class tRunnable implements Runnable {

	public static void main(String[] args) {
		Thread t = new Thread(new tRunnable());
		t.start();

	}

	@Override
	public void run() {
		System.out.println("继承runnable接口,比较常用");
	}
}

class tThread extends Thread {
	@Override
	public void run() {
		System.out.println("实现thread方法");
	}

	public static void main(String[] args) {
		Thread t = new tThread();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("cucuole");
		}
		t.start();
	}
}