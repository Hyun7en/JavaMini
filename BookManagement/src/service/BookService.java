package service;

import java.sql.Connection;
import java.util.List;

import model.dao.BookDao;
import model.vo.Book;

public class BookService {
	
		private BookDao bd = new BookDao(); 
	
	
		// 1. 도서 등록
		public int insertBook(Book book) {
			Connection conn = JDBCTemplate.getConnection();
			
			int result = bd.insertBook(conn, book);
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return result;
		}
		
		// 2. 도서 정보 수정
			public int updateBook(Book book) {
				Connection conn = JDBCTemplate.getConnection();
				
				int result = bd.updateBook(conn, book);
				
				if(result > 0) {
					JDBCTemplate.commit(conn);
				}else {
					JDBCTemplate.rollback(conn);
				}
				
				JDBCTemplate.close(conn);
				
				return result;
			}
		
		// 3. 도서 정보 삭제
		public int deleteBook(int bookId) {
			Connection conn = JDBCTemplate.getConnection();
			
			int result = bd.deleteBook(conn, bookId);
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			
			return result;
		}
	
		
		// 4. 도서 등록 번호로 조회
		public Book selectByRegist_No(int regist_no) {
			Connection conn = JDBCTemplate.getConnection();
			
			Book book = bd.selectByRegist_No(conn, regist_no);
			
			JDBCTemplate.close(conn);
			
			return book;
		}
		
		// 5. 도서 제목 키워드로 조회
		public List<Book> selectByTitle_Keyword(String keyword) {
			Connection conn = JDBCTemplate.getConnection();
			
			List<Book> bookList = bd.selectByTitle_Keyword(conn, keyword);
			
			JDBCTemplate.close(conn);
			
			return bookList;
		}
		
		// 8. 목록 전체 조회
		public List<Book> SelectAllBook() {
			Connection conn = JDBCTemplate.getConnection();
					
			List<Book> SelectAllBook = bd.SelectAllBook(conn); 
			
			JDBCTemplate.close(conn);
			
			return SelectAllBook;
		}
}
