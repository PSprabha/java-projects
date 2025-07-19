package com.zsgs.mailmaster.features.mail.search;

import com.zsgs.mailmaster.data.dto.Mail;
import java.util.List;

public class SearchView {
	public void showSearchResults(List<Mail> mails) {
		if (mails.isEmpty()) {
			System.out.println("No mails found matching the search criteria.");
		} else {
			System.out.println("Search Results:");
			for (Mail mail : mails) {
				System.out.println(mail);
			}
		}
	}
}
