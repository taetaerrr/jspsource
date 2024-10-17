package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;


/**
 * Servlet implementation class BasicServlet
 */
@WebServlet("*.do")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
	
		String requestUri = request.getRequestURI(); // /login.do
		String conextPath = request.getContextPath();
		String cmd = requestUri.substring(conextPath.length()); // /login.do

		System.out.println("cmd"+cmd);

		Action action = null;
		if (cmd.equals("/list.do")) {
			
		} else if(cmd.equals("/login.do")) {
			//action = new LoginAction("index.jsp");
		} else if(cmd.equals("//register.do")){
			//action = new RegisterAction("/member/login.jsp");
		} else if(cmd.equals("//create.do")){
			//action = new CreateAction("index.jsp");
		}		
		
		ActionForward af = null;

		try {
			action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(af.isRedirect()) {
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response); 
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
