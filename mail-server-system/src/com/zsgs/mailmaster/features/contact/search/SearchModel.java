package com.zsgs.mailmaster.features.contact.search;

import com.zsgs.mailmaster.data.dto.Contact;
import java.util.List;
import java.util.stream.Collectors;

public class SearchModel {
	private List<Contact> contacts;

	public SearchModel(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Contact> searchContactsByName(String keyword) {
		return contacts.stream()
				.filter(contact -> contact.getName().toLowerCase().contains(keyword.toLowerCase()))
				.collect(Collectors.toList());
	}
}
