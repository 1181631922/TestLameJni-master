package cn.edu.sjzc.fanyafeng.testlamejni.test;

import cn.edu.sjzc.fanyafeng.testlamejni.util.S;

/**
 * Created by Administrator on 2015/6/9/0009.
 */
public class OneIntParams implements GenericsInterfaceOneParams<Integer> {
    @Override
    public void show(Integer integer) {
        S.pl(integer);
    }
}
