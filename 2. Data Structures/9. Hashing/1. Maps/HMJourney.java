import java.util.HashMap;

public class HMJourney {
    public static String createJourney(HashMap<String, String> map) {
        HashMap<String, String> journeyMap = new HashMap<>();
        HashMap<String, String> reverseMap = new HashMap<>();

        // Populate journeyMap and reverseMap
        for (String start : map.keySet()) {
            String destination = map.get(start);
            journeyMap.put(start, destination);
            reverseMap.put(destination, start);
        }

        // Find the starting city (which is not in reverseMap)
        String startCity = null;
        for (String city : map.keySet()) {
            if (!reverseMap.containsKey(city)) {
                startCity = city;
                break;
            }
        }

        // Construct the journey
        StringBuilder journey = new StringBuilder();
        while (startCity != null) {
            journey.append(startCity).append(" -> ");
            startCity = journeyMap.get(startCity);
        }

        // Remove the last " -> " from the journey
        if (journey.length() > 4) {
            journey.setLength(journey.length() - 4);
        }

        return journey.toString();
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Los Angeles", "New York");
        map.put("Miami", "Chicago");
        map.put("San Francisco", "Los Angeles");
        map.put("Chicago", "San Francisco");

        String result = createJourney(map);
        System.out.println(result);
    }
}
