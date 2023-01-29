package com.me.service;

import java.util.List;
import java.util.Set;

import com.me.model.User;
import com.me.model.UserRole;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRole) throws Exception;

    public User getUser(String username);



//    update user
    public User updateUser(User user, Long userId);

    public void deleteUser(Long userId);

    public List<User> getAllUser();

}
