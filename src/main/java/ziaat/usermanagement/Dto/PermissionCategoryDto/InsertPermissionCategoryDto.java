package ziaat.usermanagement.Dto.PermissionCategoryDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class InsertPermissionCategoryDto {
    private String permissionCatName;
    private Long createdBy;
}
