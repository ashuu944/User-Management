package ziaat.usermanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;
    @Column(nullable = false, unique = true)
    private String permissionName;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "permission_cat_id", nullable = false)
    private PermissionCategory permissionCategory;

    @OneToMany(mappedBy = "permissions")
    private List<RolePermissions> rolePermissions;
}
