package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Media> collection = new ArrayList<>();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		collection.add(dvd2);
		collection.add(dvd1);
		collection.add(dvd3);
		Iterator<Media> iterator = collection.iterator();
		System.out.println("-------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		Collections.sort(collection);
		iterator = collection.iterator();
		System.out.println("--------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		System.out.println("--------------------------------");
	}

}
