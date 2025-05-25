package org.d3javu.server;

import grpcstarter.server.GrpcService;
import org.d3javu.grpc.Mail;
import io.grpc.stub.StreamObserver;

@GrpcService
public class MailService extends org.d3javu.grpc.MailServiceGrpc.MailServiceImplBase {

    @Override
    public void sendMail(Mail request, StreamObserver<Mail> responseObserver) {
        var text = request.getText();
        System.out.println(text);
        var resp = Mail.newBuilder().setText("123").build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
