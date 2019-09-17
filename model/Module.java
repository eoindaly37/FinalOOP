package model;

/**
 * This is the module class it has a name and a grade
 * @author dalye
 *
 */
public class Module {
	private String name;
	private String grade;
	
	/** This is for creating a module without a grade
	 * @param n name of module
	 */
	public Module(String n) {
		this.name = n;
	}
	/**
	 * This is for creating a module with a grade
	 * @param n name of module
	 * @param g grade of module
	 */
	public Module(String n, String g) {
		this.name = n;
		this.grade = g;
	}
	
	/**
	 * @return name of module
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @return grade of module
	 */
	public String getGrade() {
		return this.grade;
	}
	
	/**
	 * Sets the name of module
	 * @param n new name
	 */
	public void setName(String n) {
		this.name = n;
	}
	/**
	 * Sets the grade of module
	 * @param g new grade
	 */
	public void setGrade(String g) {
		this.grade = g;
	}
	
	@Override
	public String toString() {
		String res = "Module: " + this.name + " Grade: " + this.grade;
		return res;
	}
}
