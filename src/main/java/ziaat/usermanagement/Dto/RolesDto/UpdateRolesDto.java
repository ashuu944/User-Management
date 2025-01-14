package ziaat.usermanagement.Dto.RolesDto;

import lombok.Data;

@Data
public class UpdateRolesDto {
    private Long roleId;
    private String roleName;
    private Long createdBy;
}
