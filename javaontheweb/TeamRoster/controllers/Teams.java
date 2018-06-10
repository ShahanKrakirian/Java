package com.shahan.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shahan.teamroster.models.Team;
import com.shahan.teamroster.models.Roster;

@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Teams() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
		Roster roster = new Roster();

        if (session.getAttribute("teamlist") == null) {
    		session.setAttribute("teamlist", roster.getTeams());
        }
		
		request.setAttribute("teamlist", session.getAttribute("teamlist"));
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewTeam.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Get current teams from session, put into list. 
		ArrayList<Team> currTeams = new ArrayList<Team>();
		currTeams = ((ArrayList<Team>) session.getAttribute("teamlist"));
		
		//Create new team, add to list, put into session.
		Team t1 = new Team();
		t1.setTeam_name(request.getParameter("team"));
		currTeams.add(t1);
		session.setAttribute("teamslist", currTeams);
		
		response.sendRedirect("/TeamRoster/Home");

	}

}
