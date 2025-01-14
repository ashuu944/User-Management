package ziaat.usermanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table
@Entity
public class RolePermissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolePermissionId;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "role_id", nullable = false)
    private Roles roles;

    @ManyToOne()
    @JoinColumn(name = "permission_id", nullable = false)
    private Permissions permissions;

}
