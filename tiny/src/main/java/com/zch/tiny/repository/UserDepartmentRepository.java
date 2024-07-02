package com.zch.tiny.repository;

import com.zch.tiny.model.UserDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDepartmentRepository extends JpaRepository<UserDepartment, Long> {
}
