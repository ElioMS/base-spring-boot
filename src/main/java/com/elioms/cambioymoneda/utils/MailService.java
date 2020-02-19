package com.elioms.cambioymoneda.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String to ,String subject, String body) {
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom("Cambio y moneda <noreply-cambioymoneda@mail.com>");
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);

        mailSender.send(mail);
    }

}