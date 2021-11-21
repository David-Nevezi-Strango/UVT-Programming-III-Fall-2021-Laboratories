package Laboratory8;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/*
 * Create a Chair class:
 * - producer
 * - fabric
 * - price
 * 
 * a) Read a CSV file containing Chair data and create a Chair list
 * b) Sort the Chair list based on the price
 * c) Create a method that displays the Chair in a JSON format
 * d) For each distinct producer print a list of chairs that he produces in JSON format
 */

public class Exercise2 {
	public static void main(String args[]) {
		// a) Read a CSV file containing Chair data and create a Chair list
		List<Chair> chairs = readChairsFromCsvFile(Paths.get("exercise2.csv"));

		// b) Sort the list based on the price field
		sortChairList(chairs);

		// c) Create a method that displays the Chair in a JSON format
		System.out.println(chairs.get(0).toString());

		// d) For each distinct producer print a list of chairs that he
		// produces in JSON format
		printDistinctProducersChairs(chairs);
	}

	private static List<Chair> readChairsFromCsvFile(Path path) {
		// Note: To use the OpenCSV, for all the attached jars:
		// attached.jar > Build Path > Add to Build Path
		// OpenCSV dependencies: http://opencsv.sourceforge.net/dependencies.html
		List<Chair> chairs = new ArrayList<Chair>();
		try {
			Reader reader = Files.newBufferedReader(path);
			CSVReader csvReader = new CSVReader(reader);
			String[] record = csvReader.readNext();
			while (record != null) {
				String producer = record[0];
				String fabric = record[1];
				double price = Double.parseDouble(record[2]);

				chairs.add(new Chair(producer, fabric, price));

				record = csvReader.readNext();
			}
			csvReader.close();
			reader.close();
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
		return chairs;
	}

	private static void sortChairList(List<Chair> chairs) {
		chairs.sort(new Comparator<Chair>() {
			public int compare(Chair first, Chair second) {
				return first.price <= second.price ? -1 : 1;
			}
		});
	}

	private static void printDistinctProducersChairs(List<Chair> chairs) {
		Map<String, List<Chair>> uniqueProducers = new TreeMap<String, List<Chair>>();
		for (Chair chair : chairs) {
			if (!uniqueProducers.containsKey(chair.producer)) {
				uniqueProducers.put(chair.producer, new ArrayList<Chair>());
			}
			uniqueProducers.get(chair.producer).add(chair);
		}
		uniqueProducers.keySet().forEach(
				uniqueProducer -> System.out.println(uniqueProducer + ": " + uniqueProducers.get(uniqueProducer)));
	}
}
