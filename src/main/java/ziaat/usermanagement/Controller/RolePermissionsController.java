package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.RolePermissionsDto.GetRolePermissionsDto;
import ziaat.usermanagement.Dto.RolePermissionsDto.InsertRolePermissionsDto;
import ziaat.usermanagement.Dto.RolePermissionsDto.UpdateRolePermissionsDto;
import ziaat.usermanagement.Service.RolePermissionsService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RolePermissionsController {
    @Autowired
    private RolePermissionsService service;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/rolePermissions")
    public GetRolePermissionsDto insertRolePermissions(@RequestBody InsertRolePermissionsDto req){

        return service.insertRolePermissions(req);
    }

    @GetMapping("/rolePermissions")
    public List<GetRolePermissionsDto> getAllRolePermissions(){

        return service.getAllRolePermissions();
    }
    @GetMapping("/activerolePermissions")
    public List<GetRolePermissionsDto> getAllActiveRolePermissions(){
        return service.getAllActiveRolePermissions();
    }

    @GetMapping("/rolePermissions/{id}")
    public GetRolePermissionsDto getRolePermissionsById(@PathVariable Long id){

        return service.getRolePermissionsById(id);
    }

    @PutMapping("/rolePermissions")
    public GetRolePermissionsDto updateRolePermissions(@RequestBody UpdateRolePermissionsDto req){

        return service.updateRolePermissions(req);
    }

    @PutMapping("/rolePermissions/{id}")
    public GetRolePermissionsDto deleteRolePermissions(@PathVariable Long id){

        return service.deleteRolePermissions(id);
    }



}
