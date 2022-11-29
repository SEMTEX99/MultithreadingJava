package MultithreadSort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInput {
    public static void main(String[] args) {
        File file = new File("inputs.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                fileWriter.write(random.nextInt(1000000) + ",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}