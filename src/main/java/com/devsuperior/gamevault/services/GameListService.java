package com.devsuperior.gamevault.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.gamevault.dto.GameListDTO;
import com.devsuperior.gamevault.entities.GameList;
import com.devsuperior.gamevault.repositories.GameListRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {
        
        @Autowired
        public GameListRepository gameListRepository;

        @Transactional(readOnly = true)
        public List<GameListDTO> findAll(){
                List<GameList> result = gameListRepository.findAll();
                return result.stream().map(x -> new GameListDTO(x)).toList();
                
        }

}
