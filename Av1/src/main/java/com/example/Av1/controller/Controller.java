package com.example.Av1.controller;

import com.example.Av1.service.IbgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    //Classe de serviços
    @Autowired
    IbgeService service = new IbgeService();

    @GetMapping("/noticiasereleases")
    public String obterNoticiasReleases(){
        return service.obterNoticiasReleases();
    }

    @GetMapping("/noticias")
    public String obterNoticias(){
        return service.obterNoticias();
    }

    @GetMapping("/releases")
    public String obterReleases(){
        return service.obterReleases();
    }

}

