package com.shahan.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shahan.teamroster.models.Player;
import com.shahan.teamroster.models.Team;

/**
 * Servlet implementation class DeletePlayer
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePlayer() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ArrayList<Team> teams = (ArrayList<Team>) session.getAttribute("teamlist");
		
		Team currTeam = teams.get(Integer.parseInt(request.getParameter("team")));
		ArrayList<Player> players = currTeam.getPlayers();
		players.remove(Integer.parseInt(request.getParameter("player")));
		currTeam.setPlayers(players);
		teams.set(Integer.parseInt(request.getParameter("team")), currTeam);
		session.setAttribute("teamlist", teams);
		
		response.sendRedirect("/TeamRoster/TeamDetail?team=" + request.getParameter("team"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
