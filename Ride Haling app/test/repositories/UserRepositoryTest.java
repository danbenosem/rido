package repositories;

import ng.Rido.data.models.User;
import ng.Rido.data.repositories.UserRepository;
import ng.Rido.data.repositories.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryTest {

    private UserRepository userRepository;
    private User user;
    @BeforeEach

    public void setUp(){
     userRepository = new UserRepositoryImpl();
         user = new User("Benjamin", "1234", "dan@gmail.com");
    }



    @Test
    public void testThatUserCanBeSaved(){

        User savedUser=  userRepository.save(user);
        assertEquals(1,savedUser.getId());
    }

    @Test
    public void testThatUserCanBeFoundByUserName(){
        userRepository.save(user);
        User savedUser= userRepository.findByUserName(user.getUserName());
        assertEquals("Benjamin",savedUser.getUserName() );
    }

    @Test
    public void testThatUserCanBefoundById(){
        userRepository.save(user);
        assertEquals(user, userRepository.findById(1));
        User user2 =  new User("messi", "1234", "dan@gmail.com");
        userRepository.save(user2);
        assertEquals(user2, userRepository.findById(2));
    }

    @Test
    public void testThatAllSavedUsersCanBeFound(){
        userRepository.save(user);
        User user2 =  new User("messi", "1234", "dan@gmail.com");
        userRepository.save(user2);
        assertEquals(2, userRepository.findAll().size());
    }

    @Test

    public void testThatUserCanbeUpdated(){
         User firstUser= userRepository.save(user);
        User secondUser= new User("danlo", "1234", "dan@gmail.com");

        assertEquals(1,firstUser.getId());
        userRepository.update(firstUser.getId(),secondUser);
        assertEquals(   firstUser.getId(),secondUser.getId());

    }



    @Test

    public void testThatUserWithEmptyUserNameCannotBeSaved(){

        User firstUser= new User("", "1234", "dan@gmail.com");
        assertEquals(0,userRepository.findAll().size());

        User SecondUser= new User(" ", "1234", "dan@gmail.com");
        assertEquals(0,userRepository.findAll().size());
    }


}
