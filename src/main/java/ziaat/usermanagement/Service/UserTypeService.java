package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.RegionAreaDto.GetRegionAreaDto;
import ziaat.usermanagement.Dto.UserTypeDto.GetUserTypeDto;
import ziaat.usermanagement.Dto.UserTypeDto.InsertUserTypeDto;
import ziaat.usermanagement.Model.RegionArea;
import ziaat.usermanagement.Model.UserType;
import ziaat.usermanagement.Repository.UserTypeRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {
    @Autowired
    private UserTypeRepository repo;


    // for insert data in user type table
    public GetUserTypeDto insertUserType(InsertUserTypeDto req){

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapper1 = new ModelMapper();

        UserType resp = modelMapper.map(req, UserType.class);
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        UserType response = repo.save(resp);


        return modelMapper1.map(response, GetUserTypeDto.class);

    }


    // For select All data from user type table
    public List<GetUserTypeDto> getAllUserType(){
        List<UserType> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetUserTypeDto> response = new ArrayList<>();
        for(UserType row : rowlist){
            GetUserTypeDto resp = modelMapper.map(row, GetUserTypeDto.class);
            response.add(resp);
        }
        return response;
    }

    public List<GetUserTypeDto> getAllActiveUserType(){
        List<UserType> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetUserTypeDto> response = new ArrayList<>();
        for(UserType row : rowlist){
            GetUserTypeDto resp = modelMapper.map(row, GetUserTypeDto.class);
            response.add(resp);
        }
        return response;
    }


    // For select a specific data from permission category table
    public GetUserTypeDto getUserTypeId(Long id){
        Optional<UserType> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if(rowlist.isPresent()){
            UserType row = rowlist.get();
            GetUserTypeDto resp = modelMapper.map(row, GetUserTypeDto.class);
            return resp;
        }else{
            return null;
        }
    }

    // For Update a records
    public GetUserTypeDto updateUserType(GetUserTypeDto req){

        Optional<UserType> rowlist = repo.findById(req.getUserTypeId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            UserType row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            modelMapper.map(req, row);
            UserType response = repo.save(row);
            return modelMapperR.map(response, GetUserTypeDto.class);

        }else{
            return null;
        }
    }

    // For delete data
    public GetUserTypeDto deleteUserType(Long id){

        Optional<UserType> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            UserType row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            UserType response = repo.save(row);
            return modelMapperR.map(response, GetUserTypeDto.class);

        }else{
            return null;
        }

    }


}
