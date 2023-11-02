package ShuttleProject.Project1.Repositories;

import ShuttleProject.Project1.DataBases.User;
import ShuttleProject.Project1.DataBases.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface UserRepository extends JpaRepository<User, Integer> {


    List<User> findUserBySUID(Integer suid);
    List<User> findUserByAddress(String address);

    List<User> findUserByName(String name);
    User findBySUID(Integer SUID);

    User findByEmail(String email);

    List<User> findByUserStatus(UserStatus userStatus);


}

