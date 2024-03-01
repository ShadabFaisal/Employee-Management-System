package com.springboot.employeemanagementsystem.Entity;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;

	private String emailId;
	private String address;

	private String contactNumber;
	private long salary;
	private String gender;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String panNumber;
	
	private String aadharNumber;

	public Employee() {
		this.panNumber=generatePanNumber();
	}

	public Employee(Long id, String firstName, String lastName, String emailId, String address, String contactNumber,
			long salary, String gender, String panNumber, String aadharNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address = address;
		this.contactNumber = contactNumber;
		this.salary = salary;
		this.gender = gender;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	// Method to generate a random uppercase letter
    private static char getRandomLetter() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'A');
    }

    // Method to generate a random digit
    private static char getRandomDigit() {
        Random random = new Random();
        return (char) (random.nextInt(10) + '0');
    }

    // Method to generate a 10-character PAN number
    public static String generatePanNumber() {
        StringBuilder panNumber = new StringBuilder();

        // The first 5 characters are letters
        for (int i = 0; i < 5; i++) {
            panNumber.append(getRandomLetter());
        }

        // The next 4 characters are digits
        for (int i = 0; i < 4; i++) {
            panNumber.append(getRandomDigit());
        }

        // The last character is a letter
        panNumber.append(getRandomLetter());

        return panNumber.toString();
    }


}
