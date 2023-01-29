package com.me.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.me.exception.UserIdNotFoundException;
import com.me.exception.UserNameNotFoundException;
import com.me.model.Role;
import com.me.model.User;
import com.me.model.UserRole;
import com.meserviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
//@CrossOrigin("*")
public class UserController {

	@Autowired(required = false) 
    private UserServiceImpl userServiceImpl;

   
	/*
	 * public UserController(UserServiceImpl userServiceImpl) { super();
	 * this.userServiceImpl = userServiceImpl; }
	 */

	@PostMapping("/")
    public User saveUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");
        user.setPassword((user.getPassword()));
        Role role = new Role();
        role.setRoleName("NORMAL");


        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        Set<UserRole> userRoleList = new HashSet<>();
        userRoleList.add(userRole);
//        here we not save user, but getThe userRole and then add to user & save the user
//        only save the user
        return this.userServiceImpl.createUser(user, userRoleList);
    }

//    get user through username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        User user  = this.userServiceImpl.getUser(username);
        if(user==null){
            throw new UserNameNotFoundException();
        }
        return  user;
    }

//    delete user-by-username
    @DeleteMapping("/{userId}")
    public void deleteUser( @PathVariable("userId") Long username){
//        this.userServiceImpl.deleteUser(username);
        try {
            this.userServiceImpl.deleteUser(username);
        }catch (UserIdNotFoundException e){
            throw new UserIdNotFoundException();
        }
    }

//    update the user
    @PutMapping("/update/{userid}")
    public ResponseEntity<?>  updateUser(@RequestBody User user, @RequestParam("userid") Long userid){
        User users = this.userServiceImpl.updateUser(user, userid);
        return ResponseEntity.ok(users);
    }

// getAll users
    @GetMapping("/allusers")
    public List<User> getAllUser(){
        return this.userServiceImpl.getAllUser();
    }

	/*
	 * // exception handling
	 * 
	 * @ExceptionHandler(UserPresentException.class) public
	 * ResponseEntity<ExceptionResponse> exceptionHandling(){ ExceptionResponse
	 * exceptionResponse = new ExceptionResponse();
	 * exceptionResponse.setMessage("User name not found ");
	 * exceptionResponse.setStatus(HttpStatus.NOT_FOUND);
	 * exceptionResponse.setLocalTime(LocalDateTime.now()); return
	 * ResponseEntity.ok(exceptionResponse); }
	 */
}
