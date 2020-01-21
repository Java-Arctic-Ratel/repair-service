package com.epam.repair.email;

import com.epam.repair.model.email.Mail;
import com.epam.repair.service.email.EmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration freemarkerConfig;


    public void sendEmail(Mail mail) throws Exception {
        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");

        Template t = freemarkerConfig.getTemplate("faker-template.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

        helper.setTo(mail.getMailTo());
        helper.setText(text, true);
        helper.setSubject(mail.getMailSubject());

        sender.send(message);
    }
}
