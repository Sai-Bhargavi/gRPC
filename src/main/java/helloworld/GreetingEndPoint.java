package helloworld;

import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class GreetingEndPoint extends GreeterGrpc.GreeterImplBase{
GreetingService greetingService;
GreetingEndPoint(GreetingService service){
    this.greetingService = service;
}
@Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> response){
    String message = greetingService.sayHello(request.getName());
    HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
    response.onNext(reply);
    response.onCompleted();
}
}
