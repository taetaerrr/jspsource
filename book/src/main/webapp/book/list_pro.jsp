<%@page import="dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	BookDAO dao = new BookDAO();
	List<BookDTO> list = dao.getList();
	
	// 이동 방식
	//  response.senRedirect()
	// 			.forward()
	
	// 어떤 특정 값(객체)을 다른 페이지(jsp,servlet)들과 공유
	// 1. session 	session.setAttribute("list", list); + 페이지 이동(이동 방식 제한 조건 없음 => 대부분 sendRedirect())
	// - 세션은 대표적으로 로그인 정보를 담음 그외는 대부분 리퀘스트
	// 2. request 	request.setAttribute("list", list); + 페이지 이동(이동 방식이 제한 됨 => forward())
	request.setAttribute("list", list);
	
	pageContext.forward("list.jsp");

%>