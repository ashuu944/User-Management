package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.RolePermissions;

import java.util.List;

@Repository
public interface RolePermissionsRepository extends JpaRepository<RolePermissions, Long> {
    List<RolePermissions> findByIsActive(boolean b);
}
