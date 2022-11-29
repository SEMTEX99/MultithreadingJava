package MultithreadSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OutputWriter {
	private static final String OUTPUT_FILE_NAME = "output.txt";
	private static final String NEW_LINE_SEPARATOR = "\n";

	public static void main(String[] args) {
		try {
			File file = new File(OUTPUT_FILE_NAME);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}