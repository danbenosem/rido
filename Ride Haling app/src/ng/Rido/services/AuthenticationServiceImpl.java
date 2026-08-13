package ng.Rido.services;

import ng.Rido.data.models.User;
import ng.Rido.data.repositories.UserRepository;
import ng.Rido.data.repositories.UserRepositoryImpl;
import ng.Rido.dtos.requests.LoginUserRequest;
import ng.Rido.dtos.requests.RegisterUserRequest;
import ng.Rido.dtos.responses.LoginUserResponse;
import ng.Rido.dtos.responses.RegisterUserResponse;
import ng.Rido.utils.mappers.UserMapper;

public class AuthenticationServiceImpl implements AuthenticationService {
    private UserRepository userRepository= new UserRepositoryImpl();


    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        RegisterUserResponse response = new RegisterUserResponse();

        response.setFailureMessage("username is already registered");

        if (userRepository.findByUserName(request.getUsername())!=null) return response;
        if(userRepository.findByEmail(request.getEmail())!=null) return response;
        if((request.getUsername()).isBlank()){
            response.setFailureMessage("Username cannot be empty");
            return response;}

        User user = UserMapper.RegisterUserMapper(request);

        userRepository.save(user);

        response.setSuccessMessage();

        return  response;

    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) {
        User user= userRepository.findByUserName(request.getUsername());
         LoginUserResponse response = new LoginUserResponse();
         response.setFailureMessage("unRegistered user cannot login");
        if (user==null) return response;

        boolean validatePassword= user.validate_password(request.getPassword());
        response.setFailureMessage("incorrect credentials");
        if( !validatePassword) return  response;

        user.setLoggedIn(true);
        response.getSuccessMessage();
    return response ;


    }

    @Override
    public String logout(String userName) {
        return "";
    }
}
