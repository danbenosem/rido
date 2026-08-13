package ng.Rido.data.repositories;

import ng.Rido.data.models.User;

import java.util.List;

public interface UserRepository  {

    User save (User user);
    void update(int id,User user);
    User findById(long id);
    User findByUserName(String userName);
    List<User> findAll();
    void deleteById(long id);
    void deleteAll();
    User findByEmail(String email);





}
