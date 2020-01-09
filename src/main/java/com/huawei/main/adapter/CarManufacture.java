package com.huawei.main.adapter;

public class CarManufacture {
    protected Car car;

    public CarManufacture() {
        this.car = new Car();
    }
    public  void setEnginer(){
        System.out.println("获取德国引擎");
        System.out.println("按照德国引擎");
        car.description=car.description+"引擎：德国造";
    }
    public void setWheel(){
        System.out.println("获取美国轮子");
        System.out.println("安装美国轮子");
        car.description+="轮胎：美国造";
    }
    public Car getCar(){
        System.out.println("制造了一辆大众汽车");
        return car;
    }
    class Car{
        public String description="";
    }
    //想要实现的接口
    interface ManufactureBMW{
        public void setBattery();
        public void setWheel();
        public Car getCar();
    }
    class CarManufactureBMW extends CarManufacture implements ManufactureBMW{

        @Override
        public void setBattery() {
            System.out.println("获取中国电池");
            System.out.println("安装中国电池");
            car.description+="电池：中国造";
        }
    }

}
