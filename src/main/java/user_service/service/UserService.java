package user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import user_service.dto.LoginRequest;
import user_service.model.Users;
import user_service.repository.UserRepository;
import user_service.util.ResponseStructure;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AuthenticationManager authManager;

    public ResponseStructure<Users> register(Users user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        ResponseStructure<Users> rs = new ResponseStructure<Users>();
        rs.setData(user);
        rs.setMessage("User Registered");
        rs.setStatusCode(HttpStatus.CREATED.value());
        return rs;
    }

//    public ResponseStructure<Users> login(LoginRequest loginRequest) {
//        Users userFromDb = userRepo.findUserByUsername(loginRequest.getUsername());
//        ResponseStructure<Users> rs = new ResponseStructure<Users>();
//        if(userFromDb == null){
//            rs.setMessage("User not found");
//            rs.setStatusCode(HttpStatus.NOT_FOUND.value());
//        } else if(userFromDb.getPassword().equals(loginRequest.getPassword())){
//            rs.setMessage("Login Successful");
//            rs.setStatusCode(HttpStatus.OK.value());
//            rs.setData(userFromDb);
//        } else {
//            rs.setMessage("Invalid Password");
//            rs.setStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }
//        return rs;
//    }
    public String login(LoginRequest loginRequest){
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        if(authentication.isAuthenticated()){
            return "Login Successful";
        } else {
            return "FaiL";
        }
    }
}
