package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.Scanner;


import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class Aims {

	public static void main(String[] args) {
		MemoryDaemon memoryDaemonObj = new MemoryDaemon();
		Thread thread = new Thread(memoryDaemonObj);
		thread.setDaemon(true);
//		thread.start();
		Store store = new Store();
		Cart cart = new Cart();
		Scanner input = new Scanner(System.in);
		int choice;
		boolean runShowMenu = true;
		boolean runStoreMenu = true;
		boolean runCartMenu = true;
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doctor Strange", "Super hero", "Sam", 2, 20.7f);
		Book book1 = new Book("Doremon", "comic", "i can can the can but the can cannot can me", 15, "dat nguyen", "duc");
		Book book2 = new Book("Conan", "comic", "hi hi hi hi", 18, "dat nguyen", "thi");
		Book book3 = new Book("Conan", "comic", "hello world", 18, "dat nguyen", "thi");
		Track track1 = new Track(24, "Nguyen");
		Track track2 = new Track(34, "Dat");
		Track track3 = new Track(56, "duc");
		CompactDisc cd1 = new CompactDisc("Dat", "music", "viet", 2.5f, "thi", track1, track2);
		CompactDisc cd2 = new CompactDisc("Thai", "music", "viet", 2.5f, "thi", track1, track2);
		CompactDisc cd3 = new CompactDisc("Tuan", "music", "viet", 2.5f, "thi", track1, track2);
		cd3.addTrack(track3);
		book1.addAuthor("viet", "thai");
		book2.removeAuthor("thi");
		store.addMedia(dvd1, dvd2, dvd3, book1, book2, book3, cd1, cd2, cd3, dvd4);
		cart.addMedia(dvd1, dvd2, dvd3, book1, book2, book3, cd1, cd2, cd3);
		while (runShowMenu) {
			showMenu();
			runStoreMenu = true;
			runCartMenu = true;
			choice = Integer.parseInt(input.nextLine());
			switch (choice) {
				case 0:
					runShowMenu = false;
					break;
				case 1:
					while (runStoreMenu) {
						store.displayMedia();
						storeMenu();
						runCartMenu = true;
						choice = Integer.parseInt(input.nextLine());
						switch (choice) {
							case 0:
								runStoreMenu = false;
								break;
							case 1:
								System.out.println("Enter the ID of the media");
								int id = Integer.parseInt(input.nextLine());
								Media media = store.searchByID(id);
								if (media == null) {
									System.out.println("Cannot found " + id);
									break;
								}
								if (media instanceof DigitalVideoDisc) {
									System.out.println(((DigitalVideoDisc)media).toString());
									System.out.println("Do you want to play this DVD (yes/no)");
									if (input.nextLine().equals("yes")) ((DigitalVideoDisc)media).play();
								}
								else if (media instanceof CompactDisc) {
									CompactDisc cd = (CompactDisc)media;
									cd.seeDetail();
									System.out.println("Do you want to play this CD (yes/no)");
									if (input.nextLine().equals("yes")) ((CompactDisc)media).play();
								}
								else ((Book)media).seeDetail();
								System.out.println("Do you want to add this media to your cart (yes/no)");
								String answer = input.nextLine();
								if (answer.equals("yes")){
									if (media instanceof DigitalVideoDisc) { 
										DigitalVideoDisc dvd = (DigitalVideoDisc) media;
										DigitalVideoDisc newDvd = new DigitalVideoDisc(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost());
										newDvd.setId(dvd.getId());
										cart.addMedia(newDvd);
									}
									else if (media instanceof CompactDisc) {
										CompactDisc cd = (CompactDisc) media;
										CompactDisc newCd = new CompactDisc(cd.getTitle(), cd.getCategory(), cd.getDirector(), cd.getCost(), cd.getArtist(), cd.getTracks());
										newCd.setId(cd.getId());
										cart.addMedia(newCd);
									}
									else {
										Book book = (Book) media;
										Book newBook = new Book(book.getTitle(), book.getCategory(), book.getContent(), book.getCost(), book.getAuthors());
										newBook.setId(book.getId());
										cart.addMedia(newBook);
									}
								}
								break;
							case 2:
								System.out.println("Enter the ID of media");
								media = store.searchByID(Integer.parseInt(input.nextLine()));
								if (media == null) {
									System.out.println("Cannot found");
									break;
								}
								if (media instanceof DigitalVideoDisc) { 
									DigitalVideoDisc dvd = (DigitalVideoDisc) media;
									DigitalVideoDisc newDvd = new DigitalVideoDisc(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost());
									newDvd.setId(dvd.getId());
									cart.addMedia(newDvd);
								}
								else if (media instanceof CompactDisc) {
									CompactDisc cd = (CompactDisc) media;
									CompactDisc newCd = new CompactDisc(cd.getTitle(), cd.getCategory(), cd.getDirector(), cd.getCost(), cd.getArtist(), cd.getTracks());
									newCd.setId(cd.getId());
									cart.addMedia(newCd);
								}
								else {
									Book book = (Book) media;
									Book newBook = new Book(book.getTitle(), book.getCategory(), book.getContent(), book.getCost(), book.getAuthors());
									newBook.setId(book.getId());
									cart.addMedia(newBook);
								}
								System.out.println("there are " + cart.getNumOfMedia() + " media in your cart");
								break;
							case 3:
								while (runCartMenu) {
									cart.print();
//				                    cart.printCart();
									cartMenu();
									choice = Integer.parseInt(input.nextLine());
									switch (choice) {
									case 0:
										runCartMenu = false;
										break;
									case 1: 
										System.out.println("You want to filter by id or by title: (id/title)");
										if (input.nextLine().equals("id")) {
											System.out.println("Enter the id: ");
											cart.searchById(Integer.parseInt(input.nextLine()));
										}else {
											System.out.println("Enter the title: ");
											cart.searchByTitle(input.nextLine());
										}
										break;
									case 2:
										System.out.println("You want to sort by cost or by title: (cost/title)");
										if (input.nextLine().equals("cost")) {
											cart.sortByCostTitle();
											cart.printCart();
										}else {
											cart.sortByTitleCost();
											cart.printCart();
										}
										break;
									case 3:
										System.out.println("Enter the id");
										cart.removeById(Integer.parseInt(input.nextLine()));
										break;
									case 4:
										media = cart.getALuckyItem();
										if (media == null) System.out.println("Your cart is empty");
										else System.out.println("Your lucky item is " + media.getTitle());
										break;
									case 5:
										System.out.println("Your order has been created");
										cart.emptyCart();
										break;
									case 6: 
										System.out.println("Enter id:");
										id = Integer.parseInt(input.nextLine());
										media = cart.getMediaById(id);
										if (media == null) System.out.println("Cannot found");
										else if (media instanceof CompactDisc) ((CompactDisc)media).play();
										else if (media instanceof DigitalVideoDisc) ((DigitalVideoDisc)media).play();
										else if (media instanceof Book) System.out.println("Cannot play book");
										break;
									case 7: 
										cart.sortByTitleAndCategory();
										cart.printCart();
										break;
									default:
										break;
									}
								}
								break;
							default:
								break;
						}
					}
					break;
				case 2:
					System.out.println("You want to add or remove Media: (add/remove)");
					if (input.nextLine().equals("add")) {
						System.out.println("Dvd or Book or CD: (dvd/book/cd)");
						String answer = input.nextLine();
						if (answer.equals("dvd")) {
							System.out.println("Enter title: ");
							String title = input.nextLine();
							System.out.println("Enter category: ");
							String category  = input.nextLine();
							System.out.println("Enter director: ");
							String director = input.nextLine();
							System.out.println("Enter length: ");
							int length = Integer.parseInt(input.nextLine());
							System.out.println("Enter cost: ");
							float cost = Float.parseFloat(input.nextLine());
							DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
							store.addMedia(dvd);
						}
						else if (answer.equals("cd")) {
							System.out.println("Enter title:");
							String title = input.nextLine();
							System.out.println("Enter category:");
							String category = input.nextLine();
							System.out.println("Enter director:");
							String director = input.nextLine();
							System.out.println("Enter cost:");
							Float cost = Float.parseFloat(input.nextLine());
							System.out.println("Enter artist:");
							String artist = input.nextLine();
							ArrayList<Track> tracks = new ArrayList<>();
							CompactDisc cd = new CompactDisc(title, category, director, cost, artist, tracks);
							System.out.println("Enter number of track");
							int numOfTrack = Integer.parseInt(input.nextLine());
							for (int i = 0; i < numOfTrack; i++) {
								System.out.println("Enter track title:");
								title = input.nextLine();
								System.out.println("Enter track length:");
								int length = Integer.parseInt(input.nextLine());
								Track track = new Track(length, title);
								cd.addTrack(track);
							}
							store.addMedia(cd);
						}
						else {
							System.out.println("Enter title: ");
							String title = input.nextLine();
							System.out.println("Enter category: ");
							String category  = input.nextLine();
							System.out.println("Enter cost: ");
							float cost = Float.parseFloat(input.nextLine());
							System.out.println("Enter content:");
							String content = input.nextLine();
							System.out.println("Enter author");
							String author = input.nextLine();
							Book book = new Book(title, category, content, cost, author);
							store.addMedia(book);
						}
					}else {
						System.out.println("Enter id: ");
						store.removeById(Integer.parseInt(input.nextLine()));
					}
					break;
				case 3:
					while (runCartMenu) {
						cart.print();
						cartMenu();
						choice = Integer.parseInt(input.nextLine());
						switch (choice) {
						case 0:
							runCartMenu = false;
							break;
						case 1: 
							System.out.println("You want to filter by id or by title: (id/title)");
							if (input.nextLine().equals("id")) {
								System.out.println("Enter the id: ");
								cart.searchById(Integer.parseInt(input.nextLine()));
							}else {
								System.out.println("Enter the title: ");
								cart.searchByTitle(input.nextLine());
							}
							break;
						case 2:
							System.out.println("You want to sort by cost or by title: (cost/title)");
							if (input.nextLine().equals("cost")) {
								cart.sortByCostTitle();
								cart.printCart();
							}else {
								cart.sortByTitleCost();
								cart.printCart();
							}
							break;
						case 3:
							System.out.println("Enter the id");
							cart.removeById(Integer.parseInt(input.nextLine()));
							break;
						case 4:
							Media media = cart.getALuckyItem();
							if (media == null) System.out.println("Your cart is empty");
							else System.out.println("Your lucky item is " + media.getTitle());
							break;
						case 5:
							System.out.println("Your order has been created");
							cart.emptyCart();
							break;
						case 6: 
							System.out.println("Enter id:");
							int id = Integer.parseInt(input.nextLine());
							media = cart.getMediaById(id);
							if (media == null) System.out.println("Cannot found");
							else if (media instanceof CompactDisc) ((CompactDisc)media).play();
							else if (media instanceof DigitalVideoDisc) ((DigitalVideoDisc)media).play();
							else if (media instanceof Book) System.out.println("Cannot play book");
							break;
						case 7: 
							cart.sortByTitleAndCategory();
							cart.printCart();
							break;
						default:
							break;
						}
					}
					break;
				default:
					break;
				}
		}
		input.close();
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a Media's details");
		System.out.println("2. Add a Media to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter Medias in cart");
		System.out.println("2. Sort Medias in cart");
		System.out.println("3. Remove Media from cart");
		System.out.println("4. Get a lucky item from cart");
		System.out.println("5. Place order");
		System.out.println("6. Play media");
		System.out.println("7. Sort by title and category");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		}
}
