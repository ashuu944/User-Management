package ziaat.usermanagement.Dto.DistrictDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class InsertDistrictDto {
    private String districtName;
    private Long createdBy;
    private Long regId;
}
