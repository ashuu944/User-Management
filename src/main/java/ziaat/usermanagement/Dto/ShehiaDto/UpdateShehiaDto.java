package ziaat.usermanagement.Dto.ShehiaDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class UpdateShehiaDto {
    private Long shehiaId;
    private String shehiaName;
    private Long createdBy;
    private Long distId;
}
