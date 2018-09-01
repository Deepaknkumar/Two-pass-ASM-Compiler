/**
 * 
 */


import java.util.Scanner;

/**
 * @author deepakkumar
 *
 */
public class Terminal implements TerminalInterface {

	/**
	 * 
	 */
	public Terminal() {

		
	}

	@Override
	public int read() {
		System.out.print("? ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		//scan.close();
		return input;
	}

	@Override
	public void print(int value) {
		System.out.println("OUTPUT = " + value);
	}

}
