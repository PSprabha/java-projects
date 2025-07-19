package com.zsgs.mailmaster.features.mail.details;

import com.zsgs.mailmaster.data.db.MailRepository;
import com.zsgs.mailmaster.data.dto.Mail;
import java.util.Optional;

public class DetailsModel {
	private MailRepository mailRepository;

	public DetailsModel(MailRepository mailRepository) {
		this.mailRepository = mailRepository;
	}

	public Optional<Mail> getMailDetails(int id) {
		return mailRepository.getMailById(id);
	}
}
