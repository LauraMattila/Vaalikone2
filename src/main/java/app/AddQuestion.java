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
    name = "AddQuestion",
    urlPatterns = {"/addquestion"}
)
public class AddQuestion extends HttpServlet {
	
	private Dao dao;
	
	public void init() {
		
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "rimanali123");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String question=request.getParameter("KYSYMYS");
		ArrayList<Questions> list=null;
			
		if (dao.getConnection()) {
				
			list=dao.addQuestions(question);
		}
		
		request.setAttribute("questionslist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin.jsp");
		rd.forward(request, response);
	}
}