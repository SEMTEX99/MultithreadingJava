package MultithreadSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InputReader implements Runnable {
	private static final int CHUNK_SIZE = 1000;
	private static final int THREAD_POOL_SIZE = 10;
	private static final String INPUT_FILE_NAME = "input.txt";
	private static final String OUTPUT_FILE_NAME = "output.txt";
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	@Override
	public void run() {
		try {
			File file = new File(INPUT_FILE_NAME);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			List<Integer> data = new ArrayList<Integer>();
			while ((line = bufferedReader.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				for (String str : values) {
					data.add(Integer.parseInt(str));
					if (data.size() == CHUNK_SIZE) {
						ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
						Future<List<Integer>> future = executorService.submit(new Sorter(data));
						List<Integer> sortedData = future.get();
						writeToFile(sortedData);
						data.clear();
					}
				}
			}
			if (data.size() > 0) {
				ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
				Future<List<Integer>> future = executorService.submit(new Sorter(data));
				List<Integer> sortedData = future.get();
				writeToFile(sortedData);
				data.clear();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeToFile(List<Integer> data) {
		try {
			File file = new File(OUTPUT_FILE_NAME);
			FileWriter writer = new FileWriter(file, true);
			for (Integer value : data) {
				writer.append(String.valueOf(value));
				writer.append(NEW_LINE_SEPARATOR);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}