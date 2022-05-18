package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		Book book1 = new Book("Doremon", "comic", "I can can the can but the can cannot can me", 15, "dat nguyen", "vinh");
		Book book2 = new Book("Conan", "comic", "hi hi hi hi", 18, "dat nguyen");
		store.addMedia(dvd1, dvd2, dvd3, book1, book2);
		book2.addAuthor("giang", "vinh", "dat nguyen");
		book2.removeAuthor("dat nguyen");
		book2.seeDetail();
	}

}
