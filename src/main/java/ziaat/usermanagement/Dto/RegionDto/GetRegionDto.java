package ziaat.usermanagement.Dto.RegionDto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetRegionDto {
    private Long regionId;
    private String regionName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
    private Long regAreaId;
    private String regionAreaName;
}
