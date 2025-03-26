package com.tecnica.naves.api_naves.Service;


import com.tecnica.naves.api_naves.model.Nave;

import java.util.Optional;
import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.tecnica.naves.api_naves.repository.NaveRepository;


@Component
public class NaveService {

    @Autowired
    private NaveRepository naveRepository;



    public Nave createNave(Nave nave){
        return naveRepository.save(nave);
    }
    
    @Cacheable("naves")
    public Nave getNaveById(Integer id){
    	System.out.println("Nave" + id);
        Optional<Nave> optionalNave = naveRepository.findById(id);
        if (optionalNave.isPresent()) {
            return optionalNave.get();
        }else{
            return null;
        }

    }

    public List<Nave> getAllNaveByName(String name){
        List<Nave> naves = naveRepository.findByNameContaining(name);
        return naves;
    }

    @CacheEvict("naves")
    public void deleteNave(Integer id){
        naveRepository.deleteById(id);
    }


    public Page<Nave> getAll(Pageable pageable){
        return naveRepository.findAll(pageable);
    }

    @CachePut("naves")
    public Nave updateNave(Nave nave){
        return naveRepository.save(nave);
    }
}
