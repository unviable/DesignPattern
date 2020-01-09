package com.huawei.main.proxy;

public class Test {
    public static void main(String[] args) {
        SimpleProxy.ProxySubject proxy = new SimpleProxy.ProxySubject(new SimpleProxy.RealSubject());
        proxy.request();
    }
}
