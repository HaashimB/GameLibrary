package com.example.manager;

import com.example.bean.Game;
import com.example.bean.User;
import com.example.bean.UserGames;
import com.example.repository.GameRepository;
import com.example.repository.UserRepository;
import com.example.repository.UserGamesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserGamesManager {

    private UserRepository userRepository;
    private GameRepository gameRepository;
    private UserGamesRepository userGamesRepository;

    public UserGamesManager(UserRepository userRepository, GameRepository gameRepository, UserGamesRepository userGamesRepository){
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.userGamesRepository = userGamesRepository;
    }

    public void  addUserGame(int userId, int gameId) throws NoSuchFieldException {
        int resultUserId, resultGameId;

        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Game> optionalGame = gameRepository.findById(gameId);

        if (optionalUser.isPresent() && optionalGame.isPresent() ) {
            User user = optionalUser.get();
            Game game = optionalGame.get();
            resultUserId = user.getId();
            resultGameId = game.getId();

            UserGames u = new UserGames(resultUserId, resultGameId);
            userGamesRepository.save(u);
        } else {
          throw new NoSuchFieldException("User or Game not found");
        }
    }

    public Iterable<Game> getUserGames(int userId) {
        Iterable<UserGames> resultUserGames = userGamesRepository.findAllByUserId(userId);
        ArrayList<Game> games = new ArrayList<>();

        for(UserGames userGame : resultUserGames) {
            int gameId = userGame.getGameId();
            Optional<Game> optionalGame = gameRepository.findById(gameId);
            optionalGame.ifPresent(games::add);
        }
        return games;

    }
}
