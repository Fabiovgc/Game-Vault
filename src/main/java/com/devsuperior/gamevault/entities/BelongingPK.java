package com.devsuperior.gamevault.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// Usando a annotation @Embeddable para encapsular dois atributos em uma só classe
@Embeddable
public class BelongingPK {

        // Esses dois atributos não podem estar na classe Belongin pois não pode ter uma ID para duas entidades
        // Essa classe deve ser referenciada em Belonging para usar Game e GameList


        // ManyToOne = Chave com relação de muitos-para-um
        // JoinColumn = Nome da chave estrangeira
        @ManyToOne
        @JoinColumn(name="game_id")
        private Game game;

        @ManyToOne
        @JoinColumn(name="list_id")
        private GameList list;

        public BelongingPK(){
        }

        public BelongingPK(Game game, GameList list){
                this.game = game;
                this. list = list;
        }

        public Game getGame() {
                return game;
        }

        public void setGame(Game game) {
                this.game = game;
        }

        public GameList getList() {
                return list;
        }

        public void setList(GameList list) {
                this.list = list;
        }


        // Criando Equals e HashCode para os dois objetos pois esta é uma chave de comparação multipla

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((game == null) ? 0 : game.hashCode());
                result = prime * result + ((list == null) ? 0 : list.hashCode());
                return result;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                BelongingPK other = (BelongingPK) obj;
                if (game == null) {
                        if (other.game != null)
                                return false;
                } else if (!game.equals(other.game))
                        return false;
                if (list == null) {
                        if (other.list != null)
                                return false;
                } else if (!list.equals(other.list))
                        return false;
                return true;
        }

        
        

}
