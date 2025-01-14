package ziaat.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ziaat.usermanagement.Model.Shehia;

import java.util.List;

@Repository
public interface ShehiaRepository extends JpaRepository<Shehia, Long> {
    List<Shehia> findByIsActive(boolean b);
}
