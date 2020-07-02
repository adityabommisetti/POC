package com.dbs.entity;

import java.util.List;

public class OrderVO {

	private String customerName;

	private String orderDate;

	private String shippingAddress;

	private int orderId;

	private List<OrderItemVO> orderItemVO;

	private String total;

	public String getCustomerName() {
		return customerName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public int getOrderId() {
		return orderId;
	}


	public String getShippingAddress() {
		return shippingAddress;
	}

	public String getTotal() {
		return total;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<OrderItemVO> getOrderItemVO() {
		return orderItemVO;
	}

	public void setOrderItemVO(List<OrderItemVO> orderItemVO) {
		this.orderItemVO = orderItemVO;
	}

}