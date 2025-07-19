package com.zsgs.mailmaster.features.mail.manage;

import com.zsgs.mailmaster.data.db.MailRepository;
import com.zsgs.mailmaster.data.dto.Mail;
import java.util.List;
import java.util.Optional;

public class ManageModel {
	private MailRepository mailRepository;

	public ManageModel(MailRepository mailRepository) {
		this.mailRepository = mailRepository;
	}

	public Mail createMail(String sender, String recipient, String subject, String body, String timestamp) {
		return mailRepository.addMail(sender, recipient, subject, body, timestamp);
	}

	public boolean updateMail(Mail mail) {
		return mailRepository.updateMail(mail);
	}

	public boolean deleteMail(int id) {
		return mailRepository.deleteMail(id);
	}

	public List<Mail> getAllMails() {
		return mailRepository.getAllMails();
	}

	public Optional<Mail> getMailById(int id) {
		return mailRepository.getMailById(id);
	}
}
