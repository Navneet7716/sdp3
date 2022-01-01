package com.example.sdp3.Service;

import com.example.sdp3.Pojo.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.lang.module.Configuration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Service
public class SendEmailService implements SendMailService {
    private final JavaMailSender javaMailSender;

    public static int numberofthreads = 4;

    private ScheduledExecutorService quickService = Executors.newScheduledThreadPool(numberofthreads);

    public SendEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(Mail mail) throws MailException, RuntimeException, MessagingException {

//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(mail.getRecipient(), mail.getRecipient());
//
//        msg.setSubject(mail.getSubject());
//        msg.setText("<h1>  </h1>", true);

        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(mail.getSubject());
        String html = "<!doctype html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                "      xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Email</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div style=\"box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n" +
                "    border-radius: 10px;\n" +
                "    background-color: white; font-size: 1rem;\">" +
                "Hey " + mail.getSubject()+ "," + "<br/>\n" +
                "\n" +
                "<span>" + mail.getMessage() + "</span>\n" + "</div> <br />" +"\n" +
                "<span>Cheers From,</span>" + "<br/>" +
                "<span> Jobbers Team</span> <br />" +
                "<img src=\"https://sdp3jobber.s3.ap-south-1.amazonaws.com/SignUp.png\" height=\"100px\" width=\"100px\" alt=\"Logo\"/>" +
                "</body>\n" +
                "</html>\n";

        helper.setText(html, true);
        helper.setTo(mail.getRecipient());

        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    javaMailSender.send(mimeMessage);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

    }

    @Override
    public void sendMailWithAttachments(Mail mail) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo("to_@email");

        helper.setSubject("Testing from Spring Boot");

        helper.setText("Find the attached image", true);

        helper.addAttachment("hero.jpg", new ClassPathResource("hero.jpg"));

        javaMailSender.send(msg);
    }

}