package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.Mail;
import com.example.sdp3.Service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin(value = "*", maxAge=3600)
@RequestMapping("/api/mail")
public class EmailController {

    @Autowired
    SendEmailService sendEmailService;

    @PostMapping("/send")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> sendMail(@RequestBody Mail mail) throws MessagingException {
        sendEmailService.sendMail(mail);
        return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
    }

    @PostMapping("/attachment")
    public ResponseEntity<String> sendAttachmentEmail(@RequestBody Mail mail) throws MessagingException {
        sendEmailService.sendMailWithAttachments(mail);
        return new ResponseEntity<>("Attachment mail sent successfully", HttpStatus.OK);
    }


}
