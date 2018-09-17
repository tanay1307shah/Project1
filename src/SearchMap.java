import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class SearchMap {

    public static String ReadAndParseFile(String FileName, HashMap<String, Vertex> nodes, Vector<String> allDestinations){
        StringBuilder sb = new StringBuilder();
        String origin = "";
        try {
            Scanner sc = new Scanner(new File(FileName));

            origin = sc.nextLine();
            nodes.put(origin,new Vertex(origin));

            while(sc.hasNextLine()){
                String curr = sc.nextLine();
                String[] data = curr.split(" "  );

                String currOrigin = data[0];
                String currDestination = data[1];
                double currAmount = Double.parseDouble(data[2]);

                if(!allDestinations.contains(currOrigin) && !currOrigin.equalsIgnoreCase(origin)){
                    allDestinations.add(currOrigin);
                }

                if(!allDestinations.contains(currDestination) && !currDestination.equalsIgnoreCase(origin)){
                    allDestinations.add(currDestination);
                }

                if(nodes.containsKey(currOrigin)){
                    Vertex currVertex = nodes.get(currOrigin);
                    currVertex.getEdges().put(
                            currDestination,
                            currAmount
                    );

                }else{
                    Vertex currVertex = new Vertex(currOrigin);

                    currVertex.getEdges().put(
                            currDestination,
                            currAmount
                    );
                    nodes.put(currOrigin,currVertex);
                }


                if(!nodes.containsKey(currDestination)){
                    Vertex currVertex = new Vertex(currDestination);
                    nodes.put(currDestination,currVertex);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return origin;
    }

    public static void WriteToFile(String Filename, String data){
        System.out.println(data);
    }

    public static void main(String [] args){
        String inputFile = "";
        String outputFile = "";

        HashMap<String,Vertex> map = new HashMap<>();
        Vector<String> allDestinations = new Vector<>();
        if(args.length !=2){
            System.out.println("Error: Please enter correct command line inputs");
            System.exit(0);
        }
        inputFile = args[0];
        outputFile = args[1];

        String origin = ReadAndParseFile(inputFile,map,allDestinations);
        FlightMap fm = new FlightMap();
        String data = fm.findFlights(map,origin,allDestinations);
        WriteToFile(outputFile,data);

    }




}
