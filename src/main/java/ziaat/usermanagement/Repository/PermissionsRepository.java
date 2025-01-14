package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.Permissions;

import java.util.List;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions,Long> {


    List<Permissions> findByIsActive(boolean b);
}
