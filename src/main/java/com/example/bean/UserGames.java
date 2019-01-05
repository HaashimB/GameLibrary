package com.example.bean;

import javax.persistence.*;

@Entity
public class UserGames {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userId;
    private int gameId;

    public UserGames(int userId, int gameId){
        this.userId = userId;
        this.gameId = gameId;
    }

    public UserGames(){
    }

    public Integer getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }
}
