package cn.edu.sjzc.fanyafeng.testlamejni.test;

import cn.edu.sjzc.fanyafeng.testlamejni.util.S;

/**
 * Created by fanyafeng on 2015/6/9/0009.
 */
public class Generics<T> {
    private T t;

    public Generics(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void showType() {
        S.pl("T的实际类型是：", t.getClass().getName());
    }
}
