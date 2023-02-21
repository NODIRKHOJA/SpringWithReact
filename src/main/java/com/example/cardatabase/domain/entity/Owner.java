package com.example.cardatabase.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ownerId;
    private String firstName;
    private String lastName;
    public Owner() {}

    public Owner(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;

//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "car_owner",
//            joinColumns = {@JoinColumn(name = "ownerid")},
//            inverseJoinColumns = {@JoinColumn(name = "id")})
//
//    private Set<Car> cars = new HashSet<Car>();
//    public Set<Car> getCars() {
//        return cars;
//    }
//    public void setCars(Set<Car> cars) {
//        this.cars = cars;
//    }


    public List<Car> getCars()  {
        return cars;
    }
    public void setCars(List<Car> cars)  {
        this.cars = cars;
    }
    public long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}