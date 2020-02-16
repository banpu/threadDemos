package cn.com.beyond.sync;

/**
 * @author banpu
 * @since 2020/2/16
 * 对象锁的代码块形式
 */
public class SynchronizedObjectCodeBlock1 implements Runnable {

  static SynchronizedObjectCodeBlock1 codeBlock = new SynchronizedObjectCodeBlock1();

  public static void main(String[] args) {
    Thread thread1 = new Thread(codeBlock);
    Thread thread2 = new Thread(codeBlock);
    thread1.start();
    thread2.start();
    while (thread1.isAlive() || thread2.isAlive()) {

    }
    System.out.println("finished");

  }


  @Override
  public void run() {
    synchronized (this) {
      System.out.println("这是对象锁的代码快形式,名字为:" + Thread.currentThread().getName());
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + "运行结束");

    }
  }

}
