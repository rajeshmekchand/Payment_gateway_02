package com.example.demo;

import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;



@RestController
public class HomeController {

@Autowired
private OrderentityDao orderentitydao;


	
	
	

	
@PostMapping(path = "/orders")

   public String savedata(Orderentity orderrequest ) throws RazorpayException
	{

	RazorpayClient client = new RazorpayClient("rzp_test_DpKVz9ZAGnDW9r", "UmIlTE0Ja7ok5PSGZUfIkxBV");
	JSONObject orderRequest = new JSONObject();
	orderRequest.put("amount",1000);
	orderRequest.put("currency","INR");
	orderRequest.put("receipt", "receipt#1");
	JSONObject notes = new JSONObject();
	notes.put("notes_key_1","tea, Gray, Hot");
	notes.put("notes_key_1","Tea, Earl Grey, Hot");
	orderRequest.put("notes",notes);

		// creating new order
		Order order = client.orders.create(orderRequest);
		System.out.println(order);


		// save the order in database
		Orderentity orderentity = new Orderentity();
		orderentity.setAmount(order.get("amount"));
		orderentity.setNotes(order.get("notes"));
		orderentity.setCreated_at(order.get("created_it"));
		orderentity.setAmount_due(order.get("amount_due"));

		orderentity.setReceipt(order.get("currency"));
		orderentity.setReceipt(order.get("receipts"));
		orderentity.setId(order.get(order.get("id")));
		orderentity.setStatus(order.get("created"));
		orderentity.setAttempts(order.get("attempts"));
	    this.orderentitydao.save(order);

		// save the order in database

		return order.toString();
	}
	
	
//fatch order
@GetMapping(path = "/orders")
public java.util.List<Order> getdata() throws RazorpayException {
		RazorpayClient razorpay = new RazorpayClient("rzp_test_DpKVz9ZAGnDW9r", "UmIlTE0Ja7ok5PSGZUfIkxBV");

		JSONObject params = new JSONObject();
		params.put("count", "1");

		java.util.List<com.razorpay.Order> order = razorpay.orders.fetchAll(params);
		return order;

	}

//update order in razorpay
@PutMapping(path ="/payment")
public Order updataOrder(Order updateorder) throws RazorpayException {
	RazorpayClient razorpay = new RazorpayClient("[YOUR_KEY_ID]", "[YOUR_KEY_SECRET]");

	String orderId = "order_DaaS6LOUAASb7Y";

	JSONObject orderRequest = new JSONObject();
	JSONObject notes = new JSONObject();
	notes.put("notes_key_1","Tea, Earl Grey, Hot");
	notes.put("notes_key_1","Tea, Earl Grey, Hot");
	orderRequest.put("notes",notes);
	              
	Order order = razorpay.orders.edit(orderId,orderRequest);


	
	return updateorder;
	
}

//fatch order by id
@GetMapping(path ="/orders/:id")
public Optional<Order> gatedatabyOptional() throws RazorpayException{
RazorpayClient razorpay = new RazorpayClient("rzp_test_DpKVz9ZAGnDW9r", "UmIlTE0Ja7ok5PSGZUfIkxBV");

String orderId = "order_DaaS6LOUAASb7Y";

Order order = razorpay.orders.fetch(orderId);
return null;

}
 
}
