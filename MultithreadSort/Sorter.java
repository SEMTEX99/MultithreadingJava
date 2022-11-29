package MultithreadSort;

import java.util.List;
import java.util.concurrent.Callable;

public class Sorter implements Callable<List<Integer>> {
	private List<Integer> data;

	public Sorter(List<Integer> data) {
		this.data = data;
	}

	@Override
	public List<Integer> call() throws Exception {
		int n = data.size();
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (data.get(j - 1) > data.get(j)) {
					temp = data.get(j - 1);
					data.set(j - 1, data.get(j));
					data.set(j, temp);
				}
			}
		}
		return data;
	}
}