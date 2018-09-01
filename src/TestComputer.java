/**
 * 
 */

/**
 * @author deepakkumar
 *
 */
public class TestComputer {

	/**
	 * 
	 */
	public TestComputer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer c = new Computer();
		SymbolTable st = c.firstPass("src/program.asm");
		st.toString();

	}

}
