package com.tecnica.naves.api_naves.Aspect;



import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AspectConfig.class);


@Before("execution(* com.tecnica.naves.api_naves.Service.NaveService.getNaveById(Integer)) && args(id)")
    public void log(Integer id){
        if (id < 0) {
            logger.error("Se esta intentando acceder a un elemento que no existe con la ID:{}", id);
        }
    }
    
}
