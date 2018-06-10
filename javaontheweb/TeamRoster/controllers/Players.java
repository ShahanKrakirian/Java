package com.shahan.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shahan.teamroster.models.Player;
import com.shahan.teamroster.models.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Players() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession();		
		ArrayList<Team> teams = new ArrayList<Team>();
		
		teams = (ArrayList<Team>) session.getAttribute("teamlist");
		int index = Integer.parseInt(request.getParameter("team"));
		Team currTeam = teams.get(index);
		request.setAttribute("index", index);
		request.setAttribute("team", currTeam);
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewPlayer.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//Create player
		Player playerToAdd = new Player(); 
		playerToAdd.setFirst_name(request.getParameter("first_name"));
		playerToAdd.setLast_name(request.getParameter("last_name"));
		playerToAdd.setAge(Integer.parseInt(request.getParameter("age")));
		
		//Get the player's team
		ArrayList<Team> teams = new ArrayList<Team>();
		teams = (ArrayList<Team>) session.getAttribute("teamlist");
		Team currTeam = teams.get(Integer.parseInt(request.getParameter("team"))); //Exists
		currTeam.addPlayer(playerToAdd);
		
		teams.set(Integer.parseInt(request.getParameter("team")), currTeam);
		session.setAttribute("teamlist", teams);
		request.setAttribute("currTeam", currTeam);

		response.sendRedirect("/TeamRoster/TeamDetail?team=" + request.getParameter("team"));
		
	}
}
