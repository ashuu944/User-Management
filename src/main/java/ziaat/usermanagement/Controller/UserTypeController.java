package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.RegionAreaDto.GetRegionAreaDto;
import ziaat.usermanagement.Dto.RegionAreaDto.InsertRegionAreaDto;
import ziaat.usermanagement.Dto.UserTypeDto.GetUserTypeDto;
import ziaat.usermanagement.Dto.UserTypeDto.InsertUserTypeDto;
import ziaat.usermanagement.Service.RegionAreaService;
import ziaat.usermanagement.Service.UserTypeService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserTypeController {

    @Autowired
    private UserTypeService service;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/userType")
    public GetUserTypeDto insertUserType (@RequestBody InsertUserTypeDto req){
        return service.insertUserType(req);
    }

    @GetMapping("/userType")
    public List<GetUserTypeDto> getAllUserType(){
        return service.getAllUserType();
    }

    @GetMapping("/activeUserType")
    public List<GetUserTypeDto> getAllActiveUserType(){
        return service.getAllActiveUserType();
    }

    @GetMapping("/userType/{id}")
    public GetUserTypeDto getUserTypeById(@PathVariable Long id){
        return service.getUserTypeId(id);
    }

    @PutMapping("/userType")
    public GetUserTypeDto updateUserType(@RequestBody GetUserTypeDto req){
        return service.updateUserType(req);
    }

    @PutMapping("/userType/{id}")
    public GetUserTypeDto deleteUserType(@PathVariable Long id){
        return service.deleteUserType(id);
    }

}
