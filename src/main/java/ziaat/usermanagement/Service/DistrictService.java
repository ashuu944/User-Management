package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.DistrictDto.GetDistrictDto;
import ziaat.usermanagement.Dto.DistrictDto.InsertDistrictDto;
import ziaat.usermanagement.Dto.DistrictDto.UpdateDistrictDto;
import ziaat.usermanagement.Model.District;
import ziaat.usermanagement.Model.Region;
import ziaat.usermanagement.Repository.DistrictRepository;
import ziaat.usermanagement.Repository.RegionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repo;

    @Autowired
    private RegionRepository reg_repo;

    public GetDistrictDto insertDistrict(InsertDistrictDto req) {
        Optional<Region> reg = reg_repo.findById(req.getRegId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();
        District resp = modelMapper.map(req, District.class);
        resp.setRegion(reg.get());
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        District ds = repo.save(resp);
        GetDistrictDto response = modelMapperR.map(ds, GetDistrictDto.class);
        response.setRegId(ds.getRegion().getRegionId());
        response.setRegName(ds.getRegion().getRegionName());

        return response ;

    }

    public List<GetDistrictDto> getAllDistrict() {
        List<District> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetDistrictDto> response = new ArrayList<>();
        for (District row : rowlist) {
            GetDistrictDto resp = modelMapper.map(row, GetDistrictDto.class);
            resp.setRegId(row.getRegion().getRegionId());
            resp.setRegName(row.getRegion().getRegionName());
            response.add(resp);
        }
        return response;
    }

    public List<GetDistrictDto> getAllActiveDistrict() {
        List<District> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetDistrictDto> response = new ArrayList<>();
        for (District row : rowlist) {
            GetDistrictDto resp = modelMapper.map(row, GetDistrictDto.class);
            resp.setRegId(row.getRegion().getRegionId());
            resp.setRegName(row.getRegion().getRegionName());
            response.add(resp);
        }
        return response;
    }

    // For Select a specific record based on the given region id
    public GetDistrictDto getDistrictById(Long id) {

        Optional<District> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if (rowlist.isPresent()) {
            District row = rowlist.get();
            GetDistrictDto resp = modelMapper.map(row, GetDistrictDto.class);
            resp.setRegId(row.getRegion().getRegionId());
            resp.setRegName(row.getRegion().getRegionName());
            return resp;
        } else {
            return null;
        }

    }

    // For update data
    public GetDistrictDto updateDistrict(UpdateDistrictDto req) {

        Optional<District> rowlist = repo.findById(req.getDistrictId());
        Optional<Region> reg =reg_repo.findById(req.getRegId());

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            District row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setRegion(reg.get());
            modelMapper.map(req, row);
            District ds = repo.save(row);
            GetDistrictDto response = modelMapperR.map(ds, GetDistrictDto.class);
            response.setRegId(ds.getRegion().getRegionId());
            response.setRegName(ds.getRegion().getRegionName());
            return response;

        } else {
            return null;
        }

    }

    // For delete data
    public GetDistrictDto deleteDistrict(Long id) {

        Optional<District> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            District row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            District response = repo.save(row);
            return modelMapperR.map(response, GetDistrictDto.class);

        } else {
            return null;
        }

    }



}
