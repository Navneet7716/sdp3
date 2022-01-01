package com.example.sdp3.Service;

import com.example.sdp3.Pojo.Mail;

import javax.mail.MessagingException;

public interface SendMailService {
    void sendMail(Mail mail) throws MessagingException;

    void sendMailWithAttachments(Mail mail) throws MessagingException;
}
