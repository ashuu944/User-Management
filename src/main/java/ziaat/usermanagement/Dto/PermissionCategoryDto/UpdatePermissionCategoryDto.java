package ziaat.usermanagement.Dto.PermissionCategoryDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdatePermissionCategoryDto {
    private Long permissionCategoryId;
    private String permissionCatName;
    private Long createdBy;
}
