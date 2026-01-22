package com.zaurdadasov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zaurdadasov.model.Foods;


@Repository
public interface FoodPageableRepository extends JpaRepository<Foods,Long> {

}
