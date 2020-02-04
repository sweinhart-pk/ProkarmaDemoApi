package com.prokarma.model;

import java.util.Date;

import javax.persistence.GeneratedValue;

public class Transaction {
	@GeneratedValue
	private Integer id;
	private String type; //(purchase, trade, service)
	private Date date;
	private Double amtPaid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAmtPaid() {
		return amtPaid;
	}
	public void setAmtPaid(Double amtPaid) {
		this.amtPaid = amtPaid;
	}
	
	
}
