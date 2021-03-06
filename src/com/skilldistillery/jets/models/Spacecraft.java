package com.skilldistillery.jets.models;

public abstract class Spacecraft {
	private String model;
	private String type;
	private double speed;
	private double price;
	private double height;

	public Spacecraft(String type, String model, double speed, double price, double height) {
		super();
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.price = price;
		this.height = height;
	}

	public Spacecraft() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
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
	return "Spacecraft [Type = " + type + ", Model = " + model + ", Speed = " + speed + ", Price = " + price + ", Height = " + height + "]";
}

}


