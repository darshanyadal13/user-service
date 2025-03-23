package user_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import user_service.model.Users;
import user_service.repository.UserRepository;

@Repository
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    public void register(Users user){
        userRepository.save(user);
    }
}
