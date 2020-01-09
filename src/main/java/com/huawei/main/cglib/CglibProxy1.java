package com.huawei.main.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
/*
cglib代理产生的对象时被代理类的子类
cglib所需要的jar包springboot自动集成了的
methodinterceptor是aop的基础，可以在被代理类方法执行
前后添加自己的代码，enhancer的作用是生成被代理类的
需要两个属性，一个是被代理类--即生成的对象的父类
另一个是代理对象的方法执行的回调函数--即methodinterceptor
 */
class RealSubject{
    public void excute(){
        System.out.println("this is real implements method");
    }
    public void hello(){
        System.out.println("this is real implements say hello");
    }
}
class CglibProxy implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method,
                            Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy doing something before....");
        Object invoke = null;
        try {
            invoke = methodProxy.invokeSuper(o,objects);
            System.out.println("output proxy return value...");
        } catch (Exception e) {
            System.out.println("catch exception");
            throw e;
        } finally {
            System.out.println("cglib proxy doing something after..");
        }
        return invoke;
    }
}
public class CglibProxy1 {
    public static void main(String[] args) {
        System.getProperties()
                .put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new CglibProxy());
        RealSubject subject = (RealSubject) enhancer.create();
        subject.excute();
        subject.hello();
    }
}
