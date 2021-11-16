package com.example.repo;

import com.example.model.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo extends CrudRepository<PlayerEntity, String> {

}
