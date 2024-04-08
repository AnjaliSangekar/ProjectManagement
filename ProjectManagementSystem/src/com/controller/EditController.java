package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.ProjectBO;
import com.dao.dao;
import com.dao.projectdao;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProjectBO sb = projectdao.getDataById(id);
		
		pw.print("<link rel=\"stylesheet\" href=\"css\\edit.css\">");
		
		pw.print("<form action='UpdateController' method='post'>");
		
		
		pw.print("<tr><td> <input type='hidden' name='id' value='"+sb.getId()+"'/></td></tr>");
		//pw.print("<tr><td>Status: </td> <td> <input type='text' name='status' value='"+sb.getName()+"'/></td></tr>");
		
		pw.print(" <label for=\"priority\">Status:</label>\r\n" + 
				"			      <select id=\"priority\" name=\"status\" class=\"input\" required>\r\n" + 
				"			        <option value=\"\">Select Status</option>\r\n" + 
				"			        <option value=\"Registered\">Registered</option>\r\n" + 
				"			        <option value=\"Running\">Running</option>\r\n" + 
				"			        <option value=\"Cancelled\">Cancelled</option>\r\n" + 
				"			        <option value=\"Closed\">Closed</option>\r\n" + 
				"			      </select> ");
		
		//pw.print("<br>");
		pw.print("<tr> <td> <input type='submit' value='Update' class='btn'/></td></tr> ");
		
		
		pw.print("</form> ");
		

	}

}
