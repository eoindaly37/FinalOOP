package model;

/**
 * This class person is the super class for teacher and student
 * @author dalye
 *
 */
public class Person implements Comparable<Person>{
	private Name name;
	private String email;
	private String phone;
	
	/**
	 * Instantiates a person with a middlename and creates such name object
	 * @param f firstname
	 * @param m middlename
	 * @param l lastname
	 * @param e email
	 * @param p phone
	 */
	public Person(String f, String m, String l, String e, String p) {
		this.name = new Name(f,m,l);
		this.email = e;
		this.phone = p;
	}
	/**
	 * Instantiates a person without a middlename and creates such name object
	 * @param f firstname
	 * @param l lastname 
	 * @param e email
	 * @param p phone
	 */
	public Person(String f, String l, String e, String p) {
		this.name = new Name(f,l);
		this.email = e;
		this.phone = p;
	}
	
	
	/**
	 * @return name object
	 */
	public Name getName() {
		return this.name;
	}
	/**
	 * @return email address
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * @return phone number
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Takes in strings to set name of person
	 * @param f fisrtname
	 * @param m middlename
	 * @param l lastname
	 */
	public void setName(String f, String m, String l) {
		this.name.setFirst(f);
		this.name.setMiddle(m);
		this.name.setLast(l);
	}
	/**
	 * Takes in strings to set name of a person
	 * @param f fistname
	 * @param l lastname
	 */
	public void setName(String f, String l) {
		this.name.setFirst(f);
		this.name.setLast(l);
	}
	/**
	 * Sets email of a person
	 * @param e email
	 */
	public void setEmail(String e) {
		this.email = e;
	}
	/** Sets phone number of a person
	 * @param p phone number
	 */
	public void setPhone(String p) {
		this.phone = p;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Person p) {
		int lastCmp = name.getLast().compareTo(p.getName().getLast());
		if(lastCmp != 0) {
			return lastCmp;
		}
		else {
			return name.getFirst().compareTo(p.getName().getFirst());
		}
	}
	
	
}
