import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;

/**
 * @author deepakkumar
 * Proposed marks if all the tests pass - +45 marks
 *
 */

class ComputerTest {

	Computer c = new Computer();
	String filename;
	String exfilename;

	@BeforeEach
	void initComputer() {
		c = new Computer();
	}

	@Test
	void testComputer() {
		System.out.println("\n\nTesting Default Program in Memory(Maximum of two numbers)...");
		c.run();
	}
	
	/*
	 * Proposed marks if the test passes - +15 marks
	 */
	@Test
	void testComputerProgram() {
		System.out.println("\n\n Testing the program.asm code(Maximum of two numbers)");
		filename = "src/program.asm";
		exfilename = "src/program.ex";
		c.compile(filename);
		c.run(exfilename);
	}

	/*
	 * Proposed marks if the test passes - +10 marks
	 */
	@Test
	void testComputerProgramASMD() {
		System.out.println("\n\nTesting Addition, Subtraction, Multiplcation and Division of two input numbers...");
		filename = "src/programASMD.asm";
		exfilename = "src/programASMD.ex";
		c.compile(filename);
		c.run(exfilename);
	}
	
	/*
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testComputerProgramSMF() {
		System.out.println("\n\nTesting Addition and  Multiplcation of four input numbers...");
		filename = "src/programSMF.asm";
		exfilename = "src/programSMF.ex";
		c.compile(filename);
		c.run(exfilename);
	}
	
	/*
	 * Proposed marks if the test passes - +5 marks
	 */
	@Test
	void testComputerProgramBlankLineInTheMiddle() {
		System.out.println("\n\nTesting Addition of two input numbers(Code containing blank lines)...");
		filename = "src/programBlankLineInTheMiddle.asm";
		exfilename = "src/programBlankLineInTheMiddle.ex";
		c.compile(filename);
		c.run(exfilename);
	}
	
	/*
	 * Proposed marks if the test passes - +10 marks
	 */
	@Test
	void testComputerProgramMMSMF() {
		System.out.println("\n\nTesting Maximum and Minimum for three input numbers...");
		filename = "src/programMMSMF.asm";
		exfilename = "src/programMMSMF.ex";
		c.compile(filename);
		c.run(exfilename);
	}

}
