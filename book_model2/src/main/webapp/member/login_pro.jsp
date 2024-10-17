<%@page import="java.util.List"%>
<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");
	
	MemberDTO loginDto = new MemberDTO();
	loginDto.setUserid(request.getParameter("userid"));
	loginDto.setPassword(request.getParameter("password"));
	

	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.isLogin(loginDto);
	

	if(dto != null){
		
		session.setAttribute("loginDto",dto);
		response.sendRedirect("/book/list_pro.jsp");
	} else{		
		response.sendRedirect("login.jsp");
	}

%>