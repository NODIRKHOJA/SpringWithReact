package com.example.cardatabase.domain.repository;

import com.example.cardatabase.domain.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
