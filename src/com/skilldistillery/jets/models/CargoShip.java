package com.skilldistillery.jets.models;

public class CargoShip extends Spacecraft implements Carrier{

	public CargoShip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargoShip(String type, String model, double speed, double price, double height) {
		super(type, model, speed, price, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String loadCargo() {
		
		return "You have loaded all the cargo for the " + this.getModel() + ".";
		
		
		
	}

}
