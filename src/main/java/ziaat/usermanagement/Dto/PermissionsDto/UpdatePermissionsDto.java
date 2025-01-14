package ziaat.usermanagement.Dto.PermissionsDto;

import lombok.Data;
import ziaat.usermanagement.Model.PermissionCategory;

@Data
public class UpdatePermissionsDto {
    private Long permissionId;
    private Long permissionCatId;
    private String permissionName;
    private Long createdBy;

}
