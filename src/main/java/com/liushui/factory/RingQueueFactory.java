package com.liushui.factory;

import com.liushui.basic.AbstractRingQueue;
import com.liushui.basic.RingQueue;

/**
 * All rights Reserved, Designed By OneOne4Raigor.<p>
 *
 * @author: liubing
 * @Createdate: 2018/5/2 11:22
 */
public final class RingQueueFactory {
    /**
     * 初始化 环队列
     *
     * @return
     */
    public static AbstractRingQueue getRingQueue() {
        return RingQueueEnum.QUEUE.getRq();
    }

    /**
     * 单例枚举初始化
     */
    private enum RingQueueEnum {
        QUEUE(new RingQueue());

        private AbstractRingQueue rq;

        RingQueueEnum(AbstractRingQueue rq) {
            this.rq = rq;
        }

        public AbstractRingQueue getRq() {
            return rq;
        }
    }
}
