package com.skilldistillery.jets.models;

public class Satellite extends Spacecraft implements Imaging {

	public Satellite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Satellite(String model, double speed, double price, int height) {
		super(model, speed, price, height);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String retrieveImaging() {
		
		return "You have recieved all satellite images from the " + this.getModel() + ".";
		
		
		
	}

}
