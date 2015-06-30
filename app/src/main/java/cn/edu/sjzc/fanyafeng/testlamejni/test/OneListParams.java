package cn.edu.sjzc.fanyafeng.testlamejni.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.edu.sjzc.fanyafeng.testlamejni.util.S;

/**
 * Created by Administrator on 2015/6/9/0009.
 */
public class OneListParams implements GenericsInterfaceOneParams<List> {
    @Override
    public void show(List arrayList) {
        for (Object item : arrayList) {
            S.pl(item);
        }
        S.l();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            S.pl(iterator.next());
        }
    }
}
