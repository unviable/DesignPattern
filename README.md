# DesignPattern
java常见的设计模式
适配器模式：定义接口，通过让目标类实现该接口从而实现目标功能
代理模式：通过代理模式可以实现在方法前后添加自己想要实现的代码.
         静态代理，代理类的成员属性是被代理类对象
         jdk动态代理,需要被代理类实现相应的接口,jdk代理实际上生成的可以
             看作该接口的实现类，只是该实现类的方法的具体实现都是被代理类
             的方法
         cglib代理，生成的代理对象都是被代理类的子类,
        