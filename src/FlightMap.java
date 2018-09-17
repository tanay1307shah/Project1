import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class FlightMap {


    public String findFlights(HashMap<String, Vertex> map, String origin, Vector<String> allDestinations){

        StringBuilder sb = new StringBuilder();
        sb.append("Destination  \t  Flight Route from " + origin + "\t  Total Cost\n");

        Vector<String> visited = new Vector<>();
        String[] route;
        for(int i=0; i < allDestinations.size();i++) {
            route = searchRoute(origin,
                    allDestinations.elementAt(i),
                    map,
                    visited,
                    0
            );
            addRoute(route, sb);
        }

        return sb.toString();
    }

    public void addRoute(String[] route, StringBuilder sb){

        if(route != null){
            sb.append(route[route.length-2] + "\t");

            for(int j =0; j < route.length-1;j++){
                if(j == 0){
                    sb.append(route[j]);
                }
                else{
                    sb.append("," + route[j]);
                }
            }

            sb.append("\t$" + route[route.length-1] + "\n");
        }
    }


    /**
     *
     * @param origin
     * @param destination
     * @param map
     * @param visited
     * @param cost
     * @return
     */
    public String[] searchRoute(String origin, String destination,HashMap<String,Vertex> map,Vector<String> visited, double cost){

        if(origin.equalsIgnoreCase(destination)){
            visited.addElement(Double.toString(cost));
            return (String[]) visited.toArray();
        }


        HashMap<String, Double> currEdges = map.get(origin).getEdges();

        Iterator it = currEdges.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            String currDestination = (String) pair.getKey();
            double currCost = (double) pair.getValue();

            if(!visited.contains(currDestination)){
                visited.add(currDestination);
                searchRoute(currDestination,destination,map,visited,cost + currCost);
            }

        }
        return null;
    }

}
