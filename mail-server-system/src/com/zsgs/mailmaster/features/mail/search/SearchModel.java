package com.zsgs.mailmaster.features.mail.search;

import com.zsgs.mailmaster.data.db.MailRepository;
import com.zsgs.mailmaster.data.dto.Mail;
import java.util.List;
import java.util.stream.Collectors;

public class SearchModel {
	private MailRepository mailRepository;

	public SearchModel(MailRepository mailRepository) {
		this.mailRepository = mailRepository;
	}

	public List<Mail> searchMailsBySubject(String keyword) {
		return mailRepository.getAllMails().stream()
				.filter(mail -> mail.getSubject().toLowerCase().contains(keyword.toLowerCase()))
				.collect(Collectors.toList());
	}
}
