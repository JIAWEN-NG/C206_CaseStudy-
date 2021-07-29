import java.time.LocalDate;
import java.util.Date;

/**
 * 
 */
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20012122, 28 Jul 2021 20:53:23
 */

/**
 * @author 20012122
 *
 */
public class Item {
	
	private String itemName;
	private String description; 
	private double minBid;
	private Date startDate;
	private Date endDate;
	private double increment;
	
	public Item(String itemName, String description, double minBid, Date startDate, Date endDate,
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


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getIncrement() {
		return increment;
	}


	public void setIncrement(double increment) {
		this.increment = increment;
	}
	public String toString() {
		String itemInfo = String.format("%-10s %-30s %-10f %-10s %-10s %-10f", 
				itemName, description,minBid,startDate,endDate,increment);
		
		return itemInfo;
	}

}///
