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
		 public PatientBuilder setFirstName() {
	            this.firstName = RandomUtils.randomIdentifier();
	            return this;
	        }
		 public PatientBuilder setMiddleName() {
	            this.middleName = RandomUtils.randomIdentifier();
	            return this;
	        }
		 public PatientBuilder setLastName() {
	            this.lastName = RandomUtils.randomIdentifier();
	            return this;
	        }
		 public PatientBuilder setAge() {
	            this.age = RandomUtils.randomNumber(150);
	            return this;
	        }
		 public PatientBuilder setWeight() {
	            this.weight = RandomUtils.randomNumber(400);
	            return this;
	        }
		 public PatientBuilder setHeight() {
	            this.height = RandomUtils.randomNumber(300);
	            return this;
	        }
		 public PatientBuilder setGender() {
	            this.gender = RandomUtils.randomGenderString();
	            return this;
	        }
		 public PatientBuilder setBloodType() {
	            this.bloodType = RandomUtils.randomBloodType();
	            return this;
	        }
		 public PatientBuilder setOrganDoner() {
	            this.organDonor = RandomUtils.randomBoolean();
	            return this;
	        }
		 
		   public Patient build() {
			   //this.setFirstName();
			   //this.setMiddleName();
			   //this.setLastName();
			   //this.setAge();
			   //this.setWeight();
			   //this.setGender();
			   //this.setHeight();
			   //this.setOrganDoner();
			   //this.setBloodType();
			   
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
