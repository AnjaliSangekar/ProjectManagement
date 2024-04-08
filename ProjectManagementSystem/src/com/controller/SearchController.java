package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.ProjectBO;
import com.dao.projectdao;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		
		ProjectBO sb1 = projectdao.getData(name);
		
		
		pw.print("<link rel=\"stylesheet\" href=\"css\\style.css\">");
		
		pw.print("<div id='header' background-color= '#000080'>");
		
		pw.print("<h1 id='h1' color='white'> Project Listing </h1>");
		pw.print("<center>");
		pw.print("<img id='img' alt='img' src='img/Logo.svg' >");
		pw.print("</center>");
		
		pw.print("</div>");
		
		pw.print("<div class=\"sidebar\">" + 
				      "<a href=\"home.html\"><img src=\"img/Dashboard.svg\"></a>"+  
			  	  	  "<br>" + 
					  "<form action=\"ProjectListController\" method=\"post\">"+ 
					  "<br>"+
					  "<button class=\"btn\"> <img src=\"img/Project-list.svg\"> </button>" +
					  "</form>"+ 
					  
					  "<hr>" +
				      "<a href=\"project.html\"><img src=\"img/create-project.svg\"></a><br> <br>" +
					  "<a href=\"login.html\" class='log'><img src=\"img/Logout.svg\"></a></div> <br>");
		
		
		//pw.print("<a href='home.html' > <input type='button' id='btn' value='search'> </a> <br><br>");
		
		pw.print(" <div class='search'>\r\n" + 
				"        <input class='search-input' type='search' placeholder='search' width='600px'>\r\n" + 
				"    </div><br><br>");
		
		pw.print("<table width='100%'>");
		
		//pw.print("<a href='home.html' > <input type='button' id='btn' value='home'> </a> <br><br>");
		
		
		pw.print("<tr> <th>ID</th> <th width='300px'>Name</th> <th>Reason</th> <th>Type</th> <th>Division</th> <th>Category</th> <th>Priority</th> <th>Department</th> <th>Location</th> <th>Status</th> </tr>");
		
		List<ProjectBO > list = projectdao.getProjectList();
		
		for(ProjectBO sb: list)
		{
			pw.print("<tr><td>"+sb.getId()+"</td><td>"+sb.getName() +"<br><br>" + sb.getStartdate() +" to "+ sb.getEnddate() +"</td><td>"+sb.getReason()+"</td><td>"+sb.getType()+"</td><td>"+sb.getDivision()+"</td><td>"+sb.getCategory()+"</td><td>"+sb.getPriority()+"</td><td>"+sb.getDepartment()+"</td><td>"+sb.getLocation()+"</td><td>"+sb.getStatus()+"</td><td><a href='EditController?id="+sb.getId()+"'> change status </a> </td></tr>");       
		}
				
		pw.print("</table>");	
		
	}

	

}
