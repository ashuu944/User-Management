package ziaat.usermanagement.Dto.IdTypeDto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class InsertIdTypeDto {
    private Long idTypeId;
    private String idName;
    private Long createdBy;

}
