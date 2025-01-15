package ziaat.usermanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@Table
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAccountId;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String passwordToken;
    @Column(nullable = false)
    private Boolean isBlocked;
    @Column(nullable = false)
    private Integer numberOfAttempts;
    @Column(nullable = true)
    private Time blockedTime;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles roles;
}
