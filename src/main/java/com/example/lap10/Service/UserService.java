package com.example.lap10.Service;

import com.example.lap10.Model.User;
import com.example.lap10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id , User user) {
        User u = userRepository.getById(id);
        if(u==null) {
            return false;
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        userRepository.save(u);
        return true;
    }
    public boolean deleteUser(Integer id) {
        User u = userRepository.getById(id);
        if(u==null) {
            return false;
        }
        userRepository.delete(u);
        return true;
    }

}
