package ziaat.usermanagement.Dto.UsersDto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class GetUsersDto {
    private Long userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private Date dob;
    private String phoneNumber;
    private String identityNumber;
    private String email;
    private String country;
    private Long departmentId;
    private String departmentName;
    private Long designationId;
    private String designationName;
    private Long idTypeId;
    private String idName;
    private Long shehiaId;
    private String shehiaName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
}
