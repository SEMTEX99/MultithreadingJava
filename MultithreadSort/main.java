package MultithreadSort;

import java.util.List;

public class main {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        Thread inputReaderThread = new Thread(inputReader);
        inputReaderThread.start();
        try {
            inputReaderThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Integer> numbers = inputReader.getNumbers();
        Sorter sorter = new Sorter(numbers);
        Thread sorterThread = new Thread(sorter);
        sorterThread.start();
        try {
            sorterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sorter.getNumbers());
    }
}