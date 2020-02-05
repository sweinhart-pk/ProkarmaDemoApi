package com.prokarma.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerTransaction {
	@Id
	@GeneratedValue
	private Integer id;
	private String transactionType; //(purchase, trade, service)
	private Date transactionDate;
	private Double amtPaid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return transactionType;
	}
	public void setType(String type) {
		this.transactionType = type;
	}
	public Date getDate() {
		return transactionDate;
	}
	public void setDate(Date date) {
		this.transactionDate = date;
	}
	public Double getAmtPaid() {
		return amtPaid;
	}
	public void setAmtPaid(Double amtPaid) {
		this.amtPaid = amtPaid;
	}
	
	
}
