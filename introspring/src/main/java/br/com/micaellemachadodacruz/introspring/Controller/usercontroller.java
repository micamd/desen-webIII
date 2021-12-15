package br.com.micaellemachadodacruz.introspring.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.micaellemachadodacruz.introspring.model.user;
import br.com.micaellemachadodacruz.introspring.service.userservice;

@RestController
@RequestMapping ("/usuarios")
public class usercontroller {
    @Autowired
    private userservice userservice;

    @GetMapping
    public List<user> findAll(){
        return userservice.findAll();
    }

    @PostMapping
    public boolean insert(@RequestBody user entity){
        return userservice.insert(entity);
    }

    @GetMapping("/{id}")
    public user findById(@PathVariable int id) {
        return userservice.findById(id); 
    }

    @PutMapping ("/{id}")
    public boolean update(@RequestBody user entity, @PathVariable int id){
        return userservice.update(entity);
    }

    @DeleteMapping ("/{id}")
    public boolean delete(@PathVariable int id){
        return userservice.delete(id);
    }
}