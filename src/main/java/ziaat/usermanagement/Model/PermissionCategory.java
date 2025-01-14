package ziaat.usermanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class PermissionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionCategoryId;
    @Column(nullable = false, unique = true)
    private String permissionCatName;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "permissionCategory")
    private List<Permissions> Permission;

}
