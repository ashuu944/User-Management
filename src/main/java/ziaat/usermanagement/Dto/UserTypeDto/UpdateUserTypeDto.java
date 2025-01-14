package ziaat.usermanagement.Dto.UserTypeDto;

import lombok.Data;

@Data
public class UpdateUserTypeDto {
    private Long userTypeId;
    private String userTypeName;
    private Long createdBy;
}
