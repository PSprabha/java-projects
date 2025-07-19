package com.zsgs.mailmaster.features.contact.details;

import com.zsgs.mailmaster.data.dto.Contact;
import java.util.List;
import java.util.Optional;

public class DetailsModel 
{
	private List<Contact> contacts;

	public DetailsModel(List<Contact> contacts) 
	{
		this.contacts = contacts;
	}

	public Optional<Contact> getContactDetails(int id) {
		return contacts.stream().filter(c -> c.getId() == id).findFirst();
	}
}
