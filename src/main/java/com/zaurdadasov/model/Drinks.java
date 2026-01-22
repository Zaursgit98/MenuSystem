package com.zaurdadasov.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drinks",indexes = {@Index (name="idx_drink_name",columnList = "drink_name")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drinks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String drinkName;

	private BigDecimal drinkPrice;

}
