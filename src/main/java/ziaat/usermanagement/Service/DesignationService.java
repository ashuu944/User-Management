package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.DepartmentDto.GetDepartmentDto;
import ziaat.usermanagement.Dto.DesignationDto.GetDesignationDto;
import ziaat.usermanagement.Dto.DesignationDto.InsertDesignationDto;
import ziaat.usermanagement.Dto.DesignationDto.UpdateDesignationDto;
import ziaat.usermanagement.Model.Department;
import ziaat.usermanagement.Model.Designation;
import ziaat.usermanagement.Repository.DesignationRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class DesignationService {
    @Autowired
    private DesignationRepository repo;

    // for insert data in designation table

    public GetDesignationDto insertDesignation(InsertDesignationDto req){

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapper1 = new ModelMapper();

        Designation resp = modelMapper.map(req, Designation.class);
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        Designation response = repo.save(resp);


        return modelMapper1.map(response, GetDesignationDto.class);

    }

    // For select All data from designation table
    public List<GetDesignationDto> getAllDesignation(){

        List <Designation> rowlist = repo.findAll();

        ModelMapper modelMapper = new ModelMapper();
        List<GetDesignationDto> response = new ArrayList<>();
        for(Designation row : rowlist){
            GetDesignationDto resp = modelMapper.map(row, GetDesignationDto.class);
            response.add(resp);
        }
        return response;
    }

    public List<GetDesignationDto> getAllActiveDesignation(){
        List<Designation> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetDesignationDto> response = new ArrayList<>();
        for(Designation row : rowlist){
            GetDesignationDto resp = modelMapper.map(row, GetDesignationDto.class);
            response.add(resp);
        }
        return response;
    }


    // For Select a specific record based on the given department id
    public GetDesignationDto getDesignationById(Long designation_id){

        Optional<Designation> rowlist = repo.findById(designation_id);

        ModelMapper modelMapper = new ModelMapper();

        if(rowlist.isPresent()){
            Designation row = rowlist.get();
            GetDesignationDto resp = modelMapper.map(row, GetDesignationDto.class);
            return resp;
        }else{
            return null;
        }

    }

    // For update data
    public GetDesignationDto updateDesignation(UpdateDesignationDto req) {

        Optional<Designation> rowlist = repo.findById(req.getDesignationId());

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            Designation row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            modelMapper.map(req, row);
            Designation response = repo.save(row);
            return modelMapperR.map(response, GetDesignationDto.class);

        }else{
            return null;
        }
    }

    // For delete data
    public GetDesignationDto deleteDesignation(Long id){

        Optional<Designation> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            Designation row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            Designation response = repo.save(row);
            return modelMapperR.map(response, GetDesignationDto.class);

        }else{
            return null;
        }

    }
}
