import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Item item1;
	private Item item2;
	private Bid b1;
	private Bid b2;
	private Category cat1;
	private Category cat2;




	ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
	ArrayList<Seller> sellerList = new ArrayList<Seller>();
	ArrayList<Category> categoryList = new ArrayList<Category>();
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<Bid> bidsList = new ArrayList<Bid>();

	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public C206_CaseStudyTest() {
		super();
	}


	//Issue 1

	//Issue 2

	//Issue 3
	public void addItem() {
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);
		
		C206_CaseStudy.addItem(itemList, item1);
		assertEquals("Check that items arraylist size is 1", 1, itemList.size());
		assertSame("Check that items is added", item1, itemList.get(0));
		
		C206_CaseStudy.addItem(itemList, item2);
		assertEquals("Check that items arraylist size is 1", 2, itemList.size());
		assertSame("Check that items is added", item2, itemList.get(1));

	}
	
	public void viewAllItem() {
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);

		//test if the list of item retrieved is empty -Boundary
		String allItem = C206_CaseStudy.retrieveAllItem(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllItem list", testOutput, allItem);

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addItem(itemList, item1);
		C206_CaseStudy.addItem(itemList, item2);
		assertEquals("Test that Item arraylist size is 2?", 2, itemList.size());

		//test if the expected output string same as the list of bid retrieved 	
		allItem = C206_CaseStudy.retrieveAllItem(itemList);
		
		testOutput = String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 1, "Dog", "happy@gmail.com", "sam@gmail.com", 50.00);
		testOutput += String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 2, "Cat", "kkq@gmail.com", "sammy@gmail.com", 60.00);

		assertEquals("Test that ViewAllBids list", testOutput, allItem);
	}
	
	public void deleteItem() {
		C206_CaseStudy.deleteItem(itemList);
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);

		C206_CaseStudy.addItem(itemList, item1);
		C206_CaseStudy.addItem(itemList, item2);
		String deleteName = "Dog";
		String deleteName2 = "Cat";
		
		C206_CaseStudy.doDeleteItem(itemList, "Dog");
		//Given an list of 2 bids, after removing 1 item, the size of the list is 1 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Item arraylist size is 1", 1, itemList.size());
		assertSame("Check that a Item is removed", item2, bidsList.get(0));
		
		C206_CaseStudy.doDeleteItem(itemList, "Cat");
		//Given an list of 1 bids, after removing 1 item, the size of the list is 0 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that item arraylist size is 0", 0, bidsList.size());
	}

	//Issue 4
	@Test
	public void addBidTest() {
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidsList);

		C206_CaseStudy.addBid(bidsList,b1);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		assertEquals("Check that bids arraylist size is 1", 1, bidsList.size());
		assertSame("Check that bids is added", b1, bidsList.get(0));

		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addBid(bidsList,b2);
		assertEquals("Check that bids arraylist size is 2", 2, bidsList.size());
		assertSame("Check that bid is added", b2, bidsList.get(1));
	}
	@Test
	public void retrieveAllBidsTest() {
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidsList);

		//test if the list of bids retrieved is empty - boundary
		String allBids = C206_CaseStudy.retrieveAllBids(bidsList);
		String testOutput = "";
		assertEquals("Check that ViewAllBids list", testOutput, allBids);

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addBid(bidsList, b1);
		C206_CaseStudy.addBid(bidsList, b2);
		assertEquals("Test that Bids arraylist size is 2?", 2, bidsList.size());

		//test if the expected output string same as the list of bid retrieved 	
		allBids = C206_CaseStudy.retrieveAllBids(bidsList);
		
		testOutput = String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 1, "Dog", "happy@gmail.com", "sam@gmail.com", 50.00);
		testOutput += String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 2, "Cat", "kkq@gmail.com", "sammy@gmail.com", 60.00);

		assertEquals("Test that ViewAllBids list", testOutput, allBids);

	}
	@Test
	public void doDeleteBidsTest() {
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidsList);

		C206_CaseStudy.addBid(bidsList,b1);
		C206_CaseStudy.addBid(bidsList,b2);
		int deleteId = 1;
		int deleteId2 = 2;
		C206_CaseStudy.doDeleteBids(bidsList,1);
		//Given an list of 2 bids, after removing 1 item, the size of the list is 1 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Bids arraylist size is 1", 1, bidsList.size());
		assertSame("Check that a Bid is remove", b2, bidsList.get(0));
		
		C206_CaseStudy.doDeleteBids(bidsList,2);
		//Given an list of 1 bids, after removing 1 item, the size of the list is 0 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Bids arraylist size is 0", 0, bidsList.size());
	}
	
	//Issue 5

	@Before
	public void setUp() throws Exception {
		//prepare test data 
		item1 = new Item("DOG", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);
		item2 = new Item("CAT", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);
		b1 = new Bid(1, "Dog", "happy@gmail.com", "sam@gmail.com", 50.00);
		b2 = new Bid(2, "Cat", "kkq@gmail.com", "sammy@gmail.com", 60.00);
	
		cat2 = new Category("PETS");
		cat2 = new Category("FRUITS");
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
