package ziaat.usermanagement.Dto.PermissionsDto;

import lombok.Data;

@Data
public class InsertPermissionsDto {
    private String permissionName;
    private Long createdBy;
    private Long permissionCatId;

}
