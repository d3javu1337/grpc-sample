package org.d3javu.client;

import grpcstarter.client.EnableGrpcClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@EnableGrpcClients(clients = {org.d3javu.grpc.MailServiceGrpc.MailServiceBlockingStub.class})
@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var s = new Scanner(System.in);
        s.nextLine();
        this.mailService.send();
    }
}
