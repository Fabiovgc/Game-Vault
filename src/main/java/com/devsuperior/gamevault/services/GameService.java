package com.devsuperior.gamevault.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.gamevault.dto.GameMinDTO;
import com.devsuperior.gamevault.entities.Game;
import com.devsuperior.gamevault.repositories.GameRepository;

// Registrando a classe Service como um componente do sistema (necessário na classe service ou outras classes "comuns")

@Service
public class GameService {
        
        // Instanciando e injetando dependencia para a classe GameRepository
        @Autowired
        private GameRepository gameRepository;

        // Retorna uma lista de games
        // Metodo do tipo List<GamesMinDTO>
        // Metodo nome "findAll"
        // Criando uma "variavel" do tipo List<Game> chamada result / armazenar o valor de gameRepository / usar o método da sua classe pai (JpaRepository) "findAll()"
        // Criando uma "variavel" do tipo List<GameMinDTO> chamada dto / armazenar o valor de result/ usando o metodo .map() para alterar o valor de result para List<GameMinDTO>
        // Metodo retorna o valor de result que é uma variável do tipo List<GameMinDTO> ( o método pai deve corresponder)
        public List<GameMinDTO> findAll(){
                List<Game> result = gameRepository.findAll();
                return result.stream().map(x -> new GameMinDTO(x)).toList();

        }

}
