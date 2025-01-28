package com.devsuperior.gamevault.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.gamevault.entities.Game;
import com.devsuperior.gamevault.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{

        // @Query(nativeQuery = true, value = "") é usado para especificar uma consulta SQL

        @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
        List<GameMinProjection> searchByList(Long listId);
}

// JpaRepository possui metodos de consulta, inserção, atualização, deleção e outras operações básicas
// As consultas SQL são postas dentro do REPOSITORY
// O resultado da consulta deve ser uma interface ( Projection ) e é usado como parâmetro o que é necessário para a consulta ( neste caso o id da lista )
