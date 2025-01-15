package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.UsersDto.GetUsersDto;
import ziaat.usermanagement.Dto.UsersDto.GetUsersDto2;
import ziaat.usermanagement.Dto.UsersDto.InsertUsersDto;
import ziaat.usermanagement.Dto.UsersDto.UpdateUsersDto;
import ziaat.usermanagement.Model.*;
import ziaat.usermanagement.Repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsersService {
    @Autowired
    private UsersRepository repo;
    @Autowired
    private DepartmentRepository dept_repo;
    @Autowired
    private DesignationRepository desg_repo;
    @Autowired
    private ShehiaRepository shehia_repo;
    @Autowired
    private IdTypeRepository idType_repo;



    public GetUsersDto2 insertUsers(InsertUsersDto req) {
        Optional<Department> dept = dept_repo.findById(req.getDepartmentId());
        Optional<Designation> des = desg_repo.findById(req.getDesignationId());
        Optional<Shehia> shehia = shehia_repo.findById(req.getShehiaId());
        Optional<IdType> idType = idType_repo.findById(req.getIdTypeId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();
        Users resp = modelMapper.map(req, Users.class);
        resp.setUserId(null);
        resp.setDepartment(dept.get());
        resp.setDesignation(des.get());
        resp.setShehia(shehia.get());
        resp.setIdType(idType.get());
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        Users row = repo.save(resp);
        System.out.println("Mapped Users entity: " + resp);
        //GetUsersDto2 response = modelMapperR.map(row, GetUsersDto2.class);
        GetUsersDto2 response = modelMapperR.map(row, GetUsersDto2.class);
        response.setDepartmentId(row.getDepartment().getDeptId());
        response.setDepartmentName(row.getDepartment().getDeptName());
        response.setDesignationId(row.getDesignation().getDesignationId());
        response.setDesignationName(row.getDesignation().getDesignationName());
//        response.setIdTypeId(row.getIdType().getIdTypeId());
//        response.setIdName(row.getIdType().getIdName());
        response.setShehiaId(row.getShehia().getShehiaId());
        response.setShehiaName(row.getShehia().getShehiaName());
//

            return response ;

    }

    public List<GetUsersDto> getAllUsers() {
        List<Users> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetUsersDto> response = new ArrayList<>();
        for (Users row : rowlist) {
            GetUsersDto resp = modelMapper.map(row, GetUsersDto.class);
//            resp.setDepartmentId(row.getDepartment().getDeptId());
//            resp.setDepartmentName(row.getDepartment().getDeptName());
//            resp.setDesignationId(row.getDesignation().getDesignationId());
//            resp.setDesignationName(row.getDesignation().getDesignationName());
//            resp.setShehiaId(row.getShehia().getShehiaId());
//            resp.setShehiaName(row.getShehia().getShehiaName());
           // resp.setIdTypeId(row.getIdType().getIdTypeId());
           // resp.setIdName(row.getIdType().getIdName());

            response.add(resp);
        }
        return response;
    }

    public List<GetUsersDto2> getAllActiveUsers() {
        List<Users> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetUsersDto2> response = new ArrayList<>();
        for (Users row : rowlist) {
            GetUsersDto2 resp = modelMapper.map(row, GetUsersDto2.class);
            resp.setDepartmentId(row.getDepartment().getDeptId());
            resp.setDepartmentName(row.getDepartment().getDeptName());
            resp.setDesignationId(row.getDesignation().getDesignationId());
            resp.setDesignationName(row.getDesignation().getDesignationName());
            resp.setShehiaId(row.getShehia().getShehiaId());
            resp.setShehiaName(row.getShehia().getShehiaName());
//            resp.setIdTypeId(row.getIdType().getIdTypeId());
//            resp.setIdName(row.getIdType().getIdName());
            response.add(resp);
        }
        return response;
    }

    // For Select a specific record based on a given id
    public GetUsersDto getUsersById(Long id) {

        Optional<Users> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if (rowlist.isPresent()) {
            Users row = rowlist.get();
            GetUsersDto resp = modelMapper.map(row, GetUsersDto.class);
            resp.setDepartmentId(row.getDepartment().getDeptId());
            resp.setDepartmentName(row.getDepartment().getDeptName());
            resp.setDesignationId(row.getDesignation().getDesignationId());
            resp.setDesignationName(row.getDesignation().getDesignationName());
            resp.setShehiaId(row.getShehia().getShehiaId());
            resp.setShehiaName(row.getShehia().getShehiaName());
            resp.setIdTypeId(row.getIdType().getIdTypeId());
            resp.setIdName(row.getIdType().getIdName());
            return resp;
        } else {
            return null;
        }

    }

    // For update data
    public GetUsersDto updateUsers(UpdateUsersDto req) {

        Optional<Users> rowlist = repo.findById(req.getUserId());
        Optional<Department> dept = dept_repo.findById(req.getDepartmentId());
        Optional<Designation> des = desg_repo.findById(req.getDesignationId());
        Optional<Shehia> shehia = shehia_repo.findById(req.getShehiaId());
        Optional<IdType> idType = idType_repo.findById(req.getIdTypeId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            Users row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setDepartment(dept.get());
            row.setDesignation(des.get());
            row.setShehia(shehia.get());
            row.setIdType(idType.get());
            modelMapper.map(req, row);
            Users us = repo.save(row);
            GetUsersDto resp = modelMapperR.map(us, GetUsersDto.class);
            resp.setDepartmentId(row.getDepartment().getDeptId());
            resp.setDepartmentName(row.getDepartment().getDeptName());
            resp.setDesignationId(row.getDesignation().getDesignationId());
            resp.setDesignationName(row.getDesignation().getDesignationName());
            resp.setShehiaId(row.getShehia().getShehiaId());
            resp.setShehiaName(row.getShehia().getShehiaName());
            resp.setIdTypeId(row.getIdType().getIdTypeId());
            resp.setIdName(row.getIdType().getIdName());
            return resp;

        } else {
            return null;
        }

    }

    // For delete data
    public GetUsersDto deleteUsers(Long id) {

        Optional<Users> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            Users row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            Users response = repo.save(row);
            return modelMapperR.map(response, GetUsersDto.class);

        } else {
            return null;
        }

    }

}
