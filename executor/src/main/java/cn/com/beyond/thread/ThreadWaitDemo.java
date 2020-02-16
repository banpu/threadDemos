package cn.com.beyond.thread;

/**
 * @author banpu
 * @since 2020/2/12
 * wait()可以让线程从运行态转换为阻塞态，同时还会释放线程的同步锁.
 * 直到调用该方法的线程结束后再继续向下执行
 */
public class ThreadWaitDemo {

  public static void main(String[] args) throws InterruptedException {

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public synchronized void run() {
        try {
          System.out.println("线程1抢到了锁======>");
          this.wait();
          System.out.println("线程1结束了运行");
        }catch (InterruptedException e){
         e.printStackTrace();
        }
      }
    }
    );

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public synchronized void run() {
          System.out.println("线程2抢到了锁======>");
          System.out.println("线程2结束了运行");
      }
    });

    thread1.start();  //开启线程1
    //  让主线程稍等片刻,确保线程1已经运行
    Thread.sleep(200);

    thread2.start();//开启线程2

//    运行结果：线程2运行结束后，由于线程1没有被唤醒，
// 所以一直阻塞在那里......可以使用带有参数的wait(long mills)，当等待的时间结束后，线程会被自动唤醒。

  }

}
