package Thread;
/**
 * �̵߳Ĵ���
 * @author Administrator
 *
 */
public class demoOne {

	public static void main(String[] args) {
		// �����ڲ��ഴ���߳�
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("���������ڲ���");
			}
		};
		// t1.start();
		t1.run();
	}
}

// �̳�runnable�ӿڴ����߳�
class tRunnable implements Runnable {

	public static void main(String[] args) {
		Thread t = new Thread(new tRunnable());
		t.start();

	}

	@Override
	public void run() {
		System.out.println("�̳�runnable�ӿ�,�Ƚϳ���");
	}
}

class tThread extends Thread {
	@Override
	public void run() {
		System.out.println("ʵ��thread����");
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