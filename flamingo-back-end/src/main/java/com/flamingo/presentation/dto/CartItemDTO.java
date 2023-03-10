package com.flamingo.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long cartItemId;
	private CartDTO cart;
	private productDDDTO product;
	private Integer quantity;
	private double productPrice;
}
