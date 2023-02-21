package com.example.cardatabase.domain.repository;

import com.example.cardatabase.domain.entity.Car;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface CarRepository extends CrudRepository<Car, Long> {

    //Fetch cars by brand
    List<Car> findCarByBrand(String brand);

    //Fetch cars by color
    List<Car> findCarByColor(String color);

    //Fetch cars by year
    List<Car> findCarByYear(int year);

    //Fetch cars by brand and model
    List<Car> findByBrandAndModel(String brand, String model);

    //Fetch cars by brand or color
    List<Car> findCarsByBrandOrColor (String brand, String color);

    //Fetch cars by brand and sort by year
    List<Car> findCarsByBrandOrderByYearAsc(String brand);

    //Fetch cars by brand using SQL
    @Query ("select c from Car c where c.brand = ?1")
    List<Car> findCarsByBrand (String brand);

    //Fetch cars by brand using SQL
    @Query ("select c from Car c where c.brand like %?1")
    List<Car> findCarsByBrandEndingWith (String brand);



}
