package cn.com.beyond.sync;

/**
 * @author banpu
 * @since 2020/2/16
 */
public class SynchronizedException9 implements Runnable {

  private static SynchronizedException9 instance = new SynchronizedException9();

  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(instance);
    Thread thread2 = new Thread(instance);
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println("finished");
  }

  private synchronized void method1(){
    System.out.println("这是加锁的方法,名字是：" + Thread.currentThread().getName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }catch (Exception e) {
      e.printStackTrace();
    }
    throw new RuntimeException();
//    System.out.println(Thread.currentThread().getName() + "运行结束");

  }

  private synchronized void method2() {
    System.out.println("这是没锁的方法,名字是：" + Thread.currentThread().getName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + "运行结束");
  }

  @Override
  public void run() {
    if (Thread.currentThread().getName().equals("Thread-0")) {
      method1();
    } else {
      method2();
    }
  }
}
