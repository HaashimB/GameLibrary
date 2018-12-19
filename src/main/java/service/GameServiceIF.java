package service;

import bean.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GameRepository;

import java.util.List;

public interface GameServiceIF {
    public List<Game> findAll();
}
