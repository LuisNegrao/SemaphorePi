package communication_proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: Communication.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommunicationGrpc {

  private CommunicationGrpc() {}

  public static final String SERVICE_NAME = "protoCommunication.Communication";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<communication_proto.VoidConfirmation,
      communication_proto.State> getGetCurrentStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentState",
      requestType = communication_proto.VoidConfirmation.class,
      responseType = communication_proto.State.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<communication_proto.VoidConfirmation,
      communication_proto.State> getGetCurrentStateMethod() {
    io.grpc.MethodDescriptor<communication_proto.VoidConfirmation, communication_proto.State> getGetCurrentStateMethod;
    if ((getGetCurrentStateMethod = CommunicationGrpc.getGetCurrentStateMethod) == null) {
      synchronized (CommunicationGrpc.class) {
        if ((getGetCurrentStateMethod = CommunicationGrpc.getGetCurrentStateMethod) == null) {
          CommunicationGrpc.getGetCurrentStateMethod = getGetCurrentStateMethod =
              io.grpc.MethodDescriptor.<communication_proto.VoidConfirmation, communication_proto.State>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  communication_proto.VoidConfirmation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  communication_proto.State.getDefaultInstance()))
              .setSchemaDescriptor(new CommunicationMethodDescriptorSupplier("getCurrentState"))
              .build();
        }
      }
    }
    return getGetCurrentStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<communication_proto.State,
      communication_proto.VoidConfirmation> getRequestStateChangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestStateChange",
      requestType = communication_proto.State.class,
      responseType = communication_proto.VoidConfirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<communication_proto.State,
      communication_proto.VoidConfirmation> getRequestStateChangeMethod() {
    io.grpc.MethodDescriptor<communication_proto.State, communication_proto.VoidConfirmation> getRequestStateChangeMethod;
    if ((getRequestStateChangeMethod = CommunicationGrpc.getRequestStateChangeMethod) == null) {
      synchronized (CommunicationGrpc.class) {
        if ((getRequestStateChangeMethod = CommunicationGrpc.getRequestStateChangeMethod) == null) {
          CommunicationGrpc.getRequestStateChangeMethod = getRequestStateChangeMethod =
              io.grpc.MethodDescriptor.<communication_proto.State, communication_proto.VoidConfirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "requestStateChange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  communication_proto.State.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  communication_proto.VoidConfirmation.getDefaultInstance()))
              .setSchemaDescriptor(new CommunicationMethodDescriptorSupplier("requestStateChange"))
              .build();
        }
      }
    }
    return getRequestStateChangeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommunicationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommunicationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommunicationStub>() {
        @java.lang.Override
        public CommunicationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommunicationStub(channel, callOptions);
        }
      };
    return CommunicationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommunicationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommunicationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommunicationBlockingStub>() {
        @java.lang.Override
        public CommunicationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommunicationBlockingStub(channel, callOptions);
        }
      };
    return CommunicationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommunicationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommunicationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommunicationFutureStub>() {
        @java.lang.Override
        public CommunicationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommunicationFutureStub(channel, callOptions);
        }
      };
    return CommunicationFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommunicationImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCurrentState(communication_proto.VoidConfirmation request,
        io.grpc.stub.StreamObserver<communication_proto.State> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentStateMethod(), responseObserver);
    }

    /**
     */
    public void requestStateChange(communication_proto.State request,
        io.grpc.stub.StreamObserver<communication_proto.VoidConfirmation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestStateChangeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrentStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                communication_proto.VoidConfirmation,
                communication_proto.State>(
                  this, METHODID_GET_CURRENT_STATE)))
          .addMethod(
            getRequestStateChangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                communication_proto.State,
                communication_proto.VoidConfirmation>(
                  this, METHODID_REQUEST_STATE_CHANGE)))
          .build();
    }
  }

  /**
   */
  public static final class CommunicationStub extends io.grpc.stub.AbstractAsyncStub<CommunicationStub> {
    private CommunicationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommunicationStub(channel, callOptions);
    }

    /**
     */
    public void getCurrentState(communication_proto.VoidConfirmation request,
        io.grpc.stub.StreamObserver<communication_proto.State> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void requestStateChange(communication_proto.State request,
        io.grpc.stub.StreamObserver<communication_proto.VoidConfirmation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestStateChangeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommunicationBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommunicationBlockingStub> {
    private CommunicationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommunicationBlockingStub(channel, callOptions);
    }

    /**
     */
    public communication_proto.State getCurrentState(communication_proto.VoidConfirmation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentStateMethod(), getCallOptions(), request);
    }

    /**
     */
    public communication_proto.VoidConfirmation requestStateChange(communication_proto.State request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestStateChangeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommunicationFutureStub extends io.grpc.stub.AbstractFutureStub<CommunicationFutureStub> {
    private CommunicationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommunicationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<communication_proto.State> getCurrentState(
        communication_proto.VoidConfirmation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<communication_proto.VoidConfirmation> requestStateChange(
        communication_proto.State request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestStateChangeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_STATE = 0;
  private static final int METHODID_REQUEST_STATE_CHANGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommunicationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommunicationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT_STATE:
          serviceImpl.getCurrentState((communication_proto.VoidConfirmation) request,
              (io.grpc.stub.StreamObserver<communication_proto.State>) responseObserver);
          break;
        case METHODID_REQUEST_STATE_CHANGE:
          serviceImpl.requestStateChange((communication_proto.State) request,
              (io.grpc.stub.StreamObserver<communication_proto.VoidConfirmation>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CommunicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommunicationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return communication_proto.AndroidGRPCCommunication.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Communication");
    }
  }

  private static final class CommunicationFileDescriptorSupplier
      extends CommunicationBaseDescriptorSupplier {
    CommunicationFileDescriptorSupplier() {}
  }

  private static final class CommunicationMethodDescriptorSupplier
      extends CommunicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommunicationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommunicationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommunicationFileDescriptorSupplier())
              .addMethod(getGetCurrentStateMethod())
              .addMethod(getRequestStateChangeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
