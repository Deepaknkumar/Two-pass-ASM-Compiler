
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


/**
 * 
 */

/**
 * @author deepakkumar
 * Proposed marks if all the tests pass - +25 marks
 *
 */
class SymbolTableTest {

	/**
	 * Test method for {@link SymbolTable#SymbolTable()}.
	 */
	
	SymbolTable st = new SymbolTable();
	
	@BeforeEach
	void initSymbolTableObject() {
		st = new SymbolTable();
	}
	
	@Test
	void testSymbolTable() {
//		SymbolTable st = new SymbolTable();
		st.add("label1", 1);
		st.add("label2", 2);
		st.add("label3", 3);
//		assertEquals(st.getLabelLocation(""),-1);
	}

	/**
	 * Test method for {@link SymbolTable#add(java.lang.String, int)}.
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testAddStringInt() {
//		SymbolTable st = new SymbolTable();
		st.add("label1", 1);
		st.add("label2", 2);
		st.add("label3", 3);
		assertEquals(st.getLabelLocation("label1"),1);
		assertEquals(st.getLabelLocation("label2"),2);
		assertEquals(st.getLabelLocation("label3"),3);
	}

	/**
	 * Test method for {@link SymbolTable#add(java.lang.String, int, int)}.
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testAddStringIntInt() {
//		SymbolTable st = new SymbolTable();
		st.add("label1", 1, 2);
		st.add("label2", 2, 3);
		st.add("label3", 3, 4);
		assertEquals(st.getLabelLocation("label1"),1);
		assertEquals(st.getLabelLocation("label2"),2);
		assertEquals(st.getLabelLocation("label3"),3);
//		assertEquals(st.getLabelLocation("Invalid location"),-1); 		// Doesn't have to be -1 -- Uncomment if you want to check for an invalid location
	}

	/**
	 * Test method for {@link SymbolTable#getLabelLocation(java.lang.String)}.
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testGetLabelLocation() {
//		SymbolTable st = new SymbolTable();
		st.add("l1", 1);
		st.add("l2", 2);
		st.add("l3", 3);
		assertEquals(st.getLabelLocation("l1"),1);
		assertEquals(st.getLabelLocation("l2"),2);
		assertEquals(st.getLabelLocation("l3"),3);
	}

	/**
	 * Test method for {@link SymbolTable#getLabelValueByLocation(int)}.
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testGetLabelValueByLocation() {
//		SymbolTable st = new SymbolTable();
		st.add("l1", 1, 2);
		st.add("l2", 2, 3);
		st.add("l3", 3, 4);
		assertEquals(st.getLabelValueByLocation(1),2);
		assertEquals(st.getLabelValueByLocation(2),3);
		assertEquals(st.getLabelValueByLocation(3),4);
//		assertEquals(st.getLabelValueByLocation(10),-1); 			// Doesn't have to be -1 -- Uncomment if you want to check for an invalid location
//		System.out.println(st);
	}

	/**
	 * Test method for {@link SymbolTable#size()}.
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testSize() {
//		SymbolTable st = new SymbolTable();
		st.add("l1", 1);
		st.add("l2", 2);
		st.add("l3", 3);
		assertEquals(3,st.size());
//		System.out.println(st);
	}

	@Test
	void testToString() {
		st.add("label1", 1, 2);
		st.add("label2", 2, 3);
		st.add("label3", 3, 4);
		System.out.println(st); 				// Automatically calls toString() 
	}
}
