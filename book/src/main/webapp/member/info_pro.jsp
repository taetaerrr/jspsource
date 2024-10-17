<%@page import="dao.MemberDAO"%>
<%@page import="dto.ChangeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 1. 	
ChangeDTO changeDto = new ChangeDTO();
changeDto.setUserid(request.getParameter("current_password"));
changeDto.setCurrentPassword(request.getParameter("userid"));
changeDto.setChangePassword(request.getParameter("change_password"));

// 2. 
MemberDAO dao = new MemberDAO();
int updateRow = dao.update(changeDto);

	if(updateRow == 0){
	response.sendRedirect("info.jsp");
	} else{
		response.sendRedirect("login.jsp");
	}
%>