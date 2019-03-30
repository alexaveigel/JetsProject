package com.skilldistillery.jets.models;

public class CargoShip extends Spacecraft implements Carrier{

	public CargoShip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargoShip(String model, double speed, double price, int height) {
		super(model, speed, price, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String loadCargo() {
		
		return "You have loaded all the cargo for the " + this.getModel();
		
		
		
	}

}
