package ziaat.usermanagement.Service;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.DesignationDto.GetDesignationDto;
import ziaat.usermanagement.Dto.IdTypeDto.GetIdTypeDto;
import ziaat.usermanagement.Dto.IdTypeDto.InsertIdTypeDto;
import ziaat.usermanagement.Dto.IdTypeDto.UpdateIdTypeDto;
import ziaat.usermanagement.Model.Designation;
import ziaat.usermanagement.Model.IdType;
import ziaat.usermanagement.Repository.IdTypeRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IdTypeService{

    @Autowired
    private IdTypeRepository repo;

    // for insert data in id_type table
    public GetIdTypeDto insertIdType(InsertIdTypeDto req){

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapper1 = new ModelMapper();

        IdType resp = modelMapper.map(req, IdType.class);
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);;
        IdType response = repo.save(resp);


       return modelMapper1.map(response, GetIdTypeDto.class);

    }

    // For select All data from id_type table
    public List<GetIdTypeDto> getAllIdType(){
        List<IdType> listIds = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetIdTypeDto> response = new ArrayList<>();
        for(IdType ids : listIds){
            GetIdTypeDto resp = modelMapper.map(ids, GetIdTypeDto.class);
            response.add(resp);
        }
        return response;
    }

    public List<GetIdTypeDto> getAllActiveIdType(){
        List<IdType> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetIdTypeDto> response = new ArrayList<>();
        for(IdType row : rowlist){
            GetIdTypeDto resp = modelMapper.map(row, GetIdTypeDto.class);
            response.add(resp);
        }
        return response;
    }

    // For select a specific data from id_type table
    public GetIdTypeDto getIdTypeTypeById(Long id){
        Optional<IdType> listIds = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if(listIds.isPresent()){
            IdType ids = listIds.get();
            GetIdTypeDto resp = modelMapper.map(ids, GetIdTypeDto.class);
            return resp;
        }else{
            return null;
        }
    }

    // For Update a records
    public GetIdTypeDto updateIdType(UpdateIdTypeDto req){

        Optional<IdType> listIds = repo.findById(req.getIdTypeId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if(listIds.isPresent()){
            IdType ids = listIds.get();
            ids.setCreateAt(LocalDateTime.now());
            modelMapper.map(req, ids);
            IdType response = repo.save(ids);
            return modelMapperR.map(response, GetIdTypeDto.class);

        }else{
            return null;
        }
    }

    // delete id_type

    public GetIdTypeDto deleteIdType(Long id) {

        Optional<IdType> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            IdType row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            IdType response = repo.save(row);
            return modelMapperR.map(response, GetIdTypeDto.class);

        } else {
            return null;
        }

    }


}
