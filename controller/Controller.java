package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import model.ClassGroup;
import model.School;
import model.Teacher;
import model.Student;

/**
 * This is the controller for the School GUI
 * @author dalye
 *
 */
public class Controller {
	private School school;
	
	/**
	 * In the constructor I created a sample of entries for production and tests
	 */
	public Controller() {
		school = new School();
		ClassGroup classg = new ClassGroup("1-3");
		Student eoin = new Student("Eoin", "Francis", "Daly", "e@gmail.com", "1234", "23-02-99");
		eoin.addModules("Maths", "69");
		Teacher pat = new Teacher("Pat", "Lucid", "p@hotmail.com", "5678", "Woodworking");
		classg.addStudent(eoin);
		school.addClassGroup(classg);
		school.addStudent(eoin);
		school.addTeacher(pat);
	}
	
	/**
	 * Creates a class object with the name as the parameter
	 * @param s The name of the class
	 */
	public void addClass(String s) {
		ClassGroup newclass= new ClassGroup(s);
		school.addClassGroup(newclass);
		System.out.println("Added class: " + newclass.getName());
	}
	/**
	 * Calls school to remove class by name
	 * @param n name of class
	 */
	public void removeClass(String n) {
		school.remClassByName(n);
	}
	
	/**
	 * Creates a teacher object and calls to add it to school 
	 * @param f firstname
	 * @param m middlename
	 * @param l lastname
	 * @param e email
	 * @param p phone
	 * @param d degree
	 */
	public void addTeacher(String f, String m, String l, String e, String p, String d) {
		Teacher teacher = new Teacher(f,m,l,e,p,d);
		school.addTeacher(teacher);
		System.out.println("Added Teacher: " + teacher.toString());
	}
	/**
	 * Creates a teacher object with no middlename and calls to add it to school
	 * @param f firstname
	 * @param l lastname
	 * @param e email
	 * @param p phone
	 * @param d degree
	 */
	public void addTeacher(String f, String l, String e, String p, String d) {
		Teacher teacher = new Teacher(f,l,e,p,d);
		school.addTeacher(teacher);
		System.out.println("Added Teacher: " + teacher.toString());
	}
	
	/** Creates a student object and adds to school. it also adds to class specified
	 * @param f firstname
	 * @param m middlename
	 * @param l lastname
	 * @param e email
	 * @param p phone
	 * @param d date of birth
	 * @param c name of class to be added to
	 */
	public void addStudent(String f, String m, String l, String e, String p, String d,String c) {
		Student student = new Student(f,m,l,e,p,d);
		school.addStudent(student);
		school.getClassGroup(c).addStudent(student);
		System.out.println("Added student: " + student.toString());
	}
	/** Creates a student object with no middlename and adds to school. it also adds to class specified
	 * @param f firstname
	 * @param l lastname
	 * @param e email
	 * @param p phone
	 * @param d date of birth
	 * @param c name of class to be added to
	 */
	public void addStudent(String f, String l, String e, String p, String d,String c) {
		Student student = new Student(f,l,e,p,d);
		school.addStudent(student);
		school.getClassGroup(c).addStudent(student);
		System.out.println("Added student: " + student.toString());
	}
	
	/**
	 * This calls the get student by id function in School
	 * @param id student id
	 * @return the student with that id
	 */
	public Student findStudent(String id) {
		return school.getStudentID(id);
	}
	/**
	 * Finds a student with that id and gives the string of it
	 * @param id student id
	 * @return the string of that student
	 */
	public String getStudentString(String id) {
		return school.getStudentID(id).toString();
	}
	/**
	 * Calls the remove student method in school
	 * @param id student id
	 */
	public void removeStudent(String id) {
		school.remStudentID(id);
	}
	
	/**
	 * Calls the get teacher by id function in School
	 * @param id teacher id
	 * @return teacher object
	 */
	public Teacher findTeacher(String id) {
		return school.getTeacherID(id);
	}
	/**
	 * Gets the string of the teacher object
	 * @param id teacher id
	 * @return the toString of the teacher object
	 */
	public String getTeacherString(String id) {
		return school.getTeacherID(id).toString();
	}
	/**
	 * Calls the remove teacher function in School
	 * @param id teacher id
	 */
	public void removeTeacher(String id) {
		school.remTeacherID(id);
	}
	
