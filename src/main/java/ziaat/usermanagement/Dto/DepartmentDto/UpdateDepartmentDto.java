package ziaat.usermanagement.Dto.DepartmentDto;

import lombok.Data;

@Data
public class UpdateDepartmentDto {
    private Long deptId;
    private String deptName;
    private Long createdBy;
}

