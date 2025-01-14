package ziaat.usermanagement.Dto.RolesDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetRolesDto {
    private Long roleId;
    private String roleName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
}
