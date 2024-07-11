package com.zch.tiny.service;

import com.zch.tiny.model.Menu;
import com.zch.tiny.model.Permission;
import com.zch.tiny.repository.MenuRepository;
import com.zch.tiny.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Transactional
    public Menu createMenu(Menu menu) throws Exception {
        checkPermission(menu);
        checkParentId(menu);
        return menuRepository.save(menu);
    }

    @Transactional
    public Menu updateMenu(Menu menu) throws Exception {
        checkPermission(menu);
        checkParentId(menu);
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Integer menuId) {
        return menuRepository.findById(menuId).orElse(null);
    }

    public void deleteMenu(Integer menuId) {
        menuRepository.deleteById(menuId);
    }

    private void checkPermission(Menu menu) throws Exception {
        if (menu.getPermission() != null) {
            Optional<Permission> permission = permissionRepository.findById(menu.getPermission().getPermissionId());
            if (permission.isEmpty()) {
                throw new Exception("Permission not found");
            }
        }
    }

    private void checkParentId(Menu menu) throws Exception {
        if (menu.getParentId() != null && menu.getParentId() != 0) {
            Optional<Menu> parentMenu = menuRepository.findById(menu.getParentId());
            if (parentMenu.isEmpty()) {
                throw new Exception("Parent menu not found");
            }
        }
    }

    public List<Menu> getMenuTree() {
        List<Menu> allMenus = menuRepository.findAll();
        List<Menu> rootMenus = new ArrayList<>();
        for (Menu menu : allMenus) {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                rootMenus.add(menu);
            }
        }
        for (Menu rootMenu : rootMenus) {
            buildMenuTree(rootMenu, allMenus);
        }
        return rootMenus;
    }

    private void buildMenuTree(Menu rootMenu, List<Menu> allMenus) {
        List<Menu> children = new ArrayList<>();
        for (Menu menu : allMenus) {
            if (rootMenu.getMenuId().equals(menu.getParentId())) {
                children.add(menu);
                buildMenuTree(menu, allMenus);
            }
        }
        rootMenu.setChildren(children);
    }
}
