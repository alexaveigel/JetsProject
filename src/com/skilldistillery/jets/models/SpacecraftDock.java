package com.skilldistillery.jets.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SpacecraftDock {
	Scanner kb = new Scanner(System.in);

	private List<Spacecraft> scArrayList = new ArrayList<>();

	public void menu() {
		try {
			System.out.println(
					"Menu:\n\nPlease select a number.\n\n1. List fleet\n2. Launch all spacecraft\n3. View fastest spacecraft\n4. View most expensive spacecraft\n5. Load cargo\n6. Board all passengers\n7. Retrieve satellite imaging\n8. Initiate a spacecraft\n9. Decommission a spacecraft\n10. Quit");
			int menuChoice = kb.nextInt();
			kb.nextLine();
			if (menuChoice > 0) {
				switch (menuChoice) {
				case 1:
					listAllSpacecraft();
					menu();
					break;
				case 2:
					launchAllSpacecraft();
					menu();
					break;
				case 3:
					fastestSpacecraft();
					menu();
					break;
				case 4:
					mostExpensiveSpacecraft();
					menu();
					break;
				case 5:
					loadCargoShips();
					menu();
					break;
				case 6:
					boardTransportShips();
					menu();
					break;
				case 7:
					retrieveSatelliteImages();
					menu();
					break;
				case 8:
					initiateSpacecraft();
					menu();
					break;
				case 9:
					removeSpacecraft();
					menu();
				default:
					System.out.println("You have quit.");
				}
			}
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.err.println("Invalid input, try again.");
			kb.nextLine();
			menu(); 
		}

	}

	public void removeSpacecraft() {
		System.out.println("Which position would you like to remove?");
		listAllSpacecraft();
		int input = kb.nextInt();
		scArrayList.remove(input - 1);
		listAllSpacecraft();
	}

	private void addCargoShip(String type, String model, double speed, double price, double height) {
		CargoShip cs = new CargoShip(type, model, speed, price, height);
		scArrayList.add(cs);
	}

	private void addTransportShip(String type, String model, double speed, double price, double height) {
		TransportShip ts = new TransportShip(type, model, speed, price, height);
		scArrayList.add(ts);
	}

	private void addSatellite(String type, String model, double speed, double price, double height) {
		Satellite s = new Satellite(type, model, speed, price, height);
		scArrayList.add(s);
	}

	public void initiateSpacecraft() {
		String type = "";
		String model = "";
		double speed = 0.0;
		double price = 0.0;
		double height = 0.0;
		boolean correct = true;
		while (correct) {
			System.out.println("Please enter a type of Spacecraft>> ");
			type = kb.nextLine();
			if (type.equalsIgnoreCase("TransportShip") || type.equalsIgnoreCase("CargoShip")
					|| type.equalsIgnoreCase("Satellite")) {
				System.out.println("Type accepted.");
				correct = false;
			} else {
				System.err.println("Invalid input, try again.");
			}

		}
		correct = true;

		while (correct) {
			System.out.println("Please enter a type of model>> ");
			model = kb.nextLine();
			System.out.println("Model accepted.");
			correct = false;
		}

		correct = true;

		while (correct) {
			System.out.println("Please the top speed>> ");
			try {
				speed = kb.nextDouble();
				if (speed > 0) {
					System.out.println("Speed accepted.");
					correct = false;
				}
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.err.println("Enter a positive number.");
				kb.nextLine();
			}

		}
		correct = true;
		while (correct) {
			System.out.println("Please the price>> ");
			try {
				price = kb.nextDouble();
				if (price > 0) {
					System.out.println("Price accepted.");
					correct = false;
				}
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.err.println("Enter a positive number.");
				kb.nextLine();
			}

		}
		correct = true;
		while (correct) {
			System.out.println("Please the height>> ");
			try {
				height = kb.nextDouble();
				if (height > 0) {
					System.out.println("Height accepted.");
					correct = false;
				}
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.err.println("Enter a positive number.");
				kb.nextLine();
			}

			if (type.equalsIgnoreCase("cargoship")) {
				addCargoShip(type, model, speed, price, height);
			} else if (type.equalsIgnoreCase("satellite")) {
				addSatellite(type, model, speed, price, height);
			} else if (type.equalsIgnoreCase("transportship")) {
				addTransportShip(type, model, speed, price, height);
			}

		}

		menu();

	}

	public void launchAllSpacecraft() {
		for (Spacecraft spacecraft : scArrayList) {
			System.out.println("The " + spacecraft.getModel() + " has launched.");
		}
	}

	public void loadCargoShips() {
		for (Spacecraft spacecraft : scArrayList) {
			if (spacecraft instanceof Carrier) {
				System.out.println(((Carrier) spacecraft).loadCargo());
			}

		}

	}

	public void boardTransportShips() {
		for (Spacecraft spacecraft : scArrayList) {
			if (spacecraft instanceof Transpo) {
				System.out.println(((Transpo) spacecraft).boardPassengers());
			}

		}

	}

	public void retrieveSatelliteImages() {
		for (Spacecraft spacecraft : scArrayList) {
			if (spacecraft instanceof Imaging) {
				System.out.println(((Imaging) spacecraft).retrieveImaging());
			}

		}

	}

	public void fastestSpacecraft() {
		double speed = 0;
		Spacecraft fsc = new TransportShip();
		for (Spacecraft spacecraft : scArrayList) {
			if (speed < spacecraft.getSpeed()) {
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
			if (price < spacecraft.getPrice()) {
				price = spacecraft.getPrice();
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
		int counter = 1;
		for (Spacecraft spacecraft : scArrayList) {
			System.out.println(counter + ". " + spacecraft);
			counter++;
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

				case "cargoship":
					sc = new CargoShip(type, model, speed, price, height);
					break;
				case "satellite":
					sc = new Satellite(type, model, speed, price, height);
					break;
				case "transportship":
					sc = new TransportShip(type, model, speed, price, height);
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
