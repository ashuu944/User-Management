package ziaat.usermanagement.Controller;

import org.apache.commons.collections4.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.DepartmentDto.GetDepartmentDto;
import ziaat.usermanagement.Dto.DesignationDto.GetDesignationDto;
import ziaat.usermanagement.Dto.DesignationDto.InsertDesignationDto;
import ziaat.usermanagement.Dto.DesignationDto.UpdateDesignationDto;
import ziaat.usermanagement.Service.DesignationService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class DesignationController {

    @Autowired
    private DesignationService deService;

    @Autowired
    private MessageResult messageResult;

    @PostMapping("/designation")
    public GetDesignationDto insertDesignation(@RequestBody InsertDesignationDto req){
        return deService.insertDesignation(req);
    }

    @GetMapping("/designation")
    public List<GetDesignationDto> getAllDesignation(){
        return deService.getAllDesignation();
    }

    @GetMapping("/activeDesignation")
    public List<GetDesignationDto> getAllActiveDesignation(){
        return deService.getAllActiveDesignation();
    }

    @GetMapping("/designationById/{id}")
    public GetDesignationDto getDesignationById(@PathVariable Long id){
        return deService.getDesignationById(id);
    }

    @PutMapping("/designation")
    public GetDesignationDto updateDesignation(@RequestBody UpdateDesignationDto req){
        return deService.updateDesignation(req);
    }

    @PutMapping("/designation/{id}")
    public GetDesignationDto deleteDesignation(@PathVariable Long id){
        return deService.deleteDesignation(id);
    }

}
