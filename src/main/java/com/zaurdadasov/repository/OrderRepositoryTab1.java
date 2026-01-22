package com.zaurdadasov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zaurdadasov.model.Orders;

import jakarta.transaction.Transactional;

@Repository
public interface OrderRepositoryTab1 extends JpaRepository<Orders,Long>{
	
	@Transactional
	@Modifying
	@Query("Delete from Foods f Where f.foodName=:name")
	public void deleteByFoodName(@Param("name")  String name);

}
