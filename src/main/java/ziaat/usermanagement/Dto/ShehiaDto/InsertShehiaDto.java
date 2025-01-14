package ziaat.usermanagement.Dto.ShehiaDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InsertShehiaDto {
    private String shehiaName;
    private Long createdBy;
    private Long distId;
}
