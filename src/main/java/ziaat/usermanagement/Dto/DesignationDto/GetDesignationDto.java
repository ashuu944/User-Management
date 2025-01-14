package ziaat.usermanagement.Dto.DesignationDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class GetDesignationDto {
    private Long designationId;
    private String designationName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
}
