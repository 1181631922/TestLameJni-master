package cn.edu.sjzc.fanyafeng.testlamejni.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.edu.sjzc.fanyafeng.testlamejni.R;

/**
 * 最底层的基类，配置文件的数据读写
 * 若与后台链接，读取用户基本信息等
 */
public class ABaseActivity extends Activity implements View.OnClickListener {
    protected String name;
    protected String sex;
    protected String qq;
    protected String csdn;
    protected String age;
    protected static View view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPropertyFileContent();
        getBackgroundView();
        view = this.getWindow().getDecorView();   //getDecorView 获得window最顶层的View
        view.setBackgroundResource(R.color.custom_background);
    }


    private void getPropertyFileContent() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = getAssets().open("fanyafeng.properties");
            properties.load(inputStream);
            name = properties.getProperty("name");
            sex = properties.getProperty("sex");
            qq = properties.getProperty("qq");
            csdn = properties.getProperty("csdn");
            age = properties.getProperty("age");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {

    }

    public static View getBackgroundView() {
        return view;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
