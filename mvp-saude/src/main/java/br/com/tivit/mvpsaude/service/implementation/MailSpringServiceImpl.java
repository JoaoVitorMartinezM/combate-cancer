package br.com.tivit.mvpsaude.service.implementation;

import br.com.tivit.mvpsaude.service.contract.MailServiceStrategy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MailSpringServiceImpl implements MailServiceStrategy {

    private final String from;
    private final JavaMailSender emailSender;

    public MailSpringServiceImpl(JavaMailSender emailSender, String mailSpringUsername) {
        this.emailSender = emailSender;
        this.from = mailSpringUsername;
    }

    @Override
    public void sendText(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        emailSender.send(message);
    }

}
