package com.example.cardatabase.domain.controller;


import com.example.cardatabase.domain.entity.Car;
import com.example.cardatabase.domain.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository repository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars(){
        return repository.findAll();
        //Fetch and return cars
    }
}
