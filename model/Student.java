package model;

/**
 * This is a subclass of person. the diffence is 
 * student has a date of birth and has a ModuleList
 * @author dalye
 *
 */
public class Student extends Person implements Comparable<Person>{
	private String dob;
	private ModuleList modules;
	private String sID;
	
	public Student(String f, String m, String l, String e, String p, String d) {
		super(f,m,l,e,p);
		this.dob = d;
		modules = new ModuleList();
	}
	public Student(String f, String l, String e, String p, String d) {
		super(f,l,e,p);
		this.dob = d;
		modules = new ModuleList();
	}
	
	public String getID() {
		return this.sID;
	}
	public void setID(String i) {
		this.sID = i;
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
	public String getDOB() {
		return this.dob;
	}
	public ModuleList getModules() {
		return this.modules;
	}
	
	public int addModules(String name, String grade) {
		Module module = new Module(name,grade);
		return modules.addModule(module);
	}
	public void removeModule(String name) {
		modules.remModuleByName(name);
	}
	public void changeModuleGrade(String name, String grade) {
		modules.changeGrade(name, grade);
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
	public void setDOB(String d){
		this.dob = d;
	}
	
	@Override
	public String toString() {
		String res = "ID: " + this.getID() + " Name: " + super.getName().toString() + "\n";
		res += "Email: " + super.getEmail() + " Phone: " + super.getPhone() + " DOB: " + this.dob + "\n";
		res += modules.toString();
		return res;
	}
	/**
	 * Creates mySQL statement for adding data to student table
	 * @return mySQL statement
	 */
	public String mySQL() {
		String res = "INSERT INTO student (SNo,Name,Email,Phone,Dob,ClassNo) VALUES ('";
		res += this.sID + "','" + this.getName() + "','" + this.getEmail() + "','" + this.getPhone() + "','" + this.dob + "','');";
		return res;
	}
}
