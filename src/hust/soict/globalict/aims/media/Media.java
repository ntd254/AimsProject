package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public abstract class Media {
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
	public void setCategory(String category) {
		this.category = category;
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
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public boolean isMatch(String title) {
		String [] tokenStrings = title.split("\\s");
		for (int i = 0; i < tokenStrings.length; i++) {
			if (this.title.toLowerCase().contains(tokenStrings[i].toLowerCase())) return true;
		}
		return false;
	}
	
	public Media() {
		// TODO Auto-generated constructor stub
	}

}
