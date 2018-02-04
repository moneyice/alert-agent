package com.qianyitian.aa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * * @author Qian Bing(https://www.qianyitian.com/)
 */
@Component
public class MailProperties {
    @Value("${mail.from}")
    private String mailFrom;


    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }
}
