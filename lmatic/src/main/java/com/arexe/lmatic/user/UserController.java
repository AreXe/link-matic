package com.arexe.lmatic.user;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}")
    public UserDto findOne(@PathVariable Long id) {
        User entity = userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody UserDto newUser) {
        User entity = convertToEntity(newUser);
        this.userService.save(entity);
    }

    @GetMapping
    public Collection<UserDto> findAll() {
        Iterable<User> users = this.userService.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(p -> userDtos.add(convertToDto(p)));
        return userDtos;
    }

    private UserDto convertToDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    private User convertToEntity(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        if (!StringUtils.isEmpty(dto.getId())) {
            user.setId(dto.getId());
        }
        return user;
    }

}
