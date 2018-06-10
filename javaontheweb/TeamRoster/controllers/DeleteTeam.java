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

/**
 * Servlet implementation class DeleteTeam
 */
@WebServlet("/DeleteTeam")
public class DeleteTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteTeam() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession();
		
		ArrayList<Team> teams = new ArrayList<Team>();
		teams = (ArrayList<Team>) session.getAttribute("teamlist");
		System.out.println(teams);
		
        int removeIndex = Integer.parseInt(request.getParameter("teamIndex"));
        teams.remove(removeIndex);
        session.setAttribute("teamlist", teams);
		
		
		response.sendRedirect("/TeamRoster/Home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
