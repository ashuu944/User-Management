package ziaat.usermanagement.Dto.RolePermissionsDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetRolePermissionsDto {

    private Long rolePermissionId;
    private Long roleId;
    private String roleName;
    private Long permissionId;
    private String permissionName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
}
