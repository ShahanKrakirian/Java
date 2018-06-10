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

import com.shahan.teamroster.models.Team;

@WebServlet("/TeamDetail")
public class TeamDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeamDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession();		

		ArrayList<Team> teams = new ArrayList<Team>();
		teams = (ArrayList<Team>) session.getAttribute("teamlist");
		
		int index = Integer.parseInt(request.getParameter("team"));
		Team currTeam = teams.get(index);
		
		System.out.println(index);
		System.out.println(currTeam);
		
		request.setAttribute("index", index);
		request.setAttribute("team", currTeam);
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
