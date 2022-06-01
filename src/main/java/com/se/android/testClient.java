package com.se.android;

import communication_proto.CommunicationGrpc;
import communication_proto.State;
import communication_proto.VoidConfirmation;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class testClient {

    private static CommunicationGrpc.CommunicationBlockingStub stub;

    public static void main(String[] args) {

        String target = "localhost:8080";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();

        stub = CommunicationGrpc.newBlockingStub(channel);

        System.out.println("HEER");

        VoidConfirmation x = stub.requestStateChange(State.newBuilder().setState(1).build());

    }

}
