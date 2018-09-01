/**
 * Interface for computer and compiler operations.
 * 
 * @version 1.1
 */
public interface Computable
{
	/**
	 * Stop.
	 * Stops the program.
	 */
	final static int STOP = 0;
	
	/**
	 * Load.
	 * Copy the value contained at the address given by the operand and put in the Accumulator register.
	 */
	final static int LD = 1;
	
	
	/**
	 * Store.
	 * Copy the value in the Accumulator register into the location in memory corresponding to the address given by the operand.
	 */
	final static int STR = 2;
	
	
	/**
	 * Add.
	 * Accumulator register receives current value ADDED TO the value in memory located at the current operand.
	 */
	final static int ADD = 3;
	
	/**
	 * Subtract.
	 * Accumulator register receives current value SUBTRACTED BY the value in memory located at the current operand.
	 */
	final static int SUB = 4;
	
	/**
	 * Multiply.
	 * Accumulator register receives current value MULTIPLIED BY the value in memory located at the current operand.
	 */
	final static int MUL = 5;
	
	/**
	 * Divide.
	 * Accumulator register receives current value DIVIDED BY the value in memory located at the current operand.
	 */
	final static int DIV = 6;
	
	/**
	 * Input.
	 * Display on screen a question mark. Wait for a number (from keyboard) and store this number in memory at the location given by the operand.
	 */
	final static int IN  = 7;
	
	/**
	 * Output.
	 * Display on screen "OUTPUT = <code>number</code>" where <code>number</code> is the value contained in memory at the location given by the operand.
	 */
	final static int OUT = 8;
	
	/**
	 * Unconditional branch.
	 * Program counter receives the value given by the operand.
	 */
	final static int B   = 9;
	
	/**
	 * Branch greater than zero.
	 * If Accumulator register value is greater than 0, then the Program Counter register receives the value give by the operand.
	 */
	final static int BGTR = 10;
	
	/**
	 * Branch equal to zero.
	 * If Accumulator register value is zero, then the Program Counter register receives the value given by the operand.
	 */
	final static int BZ = 11;
	
	/**
	 * Begins computer simulation of fetch, decode, execute, step.
	 * 1) Loads the default program into memory.<br />
	 * 2) Initializes the program counter to zero.<br />
	 * 3) As long as the program is not finished, fetch the next instruction, increment the program counter, and perform the action of the fetched instruction.
	 */
	void run();
	
	/**
	 * Begins computer simulation of fetch, decode, execute, step.
	 * @see Computable#run run
	 * @param filename
	 */
	void run(String filename);
	
	// TODO add to lab 7
	/**
	 * Converts an ASM command to its corresponding integer operation code.
	 * @param An ASM command (e.g. LD, ADD, SUB, etc.).
	 * @return The operation code of the ASM command.
	 */
	int toOpcode(String command);
	
	/**
	 * Determines if the parameter is a comment or blank line.
	 * @param word The first word from a line in the ASM file. 
	 * @return True if the word starts with "REM" or is blank.
	 */
	boolean isComment(String firstWord);
	
	/**
	 * Determines if the parameter is a variable.
	 * @param first The first word from a line in the ASM file.
	 * @param second The second word from a line in the ASM file. 
	 * @return True if the first word is a variable name (i.e. the second word is "DC").
	 */
	boolean isVariable(String first, String second);
	
	/**
	 * Determines if the parameter is a label.
	 * @param word The first word from a line in the ASM file.
	 * @return True if the word is a label.
	 */
	boolean isLabel(String word);
	
	/**
	 * Builds the symbol table of labels and variables from an ASM file.
	 * @param filename The name of the ASM file.
	 * @return A symbol table of labels and variables.
	 */
	SymbolTable firstPass(String filename);
	
	/**
	 * Parses the supplied symbol table and ASM file to build the executable
	 * binary file. An executable file will be created with the same name as
	 * the ASM file, but with an extension of ".ex".
	 * @param symTable A symbol table populated with labels and/or variables.
	 * @param filename The name of the ASM file.
	 */
	void secondPass(SymbolTable symTable, String filename);
	
	/**
	 * Wrapper method to control the <code>firstPass</code> and
	 * <code>secondPass</code> methods. This method should call the
	 * <code>firstPass</code> method, retrieve the symbol table, pass the
	 * symbol table into the <code>secondPass</code> method which will create
	 * the executable program file.
	 * @param filename The name of the ASM file.
	 */
	void compile(String filename);

	void cycle();

	void fetch();

	void increment();

	boolean execute();
}
