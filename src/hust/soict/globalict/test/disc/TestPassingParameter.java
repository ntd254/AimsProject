package hust.soict.globalict.test.disc;

import java.time.LocalDate;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title " + cinderellaDVD.getTitle());
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
//	public static void swap(Object o1, Object o2) {
//		Object tmp = o1;
//		o1 = o2;
//		o2 = tmp;
//	}
	
	public static void swap (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String title = dvd1.getTitle();
		String category = dvd1.getCategory();
		String director = dvd1.getDirector();
		int length = dvd1.getLength();
		float cost = dvd1.getCost();
		LocalDate dateAdded = dvd1.getDateAdded();
		int id = dvd1.getId();
		dvd1.setTitle(dvd2.getTitle());
		dvd1.setCategory(dvd2.getCategory());
//		dvd1.setDirector(dvd2.getDirector());
//		dvd1.setLength(dvd2.getLength());
		dvd1.setCost(dvd2.getCost());
		dvd1.setDateAdded(dvd2.getDateAdded());
		dvd1.setId(dvd2.getId());
		dvd2.setTitle(title);
		dvd2.setCategory(category);
//		dvd2.setDirector(director);
//		dvd2.setLength(length);
		dvd2.setCost(cost);
		dvd2.setDateAdded(dateAdded);
		dvd2.setId(id);
		
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTile = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTile);
	}
}