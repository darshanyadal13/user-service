package user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import user_service.dao.UserDao;
import user_service.model.Users;
import user_service.util.ResponseStructure;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public ResponseStructure<Users> register(Users user) {
        userDao.register(user);
        ResponseStructure<Users> rs = new ResponseStructure<Users>();
        rs.setData(user);
        rs.setMessage("User Registered");
        rs.setStatusCode(HttpStatus.CREATED.value());
        return rs;
    }
}
