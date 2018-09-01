/**
 * Interface for data structures holding symbols.
 * 
 */
public interface SymbolCollection
{
	/**
	 * Adds a symbol to the collection. Since no value is given, the value
	 * should be null.
	 * @param label The label name.
	 * @param location The location as given by the instruction/data counter. 
	 */
	void add(String label, int location);
	
	/**
	 * Adds a symbol to the collection.
	 * @param label The label name.
	 * @param location The location as given by the instruction/data counter.
	 * @param value The value of the label.
	 */
	void add(String label, int location, int value);
	
	/**
	 * Retrieves the location for a given label name.
	 * @param label The name of the label.
	 * @return The memory location for the label.
	 */
	int getLabelLocation(String label);
	
	/**
	 * Retrieves the value of a variable.
	 * @param location The memory location of the label.
	 * @return The value of the label. If the value is null, -1 is returned.
	 */
	int getLabelValueByLocation(int location);
	
	/**
	 * Retrieves the number of symbols stored in the collection. 
	 * @return The number of symbol nodes in the collection.
	 */
	int size();
}