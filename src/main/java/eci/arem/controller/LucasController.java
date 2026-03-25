package eci.arem.controller;

import eci.arem.service.LucasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LucasController {

    @Autowired
    LucasService lucasService;

    @GetMapping("/lucas")
    public String getSequence(@RequestParam int n){
        try{
            return lucasService.writeSequence(n);
        }
        catch (Exception e){
            return "Algo esta yendo mal";
        }

    }
}
