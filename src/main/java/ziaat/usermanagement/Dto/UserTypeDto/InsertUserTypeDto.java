package ziaat.usermanagement.Dto.UserTypeDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class InsertUserTypeDto {
    private String userTypeName;
    private Long createdBy;
}
