package user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user_service.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
