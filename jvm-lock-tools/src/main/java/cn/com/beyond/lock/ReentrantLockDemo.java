package cn.com.beyond.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author banpu
 * @since 2020/2/13
 */
public class ReentrantLockDemo {
  // ReentrantLock 基本用法
  public static ReentrantLock reentrantLock = new ReentrantLock();

  public static void main(String[] args) {
    try {
      // 用法 1.reentrantLock.tryLock 先尝试过获取锁 获取不到就直接跳过
      if (reentrantLock.tryLock(5, TimeUnit.SECONDS)) { //让线程等待5秒看能不能那到锁 拿不到就取else
        System.out.println("获取");
      } else {
        System.out.println("获取失败");
      }
      // 用法 2.reentrantLock.lock 线程进入后直接加锁（强行获取）
      reentrantLock.lock();
      System.out.println("获取");
      // 用法 3.reentrantLock.lockInterruptibly 线程进入获取不到锁后直接中断
      reentrantLock.lockInterruptibly();
      System.out.println("获取");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      // 不加这个条件会报错 getHoldCount()方法来检查当前线程是否拥有该锁
      if(reentrantLock.isHeldByCurrentThread()) {
        reentrantLock.unlock(); //如果没有锁 解锁会报错
      }
    }

  }

}
