/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20011454, Aug 2, 2021 4:16:35 PM
 */

/**
 * @author 20011454
 *
 */
public class Category {
	private String name;

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		String cateName = String.format("%s", name);
		return cateName;
	}
	
	
	

}
