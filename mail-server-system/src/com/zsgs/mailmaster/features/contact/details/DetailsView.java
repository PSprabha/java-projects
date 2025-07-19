package com.zsgs.mailmaster.features.contact.details;

import com.zsgs.mailmaster.data.dto.Contact;

public class DetailsView
{
	public void showContactDetails(Contact contact) 
	{
		System.out.println("Contact Details:");
		System.out.println(contact);
	}

	public void showMessage(String message) 
	{
		System.out.println(message);
	}
}
