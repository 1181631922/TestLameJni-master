package cn.edu.sjzc.fanyafeng.testlamejni.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.edu.sjzc.fanyafeng.testlamejni.R;

/**
 * 首先声明：actionbar必须是在api 11以上才能使用，如果低于这个版本的话会有提示
 * 全英文代码均是新建时生成，未做任何改动
 * 首先定义这个base是为了代码的重用性
 * 解决相同功能和相同代码的重复编写
 * <p/>
 * 本来想找一下在代码中定制theme的方法，但是没找到，后期找到后会加上
 */
public class BaseActivity extends ABaseActivity {
    //相同的类型可以用一个string的，为了以后的移植都进行了单个的定义
    protected String title;
    protected String subtitle;
    protected boolean ishide = false;


    /**
     * getActionBar只能在onCreate进行get
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*左上角icon显示
        getActionBar().setDisplayShowHomeEnabled(false);
        左上角返回键显示
        ActionBar actionBar=getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);*/

        isShowIcon();
        isShowBack();
        isShowBackIcon();
        isShowTitle();
        setTitleIcon();
        setTitleBackground();

    }


    /**
     * actionbar为顶部菜单布局
     *
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    /**
     * 每个顶部menu的监听，如果横向添加的话android会自定义下拉编写，不用进行方法的重写实现
     *
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                BaseBack();
                break;
//            case R.id.base_action_setting1:
//                finish();
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 为返回监听提供重写的方法
     */
    protected void BaseBack() {
        finish();
    }

    /**
     * 为子activity的icon初始化提供重写方法
     */
    protected void isShowIcon() {
        getActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * 为子activity的back按钮初始化提供重写方法
     */
    protected void isShowBack() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 为子activity的title标题是否显示提供重写方法
     */
    protected void isShowTitle() {
        getActionBar().setDisplayShowTitleEnabled(true);
    }

    /**
     * 为子activity的返回图标是否显示提供重写方法
     */
    protected void isShowBackIcon() {
        getActionBar().setDisplayHomeAsUpEnabled(false);
    }

    /**
     * 为子activity的icon图标提供私人定制的重写方法
     */
    protected void setTitleIcon() {
        getActionBar().setIcon(getResources().getDrawable(R.drawable.title_back));
    }

    /**
     * 为子activity的title背景提供私人定制的重写方法
     */
    protected void setTitleBackground() {
        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.customthemebackground));
    }

    /**
     * 一级标题
     *
     * @param title
     */
    protected void setTitleContent(String title) {
        getActionBar().setTitle(title);
    }

    /**
     * 二级标题
     *
     * @param subtitle
     */
    protected void setSubtitleContent(String subtitle) {
        getActionBar().setSubtitle(subtitle);
    }

    protected void isActionBaiHide(boolean ishide) {
        getActionBar().hide();
    }

    /**
     * 对重新赋值的字段进行判断
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (title != null && !title.equals("")) {
            setTitleContent(title);
        }
        if (subtitle != null && !subtitle.equals("")) {
            setSubtitleContent(subtitle);
        }
        if (ishide) {
            isActionBaiHide(true);
        }
    }
}
