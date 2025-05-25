package org.d3javu.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private org.d3javu.grpc.MailServiceGrpc.MailServiceBlockingStub stub;

    public void send() {
        System.out.println("Sending mail");
        var t = stub.sendMail(org.d3javu.grpc.Mail.newBuilder().setText("test").build());
//        var resp = stub.sendMail(t);
        System.out.println(t);
    }

}
