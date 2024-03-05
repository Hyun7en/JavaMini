package model.vo;

public class Book{
	private int regist_no;			// 도서 등록번호
	private String title_nm;		// 제목명
	private String author_nm;		// 저자명           
	private String publisher;		// 출판사
	private String publisher_date;	// 출판일 
	private String regist_date;		// 등록일 
	private String book_category;	// 카테고리 -> 00 총류, 01 철학 ,02 종교 ,03 사회과학 ,04 자연과학 ,05 기술과학 ,06 예술 ,07 언어 ,08 문학, 09 역사
	private int price;				// 가격

	public Book() {
		super();
	}

	

	public Book(String title_nm, String author_nm, String publisher, String publisher_date, String book_category,
			int price) {
		super();
		this.title_nm = title_nm;
		this.author_nm = author_nm;
		this.publisher = publisher;
		this.publisher_date = publisher_date;
		this.book_category = book_category;
		this.price = price;
	}

    

	public Book(String title_nm, String author_nm, String publisher, String publisher_date, String regist_date,
			String book_category, int price) {
		super();
		this.title_nm = title_nm;
		this.author_nm = author_nm;
		this.publisher = publisher;
		this.publisher_date = publisher_date;
		this.regist_date = regist_date;
		this.book_category = book_category;
		this.price = price;
	}



	public Book(int regist_no, String title_nm, String author_nm, String publisher, String publisher_date,
			String regist_date, String book_category, int price) {
		super();
		this.regist_no = regist_no;
		this.title_nm = title_nm;
		this.author_nm = author_nm;
		this.publisher = publisher;
		this.publisher_date = publisher_date;
		this.regist_date = regist_date;
		this.book_category = book_category;
		this.price = price;
	}

	public int getRegist_no() {
		return regist_no;
	}

	public void setRegist_no(int regist_no) {
		this.regist_no = regist_no;
	}

	public String getTitle_nm() {
		return title_nm;
	}

	public void setTitle_nm(String title_nm) {
		this.title_nm = title_nm;
	}

	public String getAuthor_nm() {
		return author_nm;
	}

	public void setAuthor_nm(String author_nm) {
		this.author_nm = author_nm;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher_date() {
		return publisher_date;
	}

	public void setPublisher_date(String publisher_date) {
		this.publisher_date = publisher_date;
	}

	public String getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}

	public String getBook_category() {
		return book_category;
	}

	public void setBook_category(String book_category) {
		this.book_category = book_category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return regist_no + ", " + title_nm + ", " + author_nm + ", "
				+ publisher + ", " + publisher_date + ", " + regist_date + ", "
				+ book_category + ", " + price;
	}

	
}
