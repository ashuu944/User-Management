package ziaat.usermanagement.Dto.RegionAreaDto;

import lombok.Data;

@Data
public class UpdateRegionAreaDto {
    private Long regionAreaId;
    private String regionAreaName;
    private Long createdBy;
}
