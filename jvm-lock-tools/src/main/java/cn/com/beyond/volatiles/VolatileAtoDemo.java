package cn.com.beyond.volatiles;

/**
 * @author banpu
 * @since 2020/2/12
 */
public class VolatileAtoDemo implements Runnable {
  //原子性测试
  static volatile int i =1;
  @Override
  public void run() {
    /***
     * i++; 操作并非为原子性操作。
     什么是原子性操作？简单来说就是一个操作不能再分解。i++ 操作实际上分为 3 步：
     读取 i 变量的值。
     增加 i 变量的值。
     把新的值写到内存中。
     */
    System.out.println(Thread.currentThread().getName() + ": 当前i值: " + i + ", ++后i值: "
        + (++i));
  }
  public static void main(String[] args) {
    Thread t1 = new Thread(new VolatileAtoDemo(), "A");
    Thread t2 = new Thread(new VolatileAtoDemo(), "B");
    Thread t3 = new Thread(new VolatileAtoDemo(), "C");
    Thread t4 = new Thread(new VolatileAtoDemo(), "D");
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}