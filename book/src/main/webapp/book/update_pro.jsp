 <%@page import="dto.BookDTO"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	request.setCharacterEncoding("utf-8");

//1. 가져올 값(== 넘어오는 값)이 있는지 확인 
	// 시작하는 페이지에서 form이 존재하는 경우 넘어오는 값이 있음
	// a 태그 ? 다음에 넘어오는지 확인
			
	// pk, 수정할 컬럼 가져오기
	BookDTO updateDto = new BookDTO();
	updateDto.setCode(Integer.parseInt(request.getParameter("code")));
	updateDto.setPrice(Integer.parseInt(request.getParameter("price")));	
	updateDto.setDesciption(request.getParameter("description"));
	
	// 2. DB 작업
	BookDAO dao = new BookDAO();
	int updateRow = dao.update(updateDto);

	// 3. 결과값 공유(수정,삭제,삽입 x)
	
	// 4. 페이지 이동(client 볼 페이지)
	// 0 이 리턴되면 modify_pro.jsp
	// 1 이 리턴되면 list_pro.jsp
	if(updateRow == 0){
	response.sendRedirect("modify_pro.jsp?code="+updateDto.getCode());
	} else{
		// list 는 getparameter가 없어서 추가로 안써도됨
		response.sendRedirect("list_pro.jsp");
	}
%>









