package com.zaurdadasov.event;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAddToMenu {

	@NotEmpty(message = "ad hissesini bos qoymaq olmaz")
	private String name;

	@NotNull(message ="qiymet hissesini bos qoymaq olmaz")
	@Positive(message = "musbet eded daxil edin")
	private BigDecimal price;

}
