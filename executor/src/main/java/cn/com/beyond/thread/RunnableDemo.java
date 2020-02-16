package cn.com.beyond.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author banpu
 * @since 2020/2/7
 */
public class RunnableDemo implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(RunnableDemo.class);

    public static void main(String[] args) {
        RunnableDemo demo = new RunnableDemo();
        new Thread(demo).start();
    }


    @Override
    public void run() {
        logger.info("山川异域，风月同舟");

    }

  /*  public String name;

    public RunnableDemo(String name){
        this.name = name;
    }


    @Override
    public void run() {
//        logger.info("山川异域，风月同舟");
        for(int i = 0;i< 100;i++){
            System.out.println(this.name + "==>" + i);
        }

    }*/

}
