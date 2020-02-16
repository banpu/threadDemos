package cn.com.beyond.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author banpu
 * @since 2020/2/7
 */
public class CallableDemo implements Callable<String> {
    private static final Logger logger = LoggerFactory.getLogger(RunnableDemo.class);

    @Override
    public String call() throws Exception {
        return "山川异域";
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException {
        FutureTask task = new FutureTask(new CallableDemo());
        new Thread(task).start();
        logger.info(task.get().toString());
    }

}
