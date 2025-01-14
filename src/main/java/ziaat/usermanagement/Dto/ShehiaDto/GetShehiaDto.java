package ziaat.usermanagement.Dto.ShehiaDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetShehiaDto {
    private Long shehiaId;
    private String shehiaName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
    private Long distId;
    private String distName;
}
