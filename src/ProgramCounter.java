/**
 * 
 */

/**
 * @author deepakkumar
 *
 */
public class ProgramCounter extends Register implements PCInterface {

	/**
	 * 
	 */
	public ProgramCounter() {
		// TODO Auto-generated constructor stub
		super();
	}

	public ProgramCounter(int value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	@Override
	public void increment() {
		// TODO Auto-generated method stub
		super.setValue(super.getValue()+1);
	}

}
