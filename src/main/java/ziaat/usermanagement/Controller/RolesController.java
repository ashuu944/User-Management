package ziaat.usermanagement.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.RolesDto.GetRolesDto;
import ziaat.usermanagement.Dto.RolesDto.InsertRolesDto;
import ziaat.usermanagement.Dto.RolesDto.UpdateRolesDto;
import ziaat.usermanagement.Service.RolesService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RolesController {
    @Autowired
    private RolesService service;

    @Autowired
    private MessageResult messageResult;

    @PostMapping("/roles")
    public GetRolesDto insertRoles (@RequestBody InsertRolesDto req){
        return service.insertRole(req);
    }

    @GetMapping("/roles")
    public List<GetRolesDto> getAllRoles(){

        return service.getAllRoles();
    }

    @GetMapping("/activeRoles")
    public List<GetRolesDto> getAllActiveRoles(){

        return service.getAllActiveRoles();
    }

    @GetMapping("/roles/{id}")
    public GetRolesDto getRolesById(@PathVariable Long id){

        return service.getRolesById(id);
    }

    @PutMapping("/roles")
    public GetRolesDto updateRoles(@RequestBody UpdateRolesDto req){
        return service.updateRoles(req);
    }

    @PutMapping("/roles/{id}")
    public GetRolesDto deleteRoles(@PathVariable Long id){

        return service.deleteRoles(id);
    }
}
