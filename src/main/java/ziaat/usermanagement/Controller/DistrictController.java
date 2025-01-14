package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.DistrictDto.GetDistrictDto;
import ziaat.usermanagement.Dto.DistrictDto.InsertDistrictDto;
import ziaat.usermanagement.Dto.DistrictDto.UpdateDistrictDto;
import ziaat.usermanagement.Service.DistrictService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DistrictController {

    @Autowired
    private DistrictService service;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/district")
    public GetDistrictDto insertDistrict(@RequestBody InsertDistrictDto req){

        return service.insertDistrict(req);
    }

    @GetMapping("/district")
    public List<GetDistrictDto> getAllDistrict(){

        return service.getAllDistrict();
    }
    @GetMapping("/activeDistrict")
    public List<GetDistrictDto> getAllActiveDistrict(){
        return service.getAllActiveDistrict();
    }

    @GetMapping("/district/{id}")
    public GetDistrictDto getDistrictById(@PathVariable Long id){

        return service.getDistrictById(id);
    }

    @PutMapping("/district")
    public GetDistrictDto updateDistrict(@RequestBody UpdateDistrictDto req){

        return service.updateDistrict(req);
    }

    @PutMapping("/district/{id}")
    public GetDistrictDto deleteDistrict(@PathVariable Long id){

        return service.deleteDistrict(id);
    }


}
