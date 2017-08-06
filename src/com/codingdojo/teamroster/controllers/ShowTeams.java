package com.codingdojo.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.teamroster.models.*;

@WebServlet("/")
public class ShowTeams extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("teams") == null) {
			session.setAttribute("teams", new ArrayList<Team>());
		}
		@SuppressWarnings("unchecked")
		ArrayList<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
		request.setAttribute("teams", teams);
		
		request.getRequestDispatcher("/WEB-INF/views/teams.jsp").forward(request, response);
	}

}
