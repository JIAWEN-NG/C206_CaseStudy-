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


		int login = Helper.readInt("Enter login option > ");

		if(login == 1) {
			int adminOption = Helper.readInt("Enter option to select service type > ");
			while(adminOption != OPTION_QUIT) {

				//OPTION 1: Done by jia wen 
				if (adminOption == 1) {
					optionTypeMenu();
					int optionType = Helper.readInt("Enter service type > ");

					if (optionType == 1) {
						Account acc = inputAccount();
						C206_CaseStudy.addAccount(accList,acc);

					}else if (optionType == 2) {
						C206_CaseStudy.viewAllAccount(accList);

					}else if (optionType == 3) {
						C206_CaseStudy.deleteAcc(accList);

					}else {
						System.out.println("Invalid option!");
					}

				}
				else if (adminOption == 2) {
					optionTypeMenu();
					int optionType = Helper.readInt("Enter service type > ");

					if (optionType == 1) {
						Category cate = inputCategory();
						C206_CaseStudy.addCategory(categoryList, cate);

					}else if (optionType == 2) {
						C206_CaseStudy.viewAllAccount(categoryList);

					}else if (optionType == 3) {
						C206_CaseStudy.deleteCategory(categoryList);

					}else {
						System.out.println("Invalid option!");
					}

				}


				} 
			}
		}

	}//main



	public static void login() {
		C206_CaseStudy.setHeader("Login system");
		System.out.println("1. Login as Adminstrator");
		System.out.println("2. Login as Student");
	}

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


	public static void accType() {
		System.out.println("Buyer");
		System.out.println("Seller");
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
		String name = Helper.readString("Enter name > ");
		boolean validName = C206_CaseStudy.isValidCateName(name);
		while (validName == false ) {
			System.out.println("Please enter cetegory name less than 20 character");
			name = Helper.readString("Enter Category name > ");
		}

		if(validName == true) {
			Category category1 = new Category(name);
			return category1;
		}
		else {
			return null;
		}

	}	
	public static void addCategory(ArrayList<Category> categoryList, Category category1) {
		if (category1 == null) {
			System.out.println("Category not added");
		}
		else {
			categoryList.add(category1);
			System.out.println("Category added");
		}
	}

	public static boolean isValidCateName(String name) {
		String namePattern = "[a-zA-Z]{2,20}";
		boolean isValid = Pattern.matches(namePattern, name);
		if (isValid) {
			return true;
		}
		else {
			return false;
		}		
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
			if(categoryName.equalsIgnoreCase(categoryName)) {
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

	//Done by Chu En 
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
	//Done by Chu En 
	public static Bid inputBid(ArrayList<Bid> bidsList,ArrayList<Item> itemList) {
		int ID = Helper.readInt("Enter Bids ID > ");
		String name = Helper.readString("Enter name > ");
		boolean validName = C206_CaseStudy.isValidBidName(name);
		while (validName == false ) {
			System.out.println("Please enter cetegory name less than 20 character");
			name = Helper.readString("Enter Category name > ");
		}
		String buyerEmail = Helper.readString("Enter Buyer email > ");
		boolean validBuyerEmail = C206_CaseStudy.validEmail(buyerEmail);
		while (validBuyerEmail ==  false) {
			System.out.println("Invalid Email");
			name = Helper.readString("Enter Buyer Email > ");
		}
		String sellerEmail = Helper.readString("Enter seller email > ");
		boolean validSellerEmail = C206_CaseStudy.validEmail(sellerEmail);
		while (validSellerEmail ==  false) {
			System.out.println("Invalid Email");
			name = Helper.readString("Enter Seller Email > ");
		}
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
	//Done by Chu En 
	public static void addBid(ArrayList<Bid> bidsList, Bid bids1) {	
		if (bids1 == null ) {
			System.out.println("Invalid bid");
		}
		else {
			bidsList.add(bids1);
			System.out.println("Bids Added");
		}
	}
	public static boolean isValidBidName (String name) {
		String namePattern = "[a-zA-Z]{2,20}";
		boolean isValid = Pattern.matches(namePattern, name);
		if (isValid) {
			return true;
		}
		else {
			return false;
		}
	}//done by Jia Wen 
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
