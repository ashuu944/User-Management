package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.RegionArea;

import java.util.List;

@Repository
public interface RegionAreaRepository extends JpaRepository<RegionArea,Long> {
    List<RegionArea> findByIsActive(boolean b);
}
