package com.se.android;

import com.se.pi.Simulation;
import communication_proto.CommunicationGrpc;

import communication_proto.State;
import communication_proto.VoidConfirmation;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Endpoint {

    private static Logger logger = Logger.getLogger(Endpoint.class.getName());
    private Server server;
    EndpointImpl endpointCommunication = new EndpointImpl();
    private static Simulation simulation;

    public Endpoint(Simulation _simulation) {
        simulation = _simulation;
    }

    public void start() throws IOException {

        int port = 8080;
        server = ServerBuilder.forPort(port)
                .addService(endpointCommunication)
                .build()
                .start();

        logger.info("Server started on port: " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                Endpoint.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));

    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    static class EndpointImpl extends CommunicationGrpc.CommunicationImplBase {
        @Override
        public void getCurrentState(VoidConfirmation request, StreamObserver<State> responseObserver) {

            State state = State.newBuilder().setState(1).build();
            responseObserver.onNext(state);
            responseObserver.onCompleted();

        }

        @Override
        public void requestStateChange(State request, StreamObserver<VoidConfirmation> responseObserver) {
            try {
                simulation.requestStateChange(request.getState());
            } catch (IOException e) {
                e.printStackTrace();
            }
            responseObserver.onNext(VoidConfirmation.newBuilder().build());
            responseObserver.onCompleted();
        }
    }

}
