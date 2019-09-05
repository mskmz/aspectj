package com.wzk.aspectj.aspect

import android.util.Log
import com.wzk.aspectj.annotation.Test
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature

@Aspect
public class TestAspect {
    @Pointcut("execution(@com.wzk.aspectj.annotation.Test¬ * *(..))")
    fun methodPointCut() {
    }

    @Around("methodPointCut()")
    fun TestAround(joinPoint: ProceedingJoinPoint): Any {
        // 获取签名方法
        val methodSignature = joinPoint.signature as MethodSignature
        // 获取方法所属的类名
        val className = methodSignature.declaringType.simpleName
        // 获取方法名
        val methodName = methodSignature.name
        // 获取方法的注解值(需要统计的用户行为)
        val funName = methodSignature.method.annotations
            .filter {
                it.javaClass == Test::class.java
            }[0]
            ?.run {
                this as Test
            }?.run {
                str
            }
        Log.d("TestAspectJ", "")
        Log.d("TestAspectJ", "START")
        Log.d("TestAspectJ", "className=$className|methodName=$methodName|=funName$funName")
        val begin = System.currentTimeMillis()
        val result = joinPoint.proceed() // MainActivity中切面的方法
        Log.d("TestAspectJ", "$result")
        Log.d("TestAspectJ", "END")
        return result
    }

}