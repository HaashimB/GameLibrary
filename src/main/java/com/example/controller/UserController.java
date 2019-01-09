package com.example.controller;

import com.example.bean.Game;
import com.example.bean.User;
import com.example.manager.UserGamesManager;
import com.example.repository.GameRepository;
import com.example.repository.UserGamesRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private UserGamesManager userGamesManager;

    public UserController(UserRepository userRepository, UserGamesRepository userGamesRepository, GameRepository gameRepository) {
        this.userGamesManager = new UserGamesManager(userRepository, gameRepository, userGamesRepository);
    }

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String password){
        User u = new User(name, password);
        userRepository.save(u);
        return "\n *** Saved User ***\n";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User>getAllUsers() { return userRepository.findAll(); }

    @GetMapping(path="/addGame")
    public @ResponseBody String addGame(@RequestParam int userId, @RequestParam int gameId) {
        try {
            userGamesManager.addUserGame(userId, gameId);
            return "\n *** Added Game *** \n";
        } catch (NoSuchFieldException e) {
            System.out.println("Error: " + e.getMessage());
            return "\n " + e.getMessage() + " \n";
        }

    }

    @GetMapping(path="/games")
    public @ResponseBody Iterable<Game> getUserGames(@RequestParam int userId) {
        return userGamesManager.getUserGames(userId);
    }

    @GetMapping(path="/login")
    public @ResponseBody String login(@RequestParam String username, @RequestParam String password) {
        System.out.println("reached endpoint");
        User u = userRepository.findUserByName(username);
        if(u.getPassword().equals(password)){
            return "Success";
        }else{
            return("incorrect log in details");
        }
    }

}
