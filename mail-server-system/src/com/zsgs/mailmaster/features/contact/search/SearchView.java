package com.zsgs.mailmaster.features.contact.search;

import com.zsgs.mailmaster.data.dto.Contact;
import java.util.List;

public class SearchView {
	public void showSearchResults(List<Contact> contacts) {
		if (contacts.isEmpty()) {
			System.out.println("No contacts found matching the search criteria.");
		} else {
			System.out.println("Search Results:");
			for (Contact contact : contacts) {
				System.out.println(contact);
			}
		}
	}
}
