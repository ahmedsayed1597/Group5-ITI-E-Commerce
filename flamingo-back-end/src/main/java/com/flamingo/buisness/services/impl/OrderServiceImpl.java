package com.flamingo.buisness.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.flamingo.buisness.exception.APIException;
import com.flamingo.buisness.exception.ResourceNotFoundException;
import com.flamingo.buisness.services.interfaces.OrderService;
import com.flamingo.persistence.dao.OrderItemRepo;
import com.flamingo.persistence.dao.OrderRepo;

import com.flamingo.presentation.dto.OrderDTO;
import com.flamingo.presentation.responseviewmodel.OrderResponse;

import jakarta.persistence.criteria.Order;

@Service
public class OrderServiceImpl implements OrderService {

    // @Autowired
	// public UserRepo userRepo;

	// @Autowired
	// public CartRepo cartRepo;

	@Autowired
	public OrderRepo orderRepo;

	// @Autowired
	// private PaymentRepo paymentRepo;

	@Autowired
	public OrderItemRepo orderItemRepo;

	// @Autowired
	// public CartItemRepo cartItemRepo;

	// @Autowired
	// public UserService userService;

	// @Autowired
	// public CartService cartService;

	
	public ModelMapper modelMapper;


     @Override
	public OrderDTO getOrder(String emailId, Long orderId) {

		Order order =  (Order) orderRepo.findOrderByEmailAndOrderId(emailId, orderId);

		if (order == null) {
			throw new ResourceNotFoundException("Order", "orderId", orderId);
		}

		return modelMapper.map(order, OrderDTO.class);
	}

    @Override
	public OrderResponse getAllOrders(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

		Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

		Page<com.flamingo.persistence.entities.Order> pageOrders = orderRepo.findAll(pageDetails);

		List<com.flamingo.persistence.entities.Order> orders = pageOrders.getContent();

		List<OrderDTO> orderDTOs = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class))
				.collect(Collectors.toList());
		
		if (orderDTOs.size() == 0) {
			throw new APIException("No orders placed yet by the users");
		}

		OrderResponse orderResponse = new OrderResponse();
		
		orderResponse.setContent(orderDTOs);
		orderResponse.setPageNumber(pageOrders.getNumber());
		orderResponse.setPageSize(pageOrders.getSize());
		orderResponse.setTotalElements(pageOrders.getTotalElements());
		orderResponse.setTotalPages(pageOrders.getTotalPages());
		orderResponse.setLastPage(pageOrders.isLast());
		
		return orderResponse;
	}

    // @Override
	// public OrderDTO placeOrder(String emailId, Long cartId, String paymentMethod) {

	// 	Cart cart = cartRepo.findCartByEmailAndCartId(emailId, cartId);

	// 	if (cart == null) {
	// 		throw new ResourceNotFoundException("Cart", "cartId", cartId);
	// 	}

	// 	Order order = new Order();

	// 	order.setEmail(emailId);
	// 	order.setOrderDate(LocalDate.now());

	// 	order.setTotalAmount(cart.getTotalPrice());
	// 	order.setOrderStatus("Order Accepted !");

	// 	Payment payment = new Payment();
	// 	payment.setOrder(order);
	// 	payment.setPaymentMethod(paymentMethod);

	// 	payment = paymentRepo.save(payment);

	// 	order.setPayment(payment);

	// 	Order savedOrder = orderRepo.save(order);

	// 	List<CartItem> cartItems = cart.getCartItems();

	// 	if (cartItems.size() == 0) {
	// 		throw new APIException("Cart is empty");
	// 	}

	// 	List<OrderItem> orderItems = new ArrayList<>();

	// 	for (CartItem cartItem : cartItems) {
	// 		OrderItem orderItem = new OrderItem();

	// 		orderItem.setProduct(cartItem.getProduct());
	// 		orderItem.setQuantity(cartItem.getQuantity());
	// 		orderItem.setDiscount(cartItem.getDiscount());
	// 		orderItem.setOrderedProductPrice(cartItem.getProductPrice());
	// 		orderItem.setOrder(savedOrder);

	// 		orderItems.add(orderItem);
	// 	}

	// 	orderItems = orderItemRepo.saveAll(orderItems);

	// 	cart.getCartItems().forEach(item -> {
	// 		int quantity = item.getQuantity();

	// 		Product product = item.getProduct();

	// 		cartService.deleteProductFromCart(cartId, item.getProduct().getProductId());

	// 		product.setQuantity(product.getQuantity() - quantity);
	// 	});

	// 	OrderDTO orderDTO = modelMapper.map(savedOrder, OrderDTO.class);
		
	// 	orderItems.forEach(item -> orderDTO.getOrderItems().add(modelMapper.map(item, OrderItemDTO.class)));

	// 	return orderDTO;
	// }



    @Override
	public OrderDTO updateOrder(String emailId, Long orderId, String orderStatus) {

		Order order = (Order) orderRepo.findOrderByEmailAndOrderId(emailId, orderId);

		if (order == null) {
			throw new ResourceNotFoundException("Order", "orderId", orderId);
		}

		// order.setOrderStatus(orderStatus);

		return modelMapper.map(order, OrderDTO.class);
	}

    @Override
    public OrderDTO placeOrder(String emailId, Long cartId, String paymentMethod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'placeOrder'");
    }

    @Override
    public List<OrderDTO> getOrdersByUser(String emailId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrdersByUser'");
    }
    
}
