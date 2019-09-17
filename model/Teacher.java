package model;

/**
 * This subclass of person creates a Teacher object.
 * The difference is teacher has a degree
 * @author dalye
 *
 */
public class Teacher extends Person implements Comparable<Person>{
	private String degree;
	private String tID;
	
	public Teacher(String f, String m, String l, String e, String p, String d) {
		super(f,m,l,e,p);
		this.degree = d;
	}
	public Teacher(String f, String l, String e, String p, String d) {
		super(f,l,e,p);
		this.degree = d;
	}
	
	public String getID() {
		return this.tID;
	}
	public void setID(String i) {
		this.tID = i;
	}
	
	public Name getName() {
		return super.getName();
	}
	public String getEmail() {
		return super.getEmail();
	}
	public String getPhone() {
		return super.getPhone();
	}
	public String getDegree() {
		return this.degree;
	}
	
	public void setName(String f, String m, String l) {
		super.setName(f, m, l);
	}
	public void setName(String f, String l) {
		super.setName(f, l);
	}
	public void setEmail(String e) {
		super.setEmail(e);
	}
	public void setPhone(String p) {
		super.setPhone(p);
	}
	public void setDegree(String d) {
		this.degree = d;
	}
	
	@Override
	public String toString() {
		String res = "ID: " + this.getID() + " Name: " + super.getName().toString() + "\n";
		res += "Email: " + super.getEmail() + " Phone: " + super.getPhone() + " Degree: " + this.degree + "\n";
		return res;
	}
	
	/**Creates the mySQL statement for adding data to teacher table
	 * @return mysql statement
	 */
	public String mySQL() {
		String res = "INSERT INTO teacher (TNo,Name,Email,Phone,Degree) VALUES ('";
		res += this.tID + "','" + this.getName() + "','" + this.getEmail() + "','" + this.getPhone() + "','" + this.getDegree() + "');";
		return res;
	}
}

