package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.Region;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {
    List<Region> findByIsActive(boolean b);
}
