import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {



	private Account a1;
	private Account a2;
	private Category cate1;
	private Category cate2;
	private Item item1;
	private Item item2;
	private Bid b1;
	private Bid b2;




	ArrayList<Account> accList = new ArrayList<Account>();
	ArrayList<Category> categoryList = new ArrayList<Category>();
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<Bid> bidsList = new ArrayList<Bid>();

	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public C206_CaseStudyTest() {
		super();
	}


	//Issue 1
	//Test by Jia Wen
	@Test
	public void addAccountTest() {

		// Account list is not null, so that can add a new account - boundary
		assertNotNull("Test if there is valid Account arraylist to retrieve item", accList);

		C206_CaseStudy.addAccount(accList,a1);

		//Given an empty list, after adding 1 Account, the size of the list is 1 - normal
		//The Account just added is as same as the first item of the list
		assertEquals("Check that account arraylist size is 1", 1, accList.size());
		assertSame("Check that buyer account is added", a1, accList.get(0));

		//Add another Account . test The size of the list is 2? -normal
		//The Account just added is as same as the second Account of the list
		C206_CaseStudy.addAccount(accList,a2);
		assertEquals("Check that account arraylist size is 2", 2, accList.size());
		assertSame("Check that buyer account is added",a2, accList.get(1));
	}
	//Test by Jia Wen
	@Test
	public void validEmailTest() {


		String validEmail = "Joe123@gmail.com";
		String invalidEmail = "Joe123";

		//boundary condition -check that email is not null 
		assertNotNull(validEmail);

		// normal condition - test that an valid email (with "@" in email ) will return true 
		boolean isValid = C206_CaseStudy.validEmail(validEmail);
		assertTrue(isValid);

		// error condition - test that an invalid email (without "@" in email )will return false 
		boolean notValid = C206_CaseStudy.validEmail(invalidEmail);
		assertFalse(notValid);

	}
	@Test
	public void validNameTest() {

		String validName = "Joey";
		String invalidName = "J";

		//boundary condition -check that Name is not null 
		assertNotNull(validName);

		// normal condition - test that an valid name (2-15 character) will return true 
		boolean isValid = C206_CaseStudy.validName(validName);
		assertTrue(isValid);

		// error condition - test that an invalid name ( character < 2 ,characters > 15) will return false 
		boolean notValid = C206_CaseStudy.validName(invalidName);
		assertFalse(notValid);

	}
	@Test
	public void validRoleTest() {

		String validRole = "seller";
		String invalidRole = "user";

		//boundary condition -check that Role is not null 
		assertNotNull(validRole);

		// normal condition - test that an valid role ("seller","buyer","admin") will return true 
		boolean isValid = C206_CaseStudy.validRole(validRole);
		assertTrue(isValid);

		// error condition - test that an invalid role will return false 
		boolean notValid = C206_CaseStudy.validRole(invalidRole);
		assertFalse(notValid);

	}
	@Test
	public void validPasswordTest() {

		int validPass = 1234567;
		int invalidPass = 12345;

		//boundary condition -check that Role is not null 
		assertNotNull(validPass);

		// normal condition - test that an valid password (len == 7) will return true 
		boolean isValid = C206_CaseStudy.validPassword(validPass);
		assertTrue(isValid);

		// error condition - test that an invalid password will (len > 7 , len < 7) return false 
		boolean notValid = C206_CaseStudy.validPassword(invalidPass);
		assertFalse(notValid);

	}
	@Test
	public void notEmptyAccTest() {

		String n1 = "Joe";
		String r1 = "Seller";
		String e1 = "Joe@gmail.com";
		int p1 = 1234567;

		String n2 = "Sam";
		String r2 = "Seller";
		String e2 = "";
		int p2 = 7654321;

		// error condition - test that one input is empty will return false 
		boolean isEmpty = C206_CaseStudy.notEmptyAcc(n2,r2,e2,p2);
		assertTrue(isEmpty);

		// normal condition - test that if all user input is filled and is valid, will return true 
		boolean notEmpty = C206_CaseStudy.notEmptyAcc(n1,r1,e1,p1);
		assertFalse(notEmpty);

	}

	//Test by Jia Wen
	@Test
	public void retrieveAllUserTest() {

		// Test if account list is not null but empty -boundary
		assertNotNull("Test if there is valid account arraylist to retrieve item", accList);


		String allAcc = C206_CaseStudy.retrieveAllUser(accList);
		String testOutput = "";
		assertEquals("Check that viewAllAccount list", testOutput, allAcc);

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addAccount(accList,a1);
		C206_CaseStudy.addAccount(accList,a2);

		assertEquals("Test that Item arraylist size is 2?", 2, accList.size());

		//test if the expected output string same as the list of item retrieved 	
		allAcc = C206_CaseStudy.retrieveAllUser(accList);

		testOutput = String.format("%-10s %-10s %-15s %-10d \n", "Jay","Buyer","Jay@gmail.com",1234567);
		testOutput += String.format("%-10s %-10s %-15s %-10d \n", "Jenny","Seller","Jenny@gmail.com",7897890);

		assertEquals("Test that viewAllAccount list", testOutput, allAcc);

	}
	//Test by Jia Wen
	@Test
	public void doDeleteAccTest() {
		//C206_CaseStudy.deleteAcc(accList);
		//boundary
		assertNotNull("Test if there is valid Account arraylist to retrieve item", accList);

		C206_CaseStudy.addAccount(accList,a1);
		C206_CaseStudy.addAccount(accList,a2);


		String deleteEmail = "Jay@gmail.com";
		String deleteEmail2 = "Jenny@gmail.com";


		C206_CaseStudy.doDeleteAcc(accList, deleteEmail);
		//Given an list of 2 account, after removing 1 account, the size of the list is 1 - normal
		//The account just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Acoount arraylist size is 1", 1, accList.size());
		assertSame("Check that a Account is removed", a2, accList.get(0));

		C206_CaseStudy.doDeleteAcc(accList, deleteEmail2);
		//Given an list of 2 account, after removing 1 account, the size of the list is 0 - normal
		assertEquals("Check that Account arraylist size is 0", 0, accList.size());

		//error condition , if account does not exist cannot delete 
		boolean delete = C206_CaseStudy.doDeleteAcc(accList, "jojo@gmail.com");
		assertFalse("Test that non-existing item is NOT ok to delete", delete);
	}


	//Issue 2
	//Test by Chu En
	@Test
	public void addCategoryTest() {
		// Test if category list is not null but empty -boundary
		assertNotNull("Test if there is valid Category arraylist to retrieve item", categoryList);

		C206_CaseStudy.addCategory(categoryList, cate1);
		//Given an empty list, after adding 1 category, the size of the list is 1 - normal
		//The category just added is as same as the first item of the list
		assertEquals("Check that Category arraylist size is 1", 1, categoryList.size());
		assertSame("Check that Category is added", cate1, categoryList.get(0));

		C206_CaseStudy.addCategory(categoryList, cate2);
		//Given an empty list, after adding 1 category, the size of the list is 1 - normal
		//The category just added is as same as the first item of the list
		assertEquals("Check that Category arraylist size is 1", 2, categoryList.size());
		assertSame("Check that Category is added", cate2, categoryList.get(1));

	}
	//Test by Chu En
	@Test
	public void retrieveAllCategoryTest() {
		// Test if category list is not null but empty -boundary
		assertNotNull("Test if there is valid category arraylist to retrieve item", categoryList);

		//test if the list of category retrieved is empty -Boundary
		String allCat = C206_CaseStudy.retrieveAllCategory(categoryList);
		String testOutput = "";
		assertEquals("Check that ViewAllCategory list", testOutput, allCat);

		//Given an empty list, after adding 2 category, test if the size of the list is 2 - normal
		C206_CaseStudy.addCategory(categoryList, cate1);
		C206_CaseStudy.addCategory(categoryList, cate2);
		assertEquals("Test that category arraylist size is 2?", 2, categoryList.size());

		//test if the expected output string same as the list of category retrieved 	
		allCat = C206_CaseStudy.retrieveAllCategory(categoryList);

		testOutput = String.format("%s \n", "PETS");
		testOutput += String.format("%s \n", "FRUITS");

		assertEquals("Test that ViewAllCategory list", testOutput, allCat);
	}
	//Test by Chu En
	@Test
	public void isValidCateNameTest() {

		String validName = "Same";
		String invalidName = "S";
		String invalidName1 = "SSSSSSSSSSSSSSSSSSSSS";
		
		//boundary condition -check that Name is not null 
		assertNotNull(validName);
		
		// normal condition - test that an valid name (2-20 character) will return true 
		boolean isValid = C206_CaseStudy.isValidCateName(validName);
		assertTrue(isValid);
		
		// error condition - test that an invalid name ( character < 2 )will return false 
		boolean notValid = C206_CaseStudy.isValidCateName(invalidName);
		assertFalse(notValid);
		
		// error condition - test that an invalid name (characters > 20) will return false 
		boolean notValid1 = C206_CaseStudy.isValidCateName(invalidName1);
		assertFalse(notValid1);
	}
	//Test by Chu En
	@Test
	public void doDeleteCategoryTest() {
		// Test if category list is not null but empty -boundary
		assertNotNull("Test if there is valid Category arraylist to retrieve item", categoryList);

		C206_CaseStudy.addCategory(categoryList, cate1);
		C206_CaseStudy.addCategory(categoryList, cate2);

		String deleteCat = "PETS";
		String deleteCat2 = "FRUITS";

		C206_CaseStudy.doDeleteCategory(categoryList, deleteCat);
		//Given an list of 2 category, after removing 1 category, the size of the list is 1 - normal
		//The item just delete is remove and second category is same as the first item of the list
		assertEquals("Check that category arraylist size is 1", 1, categoryList.size());
		assertSame("Check that a Category is removed", cate2, categoryList.get(0));

		C206_CaseStudy.doDeleteCategory(categoryList, deleteCat2);
		//Given an list of 1 category, after removing 1 category, the size of the list is 0 - normal
		//The item just delete is remove and second category is same as the first item of the list
		assertEquals("Check that category arraylist size is 0", 0, categoryList.size());

		//Test if category delete is match with the category inside the categroyList
		String deleteCat3 = "DRINKS";
		Boolean delete = C206_CaseStudy.doDeleteCategory(categoryList, deleteCat3);
		assertFalse("Check if the category delete exist in the categoryList", delete);

	}

	//Issue 3
	//Test by Rachel
	@Test
	public void validItemNameTest() {
		
		String validItemName = "Portable Speaker";
		String invalidItemName = "P";
		
		//boundary condition -check that Name is not null 
		assertNotNull(validItemName);
		
		// normal condition - test for valid item name (2-20 character) returns true 
		boolean isValid = C206_CaseStudy. validItemName( validItemName);
		assertTrue(isValid);
		
		// error condition - test for invalid item name ( character < 2 ,characters > 30) returns false 
		boolean notValid = C206_CaseStudy. validItemName( invalidItemName);
		assertFalse(notValid);
		
	}
	@Test
	public void addItemTest() {
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);

		C206_CaseStudy.addItem(itemList, item1);
		assertEquals("Check that item arraylist size is 1", 1, itemList.size());
		assertSame("Check that item is added", item1, itemList.get(0));

		C206_CaseStudy.addItem(itemList, item2);
		assertEquals("Check that items arraylist size is 1", 2, itemList.size());
		assertSame("Check that item is added", item2, itemList.get(1));

	}
	//Test by Rachel
	@Test
	public void retrieveAllItemTest() {
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);

		//test if itemList retrieved is empty -Boundary
		String allItem = C206_CaseStudy.retrieveAllItem(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllItem list", testOutput, allItem);

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addItem(itemList, item1);
		C206_CaseStudy.addItem(itemList, item2);
		assertEquals("Test that Item arraylist size is 2", 2, itemList.size());

		//test if the expected output is same as the itemList retrieved 	
		allItem = C206_CaseStudy.retrieveAllItem(itemList);

		testOutput = String.format("%-10s %-20s %-10.2f %-15s %-15s %-10.2f \n", "DOG", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);
		testOutput += String.format("%-10s %-20s %-10.2f %-15s %-15s %-10.2f \n", "CAT", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);

		assertEquals("Test ViewAllItem list", testOutput, allItem);
	}
	//Test by Rachel
	@Test
	public void doDeleteItemTest() {

		assertNotNull("Test that there is valid Item arraylist to retrieve item", itemList);

		C206_CaseStudy.addItem(itemList, item1);
		C206_CaseStudy.addItem(itemList, item2);
		String deleteName = "Dog";
		String deleteName2 = "Cat";

		C206_CaseStudy.doDeleteItem(itemList, deleteName);
		//Given an arraylist of 2 item, after removing 1 item, the size of the list is 1 - normal
		//The item deleted is removed and second item is same as the first item of the list
		assertEquals("Check that Item arraylist size is 1", 1, itemList.size());
		assertSame("Check that a Item is removed", item2, itemList.get(0));

		C206_CaseStudy.doDeleteItem(itemList, deleteName2);
		//Given an arraylist of 1 item, after removing 1 item, the size of the list is 0 - normal
		//The item deleted is removed and second item is same as the first item of the list
		assertEquals("Check that item arraylist size is 0", 0, itemList.size());
	}

	//Issue 4
	//Test by Chu En
	@Test
	public void addBidTest() {
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidsList);

		C206_CaseStudy.addBid(bidsList,b1);
		//Given an empty list, after adding 1 bid, the size of the list is 1 - normal
		//The bid just added is as same as the first bid of the list
		assertEquals("Check that bids arraylist size is 1", 1, bidsList.size());
		assertSame("Check that bids is added", b1, bidsList.get(0));

		//Add another bid, test The size of the list is 2? -normal
		//The bid just added is as same as the second item of the list
		C206_CaseStudy.addBid(bidsList,b2);
		assertEquals("Check that bids arraylist size is 2", 2, bidsList.size());
		assertSame("Check that bid is added", b2, bidsList.get(1));
	}
	//Test by Chu En
	@Test
	public void retrieveAllBidsTest() {
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidsList);

		//test if the list of bids retrieved is empty - boundary
		String allBids = C206_CaseStudy.retrieveAllBids(bidsList);
		String testOutput = "";
		assertEquals("Check that ViewAllBids list", testOutput, allBids);

		//Given an empty list, after adding 2 bids, test if the size of the list is 2 - normal
		C206_CaseStudy.addBid(bidsList, b1);
		C206_CaseStudy.addBid(bidsList, b2);
		assertEquals("Test that Bids arraylist size is 2?", 2, bidsList.size());

		//test if the expected output string same as the list of bid retrieved 	
		allBids = C206_CaseStudy.retrieveAllBids(bidsList);

		testOutput = String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 1, "Dog", "happy@gmail.com", "sam@gmail.com", 50.00);
		testOutput += String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 2, "Cat", "kkq@gmail.com", "sammy@gmail.com", 60.00);

		assertEquals("Test that ViewAllBids list", testOutput, allBids);

	}

	//Test by Jia Wen 
	@Test
	public void doDeleteBidsTest() {
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidsList);

		C206_CaseStudy.addBid(bidsList,b1);
		C206_CaseStudy.addBid(bidsList,b2);
		int deleteId = 1;
		int deleteId2 = 2;

		C206_CaseStudy.doDeleteBids(bidsList,deleteId);
		//Given an list of 2 bids, after removing 1 item, the size of the list is 1 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Bids arraylist size is 1", 1, bidsList.size());
		assertSame("Check that a Bid is remove", b2, bidsList.get(0));

		C206_CaseStudy.doDeleteBids(bidsList,deleteId2);
		//Given an list of 1 bids, after removing 1 item, the size of the list is 0 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Bids arraylist size is 0", 0, bidsList.size());

		// error condition, if bid ID does not exist , cannot delete 
		boolean delete = C206_CaseStudy.doDeleteBids(bidsList,4);
		assertFalse("Test that non-esiting bid is NOT ok to delete",delete);
	}
	//Test by Jia Wen
	@Test
	public void isValidBidTest() {

		double bid1 = 55;
		double bid2 = 53;

		C206_CaseStudy.addItem(itemList, item1); // minBid 50 , increment 5
		C206_CaseStudy.addBid(bidsList,b1);

		//normal condition - if bid > minBid and bid = highest Bid + increment, will return Valid (true)	
		boolean isValid = C206_CaseStudy.isValidBid(bidsList, bid1, itemList);
		assertTrue(isValid);


		//error condition - if bid != highest Bid + increment, will return false 
		boolean notValid = C206_CaseStudy.isValidBid(bidsList, bid2, itemList);
		assertFalse(notValid);

	}
	//Test by Chu En
	@Test
	public void isValidBidNameTest() {
		
		String validName = "Aame";
		String invalidName = "A";
		String invalidName1 = "AAAAAAAAAAAAAAAAAAAAA";
		
		//boundary condition -check that Name is not null 
		assertNotNull(validName);
		
		// normal condition - test that an valid name (2-20 character) will return true 
		boolean isValid = C206_CaseStudy.isValidBidName(validName);
		assertTrue(isValid);
		
		// error condition - test that an invalid name ( character < 2 )will return false 
		boolean notValid = C206_CaseStudy.isValidBidName(invalidName);
		assertFalse(notValid);
		
		// error condition - test that an invalid name (characters > 20) will return false 
		boolean notValid1 = C206_CaseStudy.isValidBidName(invalidName1);
		assertFalse(notValid1);
	}


	//Issue 5
		@Test
		public void addDealTest() {
			assertNotNull("Test if there is valid Deal arraylist to retrieve item", dealList);
			
			C206_CaseStudy.addDeal(dealList, d1);
			assertEquals("Check that deal arraylist size is 1", 1, dealList.size());
			assertSame("Check that deal is added", d1, dealList.get(0));
			
			C206_CaseStudy.addDeal(dealList, d2);
			assertEquals("Check that deal arraylist size is 2", 2, dealList.size());
			assertSame("Check that deal is added", d2, dealList.get(1));
			
		}
		@Test
		public void retrieveAllDealsTest() {
			assertNotNull("Test if there is valid deal arraylist to retrieve item", dealList);

	//Issue 

			String allDeal = C206_CaseStudy.retrieveAllDeals(dealList);
			String testOutput = "";
			assertEquals("Check that ViewAllDeals list", testOutput, allDeal);

			C206_CaseStudy.addDeal(dealList, d1);
			C206_CaseStudy.addDeal(dealList, d2);
			assertEquals("Test that Deal arraylist size is 2?", 2, dealList.size());
	 	
			allDeal = C206_CaseStudy.retrieveAllDeals(dealList);

			testOutput = String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 1, "Dog", "happy@gmail.com", "sam@gmail.com", 50.00);
			testOutput += String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 2, "Cat", "kkq@gmail.com", "sammy@gmail.com", 60.00);

			assertEquals("Test that ViewAllBids list", testOutput, allDeal);
		}
		@Test
		public void doDeleteDealTest() {
			assertNotNull("Test if there is valid deal arraylist to retrieve item", dealList);

			C206_CaseStudy.addDeal(dealList,d1);
			C206_CaseStudy.addDeal(dealList,d2);
			int deleteID = 1;
			int deleteID2 = 2;
			
			C206_CaseStudy.doDeleteDeal(dealList, deleteID);
			assertEquals("Check that deal arraylist size is 1", 1, dealList.size());
			assertSame("Check that a deal is remove", d2, dealList.get(0));

			C206_CaseStudy.doDeleteDeal(dealList, deleteID2);
			assertEquals("Check that deal arraylist size is 0", 0, dealList.size());
			
			boolean delete = C206_CaseStudy.doDeleteDeal(dealList, 4);
			assertFalse("Test that non-existing deal is NOT ok to delete",delete);
			
		}
		
	@Before
	public void setUp() throws Exception {
		//prepare test data 
		item1 = new Item("DOG", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);
		item2 = new Item("CAT", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);
		b1 = new Bid(1, "Dog", "happy@gmail.com", "sam@gmail.com", 50.00);
		b2 = new Bid(2, "Cat", "kkq@gmail.com", "sammy@gmail.com", 60.00);

		a1 = new Account("Jay","Buyer","Jay@gmail.com",1234567);
		a2 = new Account("Jenny","Seller","Jenny@gmail.com",7897890);


		cate1 = new Category("PETS");
		cate2 = new Category("FRUITS");
	}

	@After
	public void tearDown() throws Exception {
		item1 = null;
		item2 = null;
		a1 = null;
		a2 = null;
		cate1 = null;
		cate2 = null;


	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
