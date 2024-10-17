package service;

import java.util.List;

import dao.BookDAO;
import dto.BookDTO;

public class BookServicelmpl implements BookService {
	
	private BookDAO dao = new BookDAO();

	@Override
	public List<BookDTO> list() {
		return dao.getList();
	}

	@Override
	public BookDTO read(int code) {
		return dao.getRow(code);
	}

	@Override
	public boolean update(BookDTO updateDto) {
		return dao.update(updateDto)==1?true:false;
	}

	@Override
	public boolean delete(int code) {
		return dao.update(code)==1?true:false;
	}

	@Override
	public boolean insert(BookDTO inserDto) {
		return dao.update(inserDto)==1?true:false;
	}

}
