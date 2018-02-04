package com.qianyitian.aa;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * * @author Qian Bing(https://www.qianyitian.com/)
 */
@EnableSwagger2Doc
@SpringBootApplication
public class SpringBootEmailDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmailDemoApplication.class, args);
    }
}
