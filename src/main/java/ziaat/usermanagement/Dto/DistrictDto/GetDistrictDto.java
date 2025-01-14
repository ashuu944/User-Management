package ziaat.usermanagement.Dto.DistrictDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetDistrictDto {
    private Long districtId;
    private String districtName;
    private Long createdBy;
    private LocalDateTime createAt;
    private boolean isActive;
    private Long regId;
    private String regName;
}
