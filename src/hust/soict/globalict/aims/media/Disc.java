package hust.soict.globalict.aims.media;

public abstract class Disc extends Media {
	public Disc(int length, String director) {
		// TODO Auto-generated constructor stub
		this.length = length;
		this.director = director;
	}
	public Disc(String title) {
		super(title);
	}
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	
	private int length;
	private String director;
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
}
