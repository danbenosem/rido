package ng.Rido.utils.mappers;

import ng.Rido.data.models.User;
import ng.Rido.dtos.requests.RegisterUserRequest;

public class UserMapper {

    public static User RegisterUserMapper(RegisterUserRequest request){

        User user = new User(request.getUsername(), request.getPassword(), request.getEmail());

        return user;

    }


//    public static String RegisterUserResponse(User user){
//
//
//      }

}
