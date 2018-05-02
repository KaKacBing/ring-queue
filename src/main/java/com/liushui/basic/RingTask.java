package com.liushui.basic;

import java.time.LocalDateTime;

/**
 *
 * All rights Reserved, Designed By OneOne4Raigor.<p>
 * @author:      liubing
 * @Createdate:  2018/5/2 11:23
 */
public abstract class RingTask<T> {
    /**
     * 执行圈数
     */
    private int cycle;

    /**
     * 脚标
     */
    private int index;

    /**
     * 唯一id
     */
    private String id;

    /**
     * 传输对象
     */
    private T t;

    public RingTask(String id, int after) {
        int second = LocalDateTime.now().getSecond();
        this.index = (second + after) % 60;
        this.index = (this.index >= 1 && this.index <= 59 ? this.index : 59);
        this.id = id;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
