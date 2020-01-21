package com.epam.repair.app.rest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("message")
public class EmailMessageProperties {
    private String user_for_faker;
    private String message_for_faker;

    public String getUser_for_faker() {
        return user_for_faker;
    }

    public void setUser_for_faker(String user_for_faker) {
        this.user_for_faker = user_for_faker;
    }

    public String getMessage_for_faker() {
        return message_for_faker;
    }

    public void setMessage_for_faker(String message_for_faker) {
        this.message_for_faker = message_for_faker;
    }
}
