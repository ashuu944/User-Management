package ziaat.usermanagement.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity

public class IdType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeId;
    @Column(nullable = false, unique = true)
    private String idName;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "idType")
    private List<Users> users;

}
