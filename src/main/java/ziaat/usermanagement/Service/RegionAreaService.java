package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.DepartmentDto.GetDepartmentDto;
import ziaat.usermanagement.Dto.RegionAreaDto.GetRegionAreaDto;
import ziaat.usermanagement.Dto.RegionAreaDto.InsertRegionAreaDto;
import ziaat.usermanagement.Dto.RegionAreaDto.UpdateRegionAreaDto;
import ziaat.usermanagement.Model.Department;
import ziaat.usermanagement.Model.RegionArea;
import ziaat.usermanagement.Repository.RegionAreaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionAreaService {
    @Autowired
    private RegionAreaRepository repo;

    // for insert data in region area table
    public GetRegionAreaDto insertRegionArea(InsertRegionAreaDto req){

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapper1 = new ModelMapper();

        RegionArea resp = modelMapper.map(req, RegionArea.class);
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        RegionArea response = repo.save(resp);


        return modelMapper1.map(response, GetRegionAreaDto.class);

    }


    // For select All data from permission category table
    public List<GetRegionAreaDto> getAllRegionArea(){
        List<RegionArea> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetRegionAreaDto> response = new ArrayList<>();
        for(RegionArea row : rowlist){
            GetRegionAreaDto resp = modelMapper.map(row, GetRegionAreaDto.class);
            response.add(resp);
        }
        return response;
    }

    public List<GetRegionAreaDto> getAllActiveRegionArea(){
        List<RegionArea> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetRegionAreaDto> response = new ArrayList<>();
        for(RegionArea row : rowlist){
            GetRegionAreaDto resp = modelMapper.map(row, GetRegionAreaDto.class);
            response.add(resp);
        }
        return response;
    }

    // For select a specific data from permission category table
    public GetRegionAreaDto getRegionAreaById(Long id){
        Optional<RegionArea> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if(rowlist.isPresent()){
            RegionArea row = rowlist.get();
            GetRegionAreaDto resp = modelMapper.map(row, GetRegionAreaDto.class);
            return resp;
        }else{
            return null;
        }
    }

    // For Update a records
    public GetRegionAreaDto updateRegionArea(UpdateRegionAreaDto req){

        Optional<RegionArea> rowlist = repo.findById(req.getRegionAreaId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            RegionArea row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            modelMapper.map(req, row);
            RegionArea response = repo.save(row);
            return modelMapperR.map(response, GetRegionAreaDto.class);

        }else{
            return null;
        }
    }


    // For delete data
    public GetRegionAreaDto deleteRegionArea(Long id){

        Optional<RegionArea> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            RegionArea row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            RegionArea response = repo.save(row);
            return modelMapperR.map(response, GetRegionAreaDto.class);

        }else{
            return null;
        }

    }



}

