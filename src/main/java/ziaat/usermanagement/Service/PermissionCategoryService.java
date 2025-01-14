package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.PermissionCategoryDto.GetPermissionCategoryDto;
import ziaat.usermanagement.Dto.PermissionCategoryDto.InsertPermissionCategoryDto;
import ziaat.usermanagement.Dto.PermissionCategoryDto.UpdatePermissionCategoryDto;
import ziaat.usermanagement.Model.PermissionCategory;
import ziaat.usermanagement.Repository.PermissionCategoryRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionCategoryService {
    @Autowired
    private PermissionCategoryRepository repo;

    // for insert data in permission data table
    public GetPermissionCategoryDto insertPermissionCategory(InsertPermissionCategoryDto req){

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapper1 = new ModelMapper();

        PermissionCategory resp = modelMapper.map(req, PermissionCategory.class);
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        PermissionCategory response = repo.save(resp);


        return modelMapper1.map(response, GetPermissionCategoryDto.class);

    }


    // For select All data from permission category table
    public List<GetPermissionCategoryDto> getAllPermissionCategory(){
        List<PermissionCategory> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetPermissionCategoryDto> response = new ArrayList<>();
        for(PermissionCategory row : rowlist){
            GetPermissionCategoryDto resp = modelMapper.map(row, GetPermissionCategoryDto.class);
            response.add(resp);
        }
        return response;
    }

    public List<GetPermissionCategoryDto> getAllActivePermissionCategory(){
        List<PermissionCategory> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetPermissionCategoryDto> response = new ArrayList<>();
        for(PermissionCategory row : rowlist){
            GetPermissionCategoryDto resp = modelMapper.map(row, GetPermissionCategoryDto.class);
            response.add(resp);
        }
        return response;
    }

    // For select a specific data from permission category table
    public GetPermissionCategoryDto getPermissionCategoryById(Long id){
        Optional<PermissionCategory> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if(rowlist.isPresent()){
            PermissionCategory row = rowlist.get();
            GetPermissionCategoryDto resp = modelMapper.map(row, GetPermissionCategoryDto.class);
            return resp;
        }else{
            return null;
        }
    }

    // For Update a records
    public GetPermissionCategoryDto updatePermissionCategory(UpdatePermissionCategoryDto req){

        Optional<PermissionCategory> rowlist = repo.findById(req.getPermissionCategoryId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            PermissionCategory row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            modelMapper.map(req, row);
            PermissionCategory response = repo.save(row);
            return modelMapperR.map(response, GetPermissionCategoryDto.class);

        }else{
            return null;
        }
    }

    // For delete data
    public GetPermissionCategoryDto deletePermissionCategory(Long id){

        Optional<PermissionCategory> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            PermissionCategory row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            PermissionCategory response = repo.save(row);
            return modelMapperR.map(response, GetPermissionCategoryDto.class);

        }else{
            return null;
        }

    }

}
