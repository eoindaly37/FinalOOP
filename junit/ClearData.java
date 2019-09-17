package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Controller;

/**
 * This is to be run after the add data test.
 * it clears all rows that have been added and checks to see
 * that it is 3 rows
 * @author dalye
 *
 */
public class ClearData {

	@Test
	public void test() {
		Controller controller = new Controller();
		int output = controller.clearData();
		assertEquals(3,output);
	}

}
