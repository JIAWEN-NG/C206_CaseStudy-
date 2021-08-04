import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class C206_CaseStudy {

	/**
	 * 
	 */

	private static final int OPTION_QUIT = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ArrayList<Account> accList = new ArrayList<Account>();
		ArrayList<Category> categoryList = new ArrayList<Category>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<Bid> bidsList = new ArrayList<Bid>();
		ArrayList<Deal> dealList = new ArrayList<Deal>();

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		itemList.add(new Item("DOG", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00));
		//Main program codes done by Jia Wen and Chu En 
		//OPTION 1: Done by Jia Wen
		//OPTION 2: Done by Chu En 
		//OPTION 3: Done by Rachel 
		//OPTION 4: Done by Jia Wen and Chu En 
		//OPTION 5: Done by Izhar


		int option = 0;

		while (option != OPTION_QUIT ) {

			menu();
			option = Helper.readInt("Enter an option > ");

			//OPTION 1: Done by Jia Wen
			if (option == 1) {
				C206_CaseStudy.setHeader("ACCOUNT SERVICES");
				optionTypeMenu();

				int accOption = Helper.readInt("Enter option to select service type > ");

				if (accOption == 1) {

					userTypeMenu();
					int accType = Helper.readInt("Enter user type > ");

					if (accType == 1) {
						Buyer b1 = inputBuyer();
						C206_CaseStudy.addBuyer(accList,b1);
					}
					else if (accType == 2) {
						Seller s1 = inputSeller();
						C206_CaseStudy.addSeller(accList,s1);
					}
					else {
						System.out.println("Invalid option");
					}

				} 
				else if (accOption == 2) {
					C206_CaseStudy.viewAllAccount(accList);
				}
				else if(accOption == 3) {
					C206_CaseStudy.deleteAcc(accList);

				}
				else {
					System.out.println("Invalid option entered!");

				}
			}

			//OPTION 2: Done by Chu En 
			else if (option == 2) {
				C206_CaseStudy.setHeader("CATEGORY SERVICES");
				optionTypeMenu();

				int categoryOption = Helper.readInt("Enter option to select service type > ");

				if (categoryOption == 1) {
					Category category1 = inputCategory();
					C206_CaseStudy.addCategory(categoryList, category1);

				}
				else if (categoryOption == 2) {
					C206_CaseStudy.viewAllCategory(categoryList);
				}
				else if(categoryOption == 3) {
					C206_CaseStudy.deleteCategory(categoryList);

				}
				else {
					System.out.println("Invalid option entered!");
				}

			}
			//OPTION 3: Done by Rachel
			else if (option == 3) {
				C206_CaseStudy.setHeader("ITEM SERVICES");
				optionTypeMenu();


				int itemOption = Helper.readInt("Enter option to select service type > ");

				if (itemOption == 1) {
					Item item1 = inputItem();
					C206_CaseStudy.addItem(itemList, item1);

				}
				else if (itemOption == 2) {
					C206_CaseStudy.viewAllItem(itemList);
				}
				else if(itemOption == 3) {
					C206_CaseStudy.deleteItem(itemList);

				}
				else {
					System.out.println("Invalid option entered!");
				}

			}
			//OPTION 4: Done by Jia Wen and Chu En 
			else if (option == 4) {
				C206_CaseStudy.setHeader("BIDS SERVICE");
				optionTypeMenu();

				int bidsOption = Helper.readInt("Enter option to select service type > ");
				if(bidsOption == 1) {
					C206_CaseStudy.viewAllBids(bidsList);
					Bid bids1 = inputBid(bidsList, itemList);
					C206_CaseStudy.addBid(bidsList, bids1);	
				}
				// Done by Chu En 
				else if (bidsOption == 2) {
					C206_CaseStudy.viewAllBids(bidsList);

				}
				// Done by Jia Wen 
				else if (bidsOption == 3) {
					C206_CaseStudy.deleteBids(bidsList);

				}
				//OPTION 5: Done by Izhar
				else if (option == 5) {
					C206_CaseStudy.setHeader("DEAL SERVICE");
					optionTypeMenu();

					int dealOption = Helper.readInt("Enter option to select service type > ");
					if(dealOption == 1 ) {
						Deal deal1 = InputDeal(dealList);
						C206_CaseStudy.addDeal(dealList, deal1);	
					}
					else if (dealOption == 2) {
						C206_CaseStudy.ViewAllDeal(dealList);

					}
					else if (dealOption == 3) {
						C206_CaseStudy.DeleteDeal(dealList);

					}

				}
				else if (option == OPTION_QUIT) {

				}
				else {
					System.out.println("You have enetered an invalid option!");
				}

			}
		}

	}//main

	// done by Jia wen 
	public static void menu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. Account Services");
		System.out.println("2. Category Services ");
		System.out.println("3. Item Services");
		System.out.println("4. Bids Services");
		System.out.println("5. Deals Services");
		System.out.println("6. Quit Services");
		Helper.line(80, "-");

	}
	// done by Chu En 
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//done by chu en 
	public static void optionTypeMenu() {
		C206_CaseStudy.setHeader("SERVICE OPTIONS");
		System.out.println("1. ADD");
		System.out.println("2. VIEW ALL");
		System.out.println("3. DELETE");
	}

	//OPTION 1: Account Services, done by Jia Wen 
	public static void userTypeMenu() {
		C206_CaseStudy.setHeader("USER TYPE");
		System.out.println("1. Buyer");
		System.out.println("2. Seller");

	}

	public static Buyer inputBuyer() {
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter email > ");
		int password = Helper.readInt("Enter password > ");

		Buyer userB = new Buyer(name,role,email,password);
		return userB;
	}
	public static Seller inputSeller() {
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter email > ");
		int password = Helper.readInt("Enter password > ");

		Seller userS = new Seller(name,role,email,password);
		return userS;
	}

	public static void addBuyer(ArrayList<Account> accList, Buyer userB) {
		accList.add(userB);
		System.out.println("User Account added !");
	}

	public static void addSeller(ArrayList<Account> accList, Seller userS) {
		accList.add(userS);
		System.out.println("User Account added !");
	}
	public static String retrieveAllUser(ArrayList<Account> accList) {

		String output = "";
		for (int i = 0; i < accList.size(); i++) {
			output += String.format("%-48s \n", accList.get(i).toString());
		}

		return output;

	}
	public static void viewAllAccount(ArrayList<Account> accList) {
		C206_CaseStudy.setHeader("ACCOUNT LIST");
		String output = String.format("%-10s %-10s %-15s %-10s \n", "NAME","ROLE","EMAIL","PASSWORD");
		output += retrieveAllUser(accList);
		System.out.println(output);
	}
	public static boolean doDeleteAcc(ArrayList<Account> accList, String deleteEmail) {
		boolean isFound = false;
		for(int i = 0; i < accList.size(); i++) {
			String accEmail = accList.get(i).getEmail();
			if(accEmail.equalsIgnoreCase(deleteEmail)) {
				accList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	public static void deleteAcc(ArrayList<Account> accList) {
		C206_CaseStudy.viewAllAccount(accList);
		String deleteEmail = Helper.readString("Enter the user email to delete > ");
		boolean isFound = doDeleteAcc(accList, deleteEmail);
		if(isFound == true ) {
			char toDelete = Helper.readChar("Are you sure you want to delete this user account? (Y/N) > ");
			if (toDelete == 'Y' | toDelete == 'y') {
				System.out.println("User Account deleted");
			}

			else {
				System.out.println("User Account not deleted!");
			}
		}else {
			System.out.println("User Account not found!");
		}

	}


	//Option 2: Category Services , done by Chu En 
	public static Category inputCategory() {
		String name = Helper.readString("Enter category name > ");

		Category category1 = new Category(name);

		return category1;
	}	
	public static void addCategory(ArrayList<Category> categoryList, Category category1) {
		categoryList.add(category1);
		System.out.println("Category added");
	}
	public static String retrieveAllCategory(ArrayList<Category> categoryList) {
		String output = "";
		for (int i = 0; i < categoryList.size(); i++) {
			output += String.format("%s \n", categoryList.get(i).toString());
		}
		return output;
	}
	public static void viewAllCategory(ArrayList<Category> categoryList) {
		C206_CaseStudy.setHeader("CATEGORY LIST");
		String output = String.format("%s \n", "NAME");
		output += retrieveAllCategory(categoryList);
		System.out.println(output);
	}

	public static boolean doDeleteCategory(ArrayList<Category> categoryList, String deleteName) {
		boolean isFound = false;
		for(int i = 0; i < categoryList.size(); i++) {
			String categoryName = categoryList.get(i).getName();
			if(deleteName.equalsIgnoreCase(categoryName)) {
				categoryList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	public static void deleteCategory(ArrayList<Category> categoryList) {
		C206_CaseStudy.viewAllCategory(categoryList);
		String deleteCategory = Helper.readString("Enter the item name to delete > ");
		boolean isFound = doDeleteCategory(categoryList, deleteCategory);
		if(isFound == true ) {
			char toDelete = Helper.readChar("Are you sure you want to delete this category? (Y/N) > ");
			if (toDelete == 'Y' | toDelete == 'y') {
				System.out.println("Category deleted");
			}

			else {
				System.out.println("Category not deleted!");
			}
		}else {
			System.out.println("Category not found!");
		}

	}

	//OPTION 3: Item Services, done by Rachel  
	public static Item inputItem() {
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String name = Helper.readString("Enter item name > ");
		String description = Helper.readString("Enter description > ");
		double minPrice = Helper.readInt("Enter minimum bid price >$ ");
		String startDate = Helper.readString("Enter acution start date > ");
		String endDate = Helper.readString("Enter acution end date > ");
		double increment = Helper.readDouble("Enter bid increment amount > $");

		LocalDate start = LocalDate.parse(startDate, formatter2);
		LocalDate end = LocalDate.parse(endDate, formatter2);

		Item item1= new Item(name,description,minPrice,start,end,increment);

		return item1;

	}
	public static void addItem(ArrayList<Item> itemList, Item item1) {
		itemList.add(item1);
		System.out.println("Item added");
	}
	public static String retrieveAllItem(ArrayList<Item> itemList) {
		String output = "";
		for(int i = 0; i < itemList.size(); i++) {
			output += String.format("%-80s \n", itemList.get(i).toString());
		}
		return output;
	}
	public static void viewAllItem(ArrayList<Item> itemList) {
		C206_CaseStudy.setHeader("ITEM LIST");
		String output = String.format("%-10s %-20s %-10s %-15s %-15s %-10s\n", "NAME", "DESCRIPTION", "MIN BID PRICE", "START DATE", "END DATE", "INCREMENT AMOUNT");
		output += retrieveAllItem(itemList);
		System.out.println(output);
	}

	public static boolean doDeleteItem(ArrayList<Item> itemList, String deleteName) {
		boolean isFound = false;
		for(int i = 0; i < itemList.size(); i++) {
			String itemName = itemList.get(i).getItemName();
			if(itemName.equalsIgnoreCase(deleteName)) {
				itemList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	public static void deleteItem(ArrayList<Item> itemList) {
		C206_CaseStudy.viewAllItem(itemList);
		String deleteItem = Helper.readString("Enter the item name to delete > ");
		boolean isFound = doDeleteItem(itemList, deleteItem);
		if(isFound == true ) {
			char toDelete = Helper.readChar("Are you sure you want to delete this item? (Y/N) > ");
			if (toDelete == 'Y' | toDelete == 'y') {
				System.out.println("Item deleted");
			}

			else {
				System.out.println("Item not deleted!");
			}
		}else {
			System.out.println("Item not found!");
		}

	}
	//OPTION 4: Bid Services, Done By Chu En and Jia Wen 

	//Done by chu en 
	public static boolean isValidBid (ArrayList<Bid> bidsList,double price,ArrayList<Item> itemList) {
		boolean isValid = false;

		for (int x = 0; x < itemList.size(); x++) {
			if (bidsList.isEmpty() && price >= itemList.get(x).getMinBid()) {
				isValid = true;
			}
			else {
				for (int i = 0; i < bidsList.size(); i++) {

					if (price >= bidsList.get(i).getPrice() + itemList.get(x).getIncrement() && price > itemList.get(x).getMinBid()) {
						isValid = true;
					}
				}

			}
		}
		return isValid;
	}
	//Done by chu en 
	public static Bid inputBid(ArrayList<Bid> bidsList,ArrayList<Item> itemList) {
		int ID = Helper.readInt("Enter Bids ID > ");
		String name = Helper.readString("Enter Item Name > ");
		String buyerEmail = Helper.readString("Enter Buyer email > ");
		String sellerEmail = Helper.readString("Enter seller email > ");
		double price = Helper.readDouble("Enter Bids price >$");
		boolean isValid = isValidBid(bidsList,price,itemList);

		if (isValid == true) {
			Bid bids1 = new Bid(ID, name, buyerEmail, sellerEmail,price);
			return bids1;
		}
		else {
			return null;
		}

	}
	//Done by chu en 
	public static void addBid(ArrayList<Bid> bidsList, Bid bids1) {	
		if (bids1 == null ) {
			System.out.println("Invalid bid");
		}
		else {
			bidsList.add(bids1);
			System.out.println("Bids Added");
		}
	}
	//Done by Jia Wen 
	public static void retrieveSortedBids(ArrayList<Bid> bidsList) {
		Collections.sort(bidsList,new Comparator<Bid>() {
			public int compare(Bid b1, Bid b2) {

				return Double.compare(b2.getPrice(), b1.getPrice());	
			}
		});
	}
	//Done by Jia Wen 
	public static String retrieveAllBids(ArrayList<Bid> bidsList) {

		String output = "";
		for (int i = 0; i < bidsList.size(); i++) {
			output += String.format("%-69s \n", bidsList.get(i).toString());
		}
		return output;
	}
	//Done by Chu En 
	public static void viewAllBids(ArrayList<Bid> bidsList) {
		C206_CaseStudy.setHeader("BIDS LIST");

		if (bidsList.isEmpty()) {
			System.out.println("There are no existing bids\n");
		}
		else {
			String output = String.format("%-10s %-10s %-15s %-20s %-10s \n", "ID", "NAME", 
					"BUYER EMAIL", "SELLER EMAIL", "BIDS PRICE");
			output += retrieveAllBids(bidsList);
			System.out.println(output);
		}
	}
	//Done by Jia Wen 
	public static boolean doDeleteBids(ArrayList<Bid> bidsList, int deleteID) {
		boolean isFound = false;
		for(int i = 0; i < bidsList.size(); i++) {
			int bidsID = bidsList.get(i).getId();
			if(bidsID == deleteID) {
				bidsList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}
	//Done by Jia Wen 
	public static void deleteBids(ArrayList<Bid> bidsList) {
		C206_CaseStudy.viewAllBids(bidsList);
		int deleteID = Helper.readInt("Enter the bids ID to delete > ");
		boolean isFound = doDeleteBids(bidsList, deleteID);
		if(isFound == true ) {
			char toDelete = Helper.readChar("Are you sure you want to delete this bids? (Y/N) > ");
			if (toDelete == 'Y' | toDelete == 'y') {
				System.out.println("Bids deleted");
			}

			else {
				System.out.println("Bids not deleted!");
			}
		}else {
			System.out.println("Bids not found!");
		}
	}
	//OPTION 5: Deal Services , done by Izhar
	public static Deal InputDeal(ArrayList<Deal> DealList) { 
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(""); 
		System.out.println("ADD DEAL"); 
		int DealId = Helper.readInt("Enter deal ID > "); 
		String itemName = Helper.readString("Enter Item Name > ");
		String sellerEmail = Helper.readString("Enter Seller Email");
		String BuyerEmail = Helper.readString("Enter your email > "); 
		double transactionPrice = Helper.readDouble("Enter your deal Price > $");
		String closeDate = Helper.readString("Enter closing date > ");

		LocalDate closing = LocalDate.parse(closeDate, formatter2);

		Deal deal1 = new Deal(DealId,itemName,sellerEmail,BuyerEmail,transactionPrice,closing);

		return deal1;

	}
	public static void addDeal(ArrayList<Deal> dealList, Deal deal1) {
		dealList.add(deal1);
		System.out.println("Deal added");
	}

	public static String retrieveAllDeal(ArrayList<Deal> dealList) {
		String output = "";
		for(int i = 0; i < dealList.size(); i++) {
			output += String.format("%-80s \n", dealList.get(i).toString());
		}
		return output;
	}

	public static void ViewAllDeal(ArrayList<Deal> dealList) { 

		String output = ""; 
		output = String.format("%-10s %-10s %-15s %-20s %-10s %-10s\n", "Deal ID", "Item Name", "Description", 
				"Seller Email", "Transaction price($)", "Ending Date"); 
		output += retrieveAllDeal(dealList);

		System.out.println(output); 
	}

	public static void DeleteDeal(ArrayList<Deal> dealList) { 
		System.out.println(""); 
		int RemoveDeal = Helper.readInt("Enter the Deal ID to delete > "); 
		for (int i = 0; i < dealList.size(); i++) { 
			if (RemoveDeal == dealList.get(i).getdealId()) { 
				dealList.remove(i); 
				System.out.println("Deal successfully removed"); 
			} else { 
				System.out.println("Deal ID does not exist"); 
			} 
		} 
	} 
	public static boolean doDeleteDeal(ArrayList<Deal> dealList, int deleteID) {
		boolean isFound = false;
		for(int i = 0; i < dealList.size(); i++) {
			int dealID = dealList.get(i).getdealId();
			if(dealID == deleteID) {
				dealList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	public static void deleteDeal(ArrayList<Deal> dealList) {
		C206_CaseStudy.ViewAllDeal(dealList);
		int deleteID = Helper.readInt("Enter the deal ID to delete > ");
		boolean isFound = doDeleteDeal(dealList, deleteID);
		if(isFound == true ) {
			char toDelete = Helper.readChar("Are you sure you want to delete this deal? (Y/N) > ");
			if (toDelete == 'Y' | toDelete == 'y') {
				System.out.println("Deal deleted");
			}

			else {
				System.out.println("Deal not deleted!");
			}
		}else {
			System.out.println("Deal not found!");
		}
	}


}//class
