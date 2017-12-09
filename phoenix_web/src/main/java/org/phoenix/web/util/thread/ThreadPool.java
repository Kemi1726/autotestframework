package org.phoenix.web.util.thread;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Created by Kemi on 2017/11/1.
 * Description:
 */
public class ThreadPool {
    private static int MAX_WORK_COUNT = 10;

    private static Logger logger = LoggerFactory.getLogger(ThreadPool.class);

    private static ExecutorService executorService = new ThreadPoolExecutor(MAX_WORK_COUNT,MAX_WORK_COUNT,0L,TimeUnit.SECONDS,
            new ArrayBlockingQueue(1),
    new ThreadFactory() {
        private AtomicInteger autoId = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, "Phoenix worker" + autoId.incrementAndGet());
            return thread;
        }
    },
        new ThreadPoolExecutor.AbortPolicy());

    /*
    * 向任务池提交任务，
    * @param runnable
    * @return true 成功，false任务已满，拒绝执行
    * */

    public static  boolean commitTask(Runnable runnable){
        try {
            Future future = executorService.submit(runnable
            );

        }catch (RejectedExecutionException ex){
            logger.error("task reject");
            return false;
        }
        return  true;
    }

    public static void preStartCoreWorker(){

    }

    public static void shutdown(){
        executorService.shutdown();
    }
}