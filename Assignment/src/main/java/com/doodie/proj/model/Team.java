package com.doodie.proj.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="TEAM_DETAILS")
public class Team {
	@Id
	@GeneratedValue
	private int teamId;
	private String name;
	private String location;
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(joinColumns=@JoinColumn(name="TEAM_ID"),
				inverseJoinColumns=@JoinColumn(name="PLAYER_ID"))		
	private List<Player> players = new ArrayList<Player>();
	
	public Team() {}
	
	public Team(int teamId,String name, String location) {
		super();
		this.name = name;
		this.teamId = teamId;
		this.location = location;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public int getTeamId() {
		return teamId;
	}
	
	public void setTeamId(int teamId) {
		this.teamId = teamId;
		updatedAt = new Date();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		updatedAt = new Date();
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
		updatedAt = new Date();
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		updatedAt = new Date();
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
		updatedAt = new Date();
	}
	
	public void assignTeam(Player player) {
		this.getPlayers().add(player);
		player.setTeam(this);
	}
	
	
	
}
