package com.skilldistillery.jets.models;

public abstract class Spacecraft {
	private String model;
	private double speed;
	private double price;
	private int height;
	public Spacecraft(String model, double speed, double price, int height) {
		super();
		this.model = model;
		this.speed = speed;
		this.price = price;
		this.height = height;
	}
	public Spacecraft() {
		super();
	}
	
public void fly() {
	
}

public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public double getSpeed() {
	return speed;
}
public void setSpeed(double speed) {
	this.speed = speed;
}
@Override
public String toString() {
	return "Spacecraft [Model = " + model + ", Speed = " + speed + ", Price = " + price + ", Height = " + height + "]";
}

}
