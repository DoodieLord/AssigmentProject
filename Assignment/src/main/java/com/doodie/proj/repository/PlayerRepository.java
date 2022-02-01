package com.doodie.proj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.doodie.proj.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
	public List<Player> findByTeamId(int id);
}
