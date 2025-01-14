package ziaat.usermanagement.Dto.DesignationDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class InsertDesignationDto {
    private String designationName;
    private Long createdBy;

}
