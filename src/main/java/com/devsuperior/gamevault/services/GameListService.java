package com.devsuperior.gamevault.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.gamevault.dto.GameListDTO;
import com.devsuperior.gamevault.entities.GameList;
import com.devsuperior.gamevault.projections.GameMinProjection;
import com.devsuperior.gamevault.repositories.GameListRepository;
import com.devsuperior.gamevault.repositories.GameRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {
        
        @Autowired
        public GameListRepository gameListRepository;

        @Autowired
        public GameRepository gameRepository;

        @Transactional(readOnly = true)
        public List<GameListDTO> findAll(){
                List<GameList> result = gameListRepository.findAll();
                return result.stream().map(x -> new GameListDTO(x)).toList();
                
        }

        // Este metodo atualiza a lista de jogos no banco de dados dados, dado uma lista, uma origem e destino
        // O metodo HHTTP utilizado depende da IDEMPOTÊNCIA : 
        // Se a operação for realizada varias vezes produzir o mesmo resultado sempre igual = Idempotente = Utilizamos o Verbo PUT
        // Se a cada vez que a operação for realizada produzir um resultado diferente = NÃO Idempotente = Utilizamos o Verbo POST
        @Transactional
        public void move(Long listId, int sourceIndex, int destinationIndex){
                List<GameMinProjection> list = gameRepository.searchByList(listId);
                GameMinProjection obj = list.remove(sourceIndex);
                list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++){
                gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

        }

}
