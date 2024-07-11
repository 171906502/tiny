package com.zch.tiny.repository;

import com.zch.tiny.model.RoleMenu;
import com.zch.tiny.model.RoleMenuId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuRepository extends JpaRepository<RoleMenu, RoleMenuId> {
}
