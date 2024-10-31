package com.keyin.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

@SpringBootApplication
@EntityScan(basePackages = {"com.keyin.domain.City", "com.keyin.domain.Airport", "com.keyin.domain.Aircraft", "com.keyin.domain.Passenger"})
public class AirportServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AirportServerApplication.class, args);

        try {
            String serviceType = "_airportserver._tcp.local.";
            String serviceName = "AirportServer";
            int port = 8080;

            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, port, "Airport Server");
            jmdns.registerService(serviceInfo);

            System.out.println("Service registered: " + serviceType + " at port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}