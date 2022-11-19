package com.sunedu.api.integration.reniec;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReniecApi {
    
    @Autowired
    private RestTemplate restTemplate;


    public UserReniec findExitsUserByDni(String dni){

        UserReniec reniec = null;
        


        try {

           reniec = restTemplate.getForObject("https://app-reniec.herokuapp.com/api/persona/dni={dni}&apiKey=1354bc88-3dea-44b5-a090-08af31722829", UserReniec.class, dni);
           

        } catch (Exception e) {
            
            System.out.println("No existe el usuario");
        }
      

        return reniec;

    }
}
