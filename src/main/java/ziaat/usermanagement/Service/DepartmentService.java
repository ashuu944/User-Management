package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.DepartmentDto.GetDepartmentDto;
import ziaat.usermanagement.Dto.DepartmentDto.InsertDepartmentDto;
import ziaat.usermanagement.Dto.DepartmentDto.UpdateDepartmentDto;
import ziaat.usermanagement.Dto.PermissionCategoryDto.UpdatePermissionCategoryDto;
import ziaat.usermanagement.Model.Department;
import ziaat.usermanagement.Repository.DepartmentRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repo;



    // for insert data in department table
    public GetDepartmentDto insertDepartment(InsertDepartmentDto req){
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapper1 = new ModelMapper();

        Department resp = modelMapper.map(req, Department.class);
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        Department response = repo.save(resp);


        return modelMapper1.map(response, GetDepartmentDto.class);

    }

    // For select All data from department table
    public List<GetDepartmentDto> getAllDepartment(){

        List<Department> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetDepartmentDto> response = new ArrayList<>();
        for(Department row : rowlist){
            GetDepartmentDto resp = modelMapper.map(row, GetDepartmentDto.class);
            response.add(resp);
        }
        return response;
    }


    public List<GetDepartmentDto> getAllActiveDepartment(){
        List<Department> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetDepartmentDto> response = new ArrayList<>();
        for(Department row : rowlist){
            GetDepartmentDto resp = modelMapper.map(row, GetDepartmentDto.class);
            response.add(resp);
        }
        return response;
    }

    // For Select a specific record based on the given department id
    public GetDepartmentDto getDepartmentById(Long dept_id){

        Optional<Department> rowlist = repo.findById(dept_id);
        ModelMapper modelMapper = new ModelMapper();

        if(rowlist.isPresent()){
            Department row = rowlist.get();
            GetDepartmentDto resp = modelMapper.map(row, GetDepartmentDto.class);
            return resp;
        }else{
            return null;
        }

    }


    // For update data
    public GetDepartmentDto updateDepartment(UpdateDepartmentDto req){

        Optional<Department> rowlist = repo.findById(req.getDeptId());

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            Department row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            modelMapper.map(req, row);
            Department response = repo.save(row);
            return modelMapperR.map(response, GetDepartmentDto.class);

        }else{
            return null;
        }

    }

    // For delete data
    public GetDepartmentDto deleteDepartment(Long id){

        Optional<Department> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if(rowlist.isPresent()){
            Department row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            Department response = repo.save(row);
            return modelMapperR.map(response, GetDepartmentDto.class);

        }else{
            return null;
        }

    }
}
