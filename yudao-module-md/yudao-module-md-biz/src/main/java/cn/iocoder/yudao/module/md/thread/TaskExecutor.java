package cn.iocoder.yudao.module.md.thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2022 <br/>
 * @Desc: <br/>
 * @ProjectName: dmp <br/>
 * @Date: 2022/4/27 1:46 下午 <br/>
 * @Author: youzhihao
 */
@Slf4j
public class TaskExecutor {

    private int coreSize = Runtime.getRuntime().availableProcessors() + 1;

    private int maxSize = coreSize * 4;

    private int keepAlive = 180;

    private int queueSize = 5000;

    private String name = this.getClass().getSimpleName();

    private ThreadPoolExecutor executor;

    private static final ScheduledExecutorService monitorExecutor = Executors.newScheduledThreadPool(2);

    private AtomicBoolean isInit = new AtomicBoolean(false);

    private long rejectTaskNum = 0;

    public TaskExecutor() {
    }

    public TaskExecutor(String name) {
        this.name = name;
    }

    public TaskExecutor(int coreSize, int maxSize, int keepAlive, String name) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.keepAlive = keepAlive;
        this.name = name;
    }


    public TaskExecutor(int coreSize, int maxSize, int keepAlive, int queueSize, String name) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.keepAlive = keepAlive;
        this.queueSize = queueSize;
        this.name = name;
    }

    @PostConstruct
    public void init() {
        if (isInit.compareAndSet(false, true)) {
            ThreadFactoryBuilder builder = new ThreadFactoryBuilder().setNamePrefix(name);
            executor = new ThreadPoolExecutor(coreSize, maxSize, keepAlive, TimeUnit.SECONDS, new LinkedBlockingQueue<>(queueSize), builder.build(),
                (r, executor) -> rejectTaskNum++);
            monitorExecutor.scheduleAtFixedRate(this::monitor, 60, 60, TimeUnit.SECONDS);
        }

    }

    public void execute(Runnable task) {
        try {
            executor.execute(task);
        } catch (Exception e) {
            log.error("[task executor] execute task fail, name={}, error={}", name, e.getMessage(), e);
        }
    }

    /**
     * 监控
     */
    private void monitor() {
        log.info("[task executor] monitoring... name={}, core={}, max={}, keepAlive={}ms, activeThreadNum={}, taskQueue={}/{}, rejectTaskNum={}",
            name, coreSize, maxSize, keepAlive, executor.getActiveCount(), executor.getQueue().size(), queueSize, rejectTaskNum);
        rejectTaskNum = 0;
    }

    /**
     * 监控额外资源
     */
    public static void monitorOthers(Runnable command, long initialDelay, long period, TimeUnit unit) {
        monitorExecutor.scheduleAtFixedRate(command, initialDelay, period, unit);
    }

    /**
     * 轻量级一次性调度
     */
    public static void schedule(Runnable command, long delay, TimeUnit unit) {
        monitorExecutor.schedule(command, delay, unit);
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }
}
