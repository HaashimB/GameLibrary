package com.example.repository;

import com.example.bean.UserGames;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGamesRepository extends CrudRepository<UserGames, Long> {
    Iterable<UserGames> findAllByUserId(int userId);
}
