package com.doodie.proj.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodie.proj.model.Player;
import com.doodie.proj.model.Team;
import com.doodie.proj.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public Optional<Team> getTeamByPlayerId(int id){
		Optional<Player> player =  playerRepository.findById(id);
		Optional<Team> team = Optional.of(player.get().getTeam());
		return team;
		
	}
	
	public List<Player> getAllPlayers(){
		List<Player> players = (List<Player>)playerRepository.findAll();
		return players;
	}
	
	public List<Player> getPlayersByTeamId(int id){
		List<Player> players = new ArrayList<>();
		playerRepository.findByTeamId(id).forEach(players::add);
		return players;
	}
	
	public Optional<Player> getPlayer(int id){
		return playerRepository.findById(id);
	}
	public void addPlayer(Player player) {
		playerRepository.save(player);
	}
	public void updatePlayer(Player player) {
		playerRepository.save(player);
	}
	public void deletePlayer(int id) {
		playerRepository.deleteById(id);
	}
}
