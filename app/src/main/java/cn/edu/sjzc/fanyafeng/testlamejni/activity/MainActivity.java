package cn.edu.sjzc.fanyafeng.testlamejni.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import cn.edu.sjzc.fanyafeng.testlamejni.R;
import cn.edu.sjzc.fanyafeng.testlamejni.testnetvideo.NetVideoActivity;


public class MainActivity extends BaseActivity {
    private TextView user_sex, user_age, user_csdn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = "樊亚风";
        subtitle = qq;

        initView();
        initData();
    }

    private void initView() {
        user_sex = (TextView) findViewById(R.id.user_sex);
        user_age = (TextView) findViewById(R.id.user_age);
        user_csdn = (TextView) findViewById(R.id.user_csdn);
    }

    private void initData() {
        user_sex.setText(sex);
        user_age.setText(age);
        user_csdn.setText(csdn);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                break;
            case R.id.second_action_setting:
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.action_photo:
                Intent intent1 = new Intent(MainActivity.this, PhotoActivity.class);
                startActivity(intent1);
                break;
            case R.id.action_scan:
                Intent intent2 = new Intent(MainActivity.this, ScanActivity.class);
                startActivity(intent2);
                break;
            case R.id.second_action_theme:
                Intent intent3 = new Intent(MainActivity.this, ChangeThemeActivity.class);
                startActivity(intent3);
                break;
            case R.id.main_action_test1:
                Intent intent4 = new Intent(MainActivity.this, TestBaseActivity.class);
                startActivity(intent4);
                break;
            case R.id.main_action_test2:
                Intent intent5 = new Intent(MainActivity.this, TestWeChatActivity.class);
                startActivity(intent5);
                break;
            case R.id.main_action_test3:
                Intent intent6 = new Intent(MainActivity.this, TestTitleActivity.class);
                startActivity(intent6);
                break;
            case R.id.main_action_test4:
                Intent intent7 = new Intent(MainActivity.this, TestHideActivity.class);
                startActivity(intent7);
                break;
            case R.id.main_action_test5:
                Intent intent8 = new Intent(MainActivity.this, TestCustomActivity.class);
                startActivity(intent8);
                break;
            case R.id.main_action_test6:
                Intent intent9 = new Intent(MainActivity.this, TestPopWindowActivity.class);
                startActivity(intent9);
                break;
            case R.id.main_action_test7:
                Intent intent10 = new Intent(MainActivity.this, ChangeBackgroudActivity.class);
                startActivity(intent10);
                break;
            case R.id.main_action_test8:
                Intent intent11 = new Intent(MainActivity.this, NetVideoActivity.class);
                startActivity(intent11);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void BaseBack() {
    }

    @Override
    protected void isShowBack() {
    }

    @Override
    protected void isShowIcon() {
        getActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    protected void setTitleBackground() {
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
