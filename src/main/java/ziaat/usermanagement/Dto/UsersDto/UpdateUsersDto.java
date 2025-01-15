package ziaat.usermanagement.Dto.UsersDto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateUsersDto {
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
    private Long designationId;
    private Long idTypeId;
    private Long shehiaId;
    private Long createdBy;
}
