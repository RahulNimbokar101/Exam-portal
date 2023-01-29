package com.me.runner;

import org.springframework.stereotype.Component;

@Component
public class UserData {

	//implements ApplicationRunner
	/*
	 * @Autowired private UserServiceImpl userServiceImpl;
	 * 
	 * @Override public void run(ApplicationArguments args) throws Exception { User
	 * user = new User(); user.setFirstName("Pooja"); user.setLastName("kadu");
	 * user.setEmail("pooja@gmail.com"); user.setPassword("android");
	 * user.setPhoneNo("9923445874"); user.setUsername("poojaHacker");
	 * user.setProfile("ADMIN.png"); user.setEnabled(true);
	 * 
	 * Role role = new Role(); role.setRoleName("ADMIN");
	 * 
	 * 
	 * Set<UserRole> userRoleList = new HashSet<>(); UserRole userRole = new
	 * UserRole(); userRole.setRole(role); userRole.setUser(user);
	 * 
	 * userRoleList.add(userRole);
	 * 
	 * User user1 = this.userServiceImpl.createUser(user, userRoleList);
	 * System.out.println(user1.getUsername());
	 * 
	 * // userRoleList.addAll(userRoleList);
	 * 
	 * // user.setUserRoles(userRoleList);
	 * 
	 * }
	 */
}
