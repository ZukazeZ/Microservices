package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.entity.RoleEntity;
import org.example.model.entity.UserEntity;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.example.service.URService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class URServiceImpl implements URService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> findalluser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        Optional<UserEntity> search = userRepository.findById(id);
        if (search.isPresent()) {
            log.info("updated!");
            return search.get();
        } else {
            log.error("No such movie existed");
            return null;
        }
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserEntity updaterUser(Long id, UserEntity userEntity) {
        UserEntity user = findById(id);
        if (user != null) {
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            user.setEmail(userEntity.getEmail());
            user.setAge(userEntity.getAge());
            userRepository.saveAndFlush(user);
        }
        return user;
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User Has Been Deleted";
    }

    @Override
    public RoleEntity saveRole(RoleEntity roleEntity) {
        log.info("Saving new role {} to the database", roleEntity.getName());
        return roleRepository.save(roleEntity);
    }

    @Override
    public UserEntity getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoletoUser(String username, String roleName) {
        log.info("adding role {} to user {}", roleName, username);
        UserEntity user = userRepository.findByUsername(username);
        RoleEntity role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }
}
