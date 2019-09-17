package model;

/**
 * This is the name class
 * there are 2 different types of names. with or without a middle name
 * @author dalye
 *
 */
public class Name {
	private String firstName;
	private String middleName;
	private String lastName;
	
	/**
	 * Constructor with a middlename
	 * @param f firstname
	 * @param m middlename
	 * @param l lastname
	 */
	public Name(String f, String m, String l) {
		this.firstName = f;
		this.middleName = m;
		this.lastName = l;
	}
	/**
	 * Constructor without a middlename
	 * @param f firstname
	 * @param l lastname
	 */
	public Name(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}
	
	/**
	 * @return firstname
	 */
	public String getFirst() {
		return this.firstName;
	}
	/**
	 * @return middlename
	 */
	public String getMiddle() {
		return this.middleName;
	}
	/**
	 * @return lastname
	 */
	public String getLast() {
		return this.lastName;
	}
	
	/**
	 * Set firstname
	 * @param f new firstname
	 */
	public void setFirst(String f) {
		this.firstName = f;
	}
	/**
	 * Set middlename
	 * @param m new middlename
	 */
	public void setMiddle(String m) {
		this.middleName	= m;
	}
	/**
	 * Set lastname
	 * @param l new lastname
	 */
	public void setLast(String l) {
		this.lastName = l;
	}
	
	@Override
	public String toString() {
		String res = this.firstName + " " + this.middleName + " " + this.lastName;
		if(this.middleName==null) {
			res = this.firstName + " " + this.lastName;
		}
		return res;
	}
}
