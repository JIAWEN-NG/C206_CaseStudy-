import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class C206_CaseStudy {

	/**
	 * 
	 */
	private static final int OPTION_QUIT = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		ArrayList<Item> itemList = new ArrayList<Item>();
		
		int option = 0;
		
		while (option != OPTION_QUIT ) {
			
			menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				
			}
			else if (option == 2) {
				
			}
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
			else if (option == 4) {
				
			}
			else if (option == 5) {
				
			}
			else if (option == OPTION_QUIT) {
				
			}
			else {
				System.out.println("You have enetered an invalid option!");
			}
			
			
			
		}
		
	}//main 
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
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	public static void optionTypeMenu() {
		C206_CaseStudy.setHeader("SERVICE OPTIONS");
		System.out.println("1. ADD");
		System.out.println("2. VIEW ALL");
		System.out.println("3. DELETE");
	}

	public static Item inputItem() {
		String name = Helper.readString("Enter item name > ");
		String description = Helper.readString("Enter description > ");
		double minPrice = Helper.readInt("Enter minimum bid price >$ ");
		Date startDate = Helper.readDate("Enter acution start date > ");
		Date endDate = Helper.readDate("Enter acution end date > ");
		double increment = Helper.readDouble("Enter bid increment amount > $");

		Item item1= new Item(name,description,minPrice,startDate,endDate,increment);
		
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
	    String output = String.format("%-10s %-20s %-10s %-15s %-15s %-10s\n", "NAME", "DESCRIPTION", "BID PRICE", "START DATE", "END DATE", "INCREMENT AMOUNT");
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
	        System.out.println("Item deleted");
	      }
	      else {
	        System.out.println("Item not deleted");
	      }
	    }
	
	

}//class..
