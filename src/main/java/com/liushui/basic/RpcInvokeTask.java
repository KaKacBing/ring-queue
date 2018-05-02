package com.liushui.basic;


/**
 *
 * All rights Reserved, Designed By OneOne4Raigor.<p>
 * @author:      liubing
 * @Createdate:  2018/5/2 11:22
 */
public class RpcInvokeTask<T> extends RingTask<T> {

    public RpcInvokeTask(String id, int after) {
        super(id, after);
    }
}
