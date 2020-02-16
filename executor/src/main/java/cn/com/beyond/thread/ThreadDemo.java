package cn.com.beyond.thread;


/**
 * @author banpu
 * @since 2020/2/7
 */
public class ThreadDemo extends Thread {

//    private static final Logger logger = LoggerFactory.getLogger(RunnableDemo.class);
//
//    public static void main(String[] args) {
//        ThreadDemo thread =  new ThreadDemo();
//        thread.setDaemon(true);
//        thread.start();
//    }
//
//    @Override
//    public void run() {
//        logger.info("山川异域，风月同舟");
//    }


    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }

    @Override
    public void run() {
        System.out.println("山川异域，风月同舟");
    }
}
