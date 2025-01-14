package ziaat.usermanagement.Dto.PermissionsDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetPermissionsDto {
    private Long permissionId;
    private String permissionName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
    private Long permissionCatId;
    private String permissionCatName;
}
