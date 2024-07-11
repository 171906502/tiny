package com.zch.tiny.controller;

import com.zch.tiny.model.Menu;
import com.zch.tiny.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) throws Exception {
        return menuService.createMenu(menu);
    }

    @PutMapping
    public Menu updateMenu(@RequestBody Menu menu) throws Exception {
        return menuService.updateMenu(menu);
    }

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Integer id) {
        return menuService.getMenuById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Integer id) {
        menuService.deleteMenu(id);
    }

    @GetMapping("/tree")
    public List<Menu> getMenuTree() {
        return menuService.getMenuTree();
    }
}
