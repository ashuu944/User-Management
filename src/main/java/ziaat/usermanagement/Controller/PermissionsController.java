package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.PermissionsDto.GetPermissionsDto;
import ziaat.usermanagement.Dto.PermissionsDto.InsertPermissionsDto;
import ziaat.usermanagement.Dto.PermissionsDto.UpdatePermissionsDto;
import ziaat.usermanagement.Service.PermissionsService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PermissionsController {
    @Autowired
    private PermissionsService service;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/permissions")
    public GetPermissionsDto insertPermissions(@RequestBody InsertPermissionsDto req){
        return service.insertPermissions(req);
    }

    @GetMapping("/permissions")
    public List <GetPermissionsDto> getAllPermissions(){
        return service.getAllPermissions();
    }
    @GetMapping("/activePermissions")
    public List<GetPermissionsDto> getAllActivePermissions(){
        return service.getAllActivePermissions();
    }

    @GetMapping("/permissions/{id}")
    public GetPermissionsDto getPermissionsById(@PathVariable Long id){
        return service.getPermissionsById(id);
    }

    @PutMapping("/permissions")
    public GetPermissionsDto updatePermissions(@RequestBody UpdatePermissionsDto req){
        return service.updatePermissions(req);
    }

    @PutMapping("/permissions/{id}")
    public GetPermissionsDto deletePermissions(@PathVariable Long id){
        return service.deletePermissions(id);
    }

}
