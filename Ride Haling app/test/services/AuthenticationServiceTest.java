package services;

import ng.Rido.data.models.User;
import ng.Rido.data.repositories.UserRepository;
import ng.Rido.data.repositories.UserRepositoryImpl;
import ng.Rido.dtos.requests.LoginUserRequest;
import ng.Rido.dtos.requests.RegisterUserRequest;
import ng.Rido.dtos.responses.LoginUserResponse;
import ng.Rido.dtos.responses.RegisterUserResponse;
import ng.Rido.services.AuthenticationService;
import ng.Rido.services.AuthenticationServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticationServiceTest {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Test

    public void testThatUsersCanBeRegisteredSuccessFully() {
        AuthenticationService registeredUser = new AuthenticationServiceImpl();
        RegisterUserRequest request = new RegisterUserRequest();

        request.setUsername("dan");
        request.setEmail("Dan@gmail.com");
        request.setPassword("1234");

        RegisterUserResponse result = registeredUser.register(request);

        int size = userRepository.findAll().size();

        assertEquals(1, size);
    }


    @Test
    public void testThatRegisteredUserCannot_RegisterAgain() {
        AuthenticationService registeredUser = new AuthenticationServiceImpl();
        RegisterUserRequest request = new RegisterUserRequest();

        request.setUsername("dan");
        request.setEmail("Dan@gmail.com");
        request.setPassword("1234");

        RegisterUserResponse result = registeredUser.register(request);

        int size = userRepository.findAll().size();

        assertEquals(1, size);


        RegisterUserResponse secondResult = registeredUser.register(request);
        int secondSize = userRepository.findAll().size();
        assertEquals(1, secondSize);


    }


    @Test
    public void testThatDiffrentUsersCannotRegisterWithTheSameEmail() {
        AuthenticationService registeredUser = new AuthenticationServiceImpl();
        RegisterUserRequest request = new RegisterUserRequest();

        request.setUsername("dan");
        request.setEmail("Dan@gmail.com");
        request.setPassword("1234");

        RegisterUserResponse result = registeredUser.register(request);

        int size = userRepository.findAll().size();

        assertEquals(1, size);

        RegisterUserRequest request2 = new RegisterUserRequest();

        request2.setUsername("frank");
        request2.setEmail("Dan@gmail.com");
        request2.setPassword("1234");
        RegisterUserResponse secondResult = registeredUser.register(request2);
        int secondSize = userRepository.findAll().size();
        assertEquals(1, secondSize);
    }

    public AuthenticationService RegisterUser() {

        AuthenticationService registeredUser = new AuthenticationServiceImpl();
        RegisterUserRequest request = new RegisterUserRequest();

        request.setUsername("dan");
        request.setEmail("Dan@gmail.com");
        request.setPassword("1234");

        RegisterUserResponse result = registeredUser.register(request);
        return registeredUser;

    }


    @Test
    public void testThatUserCannotRegisterWithEmptyUsername() {
        AuthenticationService registeredUser = new AuthenticationServiceImpl();
        RegisterUserRequest request = new RegisterUserRequest();

        request.setUsername("");
        request.setEmail("Dan@gmail.com");
        request.setPassword("1234");

        RegisterUserResponse result = registeredUser.register(request);

        int size = userRepository.findAll().size();

        assertEquals(0, size);

    }

    @Test
    public void testThatRegisteredUserCanLogin() {

        AuthenticationService registeredUser = RegisterUser();

        LoginUserRequest loginRequest = new LoginUserRequest();
        loginRequest.setPassword("1234");
        loginRequest.setUsername("dan");

        LoginUserResponse result = registeredUser.login(loginRequest);

        User user = userRepository.findByUserName("dan");
        assertTrue(user.isLoggedIn());
    }

    @Test
    public void testThatUnRegisteredUserCannotLogin() {

        AuthenticationService registeredUser = new AuthenticationServiceImpl();

        LoginUserRequest loginRequest = new LoginUserRequest();
        loginRequest.setPassword("1234");
        loginRequest.setUsername("john");

        LoginUserResponse result = registeredUser.login(loginRequest);

        assertEquals("unRegistered user cannot login", result.getFailureMessage());
    }


    @Test

    public void testThatRegisteredUserCannotLoginWithIncorrectPassword() {

        AuthenticationService registeredUser = RegisterUser();
        LoginUserRequest loginRequest = new LoginUserRequest();
        loginRequest.setPassword("1334");
        loginRequest.setUsername("dan");

        LoginUserResponse result = registeredUser.login(loginRequest);

        assertEquals("incorrect credentials", result.getFailureMessage());


    }
}
