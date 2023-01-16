package com.relationdb.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Wallet {

	@Id
	@GeneratedValue
	private int wId;
	private int amount;
	
	@OneToOne
	@JoinColumn(name = "fk_Customer_Id")
	private Customer customer;
	
	public Wallet() {
		super();
	}

	public Wallet(int wId, int amount, Customer customer) {
		super();
		this.wId = wId;
		this.amount = amount;
		this.customer = customer;
	}

	public int getwId() {
		return wId;
	}

	public void setwId(int wId) {
		this.wId = wId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Wallet [wId=" + wId + ", amount=" + amount + ", customer=" + customer + "]";
	}
	
	
	
}








