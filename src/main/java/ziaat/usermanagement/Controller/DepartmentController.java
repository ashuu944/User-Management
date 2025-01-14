package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.DepartmentDto.GetDepartmentDto;
import ziaat.usermanagement.Dto.DepartmentDto.InsertDepartmentDto;
import ziaat.usermanagement.Dto.DepartmentDto.UpdateDepartmentDto;
import ziaat.usermanagement.Service.DepartmentService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class DepartmentController {

    @Autowired
    private DepartmentService deptServ;

    @Autowired
    private MessageResult messageResult;

    @PostMapping("/department")
    public GetDepartmentDto insertDepartment (@RequestBody InsertDepartmentDto req){
        return deptServ.insertDepartment(req);
    }

    @GetMapping("/department")
    public List<GetDepartmentDto> getAllDepartment(){
        return deptServ.getAllDepartment();
    }

    @GetMapping("/activeDepartment")
    public List<GetDepartmentDto> getAllActiveDepartment(){
        return deptServ.getAllActiveDepartment();
    }

    @GetMapping("/departmentById/{id}")
    public GetDepartmentDto getDepartmentById(@PathVariable Long id){
        return deptServ.getDepartmentById(id);
    }

    @PutMapping("/department")
    public GetDepartmentDto updateDepartment(@RequestBody UpdateDepartmentDto req){
        return deptServ.updateDepartment(req);
    }

    @PutMapping("/department/{id}")
    public GetDepartmentDto deleteDepartment(@PathVariable Long id){
        return deptServ.deleteDepartment(id);
    }
}
