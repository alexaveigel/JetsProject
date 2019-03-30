package com.skilldistillery.jets.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SpacecraftDock {

	private List<Spacecraft> scArrayList = new ArrayList<>();

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
		}
	}
}
