package ziaat.usermanagement.Dto.UsersDto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class InsertUsersDto {
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
    private Long designationId;
    private Long idTypeId;
    private Long shehiaId;
    private Long createdBy;

}
