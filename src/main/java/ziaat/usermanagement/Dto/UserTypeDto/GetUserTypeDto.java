package ziaat.usermanagement.Dto.UserTypeDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class GetUserTypeDto {
    private Long userTypeId;
    private String userTypeName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
}
