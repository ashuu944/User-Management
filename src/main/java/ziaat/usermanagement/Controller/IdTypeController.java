package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.DepartmentDto.GetDepartmentDto;
import ziaat.usermanagement.Dto.DesignationDto.GetDesignationDto;
import ziaat.usermanagement.Dto.IdTypeDto.GetIdTypeDto;
import ziaat.usermanagement.Dto.IdTypeDto.InsertIdTypeDto;
import ziaat.usermanagement.Dto.IdTypeDto.UpdateIdTypeDto;
import ziaat.usermanagement.Service.IdTypeService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class IdTypeController {
    @Autowired
    private IdTypeService idService;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/idtype")
    public GetIdTypeDto insertIdType (@RequestBody InsertIdTypeDto req){
        return idService.insertIdType(req);
    }

    @GetMapping("/idtype")
    public List<GetIdTypeDto> getAllIdType(){
        return idService.getAllIdType();
    }

    @GetMapping("/activeIdType")
    public List<GetIdTypeDto> getAllActiveIdType(){
        return idService.getAllActiveIdType();
    }


    @GetMapping("/idtypeById/{id}")
    public GetIdTypeDto getIdTypeById(@PathVariable Long id){
        return idService.getIdTypeTypeById(id);
    }

    @PutMapping("/idtype")
    public GetIdTypeDto updateIdType(@RequestBody UpdateIdTypeDto req){
        return idService.updateIdType(req);
    }


    @PutMapping("/idtype/{id}")
    public GetIdTypeDto deleteIdType(@PathVariable Long id){
        return idService.deleteIdType(id);
    }

}

