package hust.soict.globalict.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}

	public String toString() {
		String message = "";
		message = String.format("ID: %d DVD - %s - %s - %s - %d: %f $",this.getId(), this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
		return message;
	}
	
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("DVD: " + getTitle() + " cannot be played");
			return;
		}
		System.out.println("Playing DVD: " + this.getTitle() + " - DVD length: " + this.getLength());
	}
}
