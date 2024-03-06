package model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.vo.Book;
import service.JDBCTemplate;

public class BookDao {

	
	private Properties prop = new Properties();
	
	public BookDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		// 1. 도서 등록
		public int insertBook(Connection conn, Book book) {
			String sql = prop.getProperty("insertBook");
			
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getTitle_nm());
				pstmt.setString(2, book.getAuthor_nm());
				pstmt.setString(3, book.getPublisher());
				pstmt.setString(4, book.getPublisher_date());
				pstmt.setString(5, book.getBook_category());
				pstmt.setInt(6, book.getPrice());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			
			return result;
		}
		

		// 2. 도서 정보 수정
		public int updateBook(Connection conn, Book book) {
			String sql = prop.getProperty("updateBook"); 
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getTitle_nm());
				pstmt.setString(2, book.getAuthor_nm());
				pstmt.setString(3, book.getPublisher());
				pstmt.setString(4, book.getPublisher_date());
				pstmt.setString(5, book.getRegist_date());
				pstmt.setString(6, book.getBook_category());
				pstmt.setInt(7, book.getPrice());
				pstmt.setInt(8, book.getRegist_no());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			
			return result;
		}
		
		// 3. 도서 정보 삭제
		public int deleteBook(Connection conn, int regist_no) {
			String sql = prop.getProperty("deleteBook");
			PreparedStatement pstmt = null;
			int result = 0;
					
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, regist_no);
						
				result = pstmt.executeUpdate();
						
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
					
					
			return result;
		}

		// 4. 도서 등록 번호로 조회
		public Book selectByRegist_No(Connection conn, int regist_no) {
			String sql = prop.getProperty("selectByRegist_No");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Book book = null;
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, regist_no);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					book = new Book();
					
						book.setRegist_no(rs.getInt("REGIST_NO"));
						book.setTitle_nm(rs.getString("TITLE_NM"));
						book.setAuthor_nm(rs.getString("AUTHOR_NM"));
						book.setPublisher(rs.getString("PUBLISHER"));
						book.setPublisher_date(rs.getString("PUBLISHER_DATE"));
						book.setRegist_date(rs.getString("REGIST_DATE"));
						book.setBook_category(rs.getString("BOOK_CATEGORY"));
						book.setPrice(rs.getInt("PRICE"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
			
			return book;
		}

		// 5. 도서 제목 키워드로 조회
		public List<Book> selectByTitle_Keyword(Connection conn, String keyword) {
			String sql = prop.getProperty("selectByTitle_Keyword");
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Book> bookList = new ArrayList<>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, keyword);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Book book = new Book();
					
					book.setRegist_no(rs.getInt("REGIST_NO"));
					book.setTitle_nm(rs.getString("TITLE_NM"));
					book.setAuthor_nm(rs.getString("AUTHOR_NM"));
					book.setPublisher(rs.getString("PUBLISHER"));
					book.setPublisher_date(rs.getString("PUBLISHER_DATE"));
					book.setRegist_date(rs.getString("REGIST_DATE"));
					book.setBook_category(rs.getString("BOOK_CATEGORY"));
					book.setPrice(rs.getInt("PRICE"));
					
					bookList.add(book);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
			
			return bookList;
		}
		// 8. 도서 목록 전체 조회
		public List<Book> SelectAllBook(Connection conn) {
			List<Book> bookList = new ArrayList<>(); 
			
			Statement stmt = null;
			ResultSet rs = null;
			
			String query = prop.getProperty("SelectAllBook");

			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					Book book = new Book();
					
					book.setRegist_no(rs.getInt("REGIST_NO"));
					book.setTitle_nm(rs.getString("TITLE_NM"));
					book.setAuthor_nm(rs.getString("AUTHOR_NM"));
					book.setPublisher(rs.getString("PUBLISHER"));
					book.setPublisher_date(rs.getString("PUBLISHER_DATE"));
					book.setRegist_date(rs.getString("REGIST_DATE"));
					book.setBook_category(rs.getString("BOOK_CATEGORY"));
					book.setPrice(rs.getInt("PRICE"));
					
					
					bookList.add(book);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(stmt);
			}
			
			return bookList;
		}

}
