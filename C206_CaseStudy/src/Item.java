 import java.time.LocalDate;
import java.util.Date;


/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20011472, 4 Aug 2021 9:50:08 am
 */

public class Item {
	
	private String itemName;
	private String description; 
	private double minBid;
	private LocalDate startDate;
	private LocalDate endDate;
	private double increment;
	
	public Item(String itemName, String description, double minBid, LocalDate startDate, LocalDate endDate,
			double increment) {
		this.itemName = itemName;
		this.description = description;
		this.minBid = minBid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.increment = increment;
	}

	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMinBid() {
		return minBid;
	}

	public void setMinBid(double minBid) {
		this.minBid = minBid;
	}


	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getIncrement() {
		return increment;
	}


	public void setIncrement(double increment) {
		this.increment = increment;
	}
	public String toString() {
		String itemInfo = String.format("%-10s %-20s %-10.2f %-15s %-15s %-10.2f", 
				itemName, description, minBid, startDate, endDate, increment);
		
		return itemInfo;
	}

}
