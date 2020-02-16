package cn.com.beyond.sync;

/**
 * @author banpu
 * @since 2020/2/13
 */
public class SynchronizedDemo implements Runnable{

  private static int i = 0;

  public static void main(String[] args) throws InterruptedException {
    SynchronizedDemo demo = new SynchronizedDemo();
    Thread thread1 = new Thread(demo);
    Thread thread2 = new Thread(demo);
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();

    System.out.println(i);
  }

  @Override
  public synchronized  void run() {
    for(int n =0;n<10000;n++){
      i++;
    }
  }
}
