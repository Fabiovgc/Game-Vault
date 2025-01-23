package com.devsuperior.gamevault.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.gamevault.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
        
}
