package ziaat.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziaat.usermanagement.Dto.UserTypeDto.GetUserTypeDto;
import ziaat.usermanagement.Dto.UserTypeDto.InsertUserTypeDto;
import ziaat.usermanagement.Dto.UsersDto.GetUsersDto;
import ziaat.usermanagement.Dto.UsersDto.InsertUsersDto;
import ziaat.usermanagement.Dto.UsersDto.UpdateUsersDto;
import ziaat.usermanagement.Service.UserTypeService;
import ziaat.usermanagement.Service.UsersService;
import ziaat.usermanagement.Utils.MessageResult;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UsersController {
    @Autowired
    private UsersService service;
    @Autowired
    private MessageResult messageResult;

    @PostMapping("/users")
    public GetUsersDto insertUsers (@RequestBody InsertUsersDto req){
        return service.insertUsers(req);
    }

    @GetMapping("/users")
    public List<GetUsersDto> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/activeUsers")
    public List<GetUsersDto> getAllActiveUsers(){
        return service.getAllActiveUsers();
    }

    @GetMapping("/users/{id}")
    public GetUsersDto getUsersById(@PathVariable Long id){
        return service.getUsersById(id);
    }

    @PutMapping("/users")
    public GetUsersDto updateUsers(@RequestBody UpdateUsersDto req){
        return service.updateUsers(req);
    }

    @PutMapping("/users/{id}")
    public GetUsersDto deleteUsers(@PathVariable Long id){
        return service.deleteUsers(id);
    }



}
