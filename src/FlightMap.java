import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class FlightMap {


    /**
     * A main function which regulates the search route function  and calls it for every destination.
     * @param map A HashMap from String -> vertex , where string is the vertex name.
     * @param origin The origin city for flight search.
     * @param allDestinations A vector of Strings, keeping track of all the destination where we need to find route to.
     * @return A String with route from origin to all the destinations and the cost as well.
     */
    public String findFlights(HashMap<String, Vertex> map, String origin, Vector<String> allDestinations){

        StringBuilder sb = new StringBuilder();
        sb.append("Destination               Flight Route from " + origin + "               Total Cost\n");


        String[] route;
        for(int i=0; i < allDestinations.size();i++) {
            Vector<String> visited = new Vector<>();
            route = searchRoute(origin,
                    allDestinations.elementAt(i),
                    map,
                    visited,
                    0
            );
            sb.append(addRoute(route));
        }

        return sb.toString();
    }

    /**
     * Just converts the route string Array into a ouput string and adds it to the output.
     * @param route A String Array of the route from the origin to the destination.
     * @return A string correctly formatted with the path and cost to the destination.
     */
    public String addRoute(String[] route){
        StringBuilder sb = new StringBuilder();
        if(route != null){
            sb.append(route[route.length-2] + "                         ");

            String temp = "";
            int cnt =0;
            for(int j =0; j < route.length-1;j++){
                if(j == 0){
                    temp += route[j];
                    //sb.append(route[j]);
                    cnt++;
                }
                else{
                    temp += "," + route[j];
 //                    sb.append("," + route[j]);
                    cnt +=2;
                }
            }

            String line = String.format("%1$-10s %2$34s",temp,"$" + route[route.length-1] + "\n");
            sb.append(line);
        }
        return sb.toString();
    }


    /**
     * Searches Route from Origin to the Desination in the Map.
     * @param origin The origin city from where we want to start.
     * @param destination The destination city where we want to reach.
     * @param map The map of String -> Vertex to get access ot all the cities object.
     * @param visited The cities that are already visited during the path finding, empty at start.
     * @param cost The total cost of the path that is being taken, will be 0 at start.
     * @return A String Array of the route from origin to destination.
     */
    public String[] searchRoute(String origin, String destination,HashMap<String,Vertex> map,Vector<String> visited, double cost){


        visited.add(origin);
        if(origin.equalsIgnoreCase(destination)){
            visited.addElement(Double.toString(cost));
            return visited.toArray(new String[visited.size()]);
        }



        HashMap<String, Double> currEdges = map.get(origin).getEdges();

        if(currEdges.size() == 0 && !origin.equalsIgnoreCase(destination)){
            return null;
        }

        Iterator it = currEdges.entrySet().iterator();
        String[] temp = null;
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();

            String currDestination = (String) pair.getKey();
            double currCost = (double) pair.getValue();

            if(!visited.contains(currDestination)){
               temp = searchRoute(currDestination,destination,map,visited,cost + currCost);

               if(temp == null){
                   visited.removeElementAt(visited.size()-1);
               }else{
                   break;
               }
            }

        }
        if(temp == null){
            return null;
        }else{
            return visited.toArray(new String[visited.size()]);
        }
    }

}
