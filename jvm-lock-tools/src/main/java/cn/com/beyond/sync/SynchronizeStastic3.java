package cn.com.beyond.sync;

/**
 * @author banpu
 * @since 2020/2/16
 * 类锁的第一种形式: static
 */
public class SynchronizeStastic3 implements Runnable{
  static SynchronizeStastic3 instance1 = new SynchronizeStastic3();
  static SynchronizeStastic3 instance2 = new SynchronizeStastic3();

  public static void main(String[] args) {
    Thread thread1 = new Thread(instance1);
    Thread thread2 = new Thread(instance2);
    thread1.start();
    thread2.start();
    while (thread1.isAlive() || thread2.isAlive()) {

    }
    System.out.println("finished");

  }


  @Override
  public void run() {
    method();
  }

  // 加上去掉static 查看运行结果
  private static synchronized void method(){
    System.out.println("类锁的第一种形式:static形式,名字是:"+Thread.currentThread().getName());

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(Thread.currentThread().getName()+"  end");

  }

  /*
  1.两个线程同时访问一个对象实例的同步方法:相互等待,锁生效。
  2.两个线程访问的两个对象实例的同步方法:相互没有影响,并行执行。
  3.两个线程访问的是synchronized的静态方法:即使实例不同,锁也生效。
  4. 同时访问同步方法和非同步方法：非同步方法不受同步方法影响。
  5. 访问同一个对象实例的不同的普通(非static)同步方法：因为默认锁对象是this，所以锁生效，会并行执行。
  6.同时访问静态synchronized方法和非静态synchronized方法:因为static synchronized的锁是*.class，而non-static synchronized的锁是this，所以并不相互冲突，可以并行执行。
  7.方法抛出异常后，会释放锁(RuntimeException()不用强制捕获)
  总结：
    a、一把锁只能同时被一个线程获取,没有拿到锁的线程必须等待(对应1,5情况)
    b、每个实例都对应有自己的一把锁，不同实例之间互不影响；例外：锁对象是*.class以及synchronized修饰的是static方法的时候，所有对象共用同一把类锁（对应第2、3、4、6种情况）；
    c、无论是方法正常执行完毕或者方法抛出异常，都会释放锁（对应第7种情况）
    d、方法method1()被synchronized修饰,method1()中调用了method2(),method2()未被synchronized修饰，method2()还是线程安全的吗？不是，可以被多个线程同时访问




*/
}
