package com.zsgs.mailmaster.features.mail.manage;

import com.zsgs.mailmaster.data.dto.Mail;
import java.util.List;
import java.util.Scanner;

public class ManageView
{
	private Scanner scanner = new Scanner(System.in);

	public String prompt(String message) {
		System.out.print(message);
		return scanner.nextLine();
	}

	public void showMailList(List<Mail> mails) {
		if (mails.isEmpty()) {
			System.out.println("No mails found.");
		} else {
			for (Mail mail : mails) {
				System.out.println(mail);
			}
		}
	}

	public void showMail(Mail mail) {
		System.out.println(mail);
	}

	public void showMessage(String message) {
		System.out.println(message);
	}
}
