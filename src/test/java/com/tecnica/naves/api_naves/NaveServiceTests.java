package com.tecnica.naves.api_naves;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.tecnica.naves.api_naves.model.Nave;
import com.tecnica.naves.api_naves.Service.NaveService;




@SpringBootTest
@Profile("test")
public class NaveServiceTests {
    
    @Autowired
     NaveService naveService;
    
    @BeforeEach
    void init(){
        Nave nave = new Nave("Nave-1");
        naveService.createNave(nave);
        Nave nave2 = new Nave("Nave-2");
        naveService.createNave(nave2);
        Nave nave3 = new Nave("Nave-3");
        naveService.createNave(nave3);

    }
    @AfterEach
    void delAll(){
        Page<Nave> res = naveService.getAll(PageRequest.of(0, 100));
        for (Nave nave : res) {
            naveService.deleteNave(nave.getId());
        }
    }
    

    @Test
    void testCreateNave(){
        Nave nave = new Nave("Nave-4"); 
        Nave result = naveService.createNave(nave);
        
        assertNotNull(result);
    }

    @Test
    void testGetNaveById(){
        Nave nave = new Nave("Nave-4"); 
        naveService.createNave(nave);
        Nave result = naveService.getNaveById(nave.getId()); // Nave-4

        assertNotNull(result);
    }

    @Test
    void testGetNaveByIdNull(){
        Nave result = naveService.getNaveById(4);
        assertNull(result);
    }




    @Test
    void testGetAllNavesByName(){
        List<Nave> result = naveService.getAllNaveByName("N");

        assertFalse(result.isEmpty());
    }

    @Test
    void testDeleteNave(){
        naveService.deleteNave(2); // Nave-2 Deleted

        assertEquals(3, naveService.getAll(PageRequest.of(0,400)).getNumberOfElements());
    }

    @Test
    void testGetAll(){
        Page<Nave> result = naveService.getAll(PageRequest.of(0, 10));
        System.out.println("GetAll"+ naveService.getAll(PageRequest.of(0, 10)).getNumberOfElements());

        assertInstanceOf(Page.class, result);
        assertEquals(3, result.getNumberOfElements());
    }

    @Test 
    void testUpdateNave(){
        Nave result = naveService.updateNave(new Nave("Plomer"));

        assertEquals("Plomer", result.getName());
        
    }


}
