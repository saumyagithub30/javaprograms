package hash.problems;

import java.util.HashMap;
import java.util.Map;

public class FlightItinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> itinerary = new HashMap<>();
		itinerary.put("Chennai", "Bangalore");
		itinerary.put("Bombay", "Delhi");
		itinerary.put("Goa", "Chennai");
		itinerary.put("Delhi", "Goa");
		FlightItinerary fltItinerary = new FlightItinerary();
		fltItinerary.printItinerary(itinerary);
	}

	private void printItinerary(Map<String, String> itinerary) {
		// TODO Auto-generated method stub
		String start = null;
		//The idea is to first find the starting point.
		Map<String, String> reverseMap = new HashMap<>();
		
		// To fill reverse map, iterate through the given map 
        for (Map.Entry<String, String> entry: itinerary.entrySet()) {
        	reverseMap.put(entry.getValue(), entry.getKey());
        }
        
        for (Map.Entry<String, String> entry : itinerary.entrySet()) {
        	if (!reverseMap.containsKey(entry.getKey())) {
        		start = entry.getKey();
        		break;
        	}
        }
        
        if (start == null) {
        	System.out.println("Invalid Input");
        	return;
        }
        
        String to = itinerary.get(start);
        while (to!=null) {
        	System.out.println("From " + start + " To "  + to);
        	start = to;
        	to = itinerary.get(start);
        }
		
	}

}
