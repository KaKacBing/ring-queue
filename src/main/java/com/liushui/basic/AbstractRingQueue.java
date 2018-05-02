package com.liushui.basic;

/**
 *
 * All rights Reserved, Designed By OneOne4Raigor.<p>
 * @author:      liubing
 * @Createdate:  2018/5/2 11:22
 */
public abstract class AbstractRingQueue {

    StepSlot[] slot = new StepSlot[60];

    public AbstractRingQueue() {
        for (int i = 0; i < 60; i++) {
            this.slot[i] = new StepSlot();
        }
    }

    /**
     * 获取下个插槽
     *
     * @param slotIndex 插槽位置
     * @return
     */
    public abstract StepSlot nextStep(int slotIndex);

    /**
     * 添加任务
     *
     * @param ringTask 任务
     * @return 所在slot的index
     */
    public abstract int add(RingTask ringTask);

    /**
     * 删除任务
     *
     * @param taskId    任务id
     * @param slotIndex 插槽位置
     */
    public abstract void remove(int slotIndex, String taskId);


}
