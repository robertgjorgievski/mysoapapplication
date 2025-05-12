package org.example.endpoint;

import com.example.soap.model.GetUserRequest;
import com.example.soap.model.GetUserResponse;
import com.example.soap.model.User;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/springboot/soap/service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();

        // Create user (in real app, fetch from service)
        User user = new User();
        user.setId(request.getUserId());
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        response.setUser(user);
        return response;
    }
}
