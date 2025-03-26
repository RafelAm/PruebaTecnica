package com.tecnica.naves.api_naves.controller;

import com.tecnica.naves.api_naves.Service.NaveService;
import com.tecnica.naves.api_naves.model.Nave;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/naves")
public class NaveController {

    @Autowired
    private NaveService naveService;

    @PostMapping    
    public Nave createNave(@RequestBody Nave nave){
        return naveService.createNave(nave);
        
    }

    @GetMapping
    public Page<Nave> getAllNaves(Pageable pageable) {
        return naveService.getAll(pageable);
    }

    

    @GetMapping("{id}")
    public Nave searchNaveById(@PathVariable("id") Integer id) {
        return naveService.getNaveById(id);
    }

    @GetMapping("/name/{name}")
    public List<Nave> searchNavesByName(@PathVariable("name") String name) {
        return naveService.getAllNaveByName(name);
    }
    
    @DeleteMapping("{id}")
    public void deleteNaveById(@PathVariable("id") Integer id) {
         naveService.deleteNave(id);
    }

    @PutMapping("/edit")
    public Nave updateNave(@RequestBody Nave nave) {
        naveService.updateNave(nave);
        return nave;
    }
    
}
