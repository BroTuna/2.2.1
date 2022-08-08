package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarServise {
    Car add(Car car);
    List<Car> listCars();
}
