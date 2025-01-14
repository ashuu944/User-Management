package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.RegionDto.GetRegionDto;
import ziaat.usermanagement.Dto.RegionDto.InsertRegionDto;
import ziaat.usermanagement.Dto.RegionDto.UpdateRegionDto;
import ziaat.usermanagement.Model.Region;
import ziaat.usermanagement.Model.RegionArea;
import ziaat.usermanagement.Repository.RegionAreaRepository;
import ziaat.usermanagement.Repository.RegionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository repo;
    @Autowired
    private RegionAreaRepository reg_repo;

    // for insert data in region data table
    public GetRegionDto insertRegion(InsertRegionDto req) {
        Optional<RegionArea> regArea = reg_repo.findById(req.getRegAreaId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();
        Region resp = modelMapper.map(req, Region.class);
        resp.setRegionArea(regArea.get());
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        Region rg = repo.save(resp);
        GetRegionDto response = modelMapperR.map(rg, GetRegionDto.class);
        response.setRegAreaId(rg.getRegionArea().getRegionAreaId());

        return response ;

    }

    // For select All data from region category table
    public List<GetRegionDto> getAllRegion() {
        List<Region> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetRegionDto> response = new ArrayList<>();
        for (Region row : rowlist) {
            GetRegionDto resp = modelMapper.map(row, GetRegionDto.class);
            resp.setRegAreaId(row.getRegionArea().getRegionAreaId());
            resp.setRegionAreaName(row.getRegionArea().getRegionAreaName());
            response.add(resp);
        }
        return response;
    }

    public List<GetRegionDto> getAllActiveRegion() {
        List<Region> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetRegionDto> response = new ArrayList<>();
        for (Region row : rowlist) {
            GetRegionDto resp = modelMapper.map(row, GetRegionDto.class);
            resp.setRegAreaId(row.getRegionArea().getRegionAreaId());
            resp.setRegionAreaName(row.getRegionArea().getRegionAreaName());
            response.add(resp);
        }
        return response;
    }

    // For Select a specific record based on the given region id
    public GetRegionDto getRegionById(Long id) {

        Optional<Region> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if (rowlist.isPresent()) {
            Region row = rowlist.get();
            GetRegionDto resp = modelMapper.map(row, GetRegionDto.class);
            resp.setRegAreaId(row.getRegionArea().getRegionAreaId());
            resp.setRegionAreaName(row.getRegionArea().getRegionAreaName());
            return resp;
        } else {
            return null;
        }

    }

    // For update data
    public GetRegionDto updateRegion(UpdateRegionDto req) {

        Optional<Region> rowlist = repo.findById(req.getRegionId());
        Optional<RegionArea> regA =reg_repo.findById(req.getRegAreaId());

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            Region row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setRegionArea(regA.get());
            modelMapper.map(req, row);
            Region reg = repo.save(row);
            GetRegionDto response = modelMapperR.map(reg, GetRegionDto.class);
            response.setRegAreaId(reg.getRegionArea().getRegionAreaId());
            response.setRegionAreaName(reg.getRegionArea().getRegionAreaName());
            return response;

        } else {
            return null;
        }

    }

    // For delete data
    public GetRegionDto deleteRegion(Long id) {

        Optional<Region> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            Region row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            Region response = repo.save(row);
            return modelMapperR.map(response, GetRegionDto.class);

        } else {
            return null;
        }

    }

}
