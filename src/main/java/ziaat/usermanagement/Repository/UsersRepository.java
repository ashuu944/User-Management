package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.Users;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    List<Users> findByIsActive(boolean b);
}
