package cn.com.beyond.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author banpu
 * @since 2020/2/14
 */
public class ScheduledThreadPoolExecutorTest {

  public static void main(String[] args) {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    // example 1,5秒后执行
    executorService.schedule(()->{
      System.out.println("==5==");
    }, 5, TimeUnit.SECONDS);

    // example 1,5秒后执行
    executorService.scheduleAtFixedRate(()->{
      System.out.println("===3===");
    }, 0,3, TimeUnit.SECONDS);

  }


}
