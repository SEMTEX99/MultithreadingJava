package MultithreadSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader implements Runnable {
    private List<Integer> numbers;

    public InputReader() {
        this.numbers = new ArrayList<>();
    }

    @Override
    public void run() {
        File file = new File("inputs.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            String[] numbersAsString = line.split(",");
            for (String numberAsString : numbersAsString) {
                this.numbers.add(Integer.parseInt(numberAsString));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}