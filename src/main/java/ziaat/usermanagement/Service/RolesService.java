package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.RolesDto.GetRolesDto;
import ziaat.usermanagement.Dto.RolesDto.InsertRolesDto;
import ziaat.usermanagement.Dto.RolesDto.UpdateRolesDto;
import ziaat.usermanagement.Model.Roles;
import ziaat.usermanagement.Repository.RolesRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    private RolesRepository repo;



    // for insert data in role table
    public GetRolesDto insertRole(InsertRolesDto req){
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapper1 = new ModelMapper();

        Roles resp = modelMapper.map(req, Roles.class);
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        Roles response = repo.save(resp);


        return modelMapper1.map(response, GetRolesDto.class);

    }

    // For select All data from role table
    public List<GetRolesDto> getAllRoles(){

        List<Roles> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetRolesDto> response = new ArrayList<>();
        for(Roles row : rowlist){
            GetRolesDto resp = modelMapper.map(row, GetRolesDto.class);
            response.add(resp);
        }
        return response;
    }


    public List<GetRolesDto> getAllActiveRoles(){
        List<Roles> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetRolesDto> response = new ArrayList<>();
        for(Roles row : rowlist){
            GetRolesDto resp = modelMapper.map(row, GetRolesDto.class);
            response.add(resp);
        }
        return response;
    }

    // For Select a specific record based on the given role id
    public GetRolesDto getRolesById(Long id){

        Optional<Roles> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if(rowlist.isPresent()){
            Roles row = rowlist.get();
            GetRolesDto resp = modelMapper.map(row, GetRolesDto.class);
            return resp;
        }else{
            return null;
        }

    }


    // For update data
    public GetRolesDto updateRoles(UpdateRolesDto req){

        Optional<Roles> rowlist = repo.findById(req.getRoleId());

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            Roles row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            modelMapper.map(req, row);
            Roles response = repo.save(row);
            return modelMapperR.map(response, GetRolesDto.class);

        }else{
            return null;
        }

    }

    // For delete data
    public GetRolesDto deleteRoles(Long id){

        Optional<Roles> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            Roles row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            Roles response = repo.save(row);
            return modelMapperR.map(response, GetRolesDto.class);

        }else{
            return null;
        }

    }
}
