package ziaat.usermanagement.Dto.IdTypeDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetIdTypeDto {
    private Long idTypeId;
    private String idName;
    private Long createdBy;
    private boolean isActive;

}
