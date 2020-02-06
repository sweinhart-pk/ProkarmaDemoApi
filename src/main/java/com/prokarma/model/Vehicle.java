package com.prokarma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer ownerId;
	private Double price;
	private String vin;
	private String vehicleType; //(coupe, sedan, truck, suv, muscle)
	private Integer numSeats;
	private String engine;
	private Integer horsepower;
	private String seatsType; //(leather, fabric)
	private String make;
	private String model;
	private String color;
	private Integer year;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Integer getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(Integer numSeats) {
		this.numSeats = numSeats;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public Integer getHorsepower() {
		return horsepower;
	}
	public void setHorsepower(Integer horsepower) {
		this.horsepower = horsepower;
	}
	public String getSeatsType() {
		return seatsType;
	}
	public void setSeatsType(String seatsType) {
		this.seatsType = seatsType;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}	
}
