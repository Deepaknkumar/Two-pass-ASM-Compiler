/**
 * 
 */

/**
 * @author deepakkumar
 *
 */
public class InstructionRegister extends Register implements IRInterface {

	/**
	 * 
	 */
	public InstructionRegister() {
		super();
	}
	
	public InstructionRegister(int value) {
		super(value);
	}
	
	@Override
	public int getOperand() {
		return super.getValue()%100;
	}

	@Override
	public int getOpcode() {
		return Math.floorDiv(super.getValue(), 100);
	}

}
