package com.shahan.greatnumbergame.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
				
		if (session.getAttribute("answer") == null){
			Random r = new Random();
			int rand = r.nextInt(101);
			session.setAttribute("answer", rand);
		} else {
			Random r = new Random();
			int rand = r.nextInt(101);
			session.setAttribute("answer", rand);
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int guess = Integer.parseInt(request.getParameter("guess"));
		
		HttpSession session = request.getSession();		
		
		if (guess > (Integer) session.getAttribute("answer")){
			request.setAttribute("status", "high");
		} else if (guess < (Integer) session.getAttribute("answer")) {
			request.setAttribute("status", "low");
		}
		else {
			request.setAttribute("status", "correct");
		}

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
        view.forward(request, response);
	}

}