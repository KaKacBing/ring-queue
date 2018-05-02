package com.liushui.basic;

/**
 *
 * All rights Reserved, Designed By OneOne4Raigor.<p>
 * @author:      liubing
 * @Createdate:  2018/5/2 11:23
 */
public class RingQueue extends AbstractRingQueue {
    public RingQueue() {
        super();
    }

    @Override
    public StepSlot nextStep(int slotIndex) {
        return slot[slotIndex];
    }

    @Override
    public int add(RingTask ringTask) {
        return slot[ringTask.getIndex()].addTask(ringTask);
    }

    @Override
    public void remove(int slotIndex, String taskId) {
        slot[slotIndex].reomve(taskId);
    }

}
