package com.sunedu.api.integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sunedu.api.integration.reniec.ReniecApi;
import com.sunedu.api.model.Registro;

@Component
public class ExisteUsuario implements Validator {
    
    

    @Autowired
    private ReniecApi reniecApi;

    @Override
    public boolean supports(Class<?> clazz) {
       
        return Registro.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      
        Registro usuario = (Registro) target;

        if(usuario.getDni().length() > 0){

            if(reniecApi.findExitsUserByDni(usuario.getDni()) == null){

                errors.rejectValue("dni", "invalidate.identificador");

            }
        }
          
    }
    
}
