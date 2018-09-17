import org.junit.Test;

import java.util.HashMap;
import java.util.Vector;

import static org.junit.Assert.*;

public class TestSearchMap {

    @Test
    public void readAndParseFile() {
        String fileName = "inputFileForTesting.txt";
        HashMap<String,Vertex> map = new HashMap<>();
        Vector<String> allDestinations = new Vector<>();

        String origin = SearchMap.ReadAndParseFile(fileName,map,allDestinations);

        Vector<String> expected = new Vector<>();
        expected.add("W");
        expected.add("R");
        expected.add("X");
        expected.add("Q");
        expected.add("S");
        expected.add("T");
        expected.add("Y");
        expected.add("Z");

        assertNotNull(map);
        assertNotNull(allDestinations);
        assertEquals(9, map.size());
        assertEquals(allDestinations.size(), map.size() - 1);
        assertTrue(allDestinations.containsAll(expected));
        assertEquals("P",origin);

    }

    @Test
    public void writeToFile() {
    }
}