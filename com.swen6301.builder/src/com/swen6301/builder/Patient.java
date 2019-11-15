package com.swen6301.builder;

import com.swen6301.builder.util.*;


public class Patient {
	private String firstName;
	private String middleName;
	private String lastName ;
	private int age;
	private int weight;
	private Gender gender ;
	private int height;
	private boolean organDonor;
	private BloodType bloodType;
	
	   private Patient(PatientBuilder builder) {
	        this.firstName=builder.firstName;
	        this.middleName=builder.middleName;
	        this.lastName=builder.lastName;
	        this.age=builder.age;
	        this.weight=builder.weight;
	        this.gender=builder.gender;
	        this.height=builder.height;
	        this.organDonor=builder.organDonor;
	        this.bloodType=builder.bloodType;
	   }

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public int getWeight() {
		return weight;
	}

	public Gender getGender() {
		return gender;
	}

	public boolean isOrganDonor() {
		return organDonor;
	}

	public int getHeight() {
		return height;
	}

	public BloodType getBloodType() {
		return bloodType;
	}
	
	public static class PatientBuilder{
		private String firstName;
		private String middleName;
		private String lastName ;
		private int age;
		private int weight;
		private Gender gender ;
		private int height;
		private boolean organDonor;
		private BloodType bloodType;
		
		public PatientBuilder()
		{
			super();
		}
		 public PatientBuilder setFirstName(String firstName) {
	            this.firstName = firstName;
	            return this;
	        }
		 public PatientBuilder setMiddleName(String middleName) {
	            this.middleName = middleName;
	            return this;
	        }
		 public PatientBuilder setLastName(String lastName) {
	            this.lastName = lastName;
	            return this;
	        }
		 public PatientBuilder setAge(int age) {
	            this.age = age;
	            return this;
	        }
		 public PatientBuilder setWeight(int weight) {
	            this.weight = weight;
	            return this;
	        }
		 public PatientBuilder setHeight(int height) {
	            this.height = height;
	            return this;
	        }
		 public PatientBuilder setGender(Gender gender) {
	            this.gender = gender;
	            return this;
	        }
		 public PatientBuilder setBloodType(BloodType bloodtype) {
	            this.bloodType = bloodtype;
	            return this;
	        }
		 public PatientBuilder setOrganDoner(boolean organDoner) {
	            this.organDonor = organDoner;
	            return this;
	        }
		 
		   public Patient build() {
			   this.setFirstName(RandomUtils.randomIdentifier());
			   this.setMiddleName(RandomUtils.randomIdentifier());
			   this.setLastName(RandomUtils.randomIdentifier());
			   this.setAge(RandomUtils.randomNumber(150));
			   this.setWeight(RandomUtils.randomNumber(400));
			   this.setGender(RandomUtils.randomGenderString());
			   this.setHeight(RandomUtils.randomNumber(300));
			   this.setOrganDoner(RandomUtils.randomBoolean());
			   this.setBloodType(RandomUtils.randomBloodType());
			   
			   Patient patient =  new Patient(this);
			   validatePatient(patient);
	            return patient;
	        }
		   
		   public void validatePatient(Patient patient)
		   {
			   boolean success = PersistenceUtils.storePatientInfo(patient.firstName, patient.middleName, patient.lastName, patient.age, patient.weight, patient.gender, patient.height, patient.organDonor, patient.bloodType);
			   if(success) {
					System.out.println("Patient [" + patient.firstName + ", " + patient.lastName + "] has been successfully processed!");
				} else {
					System.out.println("An error occurred while processing info for patient [" + patient.firstName + ", " + patient.lastName + "]!");
				}
		   }

	
	}







}
