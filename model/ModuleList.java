package model;

import java.util.ArrayList;

/**
 * This is the class for an arraylist of modules that a student will have
 * @author dalye
 *
 */
public class ModuleList {
	private ArrayList<Module> modules;
	
	/**
	 * Creates the arraylist modules
	 */
	public ModuleList() {
		modules = new ArrayList<Module>();
	}
	
	/**
	 * @return list of modules
	 */
	public ArrayList<Module> getList(){
		return modules;
	}
	
	/**This is the method for adding and removing modules
	 * if the list is full it returns 0
	 * if it is not a duplicate it adds the module and returns 1
	 * if it is a duplicate it edits the module and changes the grade
	 * @param m module object
	 * @return int representing add, edit or full
	 */
	public int addModule(Module m) {
		int res = -1;
		if(modules.size()<6	) {
			int dupl = -1;
			for(int i=0; i<modules.size(); i++) {
				if(modules.get(i).getName().equals(m.getName())){
					dupl = i;
				}
			}
			if(dupl==-1) {
				modules.add(m);
				res = 1;
			}
			else {
				modules.get(dupl).setGrade(m.getGrade());
				res = 2;
			}
		}
		else {
			System.out.println("Already 6 modules");
			res = 0;
		}
		return res;
	}
	/**This is a module for changing grade with a string and a grade
	 * rather than a module object
	 * @param n name of module
	 * @param g new grade
	 */
	public void changeGrade(String n, String g) {
		for(int i=0; i<modules.size(); i++) {
			if(modules.get(i).getName().equals(n)) {
				modules.get(i).setGrade(g);
			}
		}
	}
	
	/**
	 * Removes module from list by name
	 * @param n name of module
	 */
	public void remModuleByName(String n) {
		for(int i=0; i<modules.size(); i++) {
			if(modules.get(i).getName().equals(n)) {
				modules.remove(i);
			}
		}
	}
	
	@Override
	public String toString() {
		String res = "";
		for(int i=0; i<modules.size(); i++) {
			res += modules.get(i).toString() + "\n";
		}
		return res;
	}
}
