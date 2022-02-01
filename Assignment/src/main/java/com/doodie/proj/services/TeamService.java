package com.doodie.proj.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodie.proj.model.Team;
import com.doodie.proj.repository.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepository;
	
	public List<Team> getAllTeams(){
		List<Team> teams = new ArrayList<>();
		teamRepository.findAll().forEach(teams::add);
		return teams;
	}
	
	public Optional<Team> getTeam(int id){
		return teamRepository.findById(id);
	}
	
	public void addTeam(Team team) {
		teamRepository.save(team);
	}
	
	public void updateTeam(int id,Team team) {
		teamRepository.save(team);
	}
	public void deleteTeam(int id) {
		teamRepository.deleteById(id);
	}
}
