import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;


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
					Account acc = inputAccount();
					C206_CaseStudy.addAccount(accList,acc);


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

	public static Account inputAccount() {

		String name = Helper.readString("Enter name > ");
		boolean vName = C206_CaseStudy.validName(name);
		while (vName == false ) {
			System.out.println("Invalid name");
			name = Helper.readString("Enter name > ");
		}
		String role = Helper.readString("Enter role > ");
		boolean vRole = C206_CaseStudy.validRole(role);
		while (vRole == false ) {
			System.out.println("Invalid Role");
			role = Helper.readString("Enter role > ");
		}
		String email = Helper.readString("Enter email > ");
		boolean vEmail = C206_CaseStudy.validEmail(email);
		while (vEmail == false ) {
			System.out.println("Invalid Email");
			email = Helper.readString("Enter email > ");
		}
		int password = Helper.readInt("Enter password > ");
		boolean vPw = C206_CaseStudy.validPassword(password);
		while (vEmail == false ) {
			System.out.println("Invalid Password...Please enter a 7 digit number");
			password = Helper.readInt("Enter password > ");
		}
		boolean isEmpty = C206_CaseStudy.notEmptyAcc(name, role, email, password);
		if (isEmpty == false) {
			System.out.println("Please fill in all the details");
		}
		if (vName == true && vRole == true && vEmail == true && vPw == true && isEmpty == true) {
			Account user = new Account(name,role,email,password);
			return user;
		}
		else {
			return null;
		}
	}
	//By Jia Wen
	public static boolean validEmail(String email) {
		String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		boolean isValid = Pattern.matches(emailPattern, email);

		if (isValid) {
			return true;
		}
		else {
			return false;
		}
	}
	//By Jia Wen
	public static boolean validPassword(int password) {
		int len = String.valueOf(password).length();
		if (len == 7) {
			return true;
		}
		else {
			return false;
		}

	}
	public static boolean validRole (String role) {

		if(role.equalsIgnoreCase("Seller") || role.equalsIgnoreCase("Buyer") || role.equalsIgnoreCase("Admin")) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean validName (String name) {
		String namePattern = "[a-zA-Z]{2,15}";
		boolean isValid = Pattern.matches(namePattern, name);
		if (isValid) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean notEmptyAcc(String name,String role,String email,int password) {
		String patternEmpty = "\\s*";

		if (Pattern.matches(patternEmpty,name) || Pattern.matches(patternEmpty,role) || Pattern.matches(patternEmpty,email)
				|| String.valueOf(password).length() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void addAccount(ArrayList<Account> accList, Account user) {

		if (user == null ) {
			System.out.println("User Account not added");
		}
		else {
			accList.add(user);
			System.out.println("User Account added");
		}
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

		if (accList.isEmpty()) {
			System.out.println("There are no user accounts");
		}
		else {
			String output = String.format("%-10s %-10s %-15s %-10s \n", "NAME","ROLE","EMAIL","PASSWORD");
			output += retrieveAllUser(accList);
			System.out.println(output);
		}
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
		
		String email = Helper.readString("Enter email > ");
		boolean vEmail = C206_CaseStudy.validEmail(email);
		
		while (vEmail == false ) {
			System.out.println("Invalid Email");
			email = Helper.readString("Enter email > ");
		}
		boolean isFound = doDeleteAcc(accList, email);
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
		String name = Helper.readString("Enter item name > ");
		boolean vIName = C206_CaseStudy.validItemName(name);
		while (vIName == false ) {
			System.out.println("Invalid Item Name");
			name = Helper.readString("Enter item name > ");

		}
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String description = Helper.readString("Enter description > ");
		double minPrice = Helper.readInt("Enter minimum bid price >$ ");
		String startDate = Helper.readString("Enter auction start date > ");
		String endDate = Helper.readString("Enter auction end date > ");
		double increment = Helper.readDouble("Enter bid increment amount > $");

		LocalDate start = LocalDate.parse(startDate, formatter2);
		LocalDate end = LocalDate.parse(endDate, formatter2);

		Item item1= new Item(name,description,minPrice,start,end,increment);

		return item1;
		

	}
	public static boolean validItemName (String itemName) {
		String namePattern = "[a-zA-Z]{2,30}";
		boolean isValid = Pattern.matches(namePattern, itemName);
		if (isValid) {
			return true;
		}
		else {
			return false;
		}
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
	//deal
	
		public static Deal inputDeal(ArrayList<Deal> bidsList,ArrayList<Item> itemList) { 
			C206_CaseStudy.setHeader("ADD NEW DEAL"); 
			  
			  int dealId = Helper.readInt("Enter deal ID > ");
			  String itemName = Helper.readString("Enter item name > ");
			  String sellerEmail = Helper.readString("Enter seller's email > ");
	          String buyerEmail = Helper.readString("Enter buyer's email > ");
			  double transactionPrice = Helper.readDouble("Enter transaction price > ");
		      String closeDate = Helper.readString("Enter close deal (DD/MM/YYYY) > "); 
		      
		      Deal deal1 = new Deal(dealId, itemName, sellerEmail, buyerEmail, transactionPrice, closeDate);
		      return deal1;
			 
			     
			   }
		
		public static void addDeal(ArrayList<Deal> dealList, Deal deal1) {

		    if (deal1.getItemName().isEmpty() || deal1.getSellerEmail().isEmpty() || deal1.getBuyerEmail().isEmpty()
		        || deal1.getCloseDate().isEmpty()) {
		      System.out.println("Please fill in all mandatory fields!");
		    } else {
		      dealList.add(deal1);
		      System.out.println("Successfully added new deal!");
		    }

		  }
		
		public static String retrieveAllDeals(ArrayList<Deal> dealList) {
		    String output = "";

		    for (Deal d : dealList) {

		      output += String.format("\n%-10d %-25s %-30s %-30s %-9.2f %11s", d.getdealId(), d.getItemName(),
		          d.getSellerEmail(), d.getBuyerEmail(), d.getTransactionPrice(), d.getCloseDate());
		    }
		    return output;
		  }
		
		public static void viewAllDeals(ArrayList<Deal> dealList) {

		    String output = String.format("%-10s %-25s %-30s %-30s %-9s %11s", "DEAL ID", "ITEM NAME", "SELLER EMAIL",
		        "BUYER EMAIL", "TRANSACTION PRICE", "CLOSE DATE");
		    output += retrieveAllDeals(dealList);
		    System.out.println(output);

		  }
		
		public static boolean doDeleteDeal(ArrayList<Deal> dealList, int dealID, char cfm) {

		    boolean isDeleted = false;

		    for (Deal d : dealList) {
		      if (dealID == d.getdealId() && (cfm == 'Y' || cfm == 'y')) {
		        dealList.remove(d);
		        isDeleted = true;
		        break;
		      }
		    }

		    return isDeleted;
		  }
		
		public static void deleteDeal(ArrayList<Deal> dealList) {
			C206_CaseStudy.setHeader("Delete deal");
		    C206_CaseStudy.viewAllDeals(dealList);
		    int dealID = Helper.readInt("Enter deal ID you want to delete > ");
		    char cfm = Helper.readChar("Are you sure you want to delete this deal? (Y/N) > ");
		    boolean isDeleted = doDeleteDeal(dealList, dealID, cfm);

		    if (isDeleted == false) {
		      System.out.println("Delete was unsuccessful. Please enter a valid deal ID.");
		    } else {
		      System.out.println("Deal ID " + dealID + " successfully deleted!");
		    }
		  }


}//class
