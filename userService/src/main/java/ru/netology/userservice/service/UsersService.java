package ru.netology.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.userservice.model.User;
import ru.netology.userservice.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsers(){
        return usersRepository.getAllUsers();
    }

    public Optional<User> getUserById(int id){
        return usersRepository.getUserById(id);
    }
}
