package com.huawei.main.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//主题接口
interface Subject{
    public void request();
}
//真实主题
class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("处理请求");
    }
    public void hello(){
        System.out.println("say hello");
    }
}
//动态代理处理器
class ProxyHandler implements InvocationHandler{
    Object proxied;

    public ProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象："+proxy.getClass().getName());
        System.out.println("代理方法:"+method.getName());
        System.out.println("预处理请求");
        Object invoke = method.invoke(proxied, args);
        System.out.println("预处理请求");
        return invoke;
    }
}
public class JdkProxy {
    public static void main(String[] args) {
        com.huawei.main.proxy.RealSubject real = new com.huawei.main.proxy.RealSubject();
        Subject obj = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class}, new ProxyHandler(real));
        obj.request();
    }
}
