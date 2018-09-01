/**
 * Updated interface to help define the methods
 * for the memory class
 * COSC 121 Summer 2018
 */
public interface MemoryInterface {

	public void writeTo(int location, int value);
	
	public int readFrom(int location);
	
	public void loadMemory();
	
	/**
	 * This method will take what you have learned about reading from files.
	 * This method should read each int from the file, and store it in your Memory
	 * array instance data.
	 * @param filename - the name of the file you are going to run
	 */
	public void loadMemory(String filename);
	
	public int size();
	
}
