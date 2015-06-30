package cn.edu.sjzc.fanyafeng.testlamejni.testnetvideo;

import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import cn.edu.sjzc.fanyafeng.testlamejni.R;
import cn.edu.sjzc.fanyafeng.testlamejni.activity.BaseActivity;
import cn.edu.sjzc.fanyafeng.testlamejni.util.S;

public class NetVideoViewActivity extends BaseActivity implements SurfaceHolder.Callback {

    private SurfaceView surface_view;                           /* 播放视频载体 */
    private TextView status;                                    /* 显示播放状态 */
    private Button play;                                        /* 播放按钮 */
    private Button pause;                                       /* 咱提供按钮 */
    private Button reset;                                       /* 重放按钮 */
    private Button stop;                                        /* 停止按钮 */

    private MediaPlayer mediaPlayer;                            /* 播放器 */
    private SurfaceHolder surface_holder;                       /* Surface 控制器 */

    private boolean isStartPlaying;     /* 是否开始了播放 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_video);
        title = "网络视频测试";
        subtitle="测试";

        initView();
        initData();
    }

    private void initView() {
        /* 通过 findViewById 获取相关方法 */
        surface_view = (SurfaceView) findViewById(R.id.surface_view);
        status = (TextView) findViewById(R.id.status);
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        reset = (Button) findViewById(R.id.reset);
        stop = (Button) findViewById(R.id.stop);

        /* 使窗口支持透明度, 把当前 Activity 窗口设置成透明, 设置了该选项就可以使用 setAlpha 等函数设置窗口透明度 */
        getWindow().setFormat(PixelFormat.TRANSPARENT);
    }

    private void initData() {
        /* 获取并设置 SurfaceHolder 对象 */
        surface_holder = surface_view.getHolder();                      /* 根据 SurfaceView 组件, 获取 SurfaceHolder 对象 */
        surface_holder.addCallback(this);                               /* 为 SurfaceHolder 设置回调函数, 即 SurfaceHolder.Callback 子类对象 */
        surface_holder.setFixedSize(160, 128);                          /* 设置视频大小比例 */
        surface_holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);/* 设置视频类型 */
    }

    /**
     * 播放网络视频
     * a. 创建并配置 MediaPlayer 对象 (音量, SurfaceHolder)
     * b. 为 MediaPlayer 设置错误监听器, 缓冲进度监听器, 播放完毕监听器, 准备完毕监听器
     * c. 未 MediaPlayer 设置数据源
     * d. 调用 prepare() 进入 Prapared 状态
     * e. 调用 start() 进入 Started 状态
     * @param dataSource 播放视频的网络地址
     */
    private void playVideo(final String dataSource) {
        /* 点击播放有两种情况
         * a. 第一次点击 : 需要初始化 MediaPlayer 对象, 设置监听器
         * b. 第二次点击 : 只需要 调用 mediaPlayer 的 start() 方法
         * 两种情况通过 isStartPlaying 点击时间判断 */
        if (isStartPlaying) {                             /* 如果已经开始了播放, 就直接开始播放 */
            mediaPlayer.start();
        } else {                                          /* 如果是第一次开始播放, 需要初始化 MediaPlayer 设置监听器等操作 */
            mediaPlayer = new MediaPlayer();            /* 创建 MediaPlayer 对象 */
            mediaPlayer.setAudioStreamType(2);          /* 设置播放音量 */
            mediaPlayer.setDisplay(surface_holder);     /* 设置播放载体 */
            /* 设置 MediaPlayer 错误监听器, 如果出现错误就会回调该方法打印错误代码 */
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer arg0, int what, int extra) {
                    S.pl("MediaPlayer 出现错误 what : " + what + " , extra : " + extra);
                    return false;
                }
            });
            /* 设置缓冲进度更新监听器 */
            mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer arg0, int percent) {
                    /* 打印缓冲的百分比, 如果缓冲 */
                    S.pl("缓冲了的百分比 : " , percent + " %");
                }
            });
            /* 设置播放完毕监听器 */
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer arg0) {
                    S.pl("播放完毕了");
                    status.setText("播放完毕");
                }
            });
            /* 设置准备完毕监听器 */
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer arg0) {
                    S.pl("准备完毕");
                    /* 设置播放状态 */
                    status.setText("播放中");
                }
            });
            new Thread() {
                public void run() {
                    try {
                        System.out.println("设置数据源");
                        mediaPlayer.setDataSource(dataSource);
                        mediaPlayer.prepare();
//                        mediaPlayer.prepareAsync();

//                        File file = new File(dataSource);
//                        FileInputStream fis = new FileInputStream(file);
//                        mediaPlayer.setDataSource(fis.getFD());
//                        mediaPlayer.prepare();


                        /* 打印播放视频的时长 */
                        S.pl("视频播放长度 : ",mediaPlayer.getDuration());
                        mediaPlayer.start();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
            }.start();
            /* 设置 MediaPlayer 开始播放标识为 true */
            isStartPlaying = true;
            /* 设置播放状态 */
            status.setText("正在缓冲");
        }
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_net_video, menu);
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

    /**
     * 在 Surface 大小发生改变的时候回调
     * 实现的 SurfaceHolder.Callback 接口方法
     */
    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        System.out.println("SurfaceHolder.Callback.surfaceChanged : Surface 大小发生改变");
    }

    /**
     * 在 Surface 创建的时候回调, 一般在该方法中开始绘图
     * 实现的 SurfaceHolder.Callback 接口方法
     */
    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        System.out.println("SurfaceHolder.Callback.surfaceCreated : Surface 开始创建");
    }

    /**
     * 在 Surface 销毁之前回调, 在该方法中停止渲染线程, 释放相关资源
     * 实现的 SurfaceHolder.Callback 接口方法
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        System.out.println("SurfaceHolder.Callback.surfaceDestroyed : Surface 销毁");
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null)
            mediaPlayer.release();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.play:
            /* 播放视频直接从 AutoCompleteTextView 中获取字符串, 播放该 url 代表的网络视频 */
//                playVideo(url.getText().toString());
                //mp4格式
//                playVideo("http://k.youku.com/player/getFlvPath/sid/1435642937794122501f2_01/st/mp4/fileid/0300080100514CDCC117ED01BB9D9D61CCFE71-3919-AADA-2135-9ACFAF0A1691?K=e2f50491245bf084282a9867&hd=1&myp=0&ts=37&ypp=0&ctype=12&ev=1&token=9394&oip=1931268481&ep=cyaXH0%2BJVMcD4iTWjD8bZSnidSENXP4J9h%2BFidJjALshSezM7U2ixpy3O4tCF4tre1YPZO3w2KORH0cVYfNKqGEQrj%2FcSPri%2F%2FPm5aQit%2BZxEBlHc8vetVSXQDn1");
                //m3u8格式
                playVideo("http://pl.youku.com/playlist/m3u8?ts=1435648051&keyframe=0&vid=XODgyNjQwNzc2&type=flv&ep=eyaXH0%2BJXs4F5CbXgT8bYH7hdX5ZXJZ1gkjM%2F4gDR8VuG%2BrQmzzTzw%3D%3D&sid=9435648051589127b319f&token=2228&ctype=12&ev=1&oip=1931268481");
                break;

            case R.id.pause:
                if(mediaPlayer != null){
                    mediaPlayer.pause();
                    status.setText("暂停");
                }
                break;

            case R.id.reset:
                if(mediaPlayer != null){
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                    status.setText("播放中");
                }
                break;

            case R.id.stop:
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    isStartPlaying = false;
                    status.setText("停止");
                }
                break;

            default:
                break;
        }
    }


}
