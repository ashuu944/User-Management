package ziaat.usermanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(nullable = true)
    private String address;
    @Column(nullable = true)
    private Date dob;
    @Column(nullable = true)
    private String phoneNumber;
    private String identityNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = true)
    private String country;
    @Column(nullable = false)
    private Long createdBy;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private boolean isActive;



    @ManyToOne
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "designation_id", nullable = true)
    private Designation designation;

    @ManyToOne
    @JoinColumn(name = "id_type_id", nullable = false)
    private IdType idType;

    @ManyToOne
    @JoinColumn(name = "shehia_id", nullable = true)
    private Shehia shehia;

}
