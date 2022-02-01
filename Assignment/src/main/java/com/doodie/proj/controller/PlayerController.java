package com.doodie.proj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doodie.proj.model.Player;
import com.doodie.proj.model.Team;
import com.doodie.proj.services.PlayerService;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/teams/{id}/players")
	public List<Player> getPlayersByTeamId(@PathVariable("id") int id){
		return playerService.getPlayersByTeamId(id);
	}
	
	@RequestMapping("/players")
	public List<Player> getAllPlayers(){
		return playerService.getAllPlayers();
	}
	
	@RequestMapping("/players/{id}")
	public Optional<Team> getTeamByPlayerId(@PathVariable int id){
		return playerService.getTeamByPlayerId(id);
	}
	
	@RequestMapping("/teams/{id}/players/{playerId}")
	public Optional<Player> getPlayer(@PathVariable("playerId") int id){
		return playerService.getPlayer(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/teams/{id}/players")
	public void addPlayer(@RequestBody Player player,@PathVariable int id) {
		player.setTeam(new Team(id,"",""));
		playerService.addPlayer(player);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/teams/{id}/players")
	public void updatePlayer(@RequestBody Player player,@PathVariable int id) {
		player.setTeam(new Team(id,"",""));
		playerService.updatePlayer(player);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/teams{teamId}/players/{id}")
	public void deletePlayer(@PathVariable int id) {
		playerService.deletePlayer(id);
	}
}
