package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.DepartmentDto.GetDepartmentDto;
import ziaat.usermanagement.Dto.DepartmentDto.UpdateDepartmentDto;
import ziaat.usermanagement.Dto.PermissionCategoryDto.GetPermissionCategoryDto;
import ziaat.usermanagement.Dto.PermissionsDto.GetPermissionsDto;
import ziaat.usermanagement.Dto.PermissionsDto.InsertPermissionsDto;
import ziaat.usermanagement.Dto.PermissionsDto.UpdatePermissionsDto;
import ziaat.usermanagement.Model.Department;
import ziaat.usermanagement.Model.Permissions;
import ziaat.usermanagement.Model.PermissionCategory;
import ziaat.usermanagement.Repository.PermissionCategoryRepository;
import ziaat.usermanagement.Repository.PermissionsRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionsService {

    @Autowired
    private PermissionsRepository repo;
    @Autowired
    private PermissionCategoryRepository catRepo;

    // for insert data in permission data table
    public GetPermissionsDto insertPermissions(InsertPermissionsDto req) {
        Optional<PermissionCategory> prCat = catRepo.findById(req.getPermissionCatId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();
        Permissions resp = modelMapper.map(req, Permissions.class);
        resp.setPermissionCategory(prCat.get());
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        Permissions ps = repo.save(resp);
        GetPermissionsDto response = modelMapperR.map(ps, GetPermissionsDto.class);
        response.setPermissionCatId(ps.getPermissionCategory().getPermissionCategoryId());

        return response ;

    }

    // For select All data from permission category table
    public List<GetPermissionsDto> getAllPermissions() {
        List<Permissions> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetPermissionsDto> response = new ArrayList<>();
        for (Permissions row : rowlist) {
            GetPermissionsDto resp = modelMapper.map(row, GetPermissionsDto.class);
            resp.setPermissionCatId(row.getPermissionCategory().getPermissionCategoryId());
            resp.setPermissionCatName(row.getPermissionCategory().getPermissionCatName());
            response.add(resp);
        }
        return response;
    }

    public List<GetPermissionsDto> getAllActivePermissions() {
        List<Permissions> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetPermissionsDto> response = new ArrayList<>();
        for (Permissions row : rowlist) {
            GetPermissionsDto resp = modelMapper.map(row, GetPermissionsDto.class);
            resp.setPermissionCatId(row.getPermissionCategory().getPermissionCategoryId());
            resp.setPermissionCatName(row.getPermissionCategory().getPermissionCatName());
            response.add(resp);
        }
        return response;
    }

    // For Select a specific record based on the given permission id
    public GetPermissionsDto getPermissionsById(Long id) {

        Optional<Permissions> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if (rowlist.isPresent()) {
            Permissions row = rowlist.get();
            GetPermissionsDto resp = modelMapper.map(row, GetPermissionsDto.class);
            resp.setPermissionCatId(row.getPermissionCategory().getPermissionCategoryId());
            resp.setPermissionCatName(row.getPermissionCategory().getPermissionCatName());
            return resp;
        } else {
            return null;
        }

    }

    // For update data
    public GetPermissionsDto updatePermissions(UpdatePermissionsDto req) {

        Optional<Permissions> rowlist = repo.findById(req.getPermissionId());
        Optional<PermissionCategory> prCat = catRepo.findById(req.getPermissionCatId());

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            Permissions row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setPermissionCategory(prCat.get());
            modelMapper.map(req, row);
            Permissions ps = repo.save(row);
            GetPermissionsDto response = modelMapperR.map(ps, GetPermissionsDto.class);
            response.setPermissionCatName(ps.getPermissionCategory().getPermissionCatName());
            response.setPermissionCatId(ps.getPermissionCategory().getPermissionCategoryId());
            return response;

        } else {
            return null;
        }

    }

    // For delete data
    public GetPermissionsDto deletePermissions(Long id) {

        Optional<Permissions> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            Permissions row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            Permissions response = repo.save(row);
            return modelMapperR.map(response, GetPermissionsDto.class);

        } else {
            return null;
        }

    }
}