package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.Designation;

import java.util.List;

@Repository
public interface DesignationRepository extends JpaRepository<Designation,Long> {
    List<Designation> findByIsActive(boolean b);
}
