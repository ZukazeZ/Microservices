package org.example.service;

import org.example.model.entity.RoleEntity;
import org.example.model.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface URService{

    List<UserEntity> findalluser();
    UserEntity findById(Long id);
    UserEntity saveUser(UserEntity userEntity);
    UserEntity updaterUser(Long id,UserEntity userEntity);
    UserEntity getUser(String userEntity);
    String deleteUser(Long id);
    RoleEntity saveRole(RoleEntity role);
    void addRoletoUser(String username, String roleName);

}