	/**
	 * @param id Student id
	 * @param module Module name
	 * @param grade Grade to be added
	 * @return 3 possible return values. 0 means it was full, 1 means it added the module, 2 means it edited a module
	 */
	public int changeModule(String id, String module, String grade) {
		return school.getStudentID(id).addModules(module, grade);
	}
	/**
	 * Removes the module of a student
	 * @param id student id
	 * @param module module name
	 */
	public void remModule(String id,String module) {
		school.getStudentID(id).removeModule(module);
	}
	
	/**
	 * Changes the degree of a teacher
	 * @param id teacher id
	 * @param degree teacher degree
	 */
	public void changeDegree(String id, String degree) {
		school.getTeacherID(id).setDegree(degree);
	}
	
	/**
	 * This calls the sort students and sort teachers methods in school and calls the
	 * schools to string function
	 * @return the school as a string
	 */
	public String list() {
		school.sortStudents();
		school.sortTeachers();
		
		String res = school.toString();
		
		
		return res;
	}
	/**
	 * Gets a mySQL statement for students
	 * @param delete true or false whether the table is being cleared or added to
	 * @return the mysql query
	 */
	public String mySQLStudent(boolean delete) {
		if(delete==false){
			return school.mySQLStudents();
		}
		else {
			return "delete from student";
		}
	}
	/**
	 * Gets a mySQL statement for teachers
	 * @param delete true or false whether the table is being cleared or added to
	 * @return the mysql query
	 */
	public String mySQLTeacher(boolean delete) {
		if(delete==false) {
			return school.mySQLTeachers();
		}
		else {
			return "delete from teacher";
		}
	}
	/**
	 * Gets a mySQL statement for adding classes
	 * @param delete true or false whether the table is being cleared or added to
	 * @return the mysql query
	 */
	public String mySQLClasses(boolean delete) {
		if(delete==false) {
			return school.mySQLNewClasses();
		}
		else {
			return "delete from class";
		}
	}
	/** 
	 * This gets the mysql string for updating student tables with classes
	 * @return the mysql query
	 */
	public String mySQLUpdates() {
		return school.mySQLUpdateClasses();
	}
	
	/**
	 * Creates a connection with databases and adds appropriate data to tables
	 * @return number of rows affected
	 */
	public int addData() {
        int rows_affected = 0;
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        boolean clear = false;
	        //Here is where we create the new connection using the username and I did not set a password
	        String url = "jdbc:mysql://127.0.0.1:3306/oopschool?useTimezone=true&serverTimezone=UTC";
	        String user = "root";
	        String password = "";
	        Connection connection = DriverManager.getConnection(url,user,password);
	        System.out.println ("Database connection created");
	        Statement statem = connection.createStatement ();
	        rows_affected += statem.executeUpdate(this.mySQLTeacher(clear));
	        rows_affected += statem.executeUpdate(this.mySQLClasses(clear));
	        rows_affected += statem.executeUpdate(this.mySQLStudent(clear));
	        statem.executeUpdate(this.mySQLUpdates());
	        System.out.println("School succesfully loaded: " + rows_affected + " rows added");
	        
		}catch (Exception exc) {
            System.out.println("SQLException: " + exc.getMessage());
            
        };
        return rows_affected;
	}
	/**
	 * Creates a connection with database and clears rows from all tables
	 * @return number of rows affected
	 */
	public int clearData() {
        int rows_affected = 0;
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        boolean clear = true;
	        //Here is where we create the new connection using the username and I did not set a password
	        String url = "jdbc:mysql://127.0.0.1:3306/oopschool?useTimezone=true&serverTimezone=UTC";
	        String user = "root";
	        String password = "";
	        Connection connection = DriverManager.getConnection(url,user,password);
	        System.out.println ("Database connection created");
	        Statement statem = connection.createStatement ();
	        rows_affected += statem.executeUpdate(this.mySQLTeacher(clear));
	        rows_affected += statem.executeUpdate(this.mySQLClasses(clear));
	        rows_affected += statem.executeUpdate(this.mySQLStudent(clear));
	        System.out.println(rows_affected + " rows deleted from database");
	        
		}catch (Exception exc) {
            System.out.println("SQLException: " + exc.getMessage());
            
        };
        return rows_affected;
	}
}
