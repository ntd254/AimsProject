package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	public int compare(Media first, Media second) {
		if (first.getTitle().compareTo(second.getTitle()) == 0) {
			return -Float.compare(first.getCost(), second.getCost());
		}
		return first.getTitle().compareTo(second.getTitle());
	}
}
