package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;


public class Book extends Media {
	private String content;
	private List<String> authors = new ArrayList<String>(); 
	private ArrayList<String> contentTokens = new ArrayList<>();
	private TreeMap<String, Integer> wordFrequency = new TreeMap<>();
	public Book(String title, String category,String content,  float cost, String ... authors) {
		// TODO Auto-generated constructor stub
		super(title, category, cost);
		this.content = content;
		for (int i = 0; i < authors.length; i++) {
			this.authors.add(authors[i]);
		}
		processContent();
	}
	public Book(String title, String category,String content,  float cost, List<String> authors) {
		// TODO Auto-generated constructor stub
		super(title, category, cost);
		this.content = content;
		this.authors = authors;
		processContent();
	}
	public String getContent() {
		return this.content;
	}
	public List<String> getAuthors(){
		return this.authors;
	}
	public void addAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				System.out.println("Author: " + authorName + " has been added before");
				return;
			}
		}
		authors.add(authorName);
		System.out.println("Added " + "author: " + authorName + " successfully");
	}
	public void addAuthor(String ... authorNames) {
		for (int i = 0; i < authorNames.length; i++) {
			addAuthor(authorNames[i]);
		}
	}
	public void removeAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				authors.remove(i);
				System.out.println("Author: "+ authorName + " has been removed");
				return;
			}
		}
		System.out.println("Cannot found " + authorName);
	}
	public void removeAuthor(String ... authorNames) {
		for (int i = 0; i < authorNames.length; i++) {
			removeAuthor(authorNames[i]);
		}
	}
	
	public String toString() {
		String message = "";
		message = String.format("ID: %d   Book: %s   Category: %s   Cost: %f     Tokens length: %d      Content: %s\n", this.getId(), this.getTitle(), this.getCategory(), this.getCost(), this.contentTokens.size(), this.content);
		message += "frequency: \n";
		for (String key : wordFrequency.keySet()) {
			message += String.format(key + ": %d       ", wordFrequency.get(key));
		}
		return message;
	}
	
	public void processContent() {
		String[] tokens = this.content.split(" ");
		Collections.addAll(contentTokens, tokens);
		Collections.sort(contentTokens);
		for (String token: contentTokens) {
			Integer frequency = this.wordFrequency.get(token);
			frequency = (frequency == null) ? 1 : ++frequency;
			this.wordFrequency.put(token, frequency);
		}
	}
	
	public void seeDetail() {
		System.out.print(String.format("ID: %d   Book: %s   Category: %s   Cost: %f   Authors: ", this.getId(), this.getTitle(), this.getCategory(), this.getCost()));
		for (int i = 0; i < this.authors.size(); i++) {
			if (i == this.authors.size() - 1) {
				System.out.println(this.authors.get(i));
				break;
			}
			System.out.print(this.authors.get(i) + ", ");
		}
		System.out.println("Word frequency of the content:");
		String tokens[] = this.content.split("\\s");
		for (int i = 1; i < tokens.length; i++) {
			String key = tokens[i];
			int position = i;
			while (position > 0 && tokens[position - 1].compareTo(key) > 0) {
				tokens[position] = tokens[--position];
			}
			tokens[position] = key;
		}
		int temp = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (i == tokens.length -1) {
				if (tokens[i].equals(tokens[i-1])) System.out.print(String.format("Token: %s Frequency: %d\n", tokens[i], i - temp + 1));
				else System.out.print(String.format("Token: %s Frequency: %d\n", tokens[i], 1));
				break;
			}
			if (tokens[i].equals(tokens[i+1])) continue;
			else {
				System.out.print(String.format("Token: %s Frequency: %d      ", tokens[i], i - temp + 1));
				temp = i + 1;
			}
		}
	}
}
