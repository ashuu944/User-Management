package ziaat.usermanagement.Dto.RegionDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateRegionDto {
    private Long regionId;
    private String regionName;
    private Long createdBy;
    private Long regAreaId;
}
