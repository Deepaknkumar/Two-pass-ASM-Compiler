import org.junit.*;
//import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class UnitTestMemory
{
	private int[] defaultProgram = { 799, 798, 198, 499, 1008, 1108, 899, 909, 898, 0 };
	
    @Test
    public void testInitSize()
    {
        // Test correct instantiation
        Memory memBank = new Memory(20);
        assertEquals(20, memBank.size());
        memBank = new Memory(100);
        assertEquals(100, memBank.size());
    }
    
    @Test
    public void testSizeBoundaries()
    {
       // Test lower boundary
      Memory memBank = new Memory(0);
      assertEquals(0, memBank.size());
      
      // Upper boundary is bounded by Integer.MAX_VALUE and
      // will most likely exceed the maximum memory of the VM.
    }
    
    @Test
    public void testRead()
    {
        // Create a new Memory object of a random size.
        Random rnd = new Random();
        int size = rnd.nextInt(10000);
        int[] values = new int[size];
        Memory memBank = new Memory(size);
        
        // Write random values to every memory location
        for (int i=0; i<values.length; i++)
        {
            values[i] = rnd.nextInt();
            memBank.writeTo(i, values[i]);
        }
        
        
        // Read back the values from memory and ensure they are the
        // same values we originally stored.
        for (int i=0; i<values.length; i++)
        {
            assertEquals(values[i], memBank.readFrom(i));
        }
    }        
     
    
    // Ensure the default program is successfully loaded into
    // memory.
    @Test
    public void testDefaultProgram()
    {
    	Memory membank = new Memory(100);
    	membank.loadMemory();
    	
    	assertEquals(799, membank.readFrom(0));
    	assertEquals(898, membank.readFrom(8));
    }
    
    @Test
    public void testLoadMemoryFromFile() throws FileNotFoundException
    {
    	Memory mem = new Memory(100);
    	
    	if (!(new File("program.ex")).exists())
    	{
    		System.err.println("--------------------------------------------");
    		System.err.println("Please make sure the program.ex file exists");
    		System.err.println("in your project directory.");
    		System.err.println("--------------------------------------------");
    		throw new FileNotFoundException();
    	}
    	
    	mem.loadMemory("program.ex");
    	
    	for (int i=0; i<defaultProgram.length; i++)
    		assertEquals(defaultProgram[i], mem.readFrom(i));
    }
}