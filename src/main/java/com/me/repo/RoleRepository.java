package com.me.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.me.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
