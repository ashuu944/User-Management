package ziaat.usermanagement.Dto.DesignationDto;

import lombok.Data;

@Data
public class UpdateDesignationDto {
    private Long designationId;
    private String designationName;
    private Long createdBy;
}
