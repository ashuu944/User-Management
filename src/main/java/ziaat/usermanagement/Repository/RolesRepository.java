package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.Roles;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    List<Roles> findByIsActive(boolean b);
}
