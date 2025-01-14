package ziaat.usermanagement.Dto.DepartmentDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class GetDepartmentDto {
        private Long deptId;
        private String deptName;
        private Long createdBy;
        private LocalDateTime createAt;
        private boolean isActive;

}
