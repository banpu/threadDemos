package cn.com.beyond.sync;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

/**
 * @author banpu
 * @since 2020/2/16
 * 对象锁事例2,方法锁形式
 */
public class SynchronizedObjectCodeBlock2 implements Runnable{
  static SynchronizedObjectCodeBlock2 codeBlock = new SynchronizedObjectCodeBlock2();

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
    test();
  }

  private synchronized void test(){
    System.out.println("这是对象所方法修饰符形式,名字是:"+Thread.currentThread().getName());

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(Thread.currentThread().getName()+"  end");

  }

}
