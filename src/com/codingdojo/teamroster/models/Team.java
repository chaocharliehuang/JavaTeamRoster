package com.codingdojo.teamroster.models;

import java.util.ArrayList;

public class Team {
	private String team_name;
	private ArrayList<Player> players;
	private int numberOfPlayers = 0;
	
	public Team() {
		this("", new ArrayList<Player>());
	}
	
	public Team(String team_name) {
		this(team_name, new ArrayList<Player>());
	}
	
	public Team(String team_name, ArrayList<Player> players) {
		this.team_name = team_name;
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
		this.numberOfPlayers++;
	}
	
	public void removePlayer(Player player) {
		this.players.remove(player);
		this.numberOfPlayers--;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}
}
