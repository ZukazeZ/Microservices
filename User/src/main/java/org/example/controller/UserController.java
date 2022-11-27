package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.entity.RoleEntity;
import org.example.model.entity.UserEntity;
import org.example.service.URService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    URService userService;

    @Operation(summary="This is get all user information from db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "put user into from DB",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    }
    )

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUser(){
        return ResponseEntity.ok().body(userService.findalluser());
    }
    @PostMapping("/role/save")
    public ResponseEntity<RoleEntity> saveRole(@RequestBody RoleEntity role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<String> addRoletoUser(@RequestBody RoleToUserForm form){
        userService.addRoletoUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @Operation(summary="This is put information into db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "put user into from DB",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    }
    )
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create(@RequestBody UserEntity user){
        return userService.saveUser(user);
    }

    @Operation(summary="This is to get all user into db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "Fetched all the user information from DB",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    })
    @GetMapping("/getall")
    public List<UserEntity> getall(){
        return userService.findalluser();
    }
    @Operation(summary="This is to update the specified user from db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "update user from DB",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    }
    )
    @PutMapping("/update/{id}")
    public UserEntity update(@PathVariable Long id, @RequestBody UserEntity users){
        return userService.updaterUser(id,users);
    }
    @Operation(summary="This is to delete specified user from db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "deleted user from DB",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    }
    )
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return userService.deleteUser(id);
    }
    @Data
    class RoleToUserForm{
        private String username;
        private String roleName;
    }

}