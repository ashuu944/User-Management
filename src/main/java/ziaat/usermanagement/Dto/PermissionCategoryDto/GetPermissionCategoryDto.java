package ziaat.usermanagement.Dto.PermissionCategoryDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class GetPermissionCategoryDto {
    private Long permissionCategoryId;
    private String permissionCatName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
}
