package com.infoshareacademy.service.email;

import com.infoshareacademy.domain.entity.Reservation;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class MailSender {
    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    private void createMail(Email from, String subject, Email to, Content content) throws IOException {
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        logger.info("Response status: {}", response.getStatusCode());
        logger.info("Response body:  {}", response.getBody());
        logger.info("Response header: {}", response.getHeaders());

    }

    public void approveReservation(String userEmail, Reservation reservation) throws IOException {

        Email from = new Email("LibraryFPO@fourplusone.com");
        String subject = "Rezerwacja książki " + reservation.getBook().getTitle();
        Email to = new Email(userEmail);
        Content content = new Content("text/plain",
                "Link potwierdzający rezerwację: http://fourplusone.jjdd8.is-academy.pl/confirm?token="
                        +reservation.getToken());
        createMail(from, subject, to, content);
    }

    public void reservationRejected(String userEmail, Reservation reservation) throws IOException {

        Email from = new Email("LibraryFPO@fourplusone.com");
        String subject = "Rezerwacja książki " + reservation.getBook().getTitle();
        Email to = new Email(userEmail);
        Content content = new Content("text/plain", "Rezerwacja książki wygasła. ");
        createMail(from, subject, to, content);
    }
}

