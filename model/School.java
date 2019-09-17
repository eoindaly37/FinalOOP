package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This is the school object. it has arraylist of teachers, students and classgroups
 * the sidcounter and tidcounter are for generating student and teacher ids
 * @author dalye
 *
 */
public class School {
	private ArrayList<ClassGroup> classes;
	private ArrayList<Teacher> teachers;
	private ArrayList<Student> students;
	private int sidcounter;
	private int tidcounter;
	
	public School() {
		classes = new ArrayList<ClassGroup>();
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
		this.sidcounter = 0;
		this.tidcounter = 0;
	}
	
	/**
	 * @return arraylist of classgroups
	 */
	public ArrayList<ClassGroup> getClasses(){
		return this.classes;
	}
	/**
	 * @return arraylist of teachers
	 */
	public ArrayList<Teacher> getTeachers(){
		return this.teachers;
	}
	/**
	 * @return arraylist of students
	 */
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	
	/**
	 * Adds a student to arraylist and gives them a student id
	 * @param s Student object
	 */
	public void addStudent(Student s) {
		students.add(s);
		sidcounter++;
		String id = "S" + sidcounter;
		s.setID(id);
	}
	/**
	 * Checks students for student with matching id
	 * @param id student id
	 * @return student object
	 */
	public Student getStudentID(String id) {
		Student res = null;
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getID().equals(id)) {
				res = students.get(i);
			}
		}
		return res;
	}
	/**
	 * removes student from students with matching id
	 * @param id student id
	 */
	public void remStudentID(String id) {
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getID().equals(id)) {
				students.remove(i);
			}
		}
		for(int i=0; i<classes.size(); i++) {
			classes.get(i).remStudentID(id);
		}
	}
	
	/**
	 * adds a teacher object to teachers and gives it a generated teacher id
	 * @param t teacher object
	 */
	public void addTeacher(Teacher t) {
		teachers.add(t);
		tidcounter++;
		String id = "T" + tidcounter;
		t.setID(id);
	}
	/**
	 * finds teacher in teachers with matching id
	 * @param id teacher id
	 * @return teacher object
	 */
	public Teacher getTeacherID(String id) {
		Teacher res = null;
		for(int i=0; i<teachers.size(); i++) {
			if(teachers.get(i).getID().equals(id)) {
				res = teachers.get(i);
			}
		}
		return res;
	}
	/**
	 * removes teacher from teachers with matching id
	 * @param id teacher id
	 */
	public void remTeacherID(String id) {
		for(int i=0; i<teachers.size(); i++) {
			if(teachers.get(i).getID().equals(id)) {
				teachers.remove(i);
			}
		}
		
	}
	
	/**
	 * adds a classgroup to classes
	 * @param c classgroup object
	 */
	public void addClassGroup(ClassGroup c) {
		classes.add(c);
	}
	/**
	 * finds a classgroup with matching name and returns it
	 * @param n name of class
	 * @return classgroup object
	 */
	public ClassGroup getClassGroup(String n) {
		ClassGroup res = null;
		for(int i=0; i<classes.size(); i++) {
			if(classes.get(i).getName().toString().equals(n.toString())){
				res = classes.get(i);
			}
		}
		return res;
	}
	
	/**
	 * finds a classgroup with matching name and removes it
	 * @param n classgroup name
	 */
	public void remClassByName(String n) {
		for(int i=0; i<classes.size(); i++) {
			if(classes.get(i).getName().toString().equals(n.toString())){
				classes.remove(i);
			}
		}
	}
	
	/**
	 * Uses comparable to sort students by name
	 */
	public void sortStudents() {
		Collections.sort(students);
	}
	/**
	 * Uses comparable to sort teachers by name
	 */
	public void sortTeachers() {
		Collections.sort(teachers);
	}
	
	@Override
	public String toString() {
		String res = "STUDENTS:\n";
		for(int i=0; i<students.size(); i++) {
			res += students.get(i).toString();
		}
		res += "\nTEACHERS:\n";
		for(int i=0; i<teachers.size(); i++) {
			res += teachers.get(i).toString();
		}
		res += "\nCLASSES:\n";
		for(int i=0; i<classes.size(); i++) {
			res +=classes.get(i).toString();
		}
		return res;
	}
	
	
	
	
	/**Gets mysql statements for all students
	 * @return concatenates mysql statements
	 */
	public String mySQLStudents() {
		String res = "";
		for(int i=0; i<students.size(); i++) {
			res += students.get(i).mySQL();
		}
		return res;
	}
	/**concatenates mysql statements for teachers
	 * @return new mysql statement
	 */
	public String mySQLTeachers() {
		String res = "";
		for(int i=0; i<teachers.size(); i++) {
			res += teachers.get(i).mySQL();
		}
		return res;
	}
	/** concatenates mysql statements for new classes
	 * @return new mysql statement
	 */
	public String mySQLNewClasses() {
		String res = "";
		for(int i=0; i<classes.size(); i++) {
			res += classes.get(i).mySQL();
		}
		return res;
	}
	/**
	 * Concatenates mysql statement for updating student tables with classNo
	 * @return new mysql update statement
	 */
	public String mySQLUpdateClasses() {
		String res = "";
		for(int i=0; i<classes.size(); i++) {
			res += classes.get(i).updateSQL();
		}
		return res;
	}
}
