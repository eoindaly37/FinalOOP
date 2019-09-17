package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Controller;
import model.ClassGroup;
import model.School;
import model.Student;
import model.Teacher;

/**
 * The sample data adds 3 rows to the database and this tests to see if the 
 * 3 have been added
 * @author dalye
 *
 */
public class AddDataTest {

	@Test
	public void test() {
		Controller controller = new Controller();
		int output = controller.addData();
		assertEquals(3,output);
	}

}
