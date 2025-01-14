package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.ShehiaDto.GetShehiaDto;
import ziaat.usermanagement.Dto.ShehiaDto.InsertShehiaDto;
import ziaat.usermanagement.Dto.ShehiaDto.UpdateShehiaDto;
import ziaat.usermanagement.Service.ShehiaService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ShehiaController {
    @Autowired
    private ShehiaService service;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/shehia")
    public GetShehiaDto insertShehia(@RequestBody InsertShehiaDto req){

        return service.insertShehia(req);
    }

    @GetMapping("/shehia")
    public List<GetShehiaDto> getAllShehia(){

        return service.getAllShehia();
    }
    @GetMapping("/activeShehia")
    public List<GetShehiaDto> getAllActiveShehia(){
        return service.getAllActiveShehia();
    }

    @GetMapping("/shehia/{id}")
    public GetShehiaDto getShehiatById(@PathVariable Long id){

        return service.getShehiaById(id);
    }

    @PutMapping("/shehia")
    public GetShehiaDto updateSheia(@RequestBody UpdateShehiaDto req){

        return service.updateShehia(req);
    }

    @PutMapping("/shehia/{id}")
    public GetShehiaDto deleteShehia(@PathVariable Long id){

        return service.deleteShehia(id);
    }


}
