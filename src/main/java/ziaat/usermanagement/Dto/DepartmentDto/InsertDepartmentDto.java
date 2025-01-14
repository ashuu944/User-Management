package ziaat.usermanagement.Dto.DepartmentDto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class InsertDepartmentDto {
    private String deptName;
    private Long createdBy;
}
