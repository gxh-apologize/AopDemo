package cn.gxh.aopdemo;

import android.os.SystemClock;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 切面
 * Created by GXH on 2017/6/29.
 */
@Aspect
public class BehaviorAspect {
    SimpleDateFormat mSimpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 切点，去拿有这个注解标记的方法
     * 注解Pointcut
     * cn.gxh.aopdemo.BehaviorTrace 表示包名+自定义注解名
     * * *(..) 表示方法、参数是所有的
     */
    @Pointcut("execution(@cn.gxh.aopdemo.BehaviorTrace * *(..))")
    public void annoBehavior() {

    }

    /**
     * 拿到方法处理
     *
     * @param point
     * @return
     */
    @Around("annoBehavior()")
    public Object dealPoint(ProceedingJoinPoint point) throws Throwable {

        //方法执行前
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        BehaviorTrace behaviorTrace = methodSignature.getMethod()
                .getAnnotation(BehaviorTrace.class);
        String contentType=behaviorTrace.value();

        Log.d("----dealPoint----","contentType:"+contentType+
                "----"+"使用时间:"+mSimpleDateFormat.format(new Date()));
        long startTime = System.currentTimeMillis();

       //方法执行时

        Object object=point.proceed();


        //方法执行后
        long endTime = System.currentTimeMillis();
        Log.d("----dealPoint----","contentType:"+contentType+
                "----"+"消耗时间:"+(endTime-startTime)+"ms");

        return object;
    }
}
