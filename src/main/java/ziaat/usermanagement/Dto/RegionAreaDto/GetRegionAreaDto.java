package ziaat.usermanagement.Dto.RegionAreaDto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class GetRegionAreaDto {
    private Long regionAreaId;
    private String regionAreaName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
}
