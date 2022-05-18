package hust.soict.globalict.aims.media;

public class Track implements Playable {
	public Track(int length, String title) {
		// TODO Auto-generated constructor stub
		this.length = length;
		this.title = title;
	}
	
	private int length;
	private String title;
	
	public int getLength() {
		return length;
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean isSame(Track track) {
		if (this.length == track.getLength() && this.title.equals(getTitle())) return true;
		return false;
	}
	
	public void play() {
		if (this.length <= 0) {
			System.out.println("Track: " + this.title + "Cannot be played");
			return;
		}
		System.out.println("Playing track: " + this.getTitle() + " - Track length: " + this.getLength());
	}
	
	public void seeDetail() {
		System.out.println("Track title: " + this.getTitle() + " - Track length: " + this.getLength());
	}
}
