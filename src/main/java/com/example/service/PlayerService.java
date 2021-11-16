package com.example.service;

import com.example.model.PlayerDto;
import com.example.model.PlayerEntity;
import com.example.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    public List<PlayerEntity> list() {
        List<PlayerEntity> players = new ArrayList<>();
        playerRepo.findAll().forEach(players::add);
        return players;
    }

//    public List<PlayerEntity> createPlayer(Player player) {
//        playerRepo.save(player);
//        return players;
//    }

    public PlayerEntity getPlayerById(String id) {
        return playerRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public PlayerEntity updateHeight(String id) {
        PlayerEntity player = getPlayerById(id);
        player.setHeight(player.getHeight() + 1);
        return playerRepo.save(player);
    }

    public PlayerEntity updateWeight(String id) {
        PlayerEntity player = getPlayerById(id);
        player.setWeight(player.getWeight() + 1);
        return playerRepo.save(player);
    }
}
