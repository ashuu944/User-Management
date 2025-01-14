package ziaat.usermanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class RegionArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionAreaId;
    @Column(nullable = false, unique = true)
    private String regionAreaName;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;


    @OneToMany(mappedBy = "regionArea")
    private List<Region> Region;
}
