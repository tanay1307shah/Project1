import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestVertex {

    @Test
    public void setEdges() {
        Vertex v = new Vertex("P");
        HashMap<String,Double> map = new HashMap<>();


        map.put("X", (double) 200);
        map.put("y", (double) 350);
        map.put("z", (double) 1150);

        v.setEdges(map);

        assertNotNull(v.getEdges());
        assertFalse(v.getEdges().isEmpty());
        assertEquals(v.getEdges().size(),3);


        map.keySet().stream().forEach((key) -> {
            Assert.assertEquals("Value mismatch for key '" + key + "';", map.get(key), v.getEdges().get(key));
        });
    }

    @Test
    public void getName() {
        Vertex v = new Vertex("x");
        assertTrue(v.getName().equalsIgnoreCase("x"));
        assertEquals(v.getName(),"x");
    }

    @Test
    public void setName() {
        Vertex v  = new Vertex("p");
        v.setName("s");
        assertEquals(v.getName(),"s");
        assertFalse(v.getName().equalsIgnoreCase("p"));
    }
}