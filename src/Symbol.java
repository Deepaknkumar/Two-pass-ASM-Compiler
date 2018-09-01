/**
 * 
 */

/**
 * @author deepakkumar
 *
 */
public class Symbol {

	private String label;
	private int location;
	private Integer value;
	private Symbol next;
	
	/**
	 * 
	 */
	public Symbol() {
		//this.next = new Symbol();
		this.next = null;
		this.value = null;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public int getLocation() {
		return this.location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public Symbol getNext() {
		return this.next;
	}
	
	public void setNext(Symbol next) {
		this.next = new Symbol();
		this.next = next;
	}

}
