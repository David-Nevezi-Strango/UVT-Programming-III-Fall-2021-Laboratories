package Laboratory8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CustomDate {
	int day;
	int month;
	int year;

	private static final Map<String, Integer> monthStringToIntegerMap;
	static {
		Map<String, Integer> mstim = new HashMap<String, Integer>();
		mstim.put("january", 1);
		mstim.put("february", 2);
		mstim.put("march", 3);
		mstim.put("april", 4);
		mstim.put("may", 5);
		mstim.put("june", 6);
		mstim.put("july", 7);
		mstim.put("august", 8);
		mstim.put("september", 9);
		mstim.put("october", 10);
		mstim.put("november", 11);
		mstim.put("december", 12);
		monthStringToIntegerMap = Collections.unmodifiableMap(mstim);
	}

	public CustomDate(String date) {
		if (date.matches("[0-9]{1,3}/[0-9]{1,2}/[0-9]{4}")) {
			StringTokenizer st = new StringTokenizer(date, "/");
			this.day = Integer.parseInt(st.nextToken());
			this.month = Integer.parseInt(st.nextToken());
			this.year = Integer.parseInt(st.nextToken());
		} else if (date.matches("[0-9]{1,3} (January|February|March|April|May|June|July|August|September|October|November|December) [0-9]{4}")) {
			StringTokenizer st = new StringTokenizer(date, " ");
			this.day = Integer.parseInt(st.nextToken());
			String month = st.nextToken().toLowerCase();
			this.month = CustomDate.monthStringToIntegerMap.get(month);
			this.year = Integer.parseInt(st.nextToken());
		} else {
			this.day = 1;
			this.month = 1;
			this.year = 1970;
		}
	}

	public String format(String fmt) {
		fmt = fmt.replaceAll("dd", String.valueOf(this.day));
		fmt = fmt.replaceAll("mm", String.valueOf(this.month));
		fmt = fmt.replaceAll("yyyy", String.valueOf(this.year));
		return fmt;
	}
}
