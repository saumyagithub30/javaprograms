package greedy;

import java.util.*;

/*#Problem Statement
		Given a set of customers and each customers has certain set of favorite drinks.
		C1 -> 3, 7, 5, 2, 9
		C2 -> 5
		C3 -> 2, 3
		C4 -> 4
		C5 -> 3, 4, 5, 7
		Goal: Find minimum types of drink a bartender needs to make?
		Ans: 3=> (5, 4,3)*/
public class LazyBartender
{
	public static void main(String[] args)
	{
		HashMap<String, Set<String>> customerMap = new HashMap<String, Set<String>>();
		customerMap.put("C1", new HashSet<String>(Arrays.asList("3","7", "5", "2", "9")));
		customerMap.put("C2", new HashSet<String>(Arrays.asList("5")));
		customerMap.put("C3", new HashSet<String>(Arrays.asList("2", "3")));
		customerMap.put("C4", new HashSet<String>(Arrays.asList("4")));
		customerMap.put("C5", new HashSet<String>(Arrays.asList("3","4","5","7")));
		System.out.println("Total No. of drinks required : " + countDrinks(customerMap));
	}

	private static int countDrinks(HashMap<String, Set<String>> customerMap)
	{
		int count = 0;
		List<GraphNode> graphNodes = createGraphNodes(customerMap);
		connectGraphNodes(graphNodes);

		return count;
	}

	private static void connectGraphNodes(List<GraphNode> graphNodes)
	{
		int j =0;
		for (int i =0; i<graphNodes.size(); i++) {

		}
	}

	private static List<GraphNode> createGraphNodes(HashMap<String, Set<String>> customerMap)
	{
		List<GraphNode> nodes = new ArrayList<>();
		for (String key: customerMap.keySet()) {
			Set<String> drinks = customerMap.get(key);
			for (String drink: drinks) {
				GraphNode node = GraphNode.builder().customerNo(key).drink(drink).build();
				nodes.add(node);
			}
		}
		return nodes;
	}
}
