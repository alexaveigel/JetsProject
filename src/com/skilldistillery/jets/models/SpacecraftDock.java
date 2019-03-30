package com.skilldistillery.jets.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpacecraftDock {
	Scanner kb = new Scanner(System.in);
	

	private List<Spacecraft> scArrayList = new ArrayList<>();
	
	public void menu() {
		System.out.println("Menu:\n\nPlease select a number.\n\n1. List fleet\n2. Launch all spacecraft\n3. View fastest spacecraft\n4. View most expensive spacecraft\n5. Load cargo\n6. Board all passengers\n7. Retrieve satellite imaging\n8. Initiate a spacecraft\n9. Decommission a spacecraft\n10. Quit");
		int menuChoice = kb.nextInt();
		switch(menuChoice) {
		case 1 :
			listAllSpacecraft();
			break;
		case 2 :
			System.out.println("fly ships");
			break;
		case 3 :
			fastestSpacecraft();
			break;
		case 4 :
			mostExpensiveSpacecraft();
			break;
		case 5 : 
			loadCargoShips();
			break;
		case 6 :
			boardTransportShips();
			break;
		case 7 :
			retrieveSatelliteImages();
			break;
		case 8 :
			fastestSpacecraft();
			break;
			
		}
		
	}

	public void loadCargoShips(){
		for (Spacecraft spacecraft : scArrayList) {
			if(spacecraft instanceof Carrier) {
				System.out.println(((Carrier) spacecraft).loadCargo());
			}
			
		}
		
	}
	public void boardTransportShips(){
		for (Spacecraft spacecraft : scArrayList) {
			if(spacecraft instanceof Transpo) {
				System.out.println(((Transpo) spacecraft).boardPassengers());
			}
			
		}
		
	}
	public void retrieveSatelliteImages(){
		for (Spacecraft spacecraft : scArrayList) {
			if(spacecraft instanceof Imaging) {
				System.out.println(((Imaging) spacecraft).retrieveImaging());
			}
			
		}
		
	}
	public void fastestSpacecraft() {
		double speed = 0;
		Spacecraft fsc = new TransportShip();
		for (Spacecraft spacecraft : scArrayList) {
			if(speed < spacecraft.getSpeed()) {
				speed = spacecraft.getSpeed();
				fsc = spacecraft;
			}
		}
		System.out.println("The fastest spacecraft is the " + fsc.getModel() + " at " + speed + "/mph.");
	}
	public void mostExpensiveSpacecraft() {
		double price = 0;
		Spacecraft mesc = new TransportShip();
		for (Spacecraft spacecraft : scArrayList) {
			if(price < spacecraft.getSpeed()) {
				price = spacecraft.getSpeed();
				mesc = spacecraft;
			}
		}
		System.out.println("The most expensive spacecraft is the " + mesc.getModel() + " at $" + price + ".");
	}
	
	public SpacecraftDock() {
		super();
		scArrayList = readFile("./initialdata.txt");
		System.out.println(scArrayList.size());
	}

	public void listAllSpacecraft() {
		for (Spacecraft spacecraft : scArrayList) {
			System.out.println(spacecraft);
		}
	}

	private List<Spacecraft> readFile(String fileName) {
		List<Spacecraft> dock = new ArrayList<>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				String[] spacecraft = line.split(", ");
				String type = spacecraft[0];
				String model = spacecraft[1];
				double speed = Double.parseDouble(spacecraft[2]);
				double price = Double.parseDouble(spacecraft[3]);
				int height = Integer.parseInt(spacecraft[4]);
				String normalizeType = type.toLowerCase();
				Spacecraft sc = null;
				switch (normalizeType) {

				case "cargo":
					sc = new CargoShip(model, speed, price, height);
					break;
				case "satellite":
					sc = new Satellite(model, speed, price, height);
					break;
				case "transpo":
					sc = new TransportShip(model, speed, price, height);
					break;

				}
				dock.add(sc);
			}
			br.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		return dock;
	}

	private void writeSpacecrafts(String nameOfFile, List<Spacecraft> dock) {
		try {
			FileWriter fw = new FileWriter(nameOfFile);
			PrintWriter pw = new PrintWriter(new FileWriter(nameOfFile));
			for (Spacecraft scd : dock) {
				StringBuilder sb = new StringBuilder();

				pw.println(scd.getModel() + "\t" + scd.getSpeed() + "\t" + scd.getPrice() + "\t" + scd.getHeight());

			}

			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
			kb.close();
		}
	}

}
