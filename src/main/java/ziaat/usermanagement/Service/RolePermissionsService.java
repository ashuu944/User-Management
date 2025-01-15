package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.RolePermissionsDto.GetRolePermissionsDto;
import ziaat.usermanagement.Dto.RolePermissionsDto.InsertRolePermissionsDto;
import ziaat.usermanagement.Dto.RolePermissionsDto.UpdateRolePermissionsDto;
import ziaat.usermanagement.Model.*;
import ziaat.usermanagement.Repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionsService {
    @Autowired
    private RolePermissionsRepository repo;

    @Autowired
    private RolesRepository role_repo;

    @Autowired
    private PermissionsRepository per_repo;

    public GetRolePermissionsDto insertRolePermissions(InsertRolePermissionsDto req) {
        Optional<Roles> roles = role_repo.findById(req.getRoleId());
        Optional<Permissions> permissions = per_repo.findById(req.getPermissionId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();
        RolePermissions resp = modelMapper.map(req, RolePermissions.class);
        resp.setRolePermissionId(null);
        resp.setRoles(roles.get());
        resp.setPermissions(permissions.get());
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        RolePermissions row = repo.save(resp);
        GetRolePermissionsDto response = modelMapperR.map(row, GetRolePermissionsDto.class);
        response.setPermissionId(row.getPermissions().getPermissionId());
        response.setPermissionName(row.getPermissions().getPermissionName());
        response.setRoleId(row.getRoles().getRoleId());
        response.setRoleName(row.getRoles().getRoleName());

        return response ;

    }

    public List<GetRolePermissionsDto> getAllRolePermissions() {
        List<RolePermissions> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetRolePermissionsDto> response = new ArrayList<>();
        for (RolePermissions row : rowlist) {
            GetRolePermissionsDto resp = modelMapper.map(row, GetRolePermissionsDto.class);
            resp.setPermissionId(row.getPermissions().getPermissionId());
            resp.setPermissionName(row.getPermissions().getPermissionName());
            resp.setRoleId(row.getRoles().getRoleId());
            resp.setRoleName(row.getRoles().getRoleName());
            response.add(resp);
        }
        return response;
    }

    public List<GetRolePermissionsDto> getAllActiveRolePermissions() {
        List<RolePermissions> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetRolePermissionsDto> response = new ArrayList<>();
        for (RolePermissions row : rowlist) {
            GetRolePermissionsDto resp = modelMapper.map(row, GetRolePermissionsDto.class);
            resp.setPermissionId(row.getPermissions().getPermissionId());
            resp.setPermissionName(row.getPermissions().getPermissionName());
            resp.setRoleId(row.getRoles().getRoleId());
            resp.setRoleName(row.getRoles().getRoleName());
            response.add(resp);
        }
        return response;
    }

    // For Select a specific record based on a given id
    public GetRolePermissionsDto getRolePermissionsById(Long id) {

        Optional<RolePermissions> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if (rowlist.isPresent()) {
            RolePermissions row = rowlist.get();
            GetRolePermissionsDto resp = modelMapper.map(row, GetRolePermissionsDto.class);
            resp.setPermissionId(row.getPermissions().getPermissionId());
            resp.setPermissionName(row.getPermissions().getPermissionName());
            resp.setRoleId(row.getRoles().getRoleId());
            resp.setRoleName(row.getRoles().getRoleName());
            return resp;
        } else {
            return null;
        }

    }

    // For update data
    public GetRolePermissionsDto updateRolePermissions(UpdateRolePermissionsDto req) {

        Optional<RolePermissions> rowlist = repo.findById(req.getRolePermissionId());
        Optional<Roles> roles = role_repo.findById(req.getRoleId());
        Optional<Permissions> permissions = per_repo.findById(req.getPermissionId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            RolePermissions row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setPermissions(permissions.get());
            row.setRoles(roles.get());
            modelMapper.map(req, row);
            RolePermissions ds = repo.save(row);
            GetRolePermissionsDto resp = modelMapperR.map(ds, GetRolePermissionsDto.class);
            resp.setPermissionId(row.getPermissions().getPermissionId());
            resp.setPermissionName(row.getPermissions().getPermissionName());
            resp.setRoleId(row.getRoles().getRoleId());
            resp.setRoleName(row.getRoles().getRoleName());
            return resp;

        } else {
            return null;
        }

    }

    // For delete data
    public GetRolePermissionsDto deleteRolePermissions(Long id) {

        Optional<RolePermissions> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            RolePermissions row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            RolePermissions response = repo.save(row);
            return modelMapperR.map(response, GetRolePermissionsDto.class);

        } else {
            return null;
        }

    }


}

