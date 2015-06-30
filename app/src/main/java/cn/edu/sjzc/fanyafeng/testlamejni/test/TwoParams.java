package cn.edu.sjzc.fanyafeng.testlamejni.test;

import cn.edu.sjzc.fanyafeng.testlamejni.util.S;

/**
 * Created by Administrator on 2015/6/9/0009.
 */
public class TwoParams implements GenericsInterfaceTwoParams<String, Integer> {
    @Override
    public void show(String s, Integer integer) {
        S.pl(s, integer);
    }
}
