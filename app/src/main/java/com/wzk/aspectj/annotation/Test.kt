package com.wzk.aspectj.annotation

@Target(AnnotationTarget.FUNCTION) // 目标作用在方法之上
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class Test(val str: String = "默认")