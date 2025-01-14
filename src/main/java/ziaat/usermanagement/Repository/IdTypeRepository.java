package ziaat.usermanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.IdType;

import java.util.List;

@Repository
public interface IdTypeRepository extends JpaRepository<IdType,Long> {
    List<IdType> findByIsActive(boolean b);
}
