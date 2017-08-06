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

@WebServlet("/teams")
public class ShowRoster extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teamID = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
		Team team = teams.get(teamID);
		request.setAttribute("team", team);
		request.setAttribute("teamID", teamID);
		request.getRequestDispatcher("/WEB-INF/views/roster.jsp").forward(request, response);
	}

}
