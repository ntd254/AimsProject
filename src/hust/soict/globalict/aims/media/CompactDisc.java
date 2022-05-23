package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	public CompactDisc(String title, String category, String director, float cost, String artist, Track ... tracks) {
		// TODO Auto-generated constructor stub
		super(title, category, director, cost);
		this.artist = artist;
		for (int i = 0; i < tracks.length; i++) {
			this.tracks.add(tracks[i]);
		}
	}
	
	public CompactDisc(String title, String category, String director, float cost, String artist, ArrayList<Track> tracks) {
		// TODO Auto-generated constructor stub
		super(title, category, director, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public String getArtist() {
		return this.artist;
	}
	
	public ArrayList<Track> getTracks(){
		return this.tracks;
	}
	
	public void addTrack(Track ... tracks) {
		for (int i = 0; i < tracks.length; i++) {
			if (this.tracks.contains(tracks[i])) {
				System.out.println("Track " + tracks[i].getTitle() + " has been added before");
			}else {
				this.tracks.add(tracks[i]);
				System.out.println("Track " + tracks[i].getTitle() + " added successfully");
			}
		}
	}
	
	public void removeTrack(Track ... tracks) {
		for (int i = 0; i < tracks.length; i++) {
			if (!this.tracks.contains(tracks[i])) {
				System.out.println("Cannot find track " + tracks[i].getTitle());
			}else {
				this.tracks.remove(i);
				System.out.println("Track " + tracks[i].getTitle() + " removed successfully");
			}
		}
	}
	
	public int getLength() {
		int sum = 0;
		for (int i = 0; i < this.tracks.size(); i++) {
			sum += this.tracks.get(i).getLength();
		}
		return sum;
	}
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle() + " - CD length: " + this.getLength());
		for (int i = 0; i < this.tracks.size(); i++) {
			this.tracks.get(i).play();
		}
	}

	public void  seeDetail() {
		System.out.printf("ID: %d - CD title: %s - Category: %s - Artist: %s - Director: %s - CD length: %d - Price: %f\n", this.getId(), this.getTitle(), this.getCategory(), this.getArtist(), this.getDirector(), this.getLength(), this.getCost());
		for (int i = 0; i < this.tracks.size();i++) {
			this.tracks.get(i).seeDetail();
		}
	}
	
	public String toString() {
		String message = "";
		message = String.format("ID: %d CD - %s - %s - %s - %d: %f $",this.getId(), this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
		return message;
	}
}
