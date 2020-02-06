package com.prokarma.constants;

import java.util.HashMap;
import java.util.Map;

public class ApiConstants {
	public static final String COUPE = "Coupe";
	public static final String SEDAN = "Sedan";
	public static final String TRUCK = "Truck";
	public static final String SUV = "Suv";
	public static final String MUSCLE = "Muscle";
	public static final String LEATHER = "Leather";
	public static final String FABRIC = "Fabric";
	public static final String PURCHASE = "Purchase";
	public static final String TRADE = "Trade";
	public static final String SERVICE = "Service";
    public static final Map<String, Double> SERVICE_TYPE = new HashMap<>();
    static {
        SERVICE_TYPE.put("oil", 40.00);
        SERVICE_TYPE.put("transmission", 150.00);
        SERVICE_TYPE.put("brakes", 200.00);
        SERVICE_TYPE.put("tires", 800.00);
    }
}
