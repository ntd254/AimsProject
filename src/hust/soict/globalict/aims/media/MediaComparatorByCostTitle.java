package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	public int compare(Media first, Media second) {
		if (Float.compare(first.getCost(), second.getCost()) == 0) {
			return first.getTitle().compareTo(second.getTitle());
		}
		return -Float.compare(first.getCost(), second.getCost());
	}
}
