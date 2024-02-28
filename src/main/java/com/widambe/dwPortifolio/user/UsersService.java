package com.widambe.dwPortifolio.user;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {
    private final UserRepository repository;

    public UsersService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }
}
