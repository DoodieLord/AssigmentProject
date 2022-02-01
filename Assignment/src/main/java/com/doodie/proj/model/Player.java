package com.doodie.proj.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table (name="PLAYER_DETAILS")
public class Player {
	@Id
	@GeneratedValue
	private int playerId;
	private String name;
	private int age;
	private Date createdAt;
	private Date updatedAt;
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private Team team;
	
	public Player() {}
	
	public Player(String name,int age,int teamId) {
		this.name = name;
		this.age = age;
		this.createdAt = new Date();
		this.updatedAt = createdAt;
		this.team = new Team(teamId,"","");
	}
	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	
	public int getPlayerId() {
		return playerId;
	}



	public void setPlayerId(int playerId) {
		this.playerId = playerId;
		updatedAt = new Date();
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		updatedAt = new Date();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
		updatedAt = new Date();
	}
	@Override
	public String toString() {
		return "Player [id=" + playerId + ", name=" + name + ", age=" + age + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
	
	
	
}
