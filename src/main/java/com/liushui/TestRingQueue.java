package com.liushui;

import com.liushui.basic.RingQueue;
import com.liushui.basic.RingTask;
import com.liushui.basic.RpcInvokeTask;
import com.liushui.basic.StepSlot;
import com.liushui.factory.RingQueueFactory;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * All rights Reserved, Designed By OneOne4Raigor.<p>
 *
 * @author: liubing
 * @Createdate: 2018/5/2 14:12
 */

public class TestRingQueue {
    /**
     * 间隔执行
     */
    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    /**
     * 数据插入
     */
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * 队列
     */
    private static final RingQueue QUEUE = (RingQueue) RingQueueFactory.getRingQueue();

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            UUID uuid = UUID.randomUUID();
            // 一个线程插入
            executorService.execute(() -> {
                RpcInvokeTask task = new RpcInvokeTask(uuid.toString(), 60);
                String str = "Hello Ring Queue ! I= " + uuid;
                task.setT(str);
                QUEUE.add(task);
                latch.countDown();
            });
            Thread.sleep(1000L);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始执行");

        // 一个线程池执行,每隔秒1执行1次
        service.scheduleWithFixedDelay(() -> {
            // 当前脚标= 当前秒数
            int second = LocalDateTime.now().getSecond();
            // 获得对应slot
            StepSlot slot = QUEUE.nextStep(second);
            final ConcurrentLinkedQueue<RingTask> ringTasks = slot.getRingTasks();

            // 执行任务
            ringTasks.forEach(t -> {
                // 执行1次就结束
                System.out.println(t.getT() + "------>" + second);
                QUEUE.remove(t.getIndex(), t.getId());
            });
        }, 60, 1, TimeUnit.SECONDS);

    }
}
