package com.sunedu.api.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.sunedu.api.model.Registro;

import com.sunedu.api.repositories.RegistroRepository;
import com.sunedu.api.repositories.UsuarioRepository;
import com.sunedu.api.integration.ExisteUsuario;
import javax.validation.Valid;


@Controller
public class RegistroController {
    
    @Autowired
    private ExisteUsuario validando;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(validando);
    }
    private static final String INDEX ="layout/registro"; 
    private static String MODEL_CONTACT="registro";
    private final RegistroRepository registroData;

    public RegistroController(RegistroRepository registroData,
        UsuarioRepository usuariosData    
        ){
        this.registroData = registroData;
    }      

    @GetMapping("app/registro")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new Registro());
        return INDEX;
    }    

    @PostMapping("app/registro")
    public String createSubmitForm(Model model, 
        @Valid Registro objRegistro, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute(MODEL_CONTACT, objRegistro);
            model.addAttribute("mensaje", "Persona no existe en reniec");
            
        }else{
            this.registroData.save(objRegistro);
            model.addAttribute(MODEL_CONTACT, objRegistro);
            model.addAttribute("mensaje", "Se registro ");
        }
        return INDEX;
    }

}