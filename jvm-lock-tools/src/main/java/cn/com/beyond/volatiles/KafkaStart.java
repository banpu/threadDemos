package cn.com.beyond.volatiles;/*
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

import cn.com.beyond.util.TlUtil;

/***
 * synchronized 和vlolatile 实验
 */
public class KafkaStart {
  private static volatile boolean isStart = false;

  public static  synchronized   void start(){
    if (isStart) {
      throw new RuntimeException();
    }
    System.out.println("初始完成");
    isStart=true;
  }

  public static void main(String[] args) {
//    KafkaStart xxxStart=new KafkaStart();
    TlUtil.timeTasks(10, 10, new Runnable() {
      @Override
      public void run() {
        KafkaStart xxxStart=new KafkaStart();  //测试下
        xxxStart.start();
      }
    });

  }


}
