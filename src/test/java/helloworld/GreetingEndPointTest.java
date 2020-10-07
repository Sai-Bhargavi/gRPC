package helloworld;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class GreetingEndPointTest {
    @Inject
    GreeterGrpc.GreeterBlockingStub blockingStub;

    @Test
    public void testHello(){
        HelloRequest request=HelloRequest.newBuilder().setName("Sai Bhargavi").build();
        Assertions.assertEquals(blockingStub.sayHello(request).getMessage(),
                "Hello Dear Sai Bhargavi");

    }
}
