package ziaat.usermanagement.Dto.RegionDto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InsertRegionDto {
    private String regionName;
    private Long createdBy;
    private Long regAreaId;
}
