package com.devsuperior.gamevault.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// Declarando a classe como uma entidade
// Declarando o nome da classe como "tb_game"
@Entity
@Table(name="tb_game")
public class Game {
        
        // Declarando que "Long Id será nossa ID da classe"
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        // Declarando que o nome da coluna na tabela do banco de dados será "game_year"
        @Column(name="game_year")
        private Integer year;

        private String genre;

        private String platforms;

        private Double score;

        private String imgUrl;

        // definindo propriedades "longDescription" e "shortDescription" como texto, não VARCHAR (255 caracteres),

        @Column(columnDefinition = "TEXT")
        private String shortDescription;

        @Column(columnDefinition = "TEXT")
        private String longDescription;

        // Constructor vazio (sem argumentos) para que o JPA mapeie os objetos Java para o banco de dados no processo de deserialização.

        public Game(){
        }

        // Constructor com parâmetros para instanciar a classe 

        public Game(Long id, String title, Integer year,
         String genre, String platforms, Double score, String imgUrl, 
         String shortDescription, String longDescription){
                this.id = id;
                this.title = title;
                this.year = year;
                this.genre = genre;
                this.platforms = platforms;
                this.score = score;
                this.imgUrl = imgUrl;
                this.shortDescription = shortDescription;
                this.longDescription = longDescription;
        }


        // Getters and Setters - Encapsulamento


        public Long getId() {
                return id;
        }


        public void setId(Long id) {
                this.id = id;
        }


        public String getTitle() {
                return title;
        }


        public void setTitle(String title) {
                this.title = title;
        }


        public Integer getYear() {
                return year;
        }


        public void setYear(Integer year) {
                this.year = year;
        }


        public String getGenre() {
                return genre;
        }


        public void setGenre(String genre) {
                this.genre = genre;
        }


        public String getPlatforms() {
                return platforms;
        }


        public void setPlatforms(String platforms) {
                this.platforms = platforms;
        }

        public Double getScore() {
                return score;
        }


        public void setScore(Double score) {
                this.score = score;
        }


        public String getImgUrl() {
                return imgUrl;
        }


        public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
        }


        public String getShortDescription() {
                return shortDescription;
        }


        public void setShortDescription(String shortDescription) {
                this.shortDescription = shortDescription;
        }


        public String getLongDescription() {
                return longDescription;
        }


        public void setLongDescription(String longDescription) {
                this.longDescription = longDescription;
        }


        // Comparar dois objetos através do ID

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
                Game other = (Game) obj;
                if (id == null) {
                        if (other.id != null)
                                return false;
                } else if (!id.equals(other.id))
                        return false;
                return true;
        }

        



}
