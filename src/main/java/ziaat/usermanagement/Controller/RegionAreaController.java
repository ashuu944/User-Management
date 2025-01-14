package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.RegionAreaDto.GetRegionAreaDto;
import ziaat.usermanagement.Dto.RegionAreaDto.InsertRegionAreaDto;
import ziaat.usermanagement.Dto.RegionAreaDto.UpdateRegionAreaDto;
import ziaat.usermanagement.Service.RegionAreaService;
import ziaat.usermanagement.Utils.MessageResult;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RegionAreaController {
    @Autowired
    private RegionAreaService service;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/regionArea")
    public GetRegionAreaDto insertRegionArea (@RequestBody InsertRegionAreaDto req){
        return service.insertRegionArea(req);
    }

    @GetMapping("/regionArea")
    public List<GetRegionAreaDto> getAllRegionArea(){
        return service.getAllRegionArea();
    }

    @GetMapping("/activeRegionArea")
    public List<GetRegionAreaDto> getAllActiveRegionArea(){
        return service.getAllActiveRegionArea();
    }


    @GetMapping("/regionArea/{id}")
    public GetRegionAreaDto getRegionAreaById(@PathVariable Long id){
        return service.getRegionAreaById(id);
    }

    @PutMapping("/regionArea")
    public GetRegionAreaDto updateRegionArea(@RequestBody UpdateRegionAreaDto req){
        return service.updateRegionArea(req);
    }

    @PutMapping("/regionArea/{id}")
    public GetRegionAreaDto deleteRegionArea(@PathVariable Long id){
        return service.deleteRegionArea(id);
    }
}
