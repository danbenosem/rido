package ng.Rido.data.repositories;

import ng.Rido.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private  static int count=0;
    private static List<User>users = new ArrayList<>();



    @Override
    public User save(User user) {
        if(user.getUserName().isBlank()){
            throw new IllegalArgumentException("UserNameCannotBeEmpty");

        }
        if(findByUserName(user.getUserName())==null){
            user.setId(++count);
            users.add(user);

            return user;
        }
        return null;


    }
    @Override
    public User findByUserName(String userName ){
         for (User user: users ){
             if(user.getUserName().equalsIgnoreCase(userName)) return user;
         }
        return null;
    }



        @Override
        public void update( int id , User updatedUser) {
           for (int index=0; index<users.size(); index++){
               if(users.get(index).getId()==id){
                   updatedUser.setId(id);
                   users.set(index,updatedUser);}
           }

        }

    @Override
    public User findById(long id) {
        for(User user: users){
            if (user.getId()==id) return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void deleteById(long id) {
     User user= findById(id);
     if(user!=null) users.remove(user);


    }

    @Override
    public void deleteAll() {

        users.clear();

    }

    @Override
    public User findByEmail(String email) {
        for(User user : users){
            if(user.getEmail().equalsIgnoreCase(email)) return user;
        }
        return  null;
    }
}
