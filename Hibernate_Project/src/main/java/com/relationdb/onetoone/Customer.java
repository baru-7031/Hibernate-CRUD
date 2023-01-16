package com.relationdb.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int cId;
	private String cName;
	private String cEmail;
	private String cMobile;
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Wallet wallet;

	public Customer() {
		super();
	}

	public Customer(int cId, String cName, String cEmail, String cMobile) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cMobile = cMobile;
	}

	public Customer(int cId, String cName, String cEmail, String cMobile, Wallet wallet) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cMobile = cMobile;
		this.wallet = wallet;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcMobile() {
		return cMobile;
	}

	public void setcMobile(String cMobile) {
		this.cMobile = cMobile;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cEmail=" + cEmail + ", cMobile=" + cMobile + ", wallet="
				+ wallet + "]";
	}
	
	
}
