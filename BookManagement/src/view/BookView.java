package view;

import java.util.List;

import model.vo.Book;

public class BookView {
	
		// --------------------응답화면--------------------//
		
		 /**
		 * 서비스요청 처리 후 성공했을 경우 사용자가 보게될 응답화면
		 * @param message: 객체별 성공메세지
		 */
		
		public void displaySuccessMsg(String msg) {
			switch(msg) {
			case "insert" :
				System.out.println("도서 등록 완료.");
				break;
			case "update" :
				System.out.println("도서 정보 수정 완료.");
				break;
			case "delete" :
				System.out.println("도서 정보 삭제 완료.");
				break;
			case "regist_no" :
				System.out.println("조회 결과 출력...");
				break;	
			case "selectByTitle_Keyword":
				System.out.println("조회 결과 출력...");
				break;
			case "SelectAllBook":
				System.out.println("조회 결과 출력...");
				break;
			default :
				System.out.println("오류를 찾을수 없음.");
			}
			
		}
		
		/**
		 * 서비스요청 처리 후 실패했을 경우 사용자가 보게될 응답화면
		 * @param message: 객체별 실패메세지
		 */
		
		public void displayFailMsg(String msg) {
			switch(msg) {
			case "insert" :
				System.out.println("도서 등록 실패.");
				break;
			case "update" :
				System.out.println("도서 정보 수정 실패.");
				break;
			case "delete" :
				System.out.println("도서 정보 삭제 실패.");
				break;
			case "regist_no" :
				System.out.println("조회 정보가 없습니다.");
				break;
			case "selectByTitle_Keyword":
				System.out.println("조회 정보가 없습니다.");
				break;
			case "SelectAllBook":
				System.out.println("조회 정보가 없습니다.");
				break;
			default :
				System.out.println("오류를 찾을수 없음.");
			}
			
		}
		
		/**
		 * 조회서비스 요청시 결과가 여러 행일 경우 보게될 응답화면
		 * @param bookList: 조회결과
		 */
		public void displayBookList(List<Book> bookList) {
			System.out.println("========== 도서 목록 전체 조회 ==========");
			for(Book book : bookList) {
				System.out.println(book);
			}
		}
		/**
		 * 조회서비스 요청시 결과가 한 행일 경우 보게될 응답화면
		 * @param book: 조회결과
		 */
		public void displayBook(Book book) {
			System.out.println("========== 도서 조회 ==========");
			System.out.println(book);
		}
}
