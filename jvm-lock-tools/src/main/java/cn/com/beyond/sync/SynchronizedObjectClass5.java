package cn.com.beyond.sync;

/**
 * @author banpu
 * @since 2020/2/16
 */
public class SynchronizedObjectClass5 implements Runnable {

  static SynchronizedObjectClass5 instance1 = new SynchronizedObjectClass5();
  static SynchronizedObjectClass5 instance2 = new SynchronizedObjectClass5();

  @Override
  public void run() {
    method();
  }

  private void method() {
    synchronized (SynchronizedObjectClass5.class) {
      System.out.println("类锁的地二种形式:synchronized (*.class),名字叫" + Thread.currentThread().getName());

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + "运行结束");

    }
  }


  public static void main(String[] args) {
    Thread thread1 = new Thread(instance1);
    Thread thread2 = new Thread(instance2);
    thread1.start();
    thread2.start();
    while (thread1.isAlive() || thread2.isAlive()) {

    }
    System.out.println("finished");
  }

}
