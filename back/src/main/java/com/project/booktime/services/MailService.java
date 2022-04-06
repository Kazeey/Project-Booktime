package com.project.booktime.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService
{

    @Autowired
    private JavaMailSender emailSender;

    public void sendMessage(String to, String subject, String text)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("booktime.projet@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}