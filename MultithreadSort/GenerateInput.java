package MultithreadSort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInput {
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			FileWriter writer = new FileWriter(file);
			Random rand = new Random();
			for (int i = 0; i < 100000; i++) {
				writer.write(rand.nextInt(100000000) + ",");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}