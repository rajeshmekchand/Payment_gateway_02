package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.minidev.json.JSONObject;




@Entity
@Table(name="orderentity")
public class Orderentity {
@Id
@GeneratedValue
private Long myorder;
private String amount;
private JSONObject notes;
private String created_at;
private String amount_due;
private String currency;
private String receipt;
private String id;
private String status;
private String attempts;




public Long getMyorder() {
	return myorder;
}
public void setMyorder(Long myorder) {
	this.myorder = myorder;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public JSONObject getNotes() {
	return notes;
}
public void setNotes(JSONObject notes) {
	this.notes = notes;
}
public String getCreated_at() {
	return created_at;
}
public void setCreated_at(String created_at) {
	this.created_at = created_at;
}
public String getAmount_due() {
	return amount_due;
}
public void setAmount_due(String amount_due) {
	this.amount_due = amount_due;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public String getReceipt() {
	return receipt;
}
public void setReceipt(String receipt) {
	this.receipt = receipt;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getAttempts() {
	return attempts;
}
public void setAttempts(String attempts) {
	this.attempts = attempts;
}
@Override
public String toString() {
	return "Orderentity [myorder=" + myorder + ", amount=" + amount + ", notes=" + notes + ", created_at=" + created_at
			+ ", amount_due=" + amount_due + ", currency=" + currency + ", receipt=" + receipt + ", id=" + id
			+ ", status=" + status + ", attempts=" + attempts + "]";
}
}
