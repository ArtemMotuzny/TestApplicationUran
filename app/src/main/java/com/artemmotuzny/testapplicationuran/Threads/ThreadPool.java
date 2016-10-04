package com.artemmotuzny.testapplicationuran.Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tema_ on 04.10.2016.
 */

public class ThreadPool implements MyExecutor {
    private static ThreadPool instance;
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    public static ThreadPool getInstance(){
        if(instance == null){
            instance = new ThreadPool();
        }
        return instance;
    }

    public ThreadPool(){
        mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,MAX_POOL_SIZE,(long)KEEP_ALIVE_TIME, TimeUnit.SECONDS,WORK_QUEUE);
    }

    @Override
    public void execute(Runnable runnable){
        mThreadPoolExecutor.submit(runnable);
    }
}
