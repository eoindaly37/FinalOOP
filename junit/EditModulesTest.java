package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Controller;

/**
 * This tests to see if the module has been edited rather than added
 * if the module has been simply added, it returns 1
 * if the module is already there and is duplicated, it returns 2
 * @author dalye
 *	
 */
public class EditModulesTest {

	@Test
	public void test() {
		int res = -1;
		Controller controller = new Controller();
		res = controller.changeModule("S1", "Maths", "80");
		//res = controller.changeModule("S1", "Physics", "80");
		System.out.println(controller.list());
		assertEquals(2,res);
	}

}
