package com.zsgs.mailmaster.features.registration;

import com.zsgs.mailmaster.data.dto.User;
import java.util.Scanner;

public class RegistrationView {
	private Scanner scanner = new Scanner(System.in);

	public String prompt(String message) {
		System.out.print(message);
		return scanner.nextLine();
	}

	public String getNameInput() {
		return prompt("Enter name: ");
	}

	public int getAgeInput() {
		System.out.print("Enter age: ");
		return Integer.parseInt(scanner.nextLine());
	}

	public String getPhoneInput() {
		return prompt("Enter phone number: ");
	}

	public String getEmailInput() {
		return prompt("Enter email: ");
	}

	public String getPasswordInput() {
		return prompt("Enter password: ");
	}

	public void showUser(User user) {
		System.out.println("Registered User: " + user);
	}

	public void showMessage(String message) {
		System.out.println(message);
	}
}
