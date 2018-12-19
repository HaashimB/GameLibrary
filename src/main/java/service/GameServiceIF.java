package service;

import bean.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GameRepository;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll() {
        return (List<Game>) gameRepository.findAll();
    }
}
