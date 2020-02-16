package cn.com.beyond.atomic.order;/*
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　永无BUG 　┣┓
 * 　　　　┃　　如来保佑　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┗┻┛　┗┻┛
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * jvm 雪花算法
 */
public class OrdersOrdersInteger {
  // 这边使用AtomicInteger方式,分别运行代码，查看结果

  /*static Integer count=new Integer(0);

  public String getOrdersNo() {
    SimpleDateFormat data = new SimpleDateFormat("YYYYMMDDHHMMSS");
    return data.format(new Date())+ count++;
  }
  // 这种方式会存在订单号重复的情况

  */

  static AtomicInteger count=new AtomicInteger(0);

  public String getOrdersNo() {
    SimpleDateFormat data = new SimpleDateFormat("YYYYMMDDHHMMSS");
    return data.format(new Date())+ count.getAndIncrement();
  }
  // 这种方式实现在分布式情况下还是会存在订单号重复的问题，原因是基于jvm实现的，不同机器的jvm不一样、
  // 可采用雪花算法修改

  public static void main(String[] args) {
    final CountDownLatch latch = new CountDownLatch(1);
    ExecutorService exeuctor = Executors.newFixedThreadPool(10);
    final OrdersOrdersInteger orderServer=new OrdersOrdersInteger();
    for (int i = 0; i < 10; i++) {
      exeuctor.submit(new Runnable() {
                          @Override
                          public void run() {
                            System.out.println(orderServer.getOrdersNo());;
                          }
      });

    }
    latch.countDown();
    exeuctor.shutdown();
  }

}
