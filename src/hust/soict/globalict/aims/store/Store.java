package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_STORED = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<>();
	public void addMedia(Media media) {
		if (this.itemsInStore.size() == MAX_NUMBERS_STORED) {
			System.out.println("Cannot store more");
		} else {
			this.itemsInStore.add(media);
			System.out.println("The media " + media.getTitle() + " has been added to store");
		}
	}
	public void addMedia(Media ... mediaList) {
		for (int i = 0; i < mediaList.length; i++) {
			addMedia(mediaList[i]);
		}
	}
	
	public void removeMedia(Media media) {
		if (this.itemsInStore.size() == 0) {
			System.out.println("You haven't stored any media");
			return;
		} else {
			this.itemsInStore.remove(media);
			System.out.println("The media " + media.getTitle() + " has been removed from store");
		}
	}
	
	public void removeMedia(Media ... mediaList) {
		for (int i = 0; i < mediaList.length; i++) {
			removeMedia(mediaList[i]);
		}
	}
	
	public Media searchByID(int id) {
		for (int i = 0; i < this.itemsInStore.size(); i++) {
			if (this.itemsInStore.get(i).getId() == id) return this.itemsInStore.get(i);
		}
		return null;
	}
	
	public Media searchByTitle(String title) {
		for (int i = 0; i < this.itemsInStore.size(); i++) {
			if (this.itemsInStore.get(i).isMatch(title)) {
				return this.itemsInStore.get(i);
			}
		}
		return null;
	}
	
	public void removeById(int id) {
		for (int i = 0; i < this.itemsInStore.size(); i++) {
			if (this.itemsInStore.get(i).getId() == id) {
				this.removeMedia(this.itemsInStore.get(i));
				return;
			}
		}
		System.out.println("Cannot found " + id);
	}
	
	public void displayMedia() {
		for (int i = 0; i < this.itemsInStore.size(); i++) {
			if (this.itemsInStore.get(i) instanceof DigitalVideoDisc) System.out.println("DVD: " + this.itemsInStore.get(i).getTitle() + " ID: " + this.itemsInStore.get(i).getId());
			else if (this.itemsInStore.get(i) instanceof CompactDisc) System.out.println("CD: " + this.itemsInStore.get(i).getTitle() + " ID: " + this.itemsInStore.get(i).getId());
			else System.out.println("Book: " + this.itemsInStore.get(i).getTitle() + " ID: " + this.itemsInStore.get(i).getId());
		}
	}
}
