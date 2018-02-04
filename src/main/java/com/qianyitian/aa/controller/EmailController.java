package com.qianyitian.aa.controller;

import javax.mail.internet.MimeMessage;

import com.alibaba.fastjson.JSON;
import com.qianyitian.aa.config.MailProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import com.qianyitian.aa.model.Email;
/**
 * * @author Qian Bing(https://www.qianyitian.com/)
 */
@RestController
public class EmailController {
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	@Autowired
	MailProperties mailProperties;

	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public String sendEmail(@RequestParam(required=true) String subject, @RequestParam(required=true) String toUsers, @RequestBody String body) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			String[] tos=toUsers.split(";");
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			message.setFrom(mailProperties.getMailFrom());
			helper.setTo(tos);
			helper.setSubject(subject);
			helper.setText(body); // true indicates html
			javaMailSender.send(message);
			logger.info("Email send OK to " + toUsers + " subject: " + subject);
		} catch (Exception e) {
			logger.error("Email send Failed", e);
			return "error: " + e.toString();
		}
		return "ok";
	}

	@RequestMapping(value = "/send4Test", method = RequestMethod.GET)
	public String sendEmailForTest() throws Exception {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		message.setFrom("ac_qianbing@juran.com.cn");
		helper.setTo("894659853@qq.com");
		helper.setSubject("hello");
		helper.setText("aa bb cc" + "\n", false); // true indicates html
		// Send Email
		javaMailSender.send(message);
		logger.info("Send mail successfully ");
		return "ok";
	}

}
