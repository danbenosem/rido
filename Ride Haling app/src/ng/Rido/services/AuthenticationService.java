package ng.Rido.services;

import ng.Rido.dtos.requests.LoginUserRequest;
import ng.Rido.dtos.requests.RegisterUserRequest;
import ng.Rido.dtos.responses.LoginUserResponse;
import ng.Rido.dtos.responses.RegisterUserResponse;

public interface AuthenticationService {

    RegisterUserResponse register(RegisterUserRequest request);
    LoginUserResponse login(LoginUserRequest request);
    String logout(String userName);


}
