package controller;

import java.util.List;

import model.vo.Book;
import service.BookService;
import view.BookView;

public class BookController {
	
		private BookService bs = new BookService();
		private BookView bv = new BookView();
		
		// 1. 도서 등록
		public void insertBook(Book book) {
			int result = bs.insertBook(book);
			
			if(result > 0) {
				bv.displaySuccessMsg("insert");
			}else {
				bv.displayFailMsg("insert");
			}
			
		}
		
	
		// 2. 도서 정보 수정
		public void updateBook(int regist_no, Book book) {
			
			book.setRegist_no(regist_no);
			
			int result = bs.updateBook(book);
			
			if(result > 0) {
				bv.displaySuccessMsg("update");
			}else {
				bv.displayFailMsg("update");
			}
			
		}
		
		// 3. 도서 정보 삭제
		public void deleteBook(int regist_no) {
			int result = bs.deleteBook(regist_no);
			
			if(result > 0) {
				bv.displaySuccessMsg("delete");
			}else {
				bv.displayFailMsg("delete");
			}
			
		}
		
		// 4. 도서 등록 번호로 조회
		public void selectByRegist_No(int regist_no) {
			Book book = bs.selectByRegist_No(regist_no);
			
			if(book == null) {
				bv.displayFailMsg("regist_no");
			}else {
				bv.displaySuccessMsg("regist_no");
				bv.displayBook(book);
			}
			
		}
	
		// 5. 도서 제목 키워드로 조회
		public void selectByTitle_Keyword(String keyword) {
			List<Book> bookList = bs.selectByTitle_Keyword(keyword);
			
			if(bookList.isEmpty()) {
				bv.displayFailMsg("selectByTitle_Keyword");
			} else {
				bv.displaySuccessMsg("selectByTitle_Keyword");
				bv.displayBookList(bookList);
			} 
			
		}
		
		// 8. 목록 전체 조회
			public void SelectAllBook() {
				List<Book> bookList = bs.SelectAllBook();
				
				if(bookList.isEmpty()) {
					bv.displayFailMsg("SelectAllBook");
				} else {
					bv.displaySuccessMsg("SelectAllBook");
					bv.displayBookList(bookList);
				}
			}
}
