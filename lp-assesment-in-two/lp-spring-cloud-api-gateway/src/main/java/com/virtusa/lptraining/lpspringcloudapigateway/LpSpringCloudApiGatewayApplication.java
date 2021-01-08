package com.virtusa.lptraining.lpspringcloudapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LpSpringCloudApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpSpringCloudApiGatewayApplication.class, args);
    }

}
