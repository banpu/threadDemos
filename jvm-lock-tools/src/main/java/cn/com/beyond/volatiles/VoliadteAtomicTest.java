package cn.com.beyond.volatiles;

/**
 * @author banpu
 * @since 2020/2/13
 */
public class VoliadteAtomicTest {

  private static volatile int num = 0;

  private static void increase() {
    num++;
  }

  public static void main(String[] args) throws InterruptedException {
    Thread[] threads = new Thread[10];
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 1000; i++) {
            increase();
          }
        }
      });

      threads[i].start();

    }

    for (Thread t : threads) {
      t.join();
    }

    System.out.println(num);

  }

}
