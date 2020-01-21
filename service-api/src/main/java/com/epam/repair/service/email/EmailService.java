package com.epam.repair.service.email;

import com.epam.repair.model.email.Mail;

public interface EmailService {

    void sendEmail(Mail mail) throws Exception;

}

