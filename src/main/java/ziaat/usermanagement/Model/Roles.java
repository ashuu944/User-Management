package ziaat.usermanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(nullable = false, unique = true)
    private String roleName;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;


    @OneToMany(mappedBy = "roles")
    private List<RolePermissions> rolePermissions;

    @OneToMany(mappedBy = "roles")
    private List<UserAccount> userAccount;
}
