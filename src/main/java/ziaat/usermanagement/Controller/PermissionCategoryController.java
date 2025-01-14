package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.DesignationDto.GetDesignationDto;
import ziaat.usermanagement.Dto.PermissionCategoryDto.GetPermissionCategoryDto;
import ziaat.usermanagement.Dto.PermissionCategoryDto.InsertPermissionCategoryDto;
import ziaat.usermanagement.Dto.PermissionCategoryDto.UpdatePermissionCategoryDto;
import ziaat.usermanagement.Service.PermissionCategoryService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PermissionCategoryController {
    @Autowired
    private PermissionCategoryService service;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/permissionCategory")
    public GetPermissionCategoryDto insertPermissionCategory (@RequestBody InsertPermissionCategoryDto req){
        return service.insertPermissionCategory(req);
    }

    @GetMapping("/permissionCategory")
    public List<GetPermissionCategoryDto> getAllPermissionCategory(){
        return service.getAllPermissionCategory();
    }

    @GetMapping("/activePermissionCategory")
    public List<GetPermissionCategoryDto> getAllActivePermissionCategory(){
        return service.getAllActivePermissionCategory();
    }


    @GetMapping("/permissionCategoryById/{id}")
    public GetPermissionCategoryDto getPermissionCategoryById(@PathVariable Long id){
        return service.getPermissionCategoryById(id);
    }

    @PutMapping("/permissionCategory")
    public GetPermissionCategoryDto updatePermissionCategory(@RequestBody UpdatePermissionCategoryDto req){
        return service.updatePermissionCategory(req);
    }

    @PutMapping("/permissionCategory/{id}")
    public GetPermissionCategoryDto deletePermissionCategory(@PathVariable Long id){
        return service.deletePermissionCategory(id);
    }
}
