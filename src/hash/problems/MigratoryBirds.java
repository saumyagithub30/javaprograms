package hash.problems;
import java.util.*;
public class MigratoryBirds {

	static int migratoryBirds(List<Integer> arr) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int newValue;
		for(int i=0; i<arr.size() ; i++) {
			if (h.containsKey(arr.get(i))) {
				newValue = h.get(arr.get(i));
				h.put(arr.get(i), newValue + 1);
			} else {
				h.put(arr.get(i), 1);
			}
		}
		int max_count = 0;
		int resultKey = 0;
		for (Map.Entry<Integer, Integer> entry: h.entrySet()) {
			if (entry.getValue() > max_count ) {
				max_count = entry.getValue();
				resultKey = entry.getKey();
			} else if (entry.getValue() == max_count) {
				if (resultKey > entry.getKey()) {
					resultKey = entry.getKey();
				}
			}
		}

		return resultKey;
	}

	public static void main(String[] args)  {

		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(1);
		arr.add(3);
		arr.add(2);
		arr.add(1);
		arr.add(2);
		arr.add(1);
		arr.add(3);
		arr.add(2);

		int result = migratoryBirds(arr);
		System.out.println(result);
		System.out.println(result);
	}

}
