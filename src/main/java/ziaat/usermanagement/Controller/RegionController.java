package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.RegionDto.GetRegionDto;
import ziaat.usermanagement.Dto.RegionDto.InsertRegionDto;
import ziaat.usermanagement.Dto.RegionDto.UpdateRegionDto;
import ziaat.usermanagement.Service.RegionService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RegionController {
    @Autowired
    private RegionService service;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/region")
    public GetRegionDto insertRegion(@RequestBody InsertRegionDto req){
        return service.insertRegion(req);
    }

    @GetMapping("/region")
    public List<GetRegionDto> getAllRegion(){
        return service.getAllRegion();
    }
    @GetMapping("/activeRegion")
    public List<GetRegionDto> getAllActiveRegion(){
        return service.getAllActiveRegion();
    }

    @GetMapping("/region/{id}")
    public GetRegionDto getRegionById(@PathVariable Long id){
        return service.getRegionById(id);
    }

    @PutMapping("/region")
    public GetRegionDto updateRegion(@RequestBody UpdateRegionDto req){
        return service.updateRegion(req);
    }

    @PutMapping("/region/{id}")
    public GetRegionDto deleteRegion(@PathVariable Long id){
        return service.deleteRegion(id);
    }

}
