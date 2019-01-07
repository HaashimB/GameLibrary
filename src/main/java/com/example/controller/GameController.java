package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.bean.Game;
import com.example.repository.GameRepository;


@Controller
@RequestMapping(path="/game", method = {RequestMethod.GET, RequestMethod.DELETE})
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewGame (@RequestParam String title, @RequestParam String description) {
        System.out.println("reached add new game");
        Game g = new Game();
        g.setTitle(title);
        g.setDescription(description);
        gameRepository.save(g);
        return "\n *** Saved Game ***\n";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Game>getAllGames(){
        return gameRepository.findAll();
    }

    @DeleteMapping("/remove/{gameId}")
    public String removeGame(@PathVariable int gameId) {
        gameRepository.deleteById(gameId);
        return "\n *** Deleted Game *** \n";
    }
}