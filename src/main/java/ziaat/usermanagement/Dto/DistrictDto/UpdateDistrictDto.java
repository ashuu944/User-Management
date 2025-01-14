package ziaat.usermanagement.Dto.DistrictDto;

import lombok.Data;

@Data
public class UpdateDistrictDto {
    private  Long districtId;
    private String districtName;
    private Long createdBy;
    private Long regId;
}
