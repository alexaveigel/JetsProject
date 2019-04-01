package com.skilldistillery.jets.models;

public class Satellite extends Spacecraft implements Imaging {

	public Satellite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Satellite(String type, String model, double speed, double price, double height) {
		super(type, model, speed, price, height);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String retrieveImaging() {
		
		return "You have recieved all satellite images from the " + this.getModel() + ".";
		
		
		
	}

}
