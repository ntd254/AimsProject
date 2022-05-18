package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DiskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Cart cart = new Cart();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("aladin 123");
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("aladin  abc");
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("aladin xyz ");

		cart.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6);
		cart.searchByTitle("aladin");
	}

}
