package com.example.rest;

import com.example.model.PlayerDto;
import com.example.model.PlayerEntity;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

// TODO: add filter to verify if user has access
@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/api/players", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlayerEntity> list(@PathParam("size") int size, @PathParam("page") int page) throws IOException {
        // TODO: maybe add pagenation as result might be too big
        return playerService.list();
    }

//    @PostMapping(value = "/api/players", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<PlayerEntity> create(@RequestBody @Valid PlayerDto entity) {
//        return playerService.createPlayer(entity);
//    }

    @GetMapping(value = "/api/players/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PlayerEntity get(@PathVariable("id") String id) throws IOException {
        return playerService.getPlayerById(id);
    }

    @PutMapping(value = "/api/players/{id}/weight", produces = MediaType.APPLICATION_JSON_VALUE)
    public PlayerEntity updateWeight(@PathVariable("id") String id) {
        // TODO: Ideally, we should accept a player json input which allow user to adjust accordingly
        return playerService.updateWeight(id);
    }

    @PutMapping(value = "/api/players/{id}/height", produces = MediaType.APPLICATION_JSON_VALUE)
    public PlayerEntity updateHeight(@PathVariable("id") String id) {
        return playerService.updateHeight(id);
    }
}
