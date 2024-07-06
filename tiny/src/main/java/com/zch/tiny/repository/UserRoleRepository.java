package com.zch.tiny.repository;

import com.zch.tiny.model.UserRole;
import com.zch.tiny.model.UserRoleId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}
