package ziaat.usermanagement.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class Shehia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shehiaId;
    @Column(nullable = false, unique = true)
    private String shehiaName;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @OneToMany(mappedBy = "shehia")
    private List<Users> users;
}
