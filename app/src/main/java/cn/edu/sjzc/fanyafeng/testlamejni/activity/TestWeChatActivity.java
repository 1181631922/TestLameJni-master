package cn.edu.sjzc.fanyafeng.testlamejni.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import cn.edu.sjzc.fanyafeng.testlamejni.R;

/**
 * 微信背景测试
 * 此activity继承父类activity
 * 虽然进行了onOptionsItemSelected的重写
 * 但是返回键的监听依旧存在，
 * menu菜单由于进行重写未显示
 * 而是显示的当前重写的menu
 * 默认不显示actionbar左侧图标
 */
public class TestWeChatActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setTitleBackground() {
        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.gray));
    }



    @Override
    protected void BaseBack() {
        super.BaseBack();
    }
}
