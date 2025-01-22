package com.devsuperior.gamevault.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.gamevault.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
        
}

// JpaRepository possui metodos de consulta, inserção, atualização, deleção e outras operações básicas