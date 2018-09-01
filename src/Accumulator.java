/**
 * 
 */

/**
 * @author deepakkumar
 *
 */
public class Accumulator extends Register implements AccInterface{

	/**
	 * 
	 */
	public Accumulator() {
		super();
	}
	
	public Accumulator(int value) {
		super(value);
	}
	
	@Override
	public void add(int value) {
		super.setValue(super.getValue() + value);
	}

	@Override
	public void subtract(int value) {
		super.setValue(super.getValue() - value);
	}

	@Override
	public void multiply(int value) {
		super.setValue(super.getValue() * value);
		//System.out.println(this.getValue());
	}

	@Override
	public void divide(int value) {
		super.setValue(super.getValue() / value);
	}

}
