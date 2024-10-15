package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BookDTO;


public class BookDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	static {		
		// 드라이버 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##java";
		String password = "12345";
		
		return DriverManager.getConnection(url, user, password);
	}
	
	public void close(Connection con, PreparedStatement ptstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(ptstmt!=null) ptstmt.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



public void close(Connection con, PreparedStatement ptstmt) {
	try {
		if(ptstmt!=null) ptstmt.close();
		if(con!=null) con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	// CRUD 메소드

	// R(Read) - 전체조회, 특정(pk) 조회, 제목 조회
	// 조회 메소드 작성하기
	// 리턴 타입 : List<~~~DTO> or ~~~DTO ==> sql 구문 보고 결정
	// List<~~~DTO> : where 절 없는 경우, where 절이 pk 가 아니면
	// ~~~DTO :	where 절이 pk인 경우

	// 전달인자 : () 에 어떻게 작성할 것인가?
	//			- sql 구문의 ? 를 보고 결정
	public BookDTO getRow(int code) {
		
		BookDTO dto = null;
		
		try {
			
			con = getConnection();
			String sql = "SELECT *FROM BOOKTBL WHERE CODE = ?";
			pstmt = con.prepareStatement(sql);
			// sql 구문 ? 해결
			pstmt.setInt(1, code); // 첫번째 물음표에 받은 값(code) 세팅
			rs = pstmt.executeQuery();
			// where pk 사용된 경우 하나만 추출됨
			if(rs.next()) {
				dto = new BookDTO();
				dto.setCode(rs.getInt("code"));
				dto.setTiitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));	
				dto.setDesciption(rs.getString("description"));				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return dto;
	}


	public List<BookDTO> getList(){
		// 전체 조회
		List<BookDTO> list = new ArrayList<BookDTO>();
		try {
			
			con = getConnection();
			String sql = "SELECT * FROM BOOKTBL";
			pstmt = con.prepareStatement(sql);
			// sql 구문 ? 해결
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// dto 에 컬럼 별로 담구 list 에 추가
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getInt("code"));
				dto.setTiitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));	
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return list;
	}
	
	// U(Update) - 수정
	// 수정 메소드 작성하기
	// 리턴타입 : int
	public int update(BookDTO updateDto) {
		
		int updateRow = 0;
		
		try {
			con = getConnection();
			// ? 가 두개 이상이면 무조건 dto사용
			String sql = "UPDATE BOOKTBL SET PRICE ?, description=? WHERE code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, updateDto.getPrice());
			pstmt.setString(2, updateDto.getDesciption());
			pstmt.setInt(3, updateDto.getCode());
			
			updateRow = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return updateRow;
	}
	
	// D(Delete) - 삭제
		// 삭제 메소드 작성하기
		// 리턴타입 : int
public int delete(int code) {
		
		int deleteRow = 0;
		
		try {
			
			con = getConnection();
			String sql = "DELETE From BOOKTBL WHERE code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			deleteRow = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return deleteRow;
	}	
}





































