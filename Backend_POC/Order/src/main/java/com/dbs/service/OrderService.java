package com.dbs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.h2.tools.Server;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.dbs.entity.OrderVO;
import com.dbs.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public List<OrderVO> getOrders() {
		List<OrderVO> orders = new ArrayList<OrderVO>();
		orderRepository.findAll().forEach(order -> {
			OrderVO orderVO = new OrderVO();
			BeanUtils.copyProperties(order, orderVO);
			orders.add(orderVO);
		});

		return orders;
	}
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
	    return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}
}