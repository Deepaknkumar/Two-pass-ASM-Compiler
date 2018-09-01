import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 */

/**
 * @author deepakkumar
 *
 */
public class WriteFile {

	/**
	 * 
	 */
	public WriteFile() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream outFile = null;
		DataOutputStream dataOut = null;
		String path = "/Users/deepakkumar/Documents/deepak/UBC Courses/UBC TA/COSC121/Lab4/src/integerdata2";
		
		try {
			outFile = new FileOutputStream(path);
			dataOut = new DataOutputStream(outFile);
			for(int i=0; i <= 100; i++) {
				System.out.println("Writing Value: " + i);
				dataOut.writeInt(i);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			outFile.close();
			dataOut.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}
