package cn.edu.sjzc.fanyafeng.testlamejni.test;

import cn.edu.sjzc.fanyafeng.testlamejni.util.S;

/**
 * Created by Administrator on 2015/6/9/0009.
 */
public class TwoStringParams implements GenericsInterfaceTwoParams<String, String> {
    @Override
    public void show(String s, String t) {
        S.pl(s, t);
    }
}
