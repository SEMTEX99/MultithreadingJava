package MultithreadSort;

import java.util.List;

public class Sorter implements Runnable {
    private List<Integer> numbers;

    public Sorter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.numbers.size(); i++) {
            for (int j = 0; j < this.numbers.size() - 1; j++) {
                if (this.numbers.get(j) > this.numbers.get(j + 1)) {
                    int temp = this.numbers.get(j);
                    this.numbers.set(j, this.numbers.get(j + 1));
                    this.numbers.set(j + 1, temp);
                }
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}