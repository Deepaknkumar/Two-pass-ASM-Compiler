import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author deepakkumar
 * Proposed marks if all the tests pass - +30 marks
 */
class ComputerMethodsTest {

	
	Computer c;
	private static final String[] Keywords = {"STOP","LD", "STR", "ADD", "SUB", "MUL", "DIV", "IN", "OUT", "B", "BGTR", "BZ"};
	/*
	 * Instantiates a computer object before running each Test
	 */
	@BeforeEach
	void initComputerObject() {
		c = new Computer();
	}
	
	
	/**
	 * Test method for {@link Computer#toOpcode(java.lang.String)}.
	 * Tests whether the method returns the correct opCode for each Keyword
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testToOpcode() {
		for(int i=0;i<Keywords.length;i++) {
			assertEquals(i,c.toOpcode(Keywords[i]));
		}
	}

	
	/**
	 * Test method for {@link Computer#isComment(java.lang.String)}.
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testIsComment() {
		assertTrue(c.isComment("REM"));
		assertTrue(c.isComment("REM ")); 			// A Trailing space at the end -- Could be strict
		assertTrue(c.isComment(""));
		for(int i=0;i<Keywords.length;i++) {
			assertFalse(c.isComment(Keywords[i]));
		}
	}

	
	/**
	 * Test method for {@link Computer#isVariable(java.lang.String, java.lang.String)}.
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testIsVariable() {
		assertTrue(c.isVariable("SomeVariable:", "DC" ));
		for(int i=0;i<Keywords.length;i++) {
			assertFalse(c.isVariable("aPossibleVariableName:",Keywords[i]));
		}
	}

	
	/**
	 * Test method for {@link Computer#isLabel(java.lang.String)}.
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testIsLabel() {
		String[] someLabelNames = {"a:","A:", "a1:", "FIRST:", "SECOND:"};
		for(int i=0;i<someLabelNames.length;i++) {
			assertTrue(c.isLabel(someLabelNames[i]));
		}
		for(int i=0;i<Keywords.length;i++) {
			assertTrue(c.isLabel(Keywords[i]+":"));
		}
		for(int i=0;i<Keywords.length;i++) {
			assertFalse(c.isLabel(Keywords[i]));
		}

	}

	
	/**
	 * Test method for {@link Computer#firstPass(java.lang.String)}.
	 * Proposed marks if the test passes - +10 marks
	 */
	@Test
	void testFirstPass() {
		String filename = "src/program.asm"; 				// Change the location if required
		String[] labels = {"ELSE","FINISH","FIRST","SECOND"};
		int[] labelLocations = {8,9,99,98};
		
		SymbolTable st = c.firstPass(filename);
		System.out.println("\nSymbol Table for first pass....");
		System.out.println(st); 							// Would print if toString() method is defined
		
		labels = getProperLabelNames(st, labels); 			// Students might store labels with colons
		for(int i=0; i<labels.length;i++) {
			assertEquals(labelLocations[i],st.getLabelLocation(labels[i]));
		}
		
	}
	
	
	public String[] getProperLabelNames(SymbolTable st,String[] labels) {
		Boolean containsColonInLabelNames = false;
		if(st.getLabelLocation("ELSE:")==8) {
			containsColonInLabelNames = true;
		}
		
		if(containsColonInLabelNames) {
			for(int i=0; i<labels.length;i++) {
				labels[i] += ":";
			}
		}
		return labels;
	}

}
