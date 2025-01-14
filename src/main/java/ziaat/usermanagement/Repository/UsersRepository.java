package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

}
