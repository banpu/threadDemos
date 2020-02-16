package cn.com.beyond.thread;

/**
 * @author banpu
 * @since 2020/2/12
 *
 */
public class JoinThread {
//      * join()可以保证让一个线程在另一个线程之前执行结束。
//      * 如何保证一个工作在另一个工作结束之前完成，就可以使用join()方法。
  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(
        new Runnable() {
          @Override
          public void run() {
            try {
              System.out.println("线程1开始执行");
              Thread.sleep(3000);
              System.out.println("线程1结束执行");
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
    );

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          System.out.println("线程2开始运行");
          thread1.join();// 线程2运行到这里会等待线程1运行结束
          System.out.println("线程2结束执行");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    // 先开启线程2,在开启xia线程1
    thread2.start();
    thread1.start();

// 线程2先启动，当运行到thread1.join()时，线程2停止运行，
// 等待线程1执行结束，虽然线程1启动比线程2迟，但是只有当线程1运行结束后，线程2才能继续运行。
  }

}
