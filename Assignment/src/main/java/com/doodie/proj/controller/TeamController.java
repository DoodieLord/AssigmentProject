package com.doodie.proj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.doodie.proj.model.Team;
import com.doodie.proj.services.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("/teams")
	public List<Team> getAllTeams(){
		return teamService.getAllTeams();
	}
	
	@RequestMapping("/teams/{id}")
	public Optional<Team> getTeam(@PathVariable("id") int id){
		return teamService.getTeam(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/teams")
	public void addTeam(@RequestBody Team team) {
		teamService.addTeam(team);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/teams/{id}")
	public void putTeam(@RequestBody Team team,@PathVariable int id) {
		teamService.updateTeam(id,team);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/teams/{id}")
	public void deleteTeam(@PathVariable int id) {
		teamService.deleteTeam(id);
	}
}
