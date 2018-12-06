package Thread;
/**
 * 线程并发时出现脏数据
 * @author Administrator
 *
 */
public class ParallelDemoOne {
	
	public static user u = new user();
	public static class user{
		private int i;
		private String j;
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
		public String getJ() {
			return j;
		}
		public void setJ(String j) {
			this.j = j;
		}
		@Override
		public String toString() {
			return "ParallelDemoOne [i=" + i + ", j=" + j + "]";
		}
	}
	public static class tRunnableWrite implements Runnable{

		@Override
		public void run() {
			while(true){
//				System.out.println("write");
				synchronized (u) {
					int i = (int)System.currentTimeMillis()/10000;
					u.setI(i);
					
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}
					u.setJ(Integer.toString(i));
				}
				Thread.yield();
			}
			
		}

		
	}
	public static class tThreadRead extends Thread{
		public void run(){
			while(true){
//				System.out.println("read");
				synchronized (u) {
					if(!u.getJ().equals(Integer.toString(u.getI()))){
						System.out.println(u);
					}
				}
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Thread.yield();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException{
		Thread tWrite = new Thread(new tRunnableWrite()); tWrite.start();
		while(true){
			Thread tRead = new tThreadRead();
			tRead.start();
			Thread.sleep(10);
			tRead.stop();
		}
	}

	

}
