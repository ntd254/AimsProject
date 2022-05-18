package hust.soict.globalict.aims.cart;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList <Media> itemsOrdered = new ArrayList<>();
	public void addMedia(Media media) {
		if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		} else {
			this.itemsOrdered.add(media);
			System.out.println("The media " + media.getTitle() + " has been added to your cart");
		}
	}
	
	public void addMedia(Media ... mediaList) {
		for (int i = 0; i < mediaList.length; i++) {
			addMedia(mediaList[i]);
		}
	}
	
	public void removeMedia(Media media) {
		if (this.itemsOrdered.size() == 0) {
			System.out.println("Your cart is empty");
			return;
		} else {
			this.itemsOrdered.remove(media);
			System.out.println("The media " + media.getTitle() + " has been removed from your cart");
			return;
		}
	}
	
	public void removeById(int id) {
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getId() == id) {
				removeMedia(this.itemsOrdered.get(i));
				return;
			}
		}
		System.out.println("Cannot found ID: " + id);
	}
	
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			total += this.itemsOrdered.get(i).getCost();
		}
		return total;
	}
	
	public void sortByCost () {
		for (int i = 1; i < this.itemsOrdered.size(); i++) {
			Media key = this.itemsOrdered.get(i);
			int position = i;
			while (position > 0 && (this.itemsOrdered.get(position - 1).getCost() < key.getCost() 
					|| this.itemsOrdered.get(position - 1).getCost() == key.getCost() && this.itemsOrdered.get(position - 1).getTitle().compareTo(key.getTitle()) > 0)) {
				this.itemsOrdered.set(position, this.itemsOrdered.get(--position));
			}
			this.itemsOrdered.set(position, key);
		}
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i) instanceof DigitalVideoDisc) System.out.println(((DigitalVideoDisc)this.itemsOrdered.get(i)).toString());
			else if (this.itemsOrdered.get(i) instanceof CompactDisc) ((CompactDisc)this.itemsOrdered.get(i)).seeDetail();
			else ((Book)this.itemsOrdered.get(i)).seeDetail();
		}
	}
	public void sortByTitle () {
		for (int i = 1; i < this.itemsOrdered.size(); i++) {
			Media key = this.itemsOrdered.get(i);
			int position = i;
			while (position > 0 && (this.itemsOrdered.get(position - 1).getTitle().compareTo(key.getTitle()) > 0 
					|| this.itemsOrdered.get(position - 1).getTitle().compareTo(key.getTitle()) == 0 && this.itemsOrdered.get(position - 1).getCost() < key.getCost())) {
				this.itemsOrdered.set(position,this.itemsOrdered.get(--position));
			}
			this.itemsOrdered.set(position, key);
		}
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i) instanceof DigitalVideoDisc) System.out.println(((DigitalVideoDisc)this.itemsOrdered.get(i)).toString());
			else if (this.itemsOrdered.get(i) instanceof CompactDisc) ((CompactDisc)this.itemsOrdered.get(i)).seeDetail();
			else ((Book)this.itemsOrdered.get(i)).seeDetail();
		}
	}
	
	
	public void searchById(int id) {
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getId() == id) {
				if (this.itemsOrdered.get(i) instanceof Book) ((Book)this.itemsOrdered.get(i)).seeDetail();
				else if (this.itemsOrdered.get(i) instanceof CompactDisc) ((CompactDisc)this.itemsOrdered.get(i)).seeDetail();
				else System.out.println(((DigitalVideoDisc)this.itemsOrdered.get(i)).toString());
				return;
			}
		}
		System.out.println("Cannot found");
	}
	public void searchByTitle(String title) {
		boolean cannotFound = true;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).isMatch(title)) {
				cannotFound = false;
				if (this.itemsOrdered.get(i) instanceof Book) ((Book)this.itemsOrdered.get(i)).seeDetail();
				else if (this.itemsOrdered.get(i) instanceof CompactDisc) ((CompactDisc)this.itemsOrdered.get(i)).seeDetail();
				else System.out.println(((DigitalVideoDisc)this.itemsOrdered.get(i)).toString());
			}
		}
		if (cannotFound) System.out.println("Cannot found " + title);
	}
	
	public Media getMediaById(int id) {
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getId() == id) {
				return this.itemsOrdered.get(i);
			}
		}
		return null;
	}
	
	public void print() {
		for (int i = 1; i < this.itemsOrdered.size(); i++) {
			Media key = this.itemsOrdered.get(i);
			int position = i;
			while (position > 0 && (this.itemsOrdered.get(position - 1).getTitle().compareTo(key.getTitle()) > 0 
					|| this.itemsOrdered.get(position - 1).getTitle().compareTo(key.getTitle()) == 0 && this.itemsOrdered.get(position - 1).getCost() < key.getCost()
					|| this.itemsOrdered.get(position - 1).getTitle().compareTo(key.getTitle()) == 0 && this.itemsOrdered.get(position - 1).getCost() == key.getCost() && this.itemsOrdered.get(position - 1).getLength() < key.getLength())) {
				this.itemsOrdered.set(position, this.itemsOrdered.get(--position));
			}
			this.itemsOrdered.set(position, key);
		}
		System.out.println("*******************CART*******************");
		System.out.println("Ordered item:");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i) instanceof DigitalVideoDisc) System.out.println(((DigitalVideoDisc)this.itemsOrdered.get(i)).toString());
			else if (this.itemsOrdered.get(i) instanceof CompactDisc) ((CompactDisc)this.itemsOrdered.get(i)).seeDetail();
			else ((Book)this.itemsOrdered.get(i)).seeDetail();
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("******************************************");
	}
	
	public int getNumOfMedia() {
		return this.itemsOrdered.size();
	}
	
	public void emptyCart() {
		this.itemsOrdered.clear();;
	}
	
	public Media getALuckyItem() {
		if (this.itemsOrdered.size() == 0) return null;
		Media media = this.itemsOrdered.get((int)(Math.random() * itemsOrdered.size()));
		media.setCost(0);
		media.setTitle(media.getTitle() + " FREE $");
		return media;
	}
}
