import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan= new Scanner(new File("impostor.txt"));
		AmongUs amongUs= new AmongUs();
		while(scan.hasNextLine()) {
			amongUs.analyzeCommand(scan.nextLine());
			
		}
		scan.close();
	}

}
