package com.liushui.basic;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * All rights Reserved, Designed By OneOne4Raigor.<p>
 * @author:      liubing
 * @Createdate:  2018/5/2 11:23
 */
public class StepSlot {
    /**
     * 线程安全队列
     */
    private ConcurrentLinkedQueue<RingTask> ringTasks = new ConcurrentLinkedQueue<>();

    public ConcurrentLinkedQueue<RingTask> getRingTasks() {
        return ringTasks;
    }

    /**
     * 向槽内添加任务
     *
     * @param ringTask 任务
     */
    int addTask(RingTask ringTask) {
        ringTasks.add(ringTask);
        return ringTask.getIndex();
    }

    /**
     * 删除槽内某个taskId的任务
     *
     * @param taskId 任务id
     * @return 成功/失败
     */
    void reomve(String taskId) {
        ringTasks.removeIf(task -> task.getId().equals(taskId));
    }
}
