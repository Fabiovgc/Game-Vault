package com.devsuperior.gamevault.dto;

import com.devsuperior.gamevault.entities.GameList;

public class GameListDTO {
        
        private Long id;
        private String name;

        public GameListDTO(){}

        public GameListDTO(GameList entity){
                id = entity.getId();
                name = entity.getName();
        }

        public Long getId() {
                return id;
        }



        public String getName() {
                return name;
        }



        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((id == null) ? 0 : id.hashCode());
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
                GameListDTO other = (GameListDTO) obj;
                if (id == null) {
                        if (other.id != null)
                                return false;
                } else if (!id.equals(other.id))
                        return false;
                return true;
        }

        
        

}
