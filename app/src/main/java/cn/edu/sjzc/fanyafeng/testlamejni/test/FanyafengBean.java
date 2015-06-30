package cn.edu.sjzc.fanyafeng.testlamejni.test;

import cn.edu.sjzc.fanyafeng.testlamejni.util.S;

/**
 * Created by Administrator on 2015/6/9/0009.
 */
public class FanyafengBean implements GenericsInterfaceOneParams<Object> {


    private Object object;

    public FanyafengBean(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void show(Object o) {
        S.pl(o, object);
    }
}
