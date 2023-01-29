package com.me.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

//find user having perticular username
    User findByUsername(String username);
    void deleteUserByUsername(String username);
}
