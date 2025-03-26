package com.tecnica.naves.api_naves.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnica.naves.api_naves.model.Nave;

@Repository
public interface NaveRepository extends JpaRepository<Nave,Integer> {
    List<Nave> findByNameContaining(String name);
    
}
