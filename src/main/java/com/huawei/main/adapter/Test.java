package com.huawei.main.adapter;

/*
测试汽车的适配器
 */
public class Test {
    public static void main(String[] args) {
        CarManufacture manufacture = new CarManufacture();
        manufacture.setEnginer();
        manufacture.setWheel();
        CarManufacture.Car car = manufacture.getCar();
        System.out.println(car.description);
        CarManufacture.ManufactureBMW manufactureOnAdpter=manufacture.new CarManufactureBMW();
        manufactureOnAdpter.setBattery();
        manufactureOnAdpter.setWheel();
        CarManufacture.Car carOnAdapter = manufactureOnAdpter.getCar();
        System.out.println(carOnAdapter.description);
    }
}
