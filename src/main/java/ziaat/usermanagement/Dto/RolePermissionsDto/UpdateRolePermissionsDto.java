package ziaat.usermanagement.Dto.RolePermissionsDto;

import lombok.Data;

@Data
public class UpdateRolePermissionsDto {
    private Long rolePermissionId;
    private Long roleId;
    private Long permissionId;
    private Long createdBy;
}
