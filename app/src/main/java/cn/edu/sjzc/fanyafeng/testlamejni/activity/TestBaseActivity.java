package cn.edu.sjzc.fanyafeng.testlamejni.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import cn.edu.sjzc.fanyafeng.testlamejni.R;

/**
 * base测试
 * 此activity测试内容：
 * 如果不进行父类baseactivity的
 * onCreateOptionsMenu以及OnOptionsItemSelected的重写
 * 或者进行重写后，但是return为super时
 * 仍然进行父类activity的方法的执行
 * 父类的menu菜单也会在此进行显示
 * 但是如果重写activity中的这两个方法
 * 则重新进行menu的重新布局配置
 */
public class TestBaseActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);
    }

    @Override
    protected void isShowIcon() {
        getActionBar().setDisplayShowHomeEnabled(true);
    }
}
