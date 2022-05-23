package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
	public Media() {
		
	}
	
	public Media (String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		this.id = ++nbMedias;
	}
	
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		this.id = ++nbMedias;
	}
	
	
	private int id;
	
	private String title;
	
	private String category;
	
	private float cost;
	
	private LocalDate dateAdded;
	
	private static int nbMedias = 0;
	
	private int length;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public int getLength() {
		return length;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public float getCost() {
		return cost;
	}
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isMatch(String title) {
		String [] tokenStrings = title.split("\\s");
		for (int i = 0; i < tokenStrings.length; i++) {
			if (this.title.toLowerCase().contains(tokenStrings[i].toLowerCase())) return true;
		}
		return false;
	}
	
	@Override public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (!(otherObject instanceof Media)) return false;
		Media other = (Media)otherObject;
		return this.id == other.id;
	}
	
	public int compareTo(Media otherObject) {
		if (this.title.compareTo(otherObject.title) == 0) {
			return this.category.compareTo(otherObject.category);
		}
		return this.title.compareTo(otherObject.title);
	}
	
	public abstract String toString();
}
