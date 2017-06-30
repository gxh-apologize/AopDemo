package cn.gxh.aopdemo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SimpleDateFormat mSimpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 摇一摇
     * @param view
     */
   /* public void shake(View view){
        Log.d("----shake----","使用时间:"+mSimpleDateFormat.format(new Date()));
        long startTime = System.currentTimeMillis();

        //摇一摇的逻辑代码
        SystemClock.sleep(3000);
        Log.d("----shake----","摇到了哦。。。");

        long endTime = System.currentTimeMillis();
        Log.d("----shake----","消耗时间:"+(endTime-startTime)+"ms");
    }*/

    /**
     * 发红包
     * @param view
     */
    public void redpacket(View view){
        Log.d("----redpacket----","使用时间:"+mSimpleDateFormat.format(new Date()));
        long startTime = System.currentTimeMillis();

        //发红包的逻辑代码
        SystemClock.sleep(3000);
        Log.d("----redpacket----","红包来了。。。");

        long endTime = System.currentTimeMillis();
        Log.d("----redpacket----","消耗时间:"+(endTime-startTime)+"ms");
    }

    /**
     * 语音
     * @param view
     */
    public void voice(View view){
        Log.d("----voice----","使用时间:"+mSimpleDateFormat.format(new Date()));
        long startTime = System.currentTimeMillis();

        //语音的逻辑代码
        SystemClock.sleep(3000);
        Log.d("----voice----","博主是个大帅哥。。。");

        long endTime = System.currentTimeMillis();
        Log.d("----voice----","消耗时间:"+(endTime-startTime)+"ms");
    }



    @BehaviorTrace("摇一摇")
    public void shake(View view){
        //摇一摇的逻辑代码
        SystemClock.sleep(3000);
        Log.d("----shake----","摇到了哦。。。");
    }
}
