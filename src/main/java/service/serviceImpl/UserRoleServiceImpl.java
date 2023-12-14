package service.serviceImpl;


import dtos.UserRoleDto;
import models.UserRole;
import models.enums.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRoleRepository;
import service.UserRoleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addNewUserRole(UserRoleDto userRoleDto) {
        UserRole userRole = modelMapper.map(userRoleDto, UserRole.class);
        userRoleRepository.saveAndFlush(userRole);
    }
    @Override
    public UserRoleDto getUserRoleById(String id){
        return modelMapper.map(userRoleRepository.findById(id), UserRoleDto.class);
    }
    @Override
    public void deleteUserRoleById(String id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public List<UserRoleDto> getAllUserRole() {
        return null;
    }

    @Override
    public UserRoleDto updateUserRoleName(String uuid, Role role) {
        UserRole userRole = userRoleRepository.findById(uuid).orElseThrow();
        userRole.setRole(role);
        userRoleRepository.save(userRole);
        return modelMapper.map(userRole, UserRoleDto.class);
    }

    @Override
    public List<UserRoleDto> getAllUserRoles() {
        return userRoleRepository.findAll().stream().map(userRole -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDto> getAllUserRoleByName(String name) {
        return null;
    }

}
