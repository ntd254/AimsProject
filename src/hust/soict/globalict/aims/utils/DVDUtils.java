package hust.soict.globalict.aims.utils;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DVDUtils {
	public static String compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String message = "";
		if (dvd1.getCost() == dvd2.getCost()) message = "The cost is equal";
		if (dvd1.getCost() > dvd2.getCost()) message = dvd1.getTitle() + " is more expensive than " + dvd2.getTitle();
		if (dvd1.getCost() < dvd2.getCost()) message = dvd2.getTitle() + " is more expensive than " + dvd1.getTitle();
		return message;
	}
	public static String compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String message = "";
		int index = dvd1.getTitle().compareTo(dvd2.getTitle());
		if (index == 0) message = "Have the same title";
		else if (index > 1) message = dvd2.getTitle() + " go first in lexicographic order than " + dvd1.getTitle();
		else message = dvd1.getTitle() + " go first in lexicographic order than " + dvd2.getTitle();
		return message;
	}
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
		for (int i = 1; i < dvdList.length; i++) {
			DigitalVideoDisc key = dvdList[i];
			int position = i;
			while (position > 0 && dvdList[position - 1].getCost() > key.getCost()) {
				dvdList[position] = dvdList[--position];
			}
			dvdList[position] = key;
		}
		return dvdList;
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
		for (int i = 1; i < dvdList.length; i++) {
			DigitalVideoDisc key = dvdList[i];
			int position = i;
			while (position > 0 && dvdList[position - 1].getTitle().compareTo(key.getTitle()) > 0) {
				dvdList[position] = dvdList[--position];
			}
			dvdList[position] = key;
		}
		return dvdList;
	}
}
