package ziaat.usermanagement.Dto.RolePermissionsDto;

import lombok.Data;


@Data
public class InsertRolePermissionsDto {
    private Long roleId;
    private Long permissionId;
    private Long createdBy;
}
