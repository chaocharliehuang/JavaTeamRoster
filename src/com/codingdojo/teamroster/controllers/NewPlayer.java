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

@WebServlet("/addplayer")
public class NewPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		int teamID = Integer.parseInt(request.getParameter("id"));
    		
    		HttpSession session = request.getSession();
    		@SuppressWarnings("unchecked")
    		ArrayList<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
    		Team team = teams.get(teamID);
    		
    		request.setAttribute("teamID", teamID);
    		request.setAttribute("teamName", team.getTeam_name());
    		request.getRequestDispatcher("/WEB-INF/views/newplayer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teamID = Integer.parseInt(request.getParameter("teamID"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
		Player player = new Player(firstName, lastName, age);
		teams.get(teamID).addPlayer(player);
		session.setAttribute("teams", teams);
		
		response.sendRedirect("/TeamRoster/teams?id=" + teamID);
	}

}
