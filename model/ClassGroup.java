package model;

import java.util.ArrayList;

/**
 * This class represents a class group with a name and students
 * @author dalye
 *
 */
public class ClassGroup {
	private ArrayList<Student> classgroup;
	private String name;
	
	/**
	 * Creates arraylist of students and gives the class a name
	 * @param n name for class
	 */
	public ClassGroup(String n) {
		classgroup = new ArrayList<Student>();
		this.name = n;
	}
	
	/**
	 * @return list of students
	 */
	public ArrayList<Student> getClassGroup() {
		return this.classgroup;
	}
	
	/**
	 * @return name of classgroup
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Sets name of class
	 * @param n new name
	 */
	public void setName(String n) {
		this.name = n;
	}
	
	/**
	 * Adds student to arraylist
	 * @param s student object
	 */
	public void addStudent(Student s) {
		classgroup.add(s);
	}
	
	/**
	 * Iterates through arraylist to find student and remove by id
	 * @param id student id
	 */
	public void remStudentID(String id) {
		for(int i=0; i<classgroup.size(); i++) {
			if(classgroup.get(i).getID().equals(id)){
				classgroup.remove(i);
			}
		}
	}
	
	@Override
	public String toString() {
		String res = "Name: " + this.name;
		for(int i=0; i<classgroup.size(); i++) {
			res += "\n\t" + classgroup.get(i).getName().toString();
		}

		return res;
	}
	/**Creates String for adding values to Class table
	 * @return mysql query
	 */
	public String mySQL() {
		String res = "INSERT INTO Class (ClassNo) VALUES ('";
		res += this.getName() + "');";
		return res;
	}
	/**
	 * Creates a sting for updating student tables and adding
	 * classNo when a student is in that class
	 * @return mysql query
	 */
	public String updateSQL() {
		String res = "";
		if(this.classgroup.size()>0) {
			for(int i=0; i<classgroup.size(); i++) {
				res += "UPDATE student SET ClassNo = '";
				res += this.getName() + "' WHERE SNo = '" + 
						classgroup.get(i).getID() + "';";
			}
		}		
		return res;
	}
}
