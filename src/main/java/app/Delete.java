package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Questions;

@WebServlet(
    name = "Delete",
    urlPatterns = {"/delete"}
)
public class Delete extends HttpServlet {
	
	private Dao dao;
	
	public void init() {
		
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "rimanali123");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String id=request.getParameter("KYSYMYS_ID");
		
		ArrayList<Questions> list=null;
		
		if (dao.getConnection()) {
			
			list=dao.deleteQuestions(id);
		}
			
		request.setAttribute("kysymykset", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin.jsp");
		rd.forward(request, response);
	}
}