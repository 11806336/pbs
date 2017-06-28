//package com.pbs.ams.common.Task;
//
//import java.util.Iterator;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//import com.pbs.ams.common.constant.GlobalConst;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
///**
// ** 任务池处理器
// * Create by TiAmo 2017/06/26
// */
//public class SimpleTaskHandler {
//
//    ThreadPoolExecutor threadPool;
//
//    private String key = "";
//
//    private static Log logger = LogFactory.getLog(SimpleTaskHandler.class);
//
//    private static TreeMap<String, SimpleTaskHandler> simpleTaskHandlerPool = new TreeMap<>(); // Key->ConnectionPool
//
//    private static String GLOBAL_STH_KEY = "GLOBAL_SIMPLE_TASK_HANDLER_DEFAULT_POOL";
//
//    private SimpleTaskHandler() {
//        threadPool = new ThreadPoolExecutor(
//                GlobalConst.simple_task_core_pool_size,
//                GlobalConst.simple_task_max_pool_size, 30, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(GlobalConst.simple_task_queue_size),
//                new ThreadPoolExecutor.CallerRunsPolicy());
//    }
//
//    private SimpleTaskHandler(int corePoolSize, int maximumPoolSize, int queueSize) {
//        threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 30,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueSize),
//                new ThreadPoolExecutor.CallerRunsPolicy());
//    }
//
//    public static SimpleTaskHandler getDefaultInstance() {
//        return getOneInstance(GLOBAL_STH_KEY);
//    }
//
//    private static synchronized SimpleTaskHandler newInstance(String key) {
//        if (!simpleTaskHandlerPool.containsKey(key)) {
//            SimpleTaskHandler newInstance = new SimpleTaskHandler();
//            newInstance.setKey(key);
//            simpleTaskHandlerPool.put(key, newInstance);
//        }
//        return simpleTaskHandlerPool.get(key);
//    }
//
//    private static synchronized SimpleTaskHandler newInstance(String key, int corePoolSize, int maximumPoolSize, int queueSize) {
//        if (!simpleTaskHandlerPool.containsKey(key)) {
//            SimpleTaskHandler newInstance = new SimpleTaskHandler(corePoolSize, maximumPoolSize, queueSize);
//            newInstance.setKey(key);
//            simpleTaskHandlerPool.put(key, newInstance);
//        }
//        return simpleTaskHandlerPool.get(key);
//    }
//
//    public static SimpleTaskHandler getOneInstance(String key) {
//        if (!simpleTaskHandlerPool.containsKey(key)) {
//            newInstance(key);
//            logger.info(">> SimpleTaskHandler[" + key + "]server is started.\n");
//        }
//        return simpleTaskHandlerPool.get(key);
//    }
//
//    public static SimpleTaskHandler getOneInstance(String key, int corePoolSize, int maximumPoolSize, int queueSize) {
//        if (!simpleTaskHandlerPool.containsKey(key)) {
//            newInstance(key, corePoolSize, maximumPoolSize, queueSize);
//            logger.info(">> SimpleTaskHandler[" + key + "]server is started.\n");
//        }
//        return simpleTaskHandlerPool.get(key);
//    }
//
//    public void execute(Runnable task) {
//        threadPool.execute(task);
//    }
//
//    public void shutdown() {
//        threadPool.shutdown();
//        logger.info(">> SimpleTaskHandler[" + key + "]server is shutdown.\n");
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    public static void ShutDownAllInstance() {
//
//        for (Map.Entry<String, SimpleTaskHandler> entry : simpleTaskHandlerPool.entrySet()) {
//            String key = entry.getKey();
//            SimpleTaskHandler value = entry.getValue();
//            value.shutdown();
//        }
//    }
//}
