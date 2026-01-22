package com.zaurdadasov.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "service")
public class GlobalProperties {

	public List<Country>countries;
	
}
