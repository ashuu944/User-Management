package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.UserType;

import java.util.List;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType,Long> {
    List<UserType> findByIsActive(boolean b);
}
