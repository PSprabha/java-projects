package com.zsgs.mailmaster.features.contact.manage;

import com.zsgs.mailmaster.data.dto.Contact;
import java.util.List;
import java.util.Scanner;

public class ManageView {
	private Scanner scanner = new Scanner(System.in);

	public String prompt(String message) {
		System.out.print(message);
		return scanner.nextLine();
	}

	public void showContactList(List<Contact> contacts) {
		if (contacts.isEmpty()) {
			System.out.println("No contacts found.");
		} else {
			for (Contact contact : contacts) {
				System.out.println(contact);
			}
		}
	}

	public void showContact(Contact contact) {
		System.out.println(contact);
	}

	public void showMessage(String message) {
		System.out.println(message);
	}
}
