package Thread;

public class synchronizedDemo {
	static  int i=0;
	public static class t1 implements Runnable{
		static t1 t = new t1();
		public synchronized static void increase(){  //�����ϼ��������ټ���staticʹֵ��Ϊ��̬��������ʹ��ͬ����Ҳ�ǵ��õ�ͬ��������
			i++;
		}
		public void run(){
			for(int j=0;j<1000000;j++){
//				synchronized(t){   ��sycchronized�����ķ�����
					increase();
//				}
			};
		}
		public static void main(String[] args) throws Exception {
//			Thread t1 = new Thread(new  t1());
//			Thread t2 = new Thread(new t1());
//			t1.start();
//			t2.start();
//			t1.join();
//			t2.join();
//			System.out.println(i);
//			System.out.println(Integer.toBinaryString(100));
			int i = 1;
	}
	} 
	
}
