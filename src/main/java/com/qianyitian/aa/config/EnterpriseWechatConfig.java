package com.qianyitian.aa.config;

import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.config.WxCpConfigStorage;
import me.chanjar.weixin.cp.config.WxCpInMemoryConfigStorage;
import me.chanjar.weixin.cp.message.WxCpMessageRouter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * * @author Qian Bing(https://www.qianyitian.com/)
 */

@Configuration
@ConditionalOnClass(WxCpService.class)
//@EnableConfigurationProperties(EnterpriseWechatProperties.class)
public class EnterpriseWechatConfig {
    @Autowired
    private EnterpriseWechatProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public WxCpConfigStorage configStorage() {
        WxCpInMemoryConfigStorage configStorage = new WxCpInMemoryConfigStorage();
        configStorage.setCorpId(this.properties.getCorpId());
        configStorage.setAgentId(this.properties.getAgentId());
        configStorage.setCorpSecret(this.properties.getSecret());
        configStorage.setToken(this.properties.getToken());
        configStorage.setAesKey(this.properties.getAesKey());
        return configStorage;
    }

    @Bean
    @ConditionalOnMissingBean
    public WxCpService WxCpService(WxCpConfigStorage configStorage) {
        WxCpService service = new me.chanjar.weixin.cp.api.impl.WxCpServiceImpl();
        service.setWxCpConfigStorage(configStorage);
        return service;
    }
}