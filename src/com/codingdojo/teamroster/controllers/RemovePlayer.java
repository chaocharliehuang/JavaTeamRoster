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

@WebServlet("/removeplayer")
public class RemovePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		int teamID = Integer.parseInt(request.getParameter("teamID"));
    		int playerID = Integer.parseInt(request.getParameter("playerID"));
    		
    		HttpSession session = request.getSession();
    		@SuppressWarnings("unchecked")
    		ArrayList<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
    		Player player = teams.get(teamID).getPlayers().get(playerID);
    		teams.get(teamID).removePlayer(player);
    		session.setAttribute("teams", teams);
    		
    		response.sendRedirect("/TeamRoster/teams?id=" + teamID);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
