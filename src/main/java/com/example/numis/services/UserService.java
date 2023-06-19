package com.example.numis.services;

import com.example.numis.domain.models.User;
import com.example.numis.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserRepository _userRepo;
    private final BCryptPasswordEncoder _passEncoder;

    public UserService() {
        _passEncoder = new BCryptPasswordEncoder();
    }

    public boolean registerUser(User user){
        try{
           user.setUsername(user.getUsername());
           user.setEmail(user.getEmail());
           user.setPassword(_passEncoder.encode(user.getPassword()));
           user.setPasswordConfirmation(user.getPassword());
           System.out.printf("Name:%s\nemail:%s\nPassword:%s\n",user.getUsername(),user.getEmail(),user.getPassword());
            _userRepo.save(user);
            return true;
        }catch (Exception ex){
            System.out.printf("Name:%s",user.getUsername());
            System.out.println(ex.getMessage());
            return false;
        }
    }
    /*Find user by username*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = _userRepo.findByEmail(username);
        if(user == null){
            System.out.printf("Not found:%s\n",username);
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println(user.getEmail());
        return user;
    }
    /*Find user by ID*/
    public User findById(Long id){
        return _userRepo.findById(id).orElse(null);
    }
}
