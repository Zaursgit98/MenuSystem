package com.zaurdadasov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zaurdadasov.model.Drinks;


@Repository
public interface DrinkRepository extends JpaRepository<Drinks, Long> {
	

}
