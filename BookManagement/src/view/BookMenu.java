package view;

import java.util.Scanner;

import controller.BookController;
import model.vo.Book;

public class BookMenu {

		private Scanner sc = new Scanner(System.in);
		private BookController bc = new BookController();
		
		// --------------------메인화면--------------------//		
		
		public void mainMenu() {
		
			
			while(true) {
				System.out.println("========== 도서 관리 프로그램 ==========");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 정보 수정");
				System.out.println("3. 도서 삭제");
				System.out.println("4. 도서 등록번호로 도서 조회");
				System.out.println("5. 도서 제목명 키워드로 도서목록 조회");
//				System.out.println("6. 저자별 도서목록 조회");
//				System.out.println("7. 카테고리별 도서목록 조회");
				System.out.println("8. 도서 목록 전체 조회");
				System.out.println("0. 프로그램 종료");
				
				System.out.println("==================================");
				System.out.print("메뉴 입력 : ");
				int menu = sc.nextInt();
				sc.nextLine(); 
				
				switch(menu) {
				case 1 :
					bc.insertBook(add_EditBook());
					break;
				case 2 :
					bc.updateBook(regist_no(), add_EditBook());
					break;
				case 3 :
					bc.deleteBook(regist_no());
					break;
				case 4 :
					bc.selectByRegist_No(regist_no());
					break;
				case 5 :
					bc.selectByTitle_Keyword(title_nm());
					break;
				case 6 :
					
					break;
				case 7 :
					
					break;		
				case 8 :
					bc.SelectAllBook();
					break;
				case 0 :
					System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
					return;
				default : 
					System.out.println("잘못된 번호입니다. 번호를 다시 입력해주세요.");
				}
				
			}
		}
		
		// 도서 등록, 수정
		public Book add_EditBook() {
			System.out.println("========== 도서 등록, 수정 ==========");
			System.out.print("제목명 : ");
			String title_nm = sc.nextLine();
			System.out.print("저자명 : ");
			String author_nm = sc.nextLine();
			System.out.print("출판사 : ");
			String publisher = sc.nextLine();
			System.out.print("출판일 : ");
			String publisher_date = sc.nextLine();
			System.out.print("등록일 : ");
			String regist_date = sc.nextLine();
			System.out.print("카테고리 : ");
			String book_category = sc.nextLine();
			System.out.print("가격 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			Book book = new Book(title_nm, author_nm, publisher, publisher_date, regist_date, book_category, price);
			
			
			return book;
		}
		
		// 도서 등록번호
		public int regist_no() {
			System.out.print("도서 번호 입력 : ");
			int regist_no = sc.nextInt(); 
			sc.nextLine();
			return regist_no;
		}
		
		// 제목명 키워드
		public String title_nm() {
			System.out.print("도서 제목명 키워드 입력 : ");
			String keyword = sc.nextLine();
			return keyword;
		}
}
