package com.huawei.main.proxy;

public class SimpleProxy {
    //主题接口
    interface Subject{
        public  void request();
    }
    //真实主题
    public static class RealSubject implements  Subject{

        @Override
        public void request() {
            System.out.println("处理请求");
        }
    }
    //使用静态代理
    static class ProxySubject implements Subject{
        private  RealSubject realSubject;

        public ProxySubject(RealSubject realSubject) {
            this.realSubject = realSubject;
        }

        @Override
        public void request() {
            preRequest();
            realSubject.request();
            postRequest();
        }
        public void preRequest(){
            System.out.println("预处理请求");
        }
        public void postRequest(){
            System.out.println("后处理请求");
        }

    }
}
