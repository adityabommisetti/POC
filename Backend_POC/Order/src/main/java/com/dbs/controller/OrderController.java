package com.dbs.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.entity.OrderItemVO;
import com.dbs.entity.OrderVO;
import com.dbs.service.OrderItemClient;
import com.dbs.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	OrderItemClient client;

	@GetMapping("/orders")
	private List<OrderVO> getOrders() {
		List<OrderVO> ordersList = orderService.getOrders();
		List<OrderItemVO> orderItemsList = client.getOrderItems();
		Map<Integer, List<OrderItemVO>> orderItemsMap = orderItemsList.stream()
				.collect(Collectors.groupingBy(OrderItemVO::getOrderId, Collectors.toList()));
		ordersList.stream().forEach(order -> order.setOrderItemVO(orderItemsMap.get(order.getOrderId())));

		return ordersList;
	}

	@GetMapping("/orderItems")
	private List<OrderItemVO> getOrdersItems() {
		return client.getOrderItems();
	}

}
