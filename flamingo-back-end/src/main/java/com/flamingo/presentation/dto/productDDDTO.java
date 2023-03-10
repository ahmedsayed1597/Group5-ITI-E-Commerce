package com.flamingo.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class productDDDTO {
    private Long productId;
	private String productName;
	private String image;
	private String description;
	private Integer quantity;
	private double price;

}
