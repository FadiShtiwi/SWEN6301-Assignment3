package com.swen6301.builder;

import com.swen6301.builder.util.BloodType;
import com.swen6301.builder.util.Gender;
import com.swen6301.builder.util.PersistenceUtils;
import com.swen6301.builder.util.RandomUtils;

/**
 * A dummy driver class that simulates a driver class for this project.
 */
public class Driver {
	
	public static void main(String[] args) {
		
		// Create 1000 random samples.
		for(int i = 0; i < 1000; i++) {
			System.out.println("****************");
			createRandomPatient();
			System.out.println("****************");
		}
	}
	
	/**
	 * Creates a sample patient info and store them on internal storage.
	 */
	public static void createRandomPatient() {
		
		Patient patient=new Patient.PatientBuilder()
				.setFirstName()
				.setMiddleName()
				.setLastName()
				.setAge()
				.setHeight()
				.setWeight()
				.setGender()
				.setBloodType()
				.setOrganDoner()
				.build();
	}
	
}
