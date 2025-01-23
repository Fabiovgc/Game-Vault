package com.devsuperior.gamevault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.gamevault.dto.GameDTO;
import com.devsuperior.gamevault.dto.GameMinDTO;
import com.devsuperior.gamevault.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
        
        @Autowired
        private GameService gameService;

        @GetMapping
        public List<GameMinDTO> findAll(){
                List<GameMinDTO> dto = gameService.findAll();
                return dto;
        }

        // Annotation @PathVariable é usada para fazer a ligação entre a Id que será enviada e a Id passada neste método
        // É preciso definir a URI (o endpoint) usando a sintaxe abaixo quando existem mais de um metodo HTTP GET na mesma classe Controller
        @GetMapping(value = "/{id}")
        public GameDTO findById(@PathVariable Long id){
                GameDTO result = gameService.findById(id);
                return result;
        }

}
