package com.example.cardatabase;

import com.example.cardatabase.domain.entity.Car;
import com.example.cardatabase.domain.entity.Owner;
import com.example.cardatabase.domain.repository.CarRepository;
import com.example.cardatabase.domain.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarDatabaseApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(CarDatabaseApplication.class);
    @Autowired
    private CarRepository repository;
    @Autowired
    private OwnerRepository ownerRepository;


    public static void main(String[] args) {
        SpringApplication.run(CarDatabaseApplication.class, args);
        LOG.info("Application started------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void run(String... args) throws Exception {

        //ADD Owner object and save to db
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        //ADD Car object and save to db
        Car car1 = new Car("Chevrolet", "Malibu", "Black", "AA01AAA", 2020, 30000, owner1);
        Car car2 = new Car("Daewoo", "Nexia", "White", "AB01BBB", 2015, 6000, owner2);
        Car car3 = new Car("BMW", "X5", "Green", "01X001XX", 2017, 40000, owner2);
        repository.saveAll(Arrays.asList(car1, car2, car3));

        for (Car car: repository.findAll()) {
            LOG.info(car.getBrand() + " " + car.getModel());

        }

    }
}
