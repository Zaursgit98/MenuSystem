package com.zaurdadasov.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "foods",
		 indexes = {
				@Index(name = "idx_food_name", columnList = "food_name") })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foods {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "foodname sahesi bos ola bilmez")
	private String foodName;

	@NotNull(message ="qiymet hissesini bos qoymaq olmaz")
	@Positive(message = "musbet eded daxil edin")
	private BigDecimal foodPrice;

	

}
