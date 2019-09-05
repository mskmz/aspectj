package com.wzk.aspectj.aspect;

import android.util.Log;

import com.wzk.aspectj.annotation.TestJava;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class TestJavaAspect {
    //---------------DEBUG配置-------------------------------------------------------
    private static final String TAG = "TestJavaAspect";
    private static final boolean DEBUG = true;

    @Pointcut("execution(@com.wzk.aspectj.annotation.TestJava * *(..))")
    private void methodPointCut() {
    }

    @Around("methodPointCut()")
    public Object jointPotin(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取签名方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // 获取方法所属的类名
        String className = methodSignature.getDeclaringType().getSimpleName();

        // 获取方法名
        String methodName = methodSignature.getName();

        // 获取方法的注解值(需要统计的用户行为)
        String funName = methodSignature.getMethod().getAnnotation(TestJava.class).value();

        // 统计方法的执行时间、统计用户点击某功能行为。（存储到本地，每过x天上传到服务器）
        long begin = System.currentTimeMillis();

        Log.d("TestAspectJ", "");
        Log.d("TestAspectJ", "START");
        Log.d("TestAspectJ", "className=" + className + "|methodName=" + methodName + "|=funName" + funName);

        Object result = joinPoint.proceed(); // MainActivity中切面的方法

        Log.d("TestAspectJ", "" + result);
        Log.d("TestAspectJ", "END");


        return result;
    }

}
