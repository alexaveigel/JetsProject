package com.skilldistillery.jets.models;

public class TransportShip extends Spacecraft implements Transpo {

	public TransportShip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransportShip(String type, String model, double speed, double price, double height) {
		super(type, model, speed, price, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String boardPassengers() {
		
		return "All the passengers have boarded the " + this.getModel() + ".";
		
		
		
	}
}
