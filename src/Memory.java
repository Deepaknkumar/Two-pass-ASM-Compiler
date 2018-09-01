import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 
 */


/**
 * @author deepakkumar
 *
 */
public class Memory implements MemoryInterface {

	/**
	 * 
	 */
	private int[] memoryBank;
	private int memorySize;
	
	public Memory(int size) {
		this.memorySize = size;
		this.memoryBank = new int[size];
	}

	@Override
	public void writeTo(int location, int value) {
		if (location >= 0 || location < memorySize) {
			memoryBank[location] = value;
		} else {
		System.out.println("location out of range.");
		}
	}

	@Override
	public int readFrom(int location) {
		if(location >= 0 || location < memorySize) {
			return memoryBank[location];
		}else {
			System.out.println("location out of range.");
			return 0;
		}
	}

	@Override
	public void loadMemory() {
		int[] tmpvals = {799,798,198,499,1008,1108,899,909,898,0};
		for(int i=0; i < memorySize; i++) {
			if (i < 10) {
				memoryBank[i] = tmpvals[i];
			}else {
				memoryBank[i] = 0;
			}
		}
	}

	@Override
	public int size() {
		return this.memorySize;
	}

	@Override
	public void loadMemory(String filename) {
		int mi = 0;
		FileInputStream inFile = null;
		DataInputStream dataIn = null;
		try {
			inFile = new FileInputStream(filename);
			dataIn = new DataInputStream(inFile);
			while(dataIn.available() != 0) {
				int data = dataIn.readInt();
				memoryBank[mi] = data;
				mi++;
//				System.out.println(data);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				inFile.close();
				dataIn.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}
