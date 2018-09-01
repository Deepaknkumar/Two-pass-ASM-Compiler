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
public class ReadFile {

	/**
	 * 
	 */
	public ReadFile() {
	}
	
	public static void main(String[] args) {
		FileInputStream inFile = null;
		DataInputStream dataIn = null;
		String path = "program.ex";
		
		try {
			inFile = new FileInputStream(path);
			dataIn = new DataInputStream(inFile);
			while(dataIn.available() != 0) {
				int data = dataIn.readInt();
				System.out.println(data);
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
