import org.junit.Test;

import java.util.HashMap;
import java.util.Vector;

import static org.junit.Assert.*;

public class TestFlightMap {

    /*@Test
    public void searchRouteTest() {

    }*/

    @Test
    public void findFlightsTest() {

        HashMap<String,Vertex> map = new HashMap<>();

        String fileName = "inputFileForTesting.txt";
        Vector<String> allDestinations = new Vector<>();

        String origin = SearchMap.ReadAndParseFile(fileName,map,allDestinations);

        FlightMap fm  = new FlightMap();
        String recieved  = fm.findFlights(map,origin,allDestinations);

        String expected = "Destination\tFlight Route from P\tTotal Cost\n" +
                "R\tP,R\t$300\n" +
                "X\tP,R,X\t$500\n" +
                "W\tP,W\t$200\n" +
                "S\tP,W,S\t$450\n" +
                "T\tP,W,S,T\t$750\n" +
                "Y\tP,W,Y\t$700\n" +
                "Z\tP,W,Y,Z\t$1150";

        assertTrue(recieved.length() == expected.length());
        assertEquals(expected,recieved);
     }

    @Test
    public void addRouteTest() {
        String[] route = new String[] {"r","s","u","c","l","a","300"};

        String expected = "a\tr,s,u,c,l,a\t$300\n";

        FlightMap fm = new FlightMap();
        String recieved  = fm.addRoute(route);

        assertTrue(expected.length() == recieved.length());
        assertEquals(expected,recieved);

    }


}