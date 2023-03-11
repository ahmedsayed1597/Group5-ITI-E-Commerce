package com.flamingo.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

	private Long categoryId;
	private String categoryName;
//	private List<ProductDTO> products = new ArrayList<>();
}