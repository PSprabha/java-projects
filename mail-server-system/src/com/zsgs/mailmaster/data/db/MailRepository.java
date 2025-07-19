package com.zsgs.mailmaster.data.db;

import com.zsgs.mailmaster.data.dto.Mail;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MailRepository 
{
	private List<Mail> mailsList = new ArrayList<>();
	private int nextId = 1;
	
	public Mail addMail(String sender, String recipient, String subject, String body, String timestamp) 
	{
		Mail mail = new Mail(nextId++, sender, recipient, subject, body, timestamp);
		mailsList.add(mail);
		return mail;
	}
	
	public Optional<Mail> getMailById(int id)
	{
		return mailsList.stream().filter(m -> m.getId() == id).findFirst();
	}
	
	public List<Mail> getAllMails() {
		return new ArrayList<>(mailsList);
	}
	
	public boolean updateMail(Mail updatedMail) {
		for (int i = 0; i < mailsList.size(); i++) {
			if (mailsList.get(i).getId() == updatedMail.getId()) {
				mailsList.set(i, updatedMail);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteMail(int id) {
		return mailsList.removeIf(m -> m.getId() == id);
	}
}
