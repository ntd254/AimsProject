package hust.soict.globalict.test;

import hust.soict.globalict.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book("Doremon", "comic", "i can can the can but the can cannot can me", 15, "dat nguyen", "duc");
		Book book2 = new Book("Conan", "comic", "hi hi hi hi", 18, "dat nguyen", "thi");
		Book book3 = new Book("Conan", "comic", "hello world", 18, "dat nguyen", "thi");
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(book3.toString());
	}

}
