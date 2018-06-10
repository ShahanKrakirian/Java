package com.shahan.teamroster.models;

import java.util.ArrayList;

public class Roster implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Team> teams = new ArrayList<Team>();
	
	public Roster() {}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	public void addTeam(Team teamToAdd) {
		this.teams.add(teamToAdd);
	}
	
	
	
	
}
