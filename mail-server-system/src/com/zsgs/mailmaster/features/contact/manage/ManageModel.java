package com.zsgs.mailmaster.features.contact.manage;

import com.zsgs.mailmaster.data.dto.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManageModel {
	private List<Contact> contacts = new ArrayList<>();
	private int nextId = 1;

	public ManageModel() {}

	public Contact createContact(String name, String email, String phone) {
		Contact contact = new Contact(nextId++, name, email, phone);
		contacts.add(contact);
		return contact;
	}

	public boolean updateContact(Contact updatedContact) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getId() == updatedContact.getId()) {
				contacts.set(i, updatedContact);
				return true;
			}
		}
		return false;
	}

	public boolean deleteContact(int id) {
		return contacts.removeIf(c -> c.getId() == id);
	}

	public List<Contact> getAllContacts() {
		return new ArrayList<>(contacts);
	}

	public Optional<Contact> getContactById(int id) {
		return contacts.stream().filter(c -> c.getId() == id).findFirst();
	}
}
