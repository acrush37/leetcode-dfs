package medium;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
    Given a list of airline tickets represented by pairs of departure and
    arrival airports [from, to], reconstruct the itinerary in order.

    All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 */
public class ReconstructItinerary {

    private boolean flag;
    private List<String> result;

    public static void main(String... args) {

        List<List<String>> tickets = Arrays.asList(Arrays.asList("CBR","JFK"),
                Arrays.asList("TIA","EZE"), Arrays.asList("AUA","TIA"), Arrays.asList("JFK","EZE"),
                Arrays.asList("BNE","CBR"), Arrays.asList("JFK","CBR"), Arrays.asList("CBR","AUA"),
                Arrays.asList("EZE","HBA"), Arrays.asList("AXA","ANU"), Arrays.asList("BNE","EZE"),
                Arrays.asList("AXA","EZE"), Arrays.asList("AUA","ADL"), Arrays.asList("OOL","JFK"),
                Arrays.asList("BNE","AXA"), Arrays.asList("OOL","EZE"), Arrays.asList("EZE","ADL"),
                Arrays.asList("TIA","BNE"), Arrays.asList("EZE","TIA"), Arrays.asList("JFK","AUA"),
                Arrays.asList("AUA","EZE"), Arrays.asList("ANU","ADL"), Arrays.asList("TIA","BNE"),
                Arrays.asList("EZE","OOL"), Arrays.asList("ANU","BNE"), Arrays.asList("EZE","ANU"),
                Arrays.asList("ANU","AUA"), Arrays.asList("BNE","ANU"), Arrays.asList("CNS","JFK"),
                Arrays.asList("TIA","ADL"), Arrays.asList("ADL","AXA"), Arrays.asList("JFK","OOL"),
                Arrays.asList("AUA","ADL"), Arrays.asList("ADL","TIA"), Arrays.asList("ADL","ANU"),
                Arrays.asList("ADL","JFK"), Arrays.asList("BNE","EZE"), Arrays.asList("ANU","BNE"),
                Arrays.asList("JFK","BNE"), Arrays.asList("EZE","AUA"), Arrays.asList("EZE","AXA"),
                Arrays.asList("AUA","TIA"), Arrays.asList("ADL","CNS"),Arrays.asList("AXA","AUA"));
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        System.out.println(reconstructItinerary.findItinerary(tickets));
    }

    private void dfs(int k, String s, Map<String, List<String>> map) {

        if (k == 0) {

            flag = true;
            return;
        }

        List<String> list = map.get(s);
        if (list == null) return;
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {

            String x = it.next();
            list.remove(x);
            result.add(x);
            dfs(k-1, x, map);
            if (flag) return;
            list.add(x);
            result.remove(result.size()-1);
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);
            List<String> list = map.get(from);
            if (list == null) list = new CopyOnWriteArrayList<>();
            list.add(to);
            map.put(from, list);
        }

        for (String key : map.keySet()) map.get(key).sort(Comparator.naturalOrder());

        flag = false;
        result = new CopyOnWriteArrayList<>();
        result.add("JFK");
        dfs(tickets.size(), "JFK", map);
        return result;
    }

}
