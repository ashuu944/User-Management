package ziaat.usermanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.PermissionCategory;

import java.util.List;

@Repository
public interface PermissionCategoryRepository extends JpaRepository<PermissionCategory,Long> {
    List<PermissionCategory> findByIsActive(boolean b);
}
