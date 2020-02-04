package com.prokarma.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private Integer id;
	private String name;
	private String phone;
	private String zipcode;
	private List<Vehicle> vehiclesOwned = new ArrayList<>();
	
	public void addVehicle(Vehicle vehicle) {
		vehiclesOwned.add(vehicle);
	}
	public void removeVehicle(Vehicle vehicle) {
		vehiclesOwned.remove(vehicle);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public List<Vehicle> getVehiclesOwned() {
		return vehiclesOwned;
	}
	public void setVehiclesOwned(List<Vehicle> vehiclesOwned) {
		this.vehiclesOwned = vehiclesOwned;
	}
	
}
