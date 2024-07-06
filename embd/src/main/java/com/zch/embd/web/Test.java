package com.zch.embd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zch.embd.model.Cat;
import com.zch.embd.model.CatRepository;
import com.zch.embd.model.CatToyUsage;
import com.zch.embd.model.CatToyUsageRepository;
import com.zch.embd.model.Pk;
import com.zch.embd.model.UsageStatus;
import com.zch.embd.model.UserService;

@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CatToyUsageRepository catToyUsageRepository;

    @GetMapping("/t1")
    public Object t1(){
        var cat = new Cat();
        // cat.setCatId(1L);
        // cat.setName("cat white");
        // catRepository.save(cat);

        // var toy =new CatToyUsage();
        // toy.setUsageStatus(UsageStatus.enabled);
        // var pk = new Pk();
        // pk.setCat(cat);
        // toy.setId(pk);

        // cat.getToyUsages().add(toy);
        // catRepository.save(cat);

        userService.createUserWithRolesAndPermissions();

        return cat;
    }

    
    @GetMapping("/t2")
    public Object t2(){
        return userService.getUserById(1L);
    }
    

    @GetMapping("/t3")
    public Object t3(){
         userService.updateUserRoles();
         return userService.getUserById(1L);
    }
}
