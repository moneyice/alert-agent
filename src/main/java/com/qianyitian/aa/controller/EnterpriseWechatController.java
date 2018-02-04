package com.qianyitian.aa.controller;

import com.qianyitian.aa.model.Email;
import com.qianyitian.aa.model.EnterpriseWechatMessage;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

/**
 * * @author Qian Bing(https://www.qianyitian.com/)
 */
@RestController
public class EnterpriseWechatController {
    private static final Logger logger = LoggerFactory.getLogger(EnterpriseWechatController.class);

    @Autowired
    private WxCpService wxService;

    @RequestMapping(value = "/sendEnterpriseWechat", method = RequestMethod.POST)
    public String sendEnterpriseWechat(@RequestParam String subject, @RequestParam String toUsers,@RequestParam String toParts,@RequestBody String body) {
        int agentID= wxService.getWxCpConfigStorage().getAgentId();
        WxCpMessage  wxCpMessage= WxCpMessage
                .TEXT()
                .agentId(agentID) // 企业号应用ID
                .toUser("@all")
                .content(subject+ "\n" + body)
                .build();
        try {
            wxService.messageSend(wxCpMessage);
            logger.info("Enterprise wechat message send OK: " + body);
        } catch (Exception e) {
            logger.error("Enterprise wechat message send Failed", e);
            return "error: " + e.toString();
        }
        return "ok";
    }


}
