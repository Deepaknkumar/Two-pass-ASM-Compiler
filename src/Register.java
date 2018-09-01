/**
 * 
 */

/**
 * @author deepakkumar
 *
 */
public class Register implements RegisterInterface {

	/**
	 * 
	 */
	private int registerValue;
	
	public Register() {
		this.registerValue = 0;
	}
	
	public Register(int value) {
		this.registerValue = value;
	}

	@Override
	public void setValue(int value) {
		this.registerValue = value;
	}

	@Override
	public int getValue() {
		return this.registerValue;
	}

}
