package br.com.tivit.mvpsaude.service.contract;

public interface MailServiceStrategy {
        void sendText(String to, String subject, String body);

}