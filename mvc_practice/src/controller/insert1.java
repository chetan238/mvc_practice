package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.RegDAO;
import VO.RegVO;

/**
 * Servlet implementation class insert1
 */
@WebServlet("/insert1")
public class insert1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insert1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = request.getParameter("flag");
		if (s.equals("search")) {
			// insert(request,response);
			search(request, response);
		}

		if (s.equals("insert")) {
			insert(request, response);
			search(request, response);
		}

		if (s.equals("delete")) {
			delete(request, response);
			search(request, response);
		}

		if (s.equals("edit")) {
			edit(request, response);
			response.sendRedirect("newreg.jsp");
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String s = request.getParameter("flag");
		if (s.equals("insert")) {
			insert(request, response);
			search(request, response);
			//insert(request, response);
		}
		if (s.equals("editdb")) {
			editdb(request, response);
			search(request, response);
			//insert(request, response);
		}
		
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 = request.getParameter("fname");
		String s2 = request.getParameter("lname");
		String s3 = request.getParameter("uname");
		String s4 = request.getParameter("pname");
		
		RegVO p = new RegVO();
		p.setFname(s1);
		p.setLname(s2);
		p.setUname(s3);
		p.setPname(s4);
		RegDAO e = new RegDAO();
		e.insert(p);

	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegDAO d = new RegDAO();
		List ls = d.search();
		HttpSession s = request.getSession();
		s.setAttribute("list", ls);
		response.sendRedirect("search.jsp");

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stu
		RegDAO e = new RegDAO();
		int id = Integer.parseInt(request.getParameter("id_del"));
		e.delete(id);

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_edit"));
		RegDAO e = new RegDAO();
		List l = e.edit(id);
		for(int i=0;i<l.size();i++){
			System.out.println(Arrays.toString(l.toArray()));
		} 
		HttpSession ss = request.getSession();
		ss.setAttribute("list", l);

	}
	
	protected void editdb(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stu
		int id = Integer.parseInt(request.getParameter("uid"));
		String s1 = request.getParameter("fname");
		String s2 = request.getParameter("lname");
		String s3 = request.getParameter("uname");
		String s4 = request.getParameter("pname");
		
		RegVO x = new RegVO();
		x.setId(id);
		x.setFname(s1);
		x.setLname(s2);
		x.setUname(s3);
		x.setPname(s4);
		RegDAO e = new RegDAO();
		e.update(x);

	}

}
