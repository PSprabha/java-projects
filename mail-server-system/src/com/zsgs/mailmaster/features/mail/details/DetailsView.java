package com.zsgs.mailmaster.features.mail.details;

import com.zsgs.mailmaster.data.dto.Mail;

public class DetailsView {
	public void showMailDetails(Mail mail) {
		System.out.println("Mail Details:");
		System.out.println(mail);
	}

	public void showMessage(String message) {
		System.out.println(message);
	}
}
