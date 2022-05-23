package hust.soict.globalict.test.media;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class TestToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Media> medias = new ArrayList<>();
		DigitalVideoDisc dvd = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
		Book book = new Book("Conan", "comic", "hi hi hi hi", 18, "dat nguyen", "thi");
		Track track1 = new Track(24, "Nguyen");
		Track track2 = new Track(34, "Dat");
		CompactDisc cd = new CompactDisc("Dat", "music", "viet", 2.5f, "thi", track1, track2);
		medias.add(book);
		medias.add(cd);
		medias.add(dvd);
		for (Media media: medias) {
			System.out.println(media.toString());
		}
	}

}
