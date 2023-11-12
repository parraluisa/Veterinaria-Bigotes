package com.bigotes.app.security;

import com.bigotes.app.model.*;
import com.bigotes.app.repository.RoleRepository;
import com.bigotes.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*Unico método para traer la informacion de un usuario a traves de su username */
    /*Retorna un USerDetails, que es la entidad básica en springboot que unicamente tiene
     * username, password y authorities
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Buscar al usuario si no se encuentra traer una excepcion
        //El usuario que se carga es de tipo USer Entity, el que nosotros creamos
        UserEntity userDB = userRepository.findByUsername(Long.parseLong(username)).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );

        //El usuario que se retorna es de tipo UserDetail
        //Se mapean los datos desde el UserEntity a UserDetail
        //Es necesario pasar como tercer parametro grantedAutathorities
        return new User(userDB.getUsername().toString(),
                userDB.getPassword(),
                mapRolesToAuthorities(userDB.getRoles()));
    }

    //PAsar de roles a GrantedAuthoritys
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity saveVeterinarian(Veterinarian vet){
        UserEntity user = new UserEntity();
        user.setUsername(vet.getIdCard());
        user.setPassword(passwordEncoder.encode(vet.getPassword()));

        Role roles = roleRepository.findByName("VET").get();
        user.setRoles(List.of(roles));
        return user;
    }

    public UserEntity saveAdmin(Administrator admin){
        UserEntity user = new UserEntity();
        user.setUsername(admin.getIdCard());
        user.setPassword(passwordEncoder.encode(admin.getPassword()));

        Role roles = roleRepository.findByName("ADMIN").get();
        user.setRoles(List.of(roles));
        return user;
    }

    public UserEntity saveOwner(Owner owner){
        UserEntity user = new UserEntity();
        user.setUsername(owner.getIdCard());
        user.setPassword(passwordEncoder.encode("123"));

        Role roles = roleRepository.findByName("OWNER").get();
        user.setRoles(List.of(roles));
        return user;
    }
}