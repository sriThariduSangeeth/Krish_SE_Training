package com.sangeeth.lptraining.lpcloudserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LpCloudServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpCloudServiceRegistryApplication.class, args);
    }

}
