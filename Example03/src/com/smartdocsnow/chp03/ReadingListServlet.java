package com.smartdocsnow.chp03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReadingListServlet
 */
@WebServlet("/ReadingListServlet")
public class ReadingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Retrieve the current List from user's session:
		List<String> readingList = null;
		HttpSession session = request.getSession();
		Object o = session.getAttribute("readingList");
		if ( o == null )
		{
			readingList = new ArrayList<String>();
			session.setAttribute("readingList", readingList);
		}
		else
		{
			readingList = (List<String>) o;
		}
		
		
		// Add the selected item to the List:
		String book = request.getParameter("book");
		if (book != null)
			readingList.add(book);
		
		//Also keep track of the number of items in the list
		session.setAttribute("itemCount", readingList.size());
		
		
		//Reroute the user back to the main reading list form:
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
//		doGet(request, response);
	}

}
