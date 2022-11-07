package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.razorpay.Order;

public interface OrderentityDao extends JpaRepository<Orderentity, Long> {

	void save(Order order);



}
