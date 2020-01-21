package com.epam.repair.app.rest.controller;

import com.epam.repair.app.rest.config.EmailMessageProperties;
import com.epam.repair.model.email.Mail;
import com.epam.repair.service.DataFakerService;
import com.epam.repair.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Java faker controller.
 */
@Profile({"rest"})
@RestController
@RequestMapping("/faker")
public class FakerController {

    @Autowired
    private DataFakerService dataFakerService;

    @Autowired
    private EmailService mailService;

    @Autowired
    private EmailMessageProperties emailMessageProperties;

    /**
     * Create fake data.
     *
     * @param numberOfRepairOrders - quantity of necessary orders
     * @return the String
     */
    @GetMapping(value = "/{numberOfRepairOrders}")
    @ResponseStatus(value = HttpStatus.OK)
    public String fillDataBase(@PathVariable Integer numberOfRepairOrders) throws Exception {
        dataFakerService.startCreation(numberOfRepairOrders);

        Mail mail = new Mail();
        mail.setMailFrom("epamtestsheet@gmail.com");
        mail.setMailTo("siarhei_arkhutsik@epam.com");
        mail.setMailSubject("JavaFaker destroyed you database");

        String message = emailMessageProperties.getMessage_for_faker() + numberOfRepairOrders;
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user_for_faker", emailMessageProperties.getUser_for_faker());
        model.put("message_for_faker", message);
        model.put("recipient_for_faker", mail.getMailFrom());
        mail.setModel(model);

        mailService.sendEmail(mail);

        return "Filling DataBase is complete, email sent";
    }
}
