package com.shahan.teamroster.models;

import java.util.ArrayList;

public class Team implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String team_name;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Team() {}
	
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
	public void addPlayer(Player player) {
		this.players.add(player);
	}
}
